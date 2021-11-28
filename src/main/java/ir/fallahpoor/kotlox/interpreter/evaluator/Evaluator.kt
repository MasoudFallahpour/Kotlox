package ir.fallahpoor.kotlox.interpreter.evaluator

import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

class Evaluator(private val errorReporter: ErrorReporter) : Expr.Visitor<Any?> {

    companion object {
        private const val ERROR_MESSAGE_UNSUPPORTED_OPERAND_TYPE = "Operands must be two numbers or two strings."
        private const val ERROR_MESSAGE_OPERAND_MUST_BE_A_NUMBER = "Operand must be a number."
        private const val ERROR_MESSAGE_DIVISION_BY_ZERO = "Division by zero."
    }

    fun evaluate(expression: Expr) {
        try {
            val value = eval(expression)
            println(stringify(value))
        } catch (error: RuntimeError) {
            errorReporter.runtimeError(error)
        }
    }

    private fun stringify(any: Any?): String {
        return when (any) {
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
    }

    override fun visitBinaryExpr(expr: Expr.Binary): Any? {

        val left: Any? = eval(expr.left)
        val right: Any? = eval(expr.right)

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
                } else {
                    throw RuntimeError(expr.operator, ERROR_MESSAGE_UNSUPPORTED_OPERAND_TYPE)
                }
            }
            TokenType.BANG_EQUAL -> !isEqual(left, right)
            TokenType.EQUAL_EQUAL -> isEqual(left, right)
            else -> null  // Unreachable
        }

    }

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

    override fun visitGroupingExpr(expr: Expr.Grouping): Any? = eval(expr.expression)

    private fun eval(expr: Expr): Any? = expr.accept(this)

    override fun visitLiteralExpr(expr: Expr.Literal): Any? = expr.value

    override fun visitUnaryExpr(expr: Expr.Unary): Any? {
        val right: Any? = eval(expr.right)
        return when (expr.operator.type) {
            TokenType.BANG -> !isTruthy(right)
            TokenType.MINUS -> {
                checkNumberOperand(expr.operator, right)
                -(right as Double)
            }
            else -> null // Unreachable.
        }
    }

    // 'false' and 'nil' are falsey, and everything else is truthy.
    private fun isTruthy(any: Any?): Boolean =
        when (any) {
            null -> false
            is Boolean -> any
            else -> true
        }

    private fun checkNumberOperand(operator: Token, operand: Any?) {
        if (operand !is Double) {
            throw RuntimeError(operator, ERROR_MESSAGE_OPERAND_MUST_BE_A_NUMBER)
        }
    }

}