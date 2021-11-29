package ir.fallahpoor.kotlox.interpreter.parser

import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.antlr.LoxBaseVisitor
import ir.fallahpoor.kotlox.interpreter.antlr.LoxLexer
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

// TODO should we throw exceptions?
// FIXME Currently when creating an Expr object, the line number of all the tokens is
//  set to 1. We should find a way to set the correct line number

class BuildAstVisitor : LoxBaseVisitor<Expr>() {

    override fun visitExpression(ctx: LoxParser.ExpressionContext): Expr {
        var expr: Expr = visitEquality(ctx.equality(0))
        for (i in 0..ctx.op.lastIndex) {
            expr = createEqualityExpr(
                currentExpr = expr,
                equalityContext = ctx.equality(i + 1)
            )
        }
        return expr
    }

    private fun createEqualityExpr(
        currentExpr: Expr,
        equalityContext: LoxParser.EqualityContext
    ): Expr =
        Expr.Binary(
            left = currentExpr,
            operator = Token(TokenType.COMMA, ",", null, 1),
            right = visitEquality(equalityContext)
        )

    override fun visitEquality(ctx: LoxParser.EqualityContext): Expr {
        var expr: Expr = visitComparison(ctx.comparison(0))
        for (i in 0..ctx.op.lastIndex) {
            expr = createComparisonExpr(
                currentExpr = expr,
                opType = ctx.op[i].type,
                comparisonContext = ctx.comparison(i + 1)
            )
        }
        return expr
    }

    private fun createComparisonExpr(
        currentExpr: Expr,
        opType: Int,
        comparisonContext: LoxParser.ComparisonContext
    ): Expr =
        when (opType) {
            LoxLexer.OP_EQUAL -> {
                Expr.Binary(
                    left = currentExpr,
                    operator = Token(TokenType.EQUAL_EQUAL, "==", null, 1),
                    right = visitComparison(comparisonContext)
                )
            }
            LoxLexer.OP_INEQUAL -> {
                Expr.Binary(
                    left = currentExpr,
                    operator = Token(TokenType.BANG_EQUAL, "!=", null, 1),
                    right = visitComparison(comparisonContext)
                )
            }
            else -> {
                throw RuntimeException()
            }
        }

    override fun visitComparison(ctx: LoxParser.ComparisonContext): Expr {
        var expr: Expr = visitTerm(ctx.term(0))
        for (i in 0..ctx.op.lastIndex) {
            expr = createTermExpr(
                currentExpr = expr,
                opType = ctx.op[i].type,
                termContext = ctx.term(i + 1)
            )
        }
        return expr
    }

    private fun createTermExpr(
        currentExpr: Expr,
        opType: Int,
        termContext: LoxParser.TermContext
    ): Expr =
        when (opType) {
            LoxLexer.OP_GREATER -> {
                Expr.Binary(
                    left = currentExpr,
                    operator = Token(TokenType.GREATER, ">", null, 1),
                    right = visitTerm(termContext)
                )
            }
            LoxLexer.OP_LESS -> {
                Expr.Binary(
                    left = currentExpr,
                    operator = Token(TokenType.LESS, "<", null, 1),
                    right = visitTerm(termContext)
                )
            }
            LoxLexer.OP_GREATER_EQUAL -> {
                Expr.Binary(
                    left = currentExpr,
                    operator = Token(TokenType.GREATER_EQUAL, ">=", null, 1),
                    right = visitTerm(termContext)
                )
            }
            LoxLexer.OP_LESS_EQUAL -> {
                Expr.Binary(
                    left = currentExpr,
                    operator = Token(TokenType.LESS_EQUAL, "<=", null, 1),
                    right = visitTerm(termContext)
                )
            }
            else -> {
                throw RuntimeException()
            }
        }

    override fun visitTerm(ctx: LoxParser.TermContext): Expr {
        var expr: Expr = visitFactor(ctx.factor(0))
        for (i in 0..ctx.op.lastIndex) {
            expr = createFactorExpr(
                currentExpr = expr,
                opType = ctx.op[i].type,
                factorContext = ctx.factor(i + 1)
            )
        }
        return expr
    }

    private fun createFactorExpr(
        currentExpr: Expr,
        opType: Int,
        factorContext: LoxParser.FactorContext
    ): Expr {
        return when (opType) {
            LoxLexer.OP_MINUS -> {
                Expr.Binary(
                    left = currentExpr,
                    operator = Token(TokenType.MINUS, "-", null, 1),
                    right = visitFactor(factorContext)
                )
            }
            LoxLexer.OP_PLUS -> {
                Expr.Binary(
                    left = currentExpr,
                    operator = Token(TokenType.PLUS, "+", null, 1),
                    right = visitFactor(factorContext)
                )
            }
            else -> {
                throw RuntimeException()
            }
        }
    }

    override fun visitFactor(ctx: LoxParser.FactorContext): Expr {
        var expr: Expr = visitUnary(ctx.unary(0))
        for (i in 0..ctx.op.lastIndex) {
            expr = createUnaryExpr(
                currentExpr = expr,
                opType = ctx.op[i].type,
                unaryContext = ctx.unary(i + 1)
            )
        }
        return expr
    }

    private fun createUnaryExpr(
        currentExpr: Expr,
        opType: Int,
        unaryContext: LoxParser.UnaryContext
    ): Expr =
        when (opType) {
            LoxLexer.OP_STAR -> {
                Expr.Binary(
                    left = currentExpr,
                    operator = Token(TokenType.STAR, "*", null, 1),
                    right = visitUnary(unaryContext)
                )
            }
            LoxLexer.OP_SLASH -> {
                Expr.Binary(
                    left = currentExpr,
                    operator = Token(TokenType.SLASH, "/", null, 1),
                    right = visitUnary(unaryContext)
                )
            }
            else -> {
                throw RuntimeException()
            }
        }

    override fun visitUnary(ctx: LoxParser.UnaryContext): Expr =
        if (ctx.unary() == null) {
            visitPrimary(ctx.primary())
        } else {
            createPrimary(ctx.op[0].type, ctx)
        }

    private fun createPrimary(opType: Int, unaryContext: LoxParser.UnaryContext): Expr =
        when (opType) {
            LoxLexer.OP_BANG -> {
                Expr.Unary(
                    operator = Token(TokenType.BANG, "!", null, 1),
                    right = visitUnary(unaryContext.unary())
                )
            }
            LoxLexer.OP_MINUS -> {
                Expr.Unary(
                    operator = Token(TokenType.MINUS, "-", null, 1),
                    right = visitUnary(unaryContext.unary())
                )
            }
            else -> {
                throw RuntimeException()
            }
        }

    override fun visitPrimary(ctx: LoxParser.PrimaryContext): Expr =
        if (ctx.text == "true") {
            Expr.Literal(true)
        } else if (ctx.text == "false") {
            Expr.Literal(false)
        } else if (ctx.text == "nil") {
            Expr.Literal(null)
        } else if (ctx.text.startsWith("(")) {
            Expr.Grouping(visit(ctx.expression()))
        } else if (ctx.text.matches("\\d+(.\\d+)?".toRegex())) {
            Expr.Literal(ctx.text.toDouble())
        } else {
            throw RuntimeException()
        }

}