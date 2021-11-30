package ir.fallahpoor.kotlox.interpreter.parser

import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

class Tokens(private val tokens: List<Token>) {

    private var currentTokenIndex = 0

    // match
    fun getNextTokenIfItHasType(vararg types: TokenType): Boolean {
        for (type in types) {
            if (nextTokenHasType(type)) {
                getNextToken()
                return true
            }
        }
        return false
    }

    // check
    fun nextTokenHasType(type: TokenType): Boolean =
        if (isAtEnd()) {
            false
        } else {
            peekNextToken().type == type
        }

    // advance
    fun getNextToken(): Token {
        if (!isAtEnd()) {
            currentTokenIndex++
        }
        return getPreviousToken()
    }

    // Returns the most recently consumed token.
    // previous
    fun getPreviousToken(): Token =
        if (currentTokenIndex >= 1) {
            tokens[currentTokenIndex - 1]
        } else {
            tokens[0]
        }

    // FIXME check currentTokenIndex to be in range
    // Returns the next token we have yet to consume.
    // peek
    fun peekNextToken(): Token = tokens[currentTokenIndex]

    // FIXME the very last token of the tokens list should always be a EOF token otherwise
    //  this method will not work correctly
    fun isAtEnd() = peekNextToken().type == TokenType.EOF

}