package ir.fallahpoor.kotlox.interpreter.scanner

object Keywords {

    const val AND = "and"
    const val CLASS = "class"
    const val ELSE = "else"
    const val FALSE = "false"
    const val FOR = "for"
    const val FUN = "fun"
    const val IF = "if"
    const val NIL = "nil"
    const val OR = "or"
    const val PRINT = "print"
    const val RETURN = "return"
    const val SUPER = "super"
    const val THIS = "this"
    const val TRUE = "true"
    const val VAR = "var"
    const val WHILE = "while"
    const val BREAK = "break"

    private val keywords = mapOf(
        AND to TokenType.AND,
        CLASS to TokenType.CLASS,
        ELSE to TokenType.ELSE,
        FALSE to TokenType.FALSE,
        FOR to TokenType.FOR,
        FUN to TokenType.FUN,
        IF to TokenType.IF,
        NIL to TokenType.NIL,
        OR to TokenType.OR,
        PRINT to TokenType.PRINT,
        RETURN to TokenType.RETURN,
        SUPER to TokenType.SUPER,
        THIS to TokenType.THIS,
        TRUE to TokenType.TRUE,
        VAR to TokenType.VAR,
        WHILE to TokenType.WHILE,
        BREAK to TokenType.BREAK
    )

    fun get(text: String): TokenType? = keywords[text]

}