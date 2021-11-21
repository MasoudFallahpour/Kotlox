package ir.fallahpoor.kotlox.scanner

data class Token(
    val type: TokenType,
    val lexeme: String,
    val literal: Any?,
    val line: Int
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
                "line = $line, " +
                "type = $type" +
                lex +
                lit +
                "$"
    }
}