package ir.fallahpoor.kotlox.interpreter.parser

import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

/**
 * This class implements a recursive descent parser for the following grammar. The grammar is
 * unambiguous and has no left-recursive rules. Otherwise, it would not be possible to implement
 * such a parser.
 *
 * expression → equality;
 * equality   → comparison ( ( "!=" | "==" ) comparison )*;
 * comparison → term ( ( ">" | ">=" | "<" | "<=" ) term )*;
 * term       → factor ( ( "-" | "+" ) factor )*;
 * factor     → unary ( ( "/" | "*" ) unary )*;
 * unary      → ( "!" | "-" ) unary | primary;
 * primary    → NUMBER | STRING | "true" | "false" | "nil" | "(" expression ")"
 */
class Parser(
    private val tokens: Tokens,
    private val errorReporter: ErrorReporter
) {

    private class ParseError : RuntimeException()

    fun parse(): Expr? =
        try {
            expression()
        } catch (error: ParseError) {
            null
        }

    private fun expression(): Expr = equality()

    private fun equality(): Expr {
        var expr: Expr = comparison()
        while (tokens.getNextTokenIfItHasType(TokenType.BANG_EQUAL, TokenType.EQUAL_EQUAL)) {
            val operator: Token = tokens.getPreviousToken()
            val right: Expr = comparison()
            expr = Expr.Binary(expr, operator, right)
        }
        return expr
    }

    private fun comparison(): Expr {
        var expr: Expr = term()
        while (tokens.getNextTokenIfItHasType(
                TokenType.GREATER,
                TokenType.GREATER_EQUAL,
                TokenType.LESS,
                TokenType.LESS_EQUAL
            )
        ) {
            val operator: Token = tokens.getPreviousToken()
            val right: Expr = term()
            expr = Expr.Binary(expr, operator, right)
        }
        return expr
    }

    private fun term(): Expr {
        var expr: Expr = factor()
        while (tokens.getNextTokenIfItHasType(TokenType.MINUS, TokenType.PLUS)) {
            val operator: Token = tokens.getPreviousToken()
            val right: Expr = factor()
            expr = Expr.Binary(expr, operator, right)
        }
        return expr
    }

    private fun factor(): Expr {
        var expr: Expr = unary()
        while (tokens.getNextTokenIfItHasType(TokenType.SLASH, TokenType.STAR)) {
            val operator: Token = tokens.getPreviousToken()
            val right: Expr = unary()
            expr = Expr.Binary(expr, operator, right)
        }
        return expr
    }

    private fun unary(): Expr =
        if (tokens.getNextTokenIfItHasType(TokenType.BANG, TokenType.MINUS)) {
            val operator: Token = tokens.getPreviousToken()
            val right = unary()
            Expr.Unary(operator, right)
        } else {
            primary()
        }

    private fun primary(): Expr {
        if (tokens.getNextTokenIfItHasType(TokenType.FALSE)) {
            return Expr.Literal(false)
        }
        if (tokens.getNextTokenIfItHasType(TokenType.TRUE)) {
            return Expr.Literal(true)
        }
        if (tokens.getNextTokenIfItHasType(TokenType.NIL)) {
            return Expr.Literal(null)
        }
        if (tokens.getNextTokenIfItHasType(TokenType.NUMBER, TokenType.STRING)) {
            return Expr.Literal(tokens.getPreviousToken().literal)
        }
        if (tokens.getNextTokenIfItHasType(TokenType.LEFT_PAREN)) {
            val expr = expression()
            consumeTokenOrThrowError(TokenType.RIGHT_PAREN, "Expect ')' after expression.")
            return Expr.Grouping(expr)
        }
        throw error(tokens.peekNextToken(), "Expect expression.")
    }

    // Checks to see if the next token is of the expected type. If so, it consumes the token.
    // Otherwise, we report an error.
    private fun consumeTokenOrThrowError(type: TokenType, errorMessage: String): Token {
        if (tokens.nextTokenHasType(type)) {
            return tokens.getNextToken()
        } else {
            throw error(tokens.peekNextToken(), errorMessage)
        }
    }

    private fun error(token: Token, errorMessage: String): ParseError {
        errorReporter.error(token, errorMessage)
        return ParseError()
    }

    // When the parser encounters an error, this method is called to discard some tokens until
    // we reach a boundary. We define boundary as the start of a new expression or when we see
    // a semicolon.
    private fun synchronize() {
        tokens.getNextToken()
        while (!tokens.isAtEnd()) {
            if (tokens.getPreviousToken().type == TokenType.SEMICOLON) {
                return
            }
            when (tokens.peekNextToken().type) {
                TokenType.CLASS,
                TokenType.FUN,
                TokenType.VAR,
                TokenType.FOR,
                TokenType.IF,
                TokenType.WHILE,
                TokenType.PRINT,
                TokenType.RETURN -> return
            }
            tokens.getNextToken()
        }
    }

}