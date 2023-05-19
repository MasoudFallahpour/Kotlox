package ir.fallahpoor.kotlox.interpreter.scanner

import ir.fallahpoor.kotlox.interpreter.ErrorReporter

class Scanner(private val source: String, private val errorReporter: ErrorReporter) {

    private val tokens = mutableListOf<Token>()

    // Offset that indexes into the 'source' string. It points to the first character in the lexeme being scanned
    private var lexemeStartIndex = 0

    // Offset that indexes into the 'source' string. It points at the next character to be considered.
    private var nextCharIndex = 0

    // Tracks what source line 'currentCharIndex' is on
    private var currentLineNumber = 1

    fun scanTokens(): List<Token> {
        while (!isAtEnd()) {
            // We are at the beginning of the next lexeme.
            lexemeStartIndex = nextCharIndex
            scanToken()
        }
        tokens += Token(type = TokenType.EOF, lexeme = "", literal = null, lineNumber = currentLineNumber)
        return tokens
    }

    private fun isAtEnd() = nextCharIndex >= source.length

    private fun scanToken() {
        when (val char = consumeNextChar()) {
            Chars.LEFT_PAREN -> addToken(TokenType.LEFT_PAREN)
            Chars.RIGHT_PAREN -> addToken(TokenType.RIGHT_PAREN)
            Chars.LEFT_BRACE -> addToken(TokenType.LEFT_BRACE)
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
                    nextCharMatches(Chars.SLASH) -> scanLineComment()
                    nextCharMatches(Chars.STAR) -> scanBlockComment()
                    else -> addToken(TokenType.SLASH)
                }
            }

            Chars.SPACE, Chars.RETURN, Chars.TAB -> {
                // Ignore whitespace
            }

            Chars.NEW_LINE -> currentLineNumber++
            Chars.DOUBLE_QUOTES -> scanString()
            in Chars.DIGITS -> scanNumber()
            in Chars.ALPHA_LOWER_CASE, in Chars.ALPHA_UPPER_CASE, Chars.UNDERSCORE -> scanIdentifier()
            else -> errorReporter.error(line = currentLineNumber, error = ErrorReporter.Error.UnexpectedChar(char))
        }
    }

    private fun consumeNextChar(): Char = source[nextCharIndex++]

    private fun addToken(type: TokenType, literal: Any? = null) {
        val text = source.substring(lexemeStartIndex, nextCharIndex)
        tokens += Token(type = type, lexeme = text, literal = literal, lineNumber = currentLineNumber)
    }

    // Check the current character. If it matches the given 'expected' character then consume it and
    // return true, otherwise don't consume it and return false.
    private fun nextCharMatches(expected: Char): Boolean = if (isAtEnd()) {
        false
    } else if (source[nextCharIndex] != expected) {
        false
    } else {
        nextCharIndex++
        true
    }

    // Get the next char without consuming it.
    private fun peekNextChar(): Char = if (isAtEnd()) {
        // TODO Verify that the following Unicode char is the correct character to use because the original
        //  character from the source code of the book is '\0'
        '\u0000'
    } else {
        source[nextCharIndex]
    }

    // Get the character after the next character without consuming it.
    private fun peekNextNextChar(): Char = if (nextCharIndex + 1 >= source.length) {
        // TODO Verify that the following Unicode char is the correct character to use because the original
        //  character from the source code of the book is '\0'
        '\u0000'
    } else {
        source[nextCharIndex + 1]
    }

    private fun scanLineComment() {
        // A comment goes until the end of the line.
        while (peekNextChar() != Chars.NEW_LINE && !isAtEnd()) {
            consumeNextChar()
        }
    }

    private fun scanBlockComment() {
        var blockCommentScannedSuccessfully = false
        var blockCommentBeginningSeenCount = 1

        while (!blockCommentScannedSuccessfully && !isAtEnd()) {
            when {
                nextCharMatches(Chars.NEW_LINE) -> {
                    currentLineNumber++
                }

                nextCharMatches(Chars.SLASH) -> {
                    if (nextCharMatches(Chars.STAR)) {
                        blockCommentBeginningSeenCount++
                    }
                }

                nextCharMatches(Chars.STAR) -> {
                    if (nextCharMatches(Chars.SLASH)) {
                        blockCommentBeginningSeenCount--
                        if (blockCommentBeginningSeenCount == 0) {
                            blockCommentScannedSuccessfully = true
                        }
                    }
                }

                else -> {
                    consumeNextChar()
                }
            }
        }

        if (!blockCommentScannedSuccessfully) {
            errorReporter.error(currentLineNumber, ErrorReporter.Error.UnterminatedBlockComment)
        }
    }

    private fun scanString() {
        var startLine = currentLineNumber

        while (peekNextChar() != Chars.DOUBLE_QUOTES && !isAtEnd()) {
            if (peekNextChar() == Chars.NEW_LINE) {
                startLine++
            }
            consumeNextChar()
        }

        if (isAtEnd()) {
            errorReporter.error(currentLineNumber, ErrorReporter.Error.UnterminatedString)
            return
        }

        // The closing "
        consumeNextChar()

        // If Lox supported escape sequences like \n, we’d unescape those here.
        // Get rid of the surrounding quotes.
        val literal = source.substring(lexemeStartIndex + 1, nextCharIndex - 1)

        addToken(type = TokenType.STRING, literal = literal)

        currentLineNumber = startLine
    }

    private fun scanNumber() {
        while (peekNextChar().isDigit()) {
            consumeNextChar()
        }

        // Look for a fractional part.
        if (peekNextChar() == Chars.DOT && peekNextNextChar().isDigit()) {
            // Consume the "."
            consumeNextChar()

            while (peekNextChar().isDigit()) {
                consumeNextChar()
            }
        }

        val literal = source.substring(lexemeStartIndex, nextCharIndex)

        addToken(type = TokenType.NUMBER, literal = literal.toDouble())
    }

    private fun scanIdentifier() {
        while (peekNextChar().isAlphaNumeric()) {
            consumeNextChar()
        }

        val lexeme = source.substring(lexemeStartIndex, nextCharIndex)
        val tokenType: TokenType = Keywords.getTokenTypeFor(lexeme) ?: TokenType.IDENTIFIER

        addToken(tokenType)
    }

    private fun Char.isAlpha(): Boolean =
        this in Chars.ALPHA_LOWER_CASE ||
                this in Chars.ALPHA_UPPER_CASE ||
                this == Chars.UNDERSCORE

    private fun Char.isAlphaNumeric(): Boolean = isAlpha() || isDigit()

    private fun Char.isDigit(): Boolean = this in Chars.DIGITS

}
