package ir.fallahpoor.kotlox.interpreter.scanner

import ir.fallahpoor.kotlox.interpreter.ErrorReporter

class Scanner(
    private val sourceCodeReader: SourceCodeReader,
    private val errorReporter: ErrorReporter
) {

    private val tokens = mutableListOf<Token>()

    fun scanTokens(): List<Token> {
        while (!sourceCodeReader.isAtEnd()) {
            // We are at the beginning of the next lexeme.
            sourceCodeReader.updateLexemeStartIndex()
            scanToken()
        }
        tokens += Token(
            type = TokenType.EOF,
            lexeme = "",
            literal = null,
            lineNumber = sourceCodeReader.currentLineNumber
        )
        return tokens
    }

    private fun scanToken() {
        when (val char = sourceCodeReader.consumeNextChar()) {
            Chars.LEFT_PAREN -> addToken(tokenType = TokenType.LEFT_PAREN)
            Chars.RIGHT_PAREN -> addToken(tokenType = TokenType.RIGHT_PAREN)
            Chars.LEFT_BRACE -> addToken(tokenType = TokenType.LEFT_BRACE)
            Chars.RIGHT_BRACE -> addToken(tokenType = TokenType.RIGHT_BRACE)
            Chars.COMMA -> addToken(tokenType = TokenType.COMMA)
            Chars.DOT -> addToken(tokenType = TokenType.DOT)
            Chars.MINUS -> addToken(tokenType = TokenType.MINUS)
            Chars.PLUS -> addToken(tokenType = TokenType.PLUS)
            Chars.SEMICOLON -> addToken(tokenType = TokenType.SEMICOLON)
            Chars.STAR -> addToken(tokenType = TokenType.STAR)
            Chars.BANG -> addToken(tokenType = if (sourceCodeReader.nextCharMatches(Chars.EQUAL)) TokenType.BANG_EQUAL else TokenType.BANG)
            Chars.EQUAL -> addToken(tokenType = if (sourceCodeReader.nextCharMatches(Chars.EQUAL)) TokenType.EQUAL_EQUAL else TokenType.EQUAL)
            Chars.LESS_THAN -> addToken(tokenType = if (sourceCodeReader.nextCharMatches(Chars.EQUAL)) TokenType.LESS_EQUAL else TokenType.LESS)
            Chars.GREATER_THAN -> addToken(tokenType = if (sourceCodeReader.nextCharMatches(Chars.EQUAL)) TokenType.GREATER_EQUAL else TokenType.GREATER)
            Chars.SLASH -> {
                when {
                    sourceCodeReader.nextCharMatches(Chars.SLASH) -> scanLineComment()
                    sourceCodeReader.nextCharMatches(Chars.STAR) -> scanBlockComment()
                    else -> addToken(tokenType = TokenType.SLASH)
                }
            }

            Chars.SPACE, Chars.RETURN, Chars.TAB -> {
                // Ignore whitespace
            }

            Chars.NEW_LINE -> sourceCodeReader.currentLineNumber++
            Chars.DOUBLE_QUOTES -> scanString()
            in Chars.DIGITS -> scanNumber()
            in Chars.ALPHA_LOWER_CASE, in Chars.ALPHA_UPPER_CASE, Chars.UNDERSCORE -> scanIdentifier()
            else -> errorReporter.error(
                line = sourceCodeReader.currentLineNumber,
                error = ErrorReporter.Error.UnexpectedChar(char)
            )
        }
    }

    private fun addToken(tokenType: TokenType, literal: Any? = null) {
        val lexeme: String = sourceCodeReader.getLexeme()
        tokens += Token(
            type = tokenType,
            lexeme = lexeme,
            literal = literal,
            lineNumber = sourceCodeReader.currentLineNumber
        )
    }

    private fun scanLineComment() {
        // A comment goes until the end of the line.
        while (sourceCodeReader.peekNextChar() != Chars.NEW_LINE && !sourceCodeReader.isAtEnd()) {
            sourceCodeReader.consumeNextChar()
        }
    }

    private fun scanBlockComment() {
        var blockCommentScannedSuccessfully = false
        var blockCommentBeginningSeenCount = 1
        var blockCommentEndingSeenCount = 0
        var currentLineNumber = sourceCodeReader.currentLineNumber

        while (!blockCommentScannedSuccessfully && !sourceCodeReader.isAtEnd()) {
            when {
                sourceCodeReader.nextCharMatches(Chars.NEW_LINE) -> {
                    currentLineNumber++
                }

                sourceCodeReader.nextCharMatches(Chars.SLASH) -> {
                    if (sourceCodeReader.nextCharMatches(Chars.STAR)) {
                        blockCommentBeginningSeenCount++
                    }
                }

                sourceCodeReader.nextCharMatches(Chars.STAR) -> {
                    if (sourceCodeReader.nextCharMatches(Chars.SLASH)) {
                        blockCommentEndingSeenCount++
                        if (blockCommentBeginningSeenCount == blockCommentEndingSeenCount) {
                            blockCommentScannedSuccessfully = true
                        }
                    }
                }

                else -> {
                    sourceCodeReader.consumeNextChar()
                }
            }
        }

        if (sourceCodeReader.isAtEnd()) {
            errorReporter.error(
                line = sourceCodeReader.currentLineNumber,
                error = ErrorReporter.Error.UnterminatedBlockComment
            )
        } else {
            sourceCodeReader.currentLineNumber = currentLineNumber
        }
    }

    private fun scanString() {
        var currentLineNumber = sourceCodeReader.currentLineNumber

        while (sourceCodeReader.peekNextChar() != Chars.DOUBLE_QUOTES && !sourceCodeReader.isAtEnd()) {
            if (sourceCodeReader.peekNextChar() == Chars.NEW_LINE) {
                currentLineNumber++
            }
            sourceCodeReader.consumeNextChar()
        }

        if (sourceCodeReader.isAtEnd()) {
            errorReporter.error(
                line = sourceCodeReader.currentLineNumber,
                error = ErrorReporter.Error.UnterminatedString
            )
            return
        }

        // The closing "
        sourceCodeReader.consumeNextChar()

        val lexeme: String = sourceCodeReader.getLexeme()
        // If Lox supported escape sequences like \n, we’d unescape those here.
        // Get rid of the surrounding quotes.
        val literal: String = lexeme.substring(startIndex = 1, endIndex = lexeme.lastIndex)
        addToken(tokenType = TokenType.STRING, literal = literal)

        sourceCodeReader.currentLineNumber = currentLineNumber
    }

    private fun scanNumber() {
        while (sourceCodeReader.peekNextChar().isDigit()) {
            sourceCodeReader.consumeNextChar()
        }

        // Look for a fractional part.
        if (sourceCodeReader.peekNextChar() == Chars.DOT && sourceCodeReader.peekNextNextChar().isDigit()) {
            // Consume the "."
            sourceCodeReader.consumeNextChar()

            while (sourceCodeReader.peekNextChar().isDigit()) {
                sourceCodeReader.consumeNextChar()
            }
        }

        val literal: String = sourceCodeReader.getLexeme()
        addToken(tokenType = TokenType.NUMBER, literal = literal.toDouble())
    }

    private fun scanIdentifier() {
        while (sourceCodeReader.peekNextChar().isAlphaNumeric()) {
            sourceCodeReader.consumeNextChar()
        }
        val lexeme: String = sourceCodeReader.getLexeme()
        val tokenType: TokenType = Keywords.getTokenTypeFor(lexeme = lexeme) ?: TokenType.IDENTIFIER
        addToken(tokenType = tokenType)
    }

    private fun Char.isAlpha(): Boolean =
        this in Chars.ALPHA_LOWER_CASE ||
                this in Chars.ALPHA_UPPER_CASE ||
                this == Chars.UNDERSCORE

    private fun Char.isAlphaNumeric(): Boolean = isAlpha() || isDigit()

    private fun Char.isDigit(): Boolean = this in Chars.DIGITS

}
