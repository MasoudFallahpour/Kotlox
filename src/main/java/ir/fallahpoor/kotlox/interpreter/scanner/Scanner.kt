package ir.fallahpoor.kotlox.interpreter.scanner

import ir.fallahpoor.kotlox.interpreter.ErrorReporter

class Scanner(private val source: String, private val errorReporter: ErrorReporter) {

    private val tokens = mutableListOf<Token>()

    // Offset that indexes into the 'source' string. It points to the first character in the lexeme being scanned
    private var lexemeStartIndex = 0

    // Offset that indexes into the 'source' string. It points at the character currently being considered
    private var currentCharIndex = 0

    // Tracks what source line 'currentCharIndex' is on
    private var currentLineNumber = 1

    fun scanTokens(): List<Token> {
        while (!isAtEnd()) {
            // We are at the beginning of the next lexeme.
            lexemeStartIndex = currentCharIndex
            scanToken()
        }
        tokens += Token(type = TokenType.EOF, lexeme = "", literal = null, lineNumber = currentLineNumber)
        return tokens
    }

    private fun isAtEnd() = currentCharIndex >= source.length

    private fun scanToken() {
        when (val char = getNextChar()) {
            Chars.LEFT_PAREN -> addToken(TokenType.LEFT_PAREN)
            Chars.RIGHT_PAREN -> addToken(TokenType.RIGHT_PAREN)
            Chars.LEFt_BRACE -> addToken(TokenType.LEFT_BRACE)
            Chars.RIGHT_BRACE -> addToken(TokenType.RIGHT_BRACE)
            Chars.COMMA -> addToken(TokenType.COMMA)
            Chars.DOT -> addToken(TokenType.DOT)
            Chars.MINUS -> addToken(TokenType.MINUS)
            Chars.PLUS -> addToken(TokenType.PLUS)
            Chars.SEMICOLON -> addToken(TokenType.SEMICOLON)
            Chars.STAR -> addToken(TokenType.STAR)
            Chars.BANG -> addToken(if (nextCharMatches(Chars.EQUAL)) TokenType.BANG_EQUAL else TokenType.BANG)
            Chars.EQUAL -> addToken(if (nextCharMatches(Chars.EQUAL)) TokenType.EQUAL_EQUAL else TokenType.EQUAL)
            Chars.LESS -> addToken(if (nextCharMatches(Chars.EQUAL)) TokenType.LESS_EQUAL else TokenType.LESS)
            Chars.GREATER -> addToken(if (nextCharMatches(Chars.EQUAL)) TokenType.GREATER_EQUAL else TokenType.GREATER)
            Chars.SLASH -> {
                when {
                    nextCharMatches(Chars.SLASH) -> lineComment()
                    nextCharMatches(Chars.STAR) -> blockComment()
                    else -> addToken(TokenType.SLASH)
                }
            }

            Chars.SPACE, Chars.RETURN, Chars.TAB -> {
                // Ignore whitespace
            }

            Chars.NEW_LINE -> currentLineNumber++
            Chars.DOUBLE_QUOTES -> string()
            in Chars.DIGITS -> number()
            in Chars.ALPHA_LOWER_CASE, in Chars.ALPHA_UPPER_CASE, Chars.UNDERSCORE -> identifier()
            else -> errorReporter.error(currentLineNumber, ErrorReporter.Error.UnexpectedChar(char))
        }
    }

    private fun getNextChar(): Char = source[currentCharIndex++]

    private fun addToken(type: TokenType, literal: Any? = null) {
        val text = source.substring(lexemeStartIndex, currentCharIndex)
        tokens += Token(type = type, lexeme = text, literal = literal, lineNumber = currentLineNumber)
    }

    // Look ahead the next char. If it matches the given 'expected' char then consume it and return true,
    // otherwise don't consume it and return false.
    private fun nextCharMatches(expected: Char): Boolean = if (isAtEnd()) {
        false
    } else if (source[currentCharIndex] != expected) {
        false
    } else {
        currentCharIndex++
        true
    }

    // Get the next char without consuming it.
    private fun peekNextChar(): Char = if (isAtEnd()) {
        // TODO Verify that the following Unicode char is the correct character to use because the original
        //  character from the source code of the book is '\0'
        '\u0000'
    } else {
        source[currentCharIndex]
    }

    // Get the character after the next character without consuming it.
    private fun peekNextNextChar(): Char = if (currentCharIndex + 1 >= source.length) {
        // TODO Verify that the following Unicode char is the correct character to use because the original
        //  character from the source code of the book is '\0'
        '\u0000'
    } else {
        source[currentCharIndex + 1]
    }

    private fun lineComment() {
        // A comment goes until the end of the line.
        while (peekNextChar() != Chars.NEW_LINE && !isAtEnd()) {
            getNextChar()
        }
    }

    private fun blockComment() {
        var blockCommentConsumed = false

        while (!blockCommentConsumed && !isAtEnd()) {
            if (peekNextChar() == Chars.NEW_LINE) {
                currentLineNumber++
                getNextChar()
            } else if (getNextChar() == Chars.STAR) {
                if (getNextChar() == Chars.SLASH) {
                    blockCommentConsumed = true
                }
            }
        }

        if (!blockCommentConsumed) {
            errorReporter.error(currentLineNumber, ErrorReporter.Error.UnterminatedBlockComment)
        }
    }

    private fun string() {
        var startLine = currentLineNumber

        while (peekNextChar() != Chars.DOUBLE_QUOTES && !isAtEnd()) {
            if (peekNextChar() == Chars.NEW_LINE) {
                startLine++
            }
            getNextChar()
        }

        if (isAtEnd()) {
            errorReporter.error(currentLineNumber, ErrorReporter.Error.UnterminatedString)
            return
        }

        // The closing "
        getNextChar()

        // Trim the surrounding quotes.
        // If Lox supported escape sequences like \n, we’d unescape those here.
        val literal = source.substring(lexemeStartIndex + 1, currentCharIndex - 1)

        addToken(TokenType.STRING, literal)

        currentLineNumber = startLine
    }

    private fun number() {
        while (peekNextChar().isDigit()) {
            getNextChar()
        }

        // Look for a fractional part.
        if (peekNextChar() == Chars.DOT && peekNextNextChar().isDigit()) {
            // Consume the "."
            getNextChar()

            while (peekNextChar().isDigit()) {
                getNextChar()
            }
        }

        val literal = source.substring(lexemeStartIndex, currentCharIndex)

        addToken(TokenType.NUMBER, literal.toDouble())
    }

    private fun identifier() {
        while (peekNextChar().isAlphaNumeric()) {
            getNextChar()
        }

        val text = source.substring(lexemeStartIndex, currentCharIndex)
        val tokenType: TokenType = Keywords.get(text) ?: TokenType.IDENTIFIER

        addToken(tokenType)
    }

    private fun Char.isAlpha(): Boolean =
        this in Chars.ALPHA_LOWER_CASE ||
                this in Chars.ALPHA_UPPER_CASE ||
                this == Chars.UNDERSCORE

    private fun Char.isAlphaNumeric(): Boolean = isAlpha() || isDigit()

    private fun Char.isDigit(): Boolean = this in Chars.DIGITS

}
