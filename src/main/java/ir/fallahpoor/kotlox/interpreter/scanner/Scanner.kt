package ir.fallahpoor.kotlox.interpreter.scanner

import ir.fallahpoor.kotlox.interpreter.ErrorReporter

class Scanner(private val sourceCodeReader: SourceCodeReader, private val errorReporter: ErrorReporter) {

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
            Chars.BANG -> addToken(if (sourceCodeReader.nextCharMatches(Chars.EQUAL)) TokenType.BANG_EQUAL else TokenType.BANG)
            Chars.EQUAL -> addToken(if (sourceCodeReader.nextCharMatches(Chars.EQUAL)) TokenType.EQUAL_EQUAL else TokenType.EQUAL)
            Chars.LESS -> addToken(if (sourceCodeReader.nextCharMatches(Chars.EQUAL)) TokenType.LESS_EQUAL else TokenType.LESS)
            Chars.GREATER -> addToken(if (sourceCodeReader.nextCharMatches(Chars.EQUAL)) TokenType.GREATER_EQUAL else TokenType.GREATER)
            Chars.SLASH -> {
                when {
                    sourceCodeReader.nextCharMatches(Chars.SLASH) -> scanLineComment()
                    sourceCodeReader.nextCharMatches(Chars.STAR) -> scanBlockComment()
                    else -> addToken(TokenType.SLASH)
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

    private fun addToken(type: TokenType, literal: Any? = null) {
        val lexeme: String = sourceCodeReader.getLexeme()
        tokens += Token(
            type = type,
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

        while (!blockCommentScannedSuccessfully && !sourceCodeReader.isAtEnd()) {
            when {
                sourceCodeReader.nextCharMatches(Chars.NEW_LINE) -> {
                    sourceCodeReader.currentLineNumber++
                }

                sourceCodeReader.nextCharMatches(Chars.SLASH) -> {
                    if (sourceCodeReader.nextCharMatches(Chars.STAR)) {
                        blockCommentBeginningSeenCount++
                    }
                }

                sourceCodeReader.nextCharMatches(Chars.STAR) -> {
                    if (sourceCodeReader.nextCharMatches(Chars.SLASH)) {
                        blockCommentBeginningSeenCount--
                        if (blockCommentBeginningSeenCount == 0) {
                            blockCommentScannedSuccessfully = true
                        }
                    }
                }

                else -> {
                    sourceCodeReader.consumeNextChar()
                }
            }
        }

        if (!blockCommentScannedSuccessfully) {
            errorReporter.error(sourceCodeReader.currentLineNumber, ErrorReporter.Error.UnterminatedBlockComment)
        }
    }

    private fun scanString() {
        var startLine = sourceCodeReader.currentLineNumber

        while (sourceCodeReader.peekNextChar() != Chars.DOUBLE_QUOTES && !sourceCodeReader.isAtEnd()) {
            if (sourceCodeReader.peekNextChar() == Chars.NEW_LINE) {
                startLine++
            }
            sourceCodeReader.consumeNextChar()
        }

        if (sourceCodeReader.isAtEnd()) {
            errorReporter.error(sourceCodeReader.currentLineNumber, ErrorReporter.Error.UnterminatedString)
            return
        }

        // The closing "
        sourceCodeReader.consumeNextChar()

        val lexeme: String = sourceCodeReader.getLexeme()
        // If Lox supported escape sequences like \n, we’d unescape those here.
        // Get rid of the surrounding quotes.
        val literal: String = lexeme.substring(startIndex = 1, endIndex = lexeme.lastIndex)

        addToken(type = TokenType.STRING, literal = literal)

        sourceCodeReader.currentLineNumber = startLine
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

        addToken(type = TokenType.NUMBER, literal = literal.toDouble())
    }

    private fun scanIdentifier() {
        while (sourceCodeReader.peekNextChar().isAlphaNumeric()) {
            sourceCodeReader.consumeNextChar()
        }

        val lexeme = sourceCodeReader.getLexeme()
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
