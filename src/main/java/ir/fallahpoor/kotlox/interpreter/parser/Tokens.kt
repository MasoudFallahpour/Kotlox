package ir.fallahpoor.kotlox.interpreter.parser

import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

class Tokens(private val tokens: List<Token>) {

    private var currentTokenIndex = 0

    /**
     * Checks to see if the next unconsumed token has any of the given types. If so, it consumes
     * the token and returns true. Otherwise, it returns false and does not consume the token.
     *
     * In the reference Java implementation this method is called 'match'.
     */
    fun consumeNextTokenIfItHasType(vararg types: TokenType): Boolean {
        for (type in types) {
            if (nextTokenHasType(type)) {
                consumeNextToken()
                return true
            }
        }
        return false
    }

    /**
     * Checks if the next unconsumed token has the given type. If so it returns true,
     * otherwise it returns false.
     *
     * In the reference Java implementation this method is called 'check'.
     */
    fun nextTokenHasType(type: TokenType): Boolean = if (isAtEnd()) {
        false
    } else {
        peekNextToken().type == type
    }

    /**
     * Consumes the next unconsumed token and returns it.
     *
     * In the reference Java implementation this method is called 'advance'.
     */
    fun consumeNextToken(): Token {
        if (!isAtEnd()) {
            currentTokenIndex++
        }
        return getPreviousToken()
    }

    /**
     * Returns the last consumed token.
     *
     * In the reference Java implementation this method is called 'previous'.
     */
    fun getPreviousToken(): Token {
        val previousIndex = currentTokenIndex - 1
        return if (previousIndex in tokens.indices) {
            tokens[previousIndex]
        } else if (previousIndex < 0) {
            tokens.first()
        } else {
            tokens.last()
        }
    }

    /**
     * Returns the next unconsumed token without consuming it.
     *
     * In the reference Java implementation this method is called 'peek'.
     */
    fun peekNextToken(): Token = if (currentTokenIndex in tokens.indices) {
        tokens[currentTokenIndex]
    } else if (currentTokenIndex < 0) {
        tokens.first()
    } else {
        tokens.last()
    }

    // FIXME the very last token of the tokens list should always be a EOF token otherwise
    //  this method will not work correctly.
    /**
     * Checks if we have run out of token.
     */
    fun isAtEnd() = peekNextToken().type == TokenType.EOF

}