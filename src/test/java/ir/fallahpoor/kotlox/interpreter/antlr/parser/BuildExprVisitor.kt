package ir.fallahpoor.kotlox.interpreter.antlr.parser

import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.antlr.LoxBaseVisitor
import ir.fallahpoor.kotlox.interpreter.antlr.LoxLexer
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

// TODO should we throw exceptions?

class BuildExprVisitor(
    private val errorReporter: ErrorReporter
) : LoxBaseVisitor<Expr>() {

    companion object {
        private val NUMBER_REGEX = "\\d+(.\\d+)?".toRegex()
        private val STRING_WITH_DOUBLE_QUOTES_REGEX = "\"[^\"]*\"".toRegex()
        private const val FUNCTION_CALL_MAX_ARGUMENT_LIST_SIZE = 255
    }

    private var isParsingFunctionArguments = false

    override fun visitExpression(ctx: LoxParser.ExpressionContext): Expr =
        visitAssignment(ctx.assignment())

    override fun visitAssignment(ctx: LoxParser.AssignmentContext): Expr =
        if (ctx.assign != null) {
            val value: Expr = visitAssignment(ctx.assignment())
            val name = Token(
                TokenType.IDENTIFIER,
                ctx.IDENTIFIER().symbol.text,
                null,
                ctx.IDENTIFIER().symbol.line
            )
            Expr.Assign(name, value)
        } else if (!isParsingFunctionArguments) {
            var expr: Expr = visitLogicOr(ctx.logicOr(0))
            for (i in ctx.op.indices) {
                expr = createOrExpr(
                    currentExpr = expr,
                    ctx.op[i],
                    logicOrContext = ctx.logicOr(i + 1)
                )
            }
            expr
        } else {
            visitChildren(ctx)
        }

    private fun createOrExpr(
        currentExpr: Expr,
        token: org.antlr.v4.runtime.Token,
        logicOrContext: LoxParser.LogicOrContext
    ): Expr = Expr.Binary(
        left = currentExpr,
        operator = Token(TokenType.COMMA, ",", null, token.line),
        right = visitLogicOr(logicOrContext)
    )

    override fun visitLogicOr(ctx: LoxParser.LogicOrContext): Expr {
        var expr: Expr = visitLogicAnd(ctx.logicAnd(0))
        for (i in ctx.or.indices) {
            expr = createAndExpr(
                currentExpr = expr,
                token = ctx.or[i],
                logicAndContext = ctx.logicAnd(i + 1)
            )
        }
        return expr
    }

    private fun createAndExpr(
        currentExpr: Expr,
        token: org.antlr.v4.runtime.Token,
        logicAndContext: LoxParser.LogicAndContext
    ): Expr = Expr.Logical(
        left = currentExpr,
        operator = Token(TokenType.OR, "or", null, token.line),
        right = visitLogicAnd(logicAndContext)
    )

    override fun visitLogicAnd(ctx: LoxParser.LogicAndContext): Expr {
        var expr: Expr = visitEquality(ctx.equality(0))
        for (i in ctx.and.indices) {
            expr = createEqualityExpr(
                currentExpr = expr,
                token = ctx.and[i],
                equalityContext = ctx.equality(i + 1)
            )
        }
        return expr
    }

    private fun createEqualityExpr(
        currentExpr: Expr,
        token: org.antlr.v4.runtime.Token,
        equalityContext: LoxParser.EqualityContext
    ): Expr = Expr.Logical(
        left = currentExpr,
        operator = Token(TokenType.AND, "and", null, token.line),
        right = visitEquality(equalityContext)
    )

    override fun visitEquality(ctx: LoxParser.EqualityContext): Expr {
        var expr: Expr = visitComparison(ctx.comparison(0))
        for (i in ctx.op.indices) {
            expr = createComparisonExpr(
                currentExpr = expr,
                token = ctx.op[i],
                comparisonContext = ctx.comparison(i + 1)
            )
        }
        return expr
    }

    private fun createComparisonExpr(
        currentExpr: Expr,
        token: org.antlr.v4.runtime.Token,
        comparisonContext: LoxParser.ComparisonContext
    ): Expr = when (token.type) {
        LoxLexer.OP_EQUAL ->
            Expr.Binary(
                left = currentExpr,
                operator = Token(TokenType.EQUAL_EQUAL, "==", null, token.line),
                right = visitComparison(comparisonContext)
            )
        LoxLexer.OP_INEQUAL ->
            Expr.Binary(
                left = currentExpr,
                operator = Token(TokenType.BANG_EQUAL, "!=", null, token.line),
                right = visitComparison(comparisonContext)
            )
        else -> throw RuntimeException()
    }

    override fun visitComparison(ctx: LoxParser.ComparisonContext): Expr {
        var expr: Expr = visitTerm(ctx.term(0))
        for (i in ctx.op.indices) {
            expr = createTermExpr(
                currentExpr = expr,
                token = ctx.op[i],
                termContext = ctx.term(i + 1)
            )
        }
        return expr
    }

    private fun createTermExpr(
        currentExpr: Expr,
        token: org.antlr.v4.runtime.Token,
        termContext: LoxParser.TermContext
    ): Expr = when (token.type) {
        LoxLexer.OP_GREATER ->
            Expr.Binary(
                left = currentExpr,
                operator = Token(TokenType.GREATER, ">", null, token.line),
                right = visitTerm(termContext)
            )
        LoxLexer.OP_LESS ->
            Expr.Binary(
                left = currentExpr,
                operator = Token(TokenType.LESS, "<", null, token.line),
                right = visitTerm(termContext)
            )
        LoxLexer.OP_GREATER_EQUAL ->
            Expr.Binary(
                left = currentExpr,
                operator = Token(TokenType.GREATER_EQUAL, ">=", null, token.line),
                right = visitTerm(termContext)
            )
        LoxLexer.OP_LESS_EQUAL ->
            Expr.Binary(
                left = currentExpr,
                operator = Token(TokenType.LESS_EQUAL, "<=", null, token.line),
                right = visitTerm(termContext)
            )
        else -> throw RuntimeException()
    }

    override fun visitTerm(ctx: LoxParser.TermContext): Expr {
        var expr: Expr = visitFactor(ctx.factor(0))
        for (i in ctx.op.indices) {
            expr = createFactorExpr(
                currentExpr = expr,
                token = ctx.op[i],
                factorContext = ctx.factor(i + 1)
            )
        }
        return expr
    }

    private fun createFactorExpr(
        currentExpr: Expr,
        token: org.antlr.v4.runtime.Token,
        factorContext: LoxParser.FactorContext
    ): Expr = when (token.type) {
        LoxLexer.OP_MINUS ->
            Expr.Binary(
                left = currentExpr,
                operator = Token(TokenType.MINUS, "-", null, token.line),
                right = visitFactor(factorContext)
            )
        LoxLexer.OP_PLUS ->
            Expr.Binary(
                left = currentExpr,
                operator = Token(TokenType.PLUS, "+", null, token.line),
                right = visitFactor(factorContext)
            )
        else -> throw RuntimeException()
    }

    override fun visitFactor(ctx: LoxParser.FactorContext): Expr {
        var expr: Expr = visitUnary(ctx.unary(0))
        for (i in ctx.op.indices) {
            expr = createUnaryExpr(
                currentExpr = expr,
                token = ctx.op[i],
                unaryContext = ctx.unary(i + 1)
            )
        }
        return expr
    }

    private fun createUnaryExpr(
        currentExpr: Expr,
        token: org.antlr.v4.runtime.Token,
        unaryContext: LoxParser.UnaryContext
    ): Expr = when (token.type) {
        LoxLexer.OP_STAR ->
            Expr.Binary(
                left = currentExpr,
                operator = Token(TokenType.STAR, "*", null, token.line),
                right = visitUnary(unaryContext)
            )
        LoxLexer.OP_SLASH ->
            Expr.Binary(
                left = currentExpr,
                operator = Token(TokenType.SLASH, "/", null, token.line),
                right = visitUnary(unaryContext)
            )
        else -> throw RuntimeException()
    }

    override fun visitUnary(ctx: LoxParser.UnaryContext): Expr =
        if (ctx.unary() != null) {
            createPrimary(ctx.op[0], ctx)
        } else {
            visitCall(ctx.call())
        }

    override fun visitCall(ctx: LoxParser.CallContext): Expr {
        var expr: Expr = visitPrimary(ctx.primary())
        if (ctx.leftParen.isNotEmpty()) {
            for (i in ctx.leftParen.indices) {
                isParsingFunctionArguments = true
                val rightParen = Token(TokenType.RIGHT_PAREN, ")", null, ctx.rightParen[i].line)
                expr = finishCall(expr, ctx.arguments(i), rightParen)
                isParsingFunctionArguments = false
            }
        }
        return expr
    }

    private fun finishCall(callee: Expr, ctx: LoxParser.ArgumentsContext?, rightParen: Token): Expr {
        return if (ctx == null) {
            Expr.Call(callee, rightParen, emptyList())
        } else {
            val arguments = mutableListOf<Expr>().apply {
                add(visitExpression(ctx.expression(0)))
            }
            for (i in ctx.comma.indices) {
                if (arguments.size >= FUNCTION_CALL_MAX_ARGUMENT_LIST_SIZE) {
                    val token = Token(TokenType.COMMA, ",", null, ctx.comma[i].line)
                    errorReporter.error(token, "Can't have more than 255 parameters.")
                }
                arguments += visitExpression(ctx.expression(i + 1))
            }
            Expr.Call(callee, rightParen, arguments)
        }
    }

    private fun createPrimary(
        token: org.antlr.v4.runtime.Token,
        unaryContext: LoxParser.UnaryContext
    ): Expr = when (token.type) {
        LoxLexer.OP_BANG ->
            Expr.Unary(
                operator = Token(TokenType.BANG, "!", null, token.line),
                right = visitUnary(unaryContext.unary())
            )
        LoxLexer.OP_MINUS ->
            Expr.Unary(
                operator = Token(TokenType.MINUS, "-", null, token.line),
                right = visitUnary(unaryContext.unary())
            )
        else -> throw RuntimeException()
    }

    override fun visitPrimary(ctx: LoxParser.PrimaryContext): Expr =
        if (ctx.text == "true") {
            Expr.Literal(true)
        } else if (ctx.text == "false") {
            Expr.Literal(false)
        } else if (ctx.text == "nil") {
            Expr.Literal(null)
        } else if (ctx.IDENTIFIER() != null) {
            val token = Token(
                TokenType.IDENTIFIER,
                ctx.IDENTIFIER().symbol.text,
                null,
                ctx.IDENTIFIER().symbol.line
            )
            Expr.Variable(token)
        } else if (ctx.text.startsWith("(")) {
            Expr.Grouping(visit(ctx.expression()))
        } else if (ctx.text.matches(NUMBER_REGEX)) {
            Expr.Literal(ctx.text.toDouble())
        } else if (ctx.text.matches(STRING_WITH_DOUBLE_QUOTES_REGEX)) {
            Expr.Literal(ctx.text.removePrefix("\"").removeSuffix("\""))
        } else {
            throw RuntimeException()
        }

}