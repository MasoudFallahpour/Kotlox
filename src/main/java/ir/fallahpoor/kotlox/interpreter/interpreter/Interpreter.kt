package ir.fallahpoor.kotlox.interpreter.interpreter

import ir.fallahpoor.kotlox.interpreter.*
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

class Interpreter(
    private val errorReporter: ErrorReporter,
    private val printer: Printer
) : Expr.Visitor<Any?>, Stmt.Visitor<Unit> {

    companion object {
        private const val ERROR_MESSAGE_INCOMPATIBLE_TYPES = "Operands are incompatible."
        private const val ERROR_MESSAGE_OPERAND_MUST_BE_A_NUMBER = "Operand must be a number."
        private const val ERROR_MESSAGE_DIVISION_BY_ZERO = "Division by zero."
    }

    private val environment = Environment()

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

    override fun visitGroupingExpr(expr: Expr.Grouping): Any? = evaluate(expr.expression)

    private fun evaluate(expr: Expr): Any? = expr.accept(this)

    override fun visitLiteralExpr(expr: Expr.Literal): Any? = expr.value

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

    override fun visitPrintStmt(stmt: Stmt.Print) {
        val value: Any? = evaluate(stmt.expression)
        printer.println(stringify(value))
    }

    override fun visitVarStmt(stmt: Stmt.Var) {
        val value: Any? = if (stmt.initializer != null) {
            evaluate(stmt.initializer)
        } else {
            null
        }
        environment.define(stmt.name.lexeme, value)
    }

    override fun visitVariableExpr(expr: Expr.Variable): Any? = environment.get(expr.name)

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