package ir.fallahpoor.kotlox.interpreter.interpreter

import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.Expr.Logical
import ir.fallahpoor.kotlox.interpreter.Printer
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

class Interpreter(
    private val errorReporter: ErrorReporter,
    private val printer: Printer
) : Expr.Visitor<Any?>, Stmt.Visitor<Unit> {

    private class BreakException : RuntimeException()
    class ReturnException(val value: Any?) : RuntimeException()

    companion object {
        private const val ERROR_MESSAGE_INCOMPATIBLE_TYPES = "Operands are incompatible."
        private const val ERROR_MESSAGE_OPERAND_MUST_BE_A_NUMBER = "Operand must be a number."
        private const val ERROR_MESSAGE_DIVISION_BY_ZERO = "Division by zero."
    }

    val globals = Environment()
    private var environment = globals

    init {
        defineNativeFunctionClock()
    }

    private fun defineNativeFunctionClock() {
        globals.define(
            "clock",
            object : LoxCallable {
                override fun arity(): Int = 0

                override fun call(interpreter: Interpreter, arguments: List<Any?>): Any {
                    return System.currentTimeMillis().toDouble() / 1000.0
                }

                override fun toString(): String = "<native fn>"
            }
        )
    }

    fun interpret(statements: List<Stmt>) {
        try {
            for (statement in statements) {
                execute(statement)
            }
        } catch (error: RuntimeError) {
            errorReporter.runtimeError(error)
        }
    }

    private fun execute(stmt: Stmt) {
        stmt.accept(this)
    }

    private fun stringify(any: Any?): String =
        when (any) {
            null -> "nil"
            is Double -> {
                var text = any.toString()
                if (text.endsWith(".0")) {
                    text = text.substring(0, text.length - 2)
                }
                text
            }
            else -> any.toString()
        }

    override fun visitAssignExpr(expr: Expr.Assign): Any? {
        val value = evaluate(expr.value)
        environment.assign(expr.name, value)
        return value
    }

    override fun visitBinaryExpr(expr: Expr.Binary): Any? {

        val left: Any? = evaluate(expr.left)
        val right: Any? = evaluate(expr.right)

        return when (expr.operator.type) {
            TokenType.COMMA -> right
            TokenType.GREATER -> {
                checkOperandsAreNumber(expr.operator, left, right)
                (left as Double) > (right as Double)
            }
            TokenType.GREATER_EQUAL -> {
                checkOperandsAreNumber(expr.operator, left, right)
                (left as Double) >= (right as Double)
            }
            TokenType.LESS -> {
                checkOperandsAreNumber(expr.operator, left, right)
                (left as Double) < (right as Double)
            }
            TokenType.LESS_EQUAL -> {
                checkOperandsAreNumber(expr.operator, left, right)
                (left as Double) <= (right as Double)
            }
            TokenType.MINUS -> {
                checkOperandsAreNumber(expr.operator, left, right)
                (left as Double) - (right as Double)
            }
            TokenType.SLASH -> {
                checkOperandsAreNumber(expr.operator, left, right)
                val rightAsDouble = (right as Double)
                if (rightAsDouble == 0.0) {
                    throw RuntimeError(expr.operator, ERROR_MESSAGE_DIVISION_BY_ZERO)
                } else {
                    (left as Double) / rightAsDouble
                }
            }
            TokenType.STAR -> {
                checkOperandsAreNumber(expr.operator, left, right)
                (left as Double) * (right as Double)
            }
            TokenType.PLUS -> {
                return if (left is Double && right is Double) {
                    left + right
                } else if (left is String && right is String) {
                    left + right
                } else if (left is Double && right is String) {
                    if (checkNumberIsWhole(left)) {
                        left.toInt().toString() + right
                    } else {
                        throw RuntimeError(expr.operator, ERROR_MESSAGE_INCOMPATIBLE_TYPES)
                    }
                } else if (left is String && right is Double) {
                    if (checkNumberIsWhole(right)) {
                        left + right.toInt().toString()
                    } else {
                        throw RuntimeError(expr.operator, ERROR_MESSAGE_INCOMPATIBLE_TYPES)
                    }
                } else {
                    throw RuntimeError(expr.operator, ERROR_MESSAGE_INCOMPATIBLE_TYPES)
                }
            }
            TokenType.BANG_EQUAL -> !isEqual(left, right)
            TokenType.EQUAL_EQUAL -> isEqual(left, right)
            else -> null  // Unreachable
        }

    }

    private fun checkNumberIsWhole(number: Double): Boolean =
        number.toString().endsWith(".0")

    private fun checkOperandsAreNumber(operator: Token, left: Any?, right: Any?) {
        if (left !is Double || right !is Double) {
            throw RuntimeError(operator, ERROR_MESSAGE_OPERAND_MUST_BE_A_NUMBER)
        }
    }

    @Suppress("IfThenToElvis", "ReplaceCallWithBinaryOperator")
    private fun isEqual(a: Any?, b: Any?): Boolean =
        if (a == null && b == null) {
            true
        } else if (a == null) {
            false
        } else {
            a.equals(b)
        }

    override fun visitCallExpr(expr: Expr.Call): Any? {
        val callee: Any? = evaluate(expr.callee)

        val arguments = mutableListOf<Any?>()
        for (argument in expr.arguments) {
            arguments += evaluate(argument)
        }

        if (callee !is LoxCallable) {
            throw RuntimeError(
                expr.paren,
                "Can only call functions and classes."
            )
        }

        val function: LoxCallable = callee
        if (arguments.size != function.arity()) {
            throw RuntimeError(
                expr.paren,
                "Expected " + function.arity().toString() +
                        " arguments but got " + arguments.size.toString() + "."
            )
        }
        return function.call(this, arguments)
    }

    override fun visitGroupingExpr(expr: Expr.Grouping): Any? = evaluate(expr.expression)

    private fun evaluate(expr: Expr): Any? = expr.accept(this)

    override fun visitLiteralExpr(expr: Expr.Literal): Any? = expr.value

    override fun visitLogicalExpr(expr: Logical): Any? {
        val left: Any? = evaluate(expr.left)
        if (expr.operator.type == TokenType.OR) {
            if (isTruthy(left)) return left
        } else {
            if (!isTruthy(left)) return left
        }
        return evaluate(expr.right)
    }

    override fun visitUnaryExpr(expr: Expr.Unary): Any? {
        val right: Any? = evaluate(expr.right)
        return when (expr.operator.type) {
            TokenType.BANG -> !isTruthy(right)
            TokenType.MINUS -> {
                checkOperandIsNumber(expr.operator, right)
                -(right as Double)
            }
            else -> null // Unreachable.
        }
    }

    override fun visitExpressionStmt(stmt: Stmt.Expression) {
        evaluate(stmt.expression)
    }

    override fun visitFunctionStmt(stmt: Stmt.Function) {
        val function = LoxFunction(stmt)
        environment.define(stmt.name.lexeme, function)
    }

    override fun visitIfStmt(stmt: Stmt.If) {
        if (isTruthy(evaluate(stmt.condition))) {
            execute(stmt.thenBranch)
        } else if (stmt.elseBranch != null) {
            execute(stmt.elseBranch)
        }
    }

    override fun visitPrintStmt(stmt: Stmt.Print) {
        val value: Any? = evaluate(stmt.expression)
        printer.println(stringify(value))
    }

    override fun visitReturnStmt(stmt: Stmt.Return) {
        val value: Any? = if (stmt.value != null) {
            evaluate(stmt.value)
        } else {
            null
        }
        throw ReturnException(value)
    }

    override fun visitVarStmt(stmt: Stmt.Var) {
        if (stmt.initializer != null) {
            val value: Any? = evaluate(stmt.initializer)
            environment.define(stmt.name.lexeme, value)
        } else {
            environment.define(stmt.name.lexeme)
        }
    }

    override fun visitWhileStmt(stmt: Stmt.While) {
        try {
            while (isTruthy(evaluate(stmt.condition))) {
                execute(stmt.body)
            }
        } catch (e: BreakException) {
            // No need to do anything here. Because the exception has terminated the while loop.
            // And that's exactly what we want when encountering a 'break' 'statement.
        }
    }

    override fun visitVariableExpr(expr: Expr.Variable): Any? = environment.get(expr.name)

    override fun visitBlockStmt(stmt: Stmt.Block) {
        executeBlock(stmt.statements, Environment(environment))
    }

    fun executeBlock(statements: List<Stmt>, environment: Environment) {
        val previousEnvironment = this@Interpreter.environment
        try {
            this@Interpreter.environment = environment
            for (statement in statements) {
                execute(statement)
            }
        } finally {
            this@Interpreter.environment = previousEnvironment
        }
    }

    @Throws(BreakException::class)
    override fun visitBreakStmt(stmt: Stmt.Break) {
        throw BreakException()
    }

    // 'false' and 'nil' are falsey, and everything else is truthy.
    private fun isTruthy(any: Any?): Boolean =
        when (any) {
            null -> false
            is Boolean -> any
            else -> true
        }

    private fun checkOperandIsNumber(operator: Token, operand: Any?) {
        if (operand !is Double) {
            throw RuntimeError(operator, ERROR_MESSAGE_OPERAND_MUST_BE_A_NUMBER)
        }
    }

}