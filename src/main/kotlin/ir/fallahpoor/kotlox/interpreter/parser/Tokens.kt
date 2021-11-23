package ir.fallahpoor.kotlox.interpreter.parser

import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

class Tokens(private val tokens: List<Token>) {

    private var currentTokenIndex = 0

    fun getNextTokenIfItHasType(vararg types: TokenType): Boolean {
        for (type in types) {
            if (nextTokenHasType(type)) {
                getNextToken()
                return true
            }
        }
        return false
    }

    fun nextTokenHasType(type: TokenType): Boolean =
        if (isAtEnd()) {
            false
        } else {
            peekNextToken().type == type
        }

    fun getNextToken(): Token {
        if (!isAtEnd()) {
            currentTokenIndex++
        }
        return getPreviousToken()
    }

    // Returns the most recently consumed token
    fun getPreviousToken(): Token = tokens[currentTokenIndex - 1]

    // Returns the next token we have yet to consume
    fun peekNextToken(): Token = tokens[currentTokenIndex]

    fun isAtEnd() = peekNextToken().type == TokenType.EOF

}