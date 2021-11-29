package ir.fallahpoor.kotlox.interpreter.evaluator

import ir.fallahpoor.kotlox.interpreter.antlr.LoxBaseVisitor
import ir.fallahpoor.kotlox.interpreter.antlr.LoxLexer
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser

class EvaluatorVisitor : LoxBaseVisitor<Any?>() {

    override fun visitExpression(ctx: LoxParser.ExpressionContext): Any? {
        var currentValue: Any? = visitEquality(ctx.equality(0))
        for (i in 0..ctx.op.lastIndex) {
            currentValue = visitEquality(ctx.equality(i + 1))
        }
        return currentValue
    }

    override fun visitEquality(ctx: LoxParser.EqualityContext): Any? {
        var currentValue: Any? = visitComparison(ctx.comparison(0))
        for (i in 0..ctx.op.lastIndex) {
            currentValue =
                when (ctx.op[i].type) {
                    LoxLexer.OP_EQUAL -> isEqual(currentValue, visitComparison(ctx.comparison(i + 1)))
                    LoxLexer.OP_INEQUAL -> !isEqual(currentValue, visitComparison(ctx.comparison(i + 1)))
                    else -> throw RuntimeException()
                }
        }
        return currentValue
    }

    override fun visitComparison(ctx: LoxParser.ComparisonContext): Any? {
        var currentValue: Any? = visitTerm(ctx.term(0))
        for (i in 0..ctx.op.lastIndex) {
            currentValue =
                when (ctx.op[i].type) {
                    LoxLexer.OP_GREATER -> {
                        val right: Any? = visitTerm(ctx.term(i + 1))
                        checkOperandsAreNumber(currentValue, right)
                        (currentValue as Double) > (right as Double)
                    }
                    LoxLexer.OP_LESS -> {
                        val right: Any? = visitTerm(ctx.term(i + 1))
                        checkOperandsAreNumber(currentValue, right)
                        (currentValue as Double) < (right as Double)
                    }
                    LoxLexer.OP_GREATER_EQUAL -> {
                        val right: Any? = visitTerm(ctx.term(i + 1))
                        checkOperandsAreNumber(currentValue, right)
                        (currentValue as Double) >= (right as Double)
                    }
                    LoxLexer.OP_LESS_EQUAL -> {
                        val right: Any? = visitTerm(ctx.term(i + 1))
                        checkOperandsAreNumber(currentValue, right)
                        (currentValue as Double) <= (right as Double)
                    }
                    else -> throw RuntimeException()
                }
        }
        return currentValue
    }

    override fun visitTerm(ctx: LoxParser.TermContext): Any? {
        var currentValue: Any? = visitFactor(ctx.factor(0))
        for (i in 0..ctx.op.lastIndex) {
            currentValue =
                when (ctx.op[i].type) {
                    LoxLexer.OP_MINUS -> {
                        val right: Any? = visitFactor(ctx.factor(i + 1))
                        checkOperandsAreNumber(currentValue, right)
                        (currentValue as Double) - (right as Double)
                    }
                    LoxLexer.OP_PLUS -> {
                        val right: Any? = visitFactor(ctx.factor(i + 1))
                        checkOperandsAreNumber(currentValue, right)
                        (currentValue as Double) + (right as Double)
                    }
                    else -> throw RuntimeException()
                }
        }
        return currentValue
    }

    override fun visitFactor(ctx: LoxParser.FactorContext): Any? {
        var currentValue: Any? = visitUnary(ctx.unary(0))
        for (i in 0..ctx.op.lastIndex) {
            currentValue =
                when (ctx.op[i].type) {
                    LoxLexer.OP_STAR -> {
                        val right: Any? = visitUnary(ctx.unary(i + 1))
                        checkOperandsAreNumber(currentValue, right)
                        (currentValue as Double) * (right as Double)
                    }
                    LoxLexer.OP_SLASH -> {
                        val right: Any? = visitUnary(ctx.unary(i + 1))
                        checkOperandsAreNumber(currentValue, right)
                        (currentValue as Double) / (right as Double)
                    }
                    else -> {
                        throw RuntimeException()
                    }
                }
        }
        return currentValue
    }

    override fun visitUnary(ctx: LoxParser.UnaryContext): Any? {
        return if (ctx.unary() == null) {
            visitPrimary(ctx.primary())
        } else {
            val right = visitUnary(ctx.unary())
            when (ctx.op[0].type) {
                LoxLexer.OP_BANG -> !isTruthy(right)
                LoxLexer.OP_MINUS -> {
                    checkNumberOperand(right)
                    -(right as Double)
                }
                else -> throw RuntimeException()
            }
        }
    }

    override fun visitPrimary(ctx: LoxParser.PrimaryContext): Any? =
        if (ctx.text == "true") {
            true
        } else if (ctx.text == "false") {
            false
        } else if (ctx.text == "nil") {
            null
        } else if (ctx.text.startsWith("(")) {
            visit(ctx.expression())
        } else if (ctx.text.matches("\\d+(.\\d+)?".toRegex())) {
            ctx.text.toDouble()
        } else {
            throw RuntimeException()
        }

    private fun checkNumberOperand(operand: Any?) {
        if (operand !is Double) {
            throw RuntimeException("Operand is not a number.")
        }
    }

    private fun checkOperandsAreNumber(left: Any?, right: Any?) {
        if (left !is Double || right !is Double) {
            throw RuntimeException("Operands are not numbers.")
        }
    }

    // 'false' and 'nil' are falsey, and everything else is truthy.
    private fun isTruthy(any: Any?): Boolean =
        when (any) {
            null -> false
            is Boolean -> any
            else -> true
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

}