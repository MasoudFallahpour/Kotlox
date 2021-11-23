package ir.fallahpoor.kotlox.interpreter

import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

class ErrorReporter {

    enum class Error(val message: String) {
        UNEXPECTED_CHAR("Unexpected character."),
        UNTERMINATED_BLOCK_COMMENT("Unterminated block comment."),
        UNTERMINATED_STRING("Unterminated string.")
    }

    var hadError = false

    fun error(line: Int, error: Error) {
        report(line, "", error.message)
    }

    fun error(token: Token, message: String) {
        if (token.type == TokenType.EOF) {
            report(token.line, " at end", message)
        } else {
            report(token.line, " at '" + token.lexeme + "'", message)
        }
    }

    private fun report(line: Int, where: String, message: String) {
        System.err.println("[line $line] Error$where: $message")
        hadError = true
    }

}