package ir.fallahpoor.kotlox.interpreter.parser

import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.Expr.Logical
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType
import java.util.*

/**
 * This class implements a recursive descent parser for the following grammar. The grammar is
 * unambiguous and has no left-recursive rules. Otherwise, it would not be possible to implement
 * such a parser.
 *
 * program     -> declaration* EOF
 * declaration -> funcDecl | varDecl | statement
 * funcDecl    -> "fun" function
 * function    -> IDENTIFIER "(" parameters? ")" block
 * parameters  -> IDENTIFIER ( "," IDENTIFIER )*
 * varDecl     -> "var" IDENTIFIER ("=" expression)? ";"
 * statement   -> exprStmt | forStmt | ifStmt | printStmt | returnStmt | whileStmt | block | breakStmt
 * exprStmt    -> expression ";"
 * forStmt     -> "for" "(" ( varDecl | exprStmt | ";" ) expression? ";" expression? ")" statement
 * ifStmt      -> "if" "(" expression ")" statement ("else" statement)?
 * printStmt   -> "print" expression ";"
 * returnStmt  -> "return" expression? ";"
 * whileStmt   -> "while" "(" expression ")" statement
 * block       -> "{" declaration* "}"
 * breakStmt   -> "break" ";"
 * expression  -> assignment
 * assignment  -> IDENTIFIER "=" assignment | logicOr ("," logicOr)*
 * logicOr     -> logicAnd ("or" logicAnd)*
 * logicAnd    -> equality ("and" equality)*
 * equality    -> comparison ( ( "!=" | "==" ) comparison )*
 * comparison  -> term ( ( ">" | ">=" | "<" | "<=" ) term )*
 * term        -> factor ( ( "-" | "+" ) factor )*
 * factor      -> unary ( ( "/" | "*" ) unary )*
 * unary       -> ( "!" | "-" ) unary | call
 * call        -> primary ( "(" arguments? ")" )*
 * arguments   -> expression ( "," expression )* ;
 * primary     -> NUMBER | STRING | IDENTIFIER | "true" | "false" | "nil" | "(" expression ")"
 */
class Parser(
    private val tokens: Tokens,
    private val errorReporter: ErrorReporter
) {

    companion object {
        private const val FUNCTION_CALL_MAX_ARGUMENT_LIST_SIZE = 255
    }

    class ParseError : RuntimeException()

    private var breakStack = Stack<Boolean>()
    private var isParsingFunctionArguments = false

    fun parse(): List<Stmt> {
        val statements = mutableListOf<Stmt>()
        while (!tokens.isAtEnd()) {
            val stmt: Stmt? = declaration()
            if (stmt != null) {
                statements += stmt
            }
        }
        return statements
    }

    private fun declaration(): Stmt? {
        return try {
            if (tokens.consumeNextTokenIfItHasType((TokenType.FUN))) {
                function("function")
            } else if (tokens.consumeNextTokenIfItHasType(TokenType.VAR)) {
                varDeclaration()
            } else {
                statement()
            }
        } catch (error: ParseError) {
            synchronize()
            null
        }
    }

    private fun function(kind: String): Stmt.Function {
        val name = consumeNextTokenOrThrowError(TokenType.IDENTIFIER, "Expect $kind name.")
        consumeNextTokenOrThrowError(TokenType.LEFT_PAREN, "Expect '(' after $kind name.")
        val parameters = mutableListOf<Token>()
        if (!tokens.nextTokenHasType(TokenType.RIGHT_PAREN)) {
            do {
                if (parameters.size >= FUNCTION_CALL_MAX_ARGUMENT_LIST_SIZE) {
                    errorReporter.error(tokens.peekNextToken(), "Can't have more than 255 parameters.")
                }
                parameters += consumeNextTokenOrThrowError(TokenType.IDENTIFIER, "Expect parameter name.")
            } while (tokens.consumeNextTokenIfItHasType(TokenType.COMMA))
        }
        consumeNextTokenOrThrowError(TokenType.RIGHT_PAREN, "Expect ')' after parameters.")
        consumeNextTokenOrThrowError(TokenType.LEFT_BRACE, "Expect '{' before $kind body.")
        val body = block()
        return Stmt.Function(name, parameters, body)
    }

    private fun varDeclaration(): Stmt {
        val name: Token = consumeNextTokenOrThrowError(TokenType.IDENTIFIER, "Expect variable name.")
        var initializer: Expr? = null
        if (tokens.consumeNextTokenIfItHasType(TokenType.EQUAL)) {
            initializer = expression()
        }
        consumeNextTokenOrThrowError(TokenType.SEMICOLON, "Expect ';' after variable declaration.")
        return Stmt.Var(name, initializer)
    }

    private fun statement(): Stmt {
        val stmt: Stmt
        if (tokens.consumeNextTokenIfItHasType(TokenType.BREAK)) {
            stmt = breakStatement()
        } else if (tokens.consumeNextTokenIfItHasType(TokenType.FOR)) {
            breakStack.push(true)
            stmt = forStatement()
            breakStack.pop()
        } else if (tokens.consumeNextTokenIfItHasType(TokenType.IF)) {
            stmt = ifStatement()
        } else if (tokens.consumeNextTokenIfItHasType(TokenType.PRINT)) {
            stmt = printStatement()
        } else if (tokens.consumeNextTokenIfItHasType(TokenType.RETURN)) {
            stmt = returnStatement()
        } else if (tokens.consumeNextTokenIfItHasType(TokenType.WHILE)) {
            breakStack.push(true)
            stmt = whileStatement()
            breakStack.pop()
        } else if (tokens.consumeNextTokenIfItHasType(TokenType.LEFT_BRACE)) {
            stmt = Stmt.Block(block())
        } else {
            stmt = expressionStatement()
        }
        return stmt
    }

    private fun breakStatement(): Stmt {
        val breakToken = tokens.getPreviousToken()
        consumeNextTokenOrThrowError(TokenType.SEMICOLON, "Expect ';' after 'break'.")
        if (!breakStack.peek()) {
            throw reportErrorAndThrowParseException(breakToken, "'break' is only allowed inside a loop.")
        }
        return Stmt.Break
    }

    // A "for loop" in Lox is syntactic sugar. So we desugar it here and convert it to a "while loop".
    private fun forStatement(): Stmt {
        consumeNextTokenOrThrowError(TokenType.LEFT_PAREN, "Expect '(' after 'for'.")
        val initializer: Stmt? = if (tokens.consumeNextTokenIfItHasType(TokenType.SEMICOLON)) {
            null
        } else if (tokens.consumeNextTokenIfItHasType(TokenType.VAR)) {
            varDeclaration()
        } else {
            expressionStatement()
        }
        var condition: Expr? = if (tokens.nextTokenHasType(TokenType.SEMICOLON)) {
            null
        } else {
            expression()
        }
        consumeNextTokenOrThrowError(TokenType.SEMICOLON, "Expect ';' after loop condition.")
        val increment: Expr? = if (tokens.nextTokenHasType(TokenType.RIGHT_PAREN)) {
            null
        } else {
            expression()
        }
        consumeNextTokenOrThrowError(TokenType.RIGHT_PAREN, "Expect ')' after for clauses.")
        var body: Stmt = statement()
        if (increment != null) {
            body = Stmt.Block(listOf(body, Stmt.Expression(increment)))
        }
        if (condition == null) {
            condition = Expr.Literal(true)
        }
        body = Stmt.While(condition, body)
        if (initializer != null) {
            body = Stmt.Block(listOf(initializer, body))
        }
        return body
    }

    private fun ifStatement(): Stmt {
        consumeNextTokenOrThrowError(TokenType.LEFT_PAREN, "Expect '(' after 'if'.")
        val condition = expression()
        consumeNextTokenOrThrowError(TokenType.RIGHT_PAREN, "Expect ')' after if condition.")
        val thenBranch = statement()
        val elseBranch: Stmt? = if (tokens.consumeNextTokenIfItHasType(TokenType.ELSE)) {
            statement()
        } else {
            null
        }
        return Stmt.If(condition, thenBranch, elseBranch)
    }

    private fun printStatement(): Stmt {
        val value = expression()
        consumeNextTokenOrThrowError(TokenType.SEMICOLON, "Expect ';' after expression.")
        return Stmt.Print(value)
    }

    private fun returnStatement(): Stmt {
        val keyword: Token = tokens.getPreviousToken()
        val value: Expr? = if (tokens.nextTokenHasType(TokenType.SEMICOLON)) {
            null
        } else {
            expression()
        }
        consumeNextTokenOrThrowError(TokenType.SEMICOLON, "Expect ';' after return value.")
        return Stmt.Return(keyword, value)
    }

    private fun whileStatement(): Stmt {
        consumeNextTokenOrThrowError(TokenType.LEFT_PAREN, "Expect '(' after 'while'.")
        val condition = expression()
        consumeNextTokenOrThrowError(TokenType.RIGHT_PAREN, "Expect ')' after condition.")
        val body = statement()
        return Stmt.While(condition, body)
    }

    private fun block(): List<Stmt> {
        val statements = mutableListOf<Stmt>()
        while (!tokens.nextTokenHasType(TokenType.RIGHT_BRACE) && !tokens.isAtEnd()) {
            val declaration = declaration()
            if (declaration != null) {
                statements += declaration
            }
        }
        consumeNextTokenOrThrowError(TokenType.RIGHT_BRACE, "Expect '}' after block.")
        return statements
    }

    private fun expressionStatement(): Stmt {
        val expr = expression()
        consumeNextTokenOrThrowError(TokenType.SEMICOLON, "Expect ';' after expression.")
        return Stmt.Expression(expr)
    }

    private fun expression(): Expr = assignment()

    private fun assignment(): Expr {
        var expr: Expr = or()
        if (tokens.consumeNextTokenIfItHasType(TokenType.EQUAL)) {
            val equals: Token = tokens.getPreviousToken()
            val value: Expr = assignment()
            if (expr is Expr.Variable) {
                val name = expr.name
                expr = Expr.Assign(name, value)
            } else {
                throw reportErrorAndThrowParseException(equals, "Invalid assignment target.")
            }
        } else if (!isParsingFunctionArguments) {
            while (tokens.getNextTokenIfItHasType(TokenType.COMMA)) {
                val operator: Token = tokens.getPreviousToken()
                val right: Expr = or()
                expr = Expr.Binary(expr, operator, right)
            }
        }
        return expr
    }

    private fun or(): Expr {
        var expr: Expr = and()
        while (tokens.consumeNextTokenIfItHasType(TokenType.OR)) {
            val operator: Token = tokens.getPreviousToken()
            val right: Expr = and()
            expr = Logical(expr, operator, right)
        }
        return expr
    }

    private fun and(): Expr {
        var expr = equality()
        while (tokens.consumeNextTokenIfItHasType(TokenType.AND)) {
            val operator: Token = tokens.getPreviousToken()
            val right = equality()
            expr = Logical(expr, operator, right)
        }
        return expr
    }

    private fun equality(): Expr {
        var expr: Expr = comparison()
        while (tokens.consumeNextTokenIfItHasType(TokenType.BANG_EQUAL, TokenType.EQUAL_EQUAL)) {
            val operator: Token = tokens.getPreviousToken()
            val right: Expr = comparison()
            expr = Expr.Binary(expr, operator, right)
        }
        return expr
    }

    private fun comparison(): Expr {
        var expr: Expr = term()
        while (tokens.consumeNextTokenIfItHasType(
                TokenType.GREATER, TokenType.GREATER_EQUAL, TokenType.LESS, TokenType.LESS_EQUAL
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
        while (tokens.consumeNextTokenIfItHasType(TokenType.MINUS, TokenType.PLUS)) {
            val operator: Token = tokens.getPreviousToken()
            val right: Expr = factor()
            expr = Expr.Binary(expr, operator, right)
        }
        return expr
    }

    private fun factor(): Expr {
        var expr: Expr = unary()
        while (tokens.consumeNextTokenIfItHasType(TokenType.SLASH, TokenType.STAR)) {
            val operator: Token = tokens.getPreviousToken()
            val right: Expr = unary()
            expr = Expr.Binary(expr, operator, right)
        }
        return expr
    }

    private fun unary(): Expr = if (tokens.consumeNextTokenIfItHasType(TokenType.BANG, TokenType.MINUS)) {
        val operator: Token = tokens.getPreviousToken()
        val right = unary()
        Expr.Unary(operator, right)
    } else {
        call()
    }

    private fun call(): Expr {
        var expr: Expr = primary()
        while (true) {
            if (tokens.getNextTokenIfItHasType(TokenType.LEFT_PAREN)) {
                isParsingFunctionArguments = true
                expr = finishCall(expr)
                isParsingFunctionArguments = false
            } else {
                break
            }
        }
        return expr
    }

    private fun finishCall(callee: Expr): Expr {
        val arguments = mutableListOf<Expr>()
        if (!tokens.nextTokenHasType(TokenType.RIGHT_PAREN)) {
            do {
                if (arguments.size >= FUNCTION_CALL_MAX_ARGUMENT_LIST_SIZE) {
                    errorReporter.error(tokens.peekNextToken(), "Can't have more than 255 arguments.")
                }
                arguments += expression()
            } while (tokens.consumeNextTokenIfItHasType(TokenType.COMMA))
        }
        val paren: Token = consumeNextTokenOrThrowError(
            TokenType.RIGHT_PAREN, "Expect ')' after arguments."
        )
        return Expr.Call(callee, paren, arguments)
    }

    private fun primary(): Expr = if (tokens.consumeNextTokenIfItHasType(TokenType.FALSE)) {
        Expr.Literal(false)
    } else if (tokens.consumeNextTokenIfItHasType(TokenType.TRUE)) {
        Expr.Literal(true)
    } else if (tokens.consumeNextTokenIfItHasType(TokenType.NIL)) {
        Expr.Literal(null)
    } else if (tokens.consumeNextTokenIfItHasType(TokenType.NUMBER, TokenType.STRING)) {
        Expr.Literal(tokens.getPreviousToken().literal)
    } else if (tokens.consumeNextTokenIfItHasType(TokenType.IDENTIFIER)) {
        Expr.Variable(tokens.getPreviousToken())
    } else if (tokens.consumeNextTokenIfItHasType(TokenType.LEFT_PAREN)) {
        val expr = expression()
        consumeNextTokenOrThrowError(
            expectedTokenType = TokenType.RIGHT_PAREN,
            errorMessage = "Expect ')' after expression."
        )
        Expr.Grouping(expr)
    } else {
        throw reportErrorAndThrowParseException(
            unexpectedToken = tokens.peekNextToken(),
            errorMessage = "Expect expression."
        )
    }

    /**
     * Checks to see if the next token is of the given type. If so, it consumes the token.
     * Otherwise, it reports an error.
     *
     * In the reference Java implementation this method is called 'consume'.
     */
    private fun consumeNextTokenOrThrowError(expectedTokenType: TokenType, errorMessage: String): Token {
        if (tokens.nextTokenHasType(expectedTokenType)) {
            return tokens.consumeNextToken()
        } else {
            throw reportErrorAndThrowParseException(
                unexpectedToken = tokens.peekNextToken(),
                errorMessage = errorMessage
            )
        }
    }

    /**
     * Reports an error and then throws a ParseException.
     *
     * In the reference Java implementation this method is called 'error'.
     */
    private fun reportErrorAndThrowParseException(unexpectedToken: Token, errorMessage: String): ParseError {
        errorReporter.error(unexpectedToken, errorMessage)
        return ParseError()
    }

    /**
     * This method is called when the parser encounters a syntax error. It discards tokens until we
     * reach a boundary. We define the boundary as the start of a new expression or when we see a semicolon.
     */
    private fun synchronize() {
        tokens.consumeNextToken()
        while (!tokens.isAtEnd()) {
            if (tokens.getPreviousToken().type == TokenType.SEMICOLON) {
                return
            }
            when (tokens.peekNextToken().type) {
                TokenType.CLASS, TokenType.FUN, TokenType.VAR, TokenType.FOR, TokenType.IF, TokenType.WHILE, TokenType.PRINT, TokenType.RETURN -> return
                else -> tokens.consumeNextToken()
            }
        }
    }

}