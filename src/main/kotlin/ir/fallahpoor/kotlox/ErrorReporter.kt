package ir.fallahpoor.kotlox

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

    private fun report(line: Int, where: String, message: String) {
        System.err.println("[line $line] Error$where: $message")
        hadError = true
    }

}