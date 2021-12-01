package ir.fallahpoor.kotlox.interpreter.interpreter

import ir.fallahpoor.kotlox.interpreter.antlr.LoxBaseVisitor
import ir.fallahpoor.kotlox.interpreter.antlr.LoxLexer
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser

class InterpretExprVisitor : LoxBaseVisitor<Any?>() {

    companion object {
        private val NUMBER_REGEX = "\\d+(.\\d+)?".toRegex()
        private val STRING_WITH_DOUBLE_QUOTES_REGEX = "\"[^\"]*\"".toRegex()
    }

    // Evaluates rule: expression → equality ("," equality)*
    override fun visitExpression(ctx: LoxParser.ExpressionContext): Any? {
        var currentValue: Any? = visitEquality(ctx.equality(0))
        for (i in 0..ctx.op.lastIndex) {
            currentValue = visitEquality(ctx.equality(i + 1))
        }
        return currentValue
    }

    // Evaluates rule: equality → comparison ( ( "!=" | "==" ) comparison )*
    override fun visitEquality(ctx: LoxParser.EqualityContext): Any? {
        var currentValue: Any? = visitComparison(ctx.comparison(0))
        for (i in 0..ctx.op.lastIndex) {
            currentValue = evaluateEquality(
                currentValue = currentValue,
                opType = ctx.op[i].type,
                comparisonContext = ctx.comparison(i + 1)
            )
        }
        return currentValue
    }

    private fun evaluateEquality(
        currentValue: Any?,
        opType: Int,
        comparisonContext: LoxParser.ComparisonContext
    ): Any = when (opType) {
        LoxLexer.OP_EQUAL -> isEqual(currentValue, visitComparison(comparisonContext))
        LoxLexer.OP_INEQUAL -> !isEqual(currentValue, visitComparison(comparisonContext))
        else -> throw RuntimeException()
    }

    // Evaluates rule: comparison → term ( ( ">" | ">=" | "<" | "<=" ) term )*
    override fun visitComparison(ctx: LoxParser.ComparisonContext): Any? {
        var currentValue: Any? = visitTerm(ctx.term(0))
        for (i in 0..ctx.op.lastIndex) {
            currentValue = evaluateComparison(
                currentValue = currentValue,
                opType = ctx.op[i].type,
                termContext = ctx.term(i + 1)
            )
        }
        return currentValue
    }

    private fun evaluateComparison(
        currentValue: Any?,
        opType: Int,
        termContext: LoxParser.TermContext
    ): Any = when (opType) {
        LoxLexer.OP_GREATER -> {
            val right: Any? = visitTerm(termContext)
            checkOperandsAreNumber(currentValue, right)
            (currentValue as Double) > (right as Double)
        }
        LoxLexer.OP_LESS -> {
            val right: Any? = visitTerm(termContext)
            checkOperandsAreNumber(currentValue, right)
            (currentValue as Double) < (right as Double)
        }
        LoxLexer.OP_GREATER_EQUAL -> {
            val right: Any? = visitTerm(termContext)
            checkOperandsAreNumber(currentValue, right)
            (currentValue as Double) >= (right as Double)
        }
        LoxLexer.OP_LESS_EQUAL -> {
            val right: Any? = visitTerm(termContext)
            checkOperandsAreNumber(currentValue, right)
            (currentValue as Double) <= (right as Double)
        }
        else -> throw RuntimeException()
    }

    // Evaluates rule: term → factor ( ( "-" | "+" ) factor )*
    override fun visitTerm(ctx: LoxParser.TermContext): Any? {
        var currentValue: Any? = visitFactor(ctx.factor(0))
        for (i in 0..ctx.op.lastIndex) {
            currentValue = evaluateTerm(
                currentValue = currentValue,
                opType = ctx.op[i].type,
                factorContext = ctx.factor(i + 1)
            )
        }
        return currentValue
    }

    private fun evaluateTerm(
        currentValue: Any?,
        opType: Int,
        factorContext: LoxParser.FactorContext
    ): Any = when (opType) {
        LoxLexer.OP_MINUS -> {
            val right: Any? = visitFactor(factorContext)
            checkOperandsAreNumber(currentValue, right)
            (currentValue as Double) - (right as Double)
        }
        LoxLexer.OP_PLUS -> {
            val right: Any? = visitFactor(factorContext)
            if (currentValue is Double && right is Double) {
                currentValue + right
            } else if (currentValue is String && right is String) {
                currentValue + right
            } else if (currentValue is Double && right is String) {
                if (checkNumberIsWhole(currentValue)) {
                    currentValue.toInt().toString() + right
                } else {
                    throw RuntimeException("Incompatible operand types for '+'")
                }
            } else if (currentValue is String && right is Double) {
                if (checkNumberIsWhole(right)) {
                    currentValue + right.toInt().toString()
                } else {
                    throw RuntimeException("Incompatible operand types for '+'")
                }
            } else {
                throw throw RuntimeException("Incompatible operand types for '+'")
            }
        }
        else -> throw RuntimeException()
    }

    private fun checkNumberIsWhole(number: Double): Boolean =
        number.toString().endsWith(".0")

    // Evaluates rule: factor → unary ( ( "/" | "*" ) unary )*
    override fun visitFactor(ctx: LoxParser.FactorContext): Any? {
        var currentValue: Any? = visitUnary(ctx.unary(0))
        for (i in 0..ctx.op.lastIndex) {
            currentValue = evaluateFactor(
                currentValue = currentValue,
                opType = ctx.op[i].type,
                unaryContext = ctx.unary(i + 1)
            )
        }
        return currentValue
    }

    private fun evaluateFactor(
        currentValue: Any?,
        opType: Int,
        unaryContext: LoxParser.UnaryContext
    ): Any = when (opType) {
        LoxLexer.OP_STAR -> {
            val right: Any? = visitUnary(unaryContext)
            checkOperandsAreNumber(currentValue, right)
            (currentValue as Double) * (right as Double)
        }
        LoxLexer.OP_SLASH -> {
            val right: Any? = visitUnary(unaryContext)
            checkOperandsAreNumber(currentValue, right)
            (currentValue as Double) / (right as Double)
        }
        else -> throw RuntimeException()
    }

    // Evaluates rule: unary → ( "!" | "-" ) unary | primary
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

    // Evaluates rule: primary → NUMBER | STRING | "true" | "false" | "nil" | "(" expression ")"
    override fun visitPrimary(ctx: LoxParser.PrimaryContext): Any? =
        if (ctx.text == "true") {
            true
        } else if (ctx.text == "false") {
            false
        } else if (ctx.text == "nil") {
            null
        } else if (ctx.text.startsWith("(")) {
            visit(ctx.expression())
        } else if (ctx.text.matches(NUMBER_REGEX)) {
            ctx.text.toDouble()
        } else if (ctx.text.matches(STRING_WITH_DOUBLE_QUOTES_REGEX)) {
            ctx.text.removePrefix("\"").removeSuffix("\"")
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