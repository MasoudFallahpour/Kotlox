package ir.fallahpoor.kotlox.interpreter.parser

import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

/**
 * This class implements a recursive descent parser for the following grammar. The grammar is
 * unambiguous and has no left-recursive rules. Otherwise, it would not be possible to implement
 * such a parser.
 *
 * program     -> declaration* EOF
 * declaration -> varDecl | statement
 * varDecl     -> "var" IDENTIFIER ("=" expression)? ";"
 * statement   -> exprStmt | printStmt
 * exprStmt    -> expression ";"
 * printStmt   -> "print" expression ";"
 * expression  -> equality ("," equality)*
 * equality    -> comparison ( ( "!=" | "==" ) comparison )*
 * comparison  -> term ( ( ">" | ">=" | "<" | "<=" ) term )*
 * term        -> factor ( ( "-" | "+" ) factor )*
 * factor      -> unary ( ( "/" | "*" ) unary )*
 * unary       -> ( "!" | "-" ) unary | primary
 * primary     -> NUMBER | STRING | IDENTIFIER | "true" | "false" | "nil" | "(" expression ")"
 */
class Parser(
    private val tokens: Tokens,
    private val errorReporter: ErrorReporter
) {

    class ParseError : RuntimeException()

    fun parse(): List<Stmt> {
        val statements = mutableListOf<Stmt>()
        while (!tokens.isAtEnd()) {
            val stmt: Stmt? = declaration()
            if (stmt != null) {
                statements.add(stmt)
            }
        }
        return statements
    }

    private fun declaration(): Stmt? {
        return try {
            if (tokens.getNextTokenIfItHasType(TokenType.VAR)) {
                varDeclaration()
            } else {
                statement()
            }
        } catch (error: ParseError) {
            synchronize()
            null
        }
    }

    private fun varDeclaration(): Stmt {
        val name: Token = consumeTokenOrThrowError(TokenType.IDENTIFIER, "Expect variable name.")
        var initializer: Expr? = null
        if (tokens.getNextTokenIfItHasType(TokenType.EQUAL)) {
            initializer = expression()
        }
        consumeTokenOrThrowError(TokenType.SEMICOLON, "Expect ';' after variable declaration.")
        return Stmt.Var(name, initializer)
    }

    private fun statement(): Stmt =
        if (tokens.getNextTokenIfItHasType(TokenType.PRINT)) {
            printStatement()
        } else {
            expressionStatement()
        }

    private fun printStatement(): Stmt {
        val value = expression()
        consumeTokenOrThrowError(TokenType.SEMICOLON, "Expect ';' after expression.")
        return Stmt.Print(value)
    }

    private fun expressionStatement(): Stmt {
        val expr = expression()
        consumeTokenOrThrowError(TokenType.SEMICOLON, "Expect ';' after expression.")
        return Stmt.Expression(expr)
    }

    private fun expression(): Expr {
        var expr: Expr = equality()
        while (tokens.getNextTokenIfItHasType(TokenType.COMMA)) {
            val operator: Token = tokens.getPreviousToken()
            val right: Expr = equality()
            expr = Expr.Binary(expr, operator, right)
        }
        return expr
    }

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

    private fun primary(): Expr =
        if (tokens.getNextTokenIfItHasType(TokenType.FALSE)) {
            Expr.Literal(false)
        } else if (tokens.getNextTokenIfItHasType(TokenType.TRUE)) {
            Expr.Literal(true)
        } else if (tokens.getNextTokenIfItHasType(TokenType.NIL)) {
            Expr.Literal(null)
        } else if (tokens.getNextTokenIfItHasType(TokenType.NUMBER, TokenType.STRING)) {
            Expr.Literal(tokens.getPreviousToken().literal)
        } else if (tokens.getNextTokenIfItHasType(TokenType.IDENTIFIER)) {
            Expr.Variable(tokens.getPreviousToken())
        } else if (tokens.getNextTokenIfItHasType(TokenType.LEFT_PAREN)) {
            val expr = expression()
            consumeTokenOrThrowError(TokenType.RIGHT_PAREN, "Expect ')' after expression.")
            Expr.Grouping(expr)
        } else {
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