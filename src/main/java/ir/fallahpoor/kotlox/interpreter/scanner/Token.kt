package ir.fallahpoor.kotlox.interpreter.scanner

data class Token(
    val type: TokenType,
    val lexeme: String,
    val literal: Any?,
    val lineNumber: Int
) {
    override fun toString(): String {
        val lex = if (lexeme.isNotBlank()) {
            ", lexeme = $lexeme"
        } else {
            ""
        }
        val lit = if (literal != null) {
            ", literal = $literal"
        } else {
            ""
        }
        return "$" +
                "line = $lineNumber, " +
                "type = $type" +
                lex +
                lit +
                "$"
    }
}