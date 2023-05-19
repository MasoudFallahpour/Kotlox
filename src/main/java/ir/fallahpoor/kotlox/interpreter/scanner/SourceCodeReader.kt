package ir.fallahpoor.kotlox.interpreter.scanner

class SourceCodeReader(private val sourceCode: String) {

    // Offset that indexes into the source code. It points to the first character in the lexeme being scanned
    private var lexemeStartIndex: Int = 0

    // Offset that indexes into the source code. It points at the next character to be considered.
    private var nextCharIndex: Int = 0

    // Tracks what source line 'nextCharIndex' is on
    var currentLineNumber = 1

    fun updateLexemeStartIndex() {
        lexemeStartIndex = nextCharIndex
    }

    fun isAtEnd(): Boolean = nextCharIndex >= sourceCode.length

    fun consumeNextChar(): Char = sourceCode[nextCharIndex++]

    // Get the next char without consuming it.
    fun peekNextChar(): Char = if (isAtEnd()) {
        // TODO Verify that the following Unicode char is the correct character to use because the original
        //  character from the source code of the book is '\0'
        '\u0000'
    } else {
        sourceCode[nextCharIndex]
    }

    // Get the character after the next character without consuming it.
    fun peekNextNextChar(): Char = if (nextCharIndex + 1 >= sourceCode.length) {
        // TODO Verify that the following Unicode char is the correct character to use because the original
        //  character from the source code of the book is '\0'
        '\u0000'
    } else {
        sourceCode[nextCharIndex + 1]
    }

    // Check the current character. If it matches the given 'expected' character then consume it and
    // return true, otherwise don't consume it and return false.
    fun nextCharMatches(expected: Char): Boolean = if (isAtEnd()) {
        false
    } else if (sourceCode[nextCharIndex] != expected) {
        false
    } else {
        nextCharIndex++
        true
    }

    fun getLexeme(): String = sourceCode.substring(startIndex = lexemeStartIndex, endIndex = nextCharIndex)

}