package ir.fallahpoor.kotlox.interpreter.scanner

data class Token(
    val type: TokenType,
    val lexeme: String,
    val literal: Any?,
    val lineNumber: Int
) {
    override fun toString(): String {
        val lexeme = if (lexeme.isNotBlank()) {
            ", lexeme = $lexeme"
        } else {
            ""
        }
        val literal = if (literal != null) {
            ", literal = $literal"
        } else {
            ""
        }
        return "$" +
                "line = $lineNumber, " +
                "type = $type" +
                lexeme +
                literal +
                "$"
    }
}