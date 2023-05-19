package ir.fallahpoor.kotlox.interpreter.scanner

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ScannerTest {

    @Mock
    private lateinit var errorReporter: ErrorReporter

    private fun scanSource(source: String): List<Token> {
        val scanner = Scanner(SourceCodeReader(source.trimIndent()), errorReporter)
        return scanner.scanTokens()
    }

    private fun createEofTokenWithLineNumber(line: Int) =
        Token(type = TokenType.EOF, lexeme = "", literal = null, lineNumber = line)

    @Test
    fun emptySource() {

        // Given
        val source = ""

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(createEofTokenWithLineNumber(1))
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testWhitespace() {

        // Given
        val source =
            """

            """

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(createEofTokenWithLineNumber(1))
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testLineComment() {

        // Given
        val source =
            """
                // This is a comment and placing some token likes 'var a = 12' should not produce any token
                true
                """

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(
            Token(type = TokenType.TRUE, lexeme = "true", literal = null, lineNumber = 2),
            createEofTokenWithLineNumber(2)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testBlockComment() {

        // Given
        val source =
            """
                for
                /*
                 This is a block comment / and * // placing some tokens like 'var a = 12'
                 should not produce any token
                */
                /* another block comment */
                123
                """

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(
            Token(type = TokenType.FOR, lexeme = "for", literal = null, lineNumber = 1),
            Token(type = TokenType.NUMBER, lexeme = "123", literal = 123.0, lineNumber = 7),
            createEofTokenWithLineNumber(7)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testNestedBlockComments() {

        // Given
        val source =
            """
                /* comment at level 1
                   // some line comment here!
                   *
                   /* comment at level 2
                       /* comment at level 3 */
                   */
                   comment at level 1
                */
                123
                """

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(
            Token(type = TokenType.NUMBER, lexeme = "123", literal = 123.0, lineNumber = 9),
            createEofTokenWithLineNumber(9)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testNumber() {

        // Given
        val source =
            """
                123
                123.456
                .456
                123.
                """

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(
            Token(type = TokenType.NUMBER, lexeme = "123", literal = 123.0, lineNumber = 1),
            Token(type = TokenType.NUMBER, lexeme = "123.456", literal = 123.456, lineNumber = 2),
            Token(type = TokenType.DOT, lexeme = ".", literal = null, lineNumber = 3),
            Token(type = TokenType.NUMBER, lexeme = "456", literal = 456.0, lineNumber = 3),
            Token(type = TokenType.NUMBER, lexeme = "123", literal = 123.0, lineNumber = 4),
            Token(type = TokenType.DOT, lexeme = ".", literal = null, lineNumber = 4),
            createEofTokenWithLineNumber(4)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testIdentifier() {

        // Given
        val source =
            """
                formation _private ARRAY_LENGTH andy fo _ _123 _abc ab123 abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_
            """

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(
            Token(type = TokenType.IDENTIFIER, lexeme = "formation", literal = null, lineNumber = 1),
            Token(type = TokenType.IDENTIFIER, lexeme = "_private", literal = null, lineNumber = 1),
            Token(type = TokenType.IDENTIFIER, lexeme = "ARRAY_LENGTH", literal = null, lineNumber = 1),
            Token(type = TokenType.IDENTIFIER, lexeme = "andy", literal = null, lineNumber = 1),
            Token(type = TokenType.IDENTIFIER, lexeme = "fo", literal = null, lineNumber = 1),
            Token(type = TokenType.IDENTIFIER, lexeme = "_", literal = null, lineNumber = 1),
            Token(type = TokenType.IDENTIFIER, lexeme = "_123", literal = null, lineNumber = 1),
            Token(type = TokenType.IDENTIFIER, lexeme = "_abc", literal = null, lineNumber = 1),
            Token(type = TokenType.IDENTIFIER, lexeme = "ab123", literal = null, lineNumber = 1),
            Token(
                type = TokenType.IDENTIFIER,
                lexeme = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_",
                literal = null,
                lineNumber = 1
            ),
            createEofTokenWithLineNumber(1)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testString() {

        // Given
        val source =
            """
                "This is a string"
                "This is a multi-line
                string"
            """

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(
            Token(
                type = TokenType.STRING,
                lexeme = "\"This is a string\"",
                literal = "This is a string",
                lineNumber = 1
            ),
            Token(
                type = TokenType.STRING,
                lexeme = "\"This is a multi-line\nstring\"",
                literal = "This is a multi-line\nstring",
                lineNumber = 2
            ),
            createEofTokenWithLineNumber(3)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testSingleCharTokens() {

        // Given
        val source =
            """
                (){},
                .+-;*/
                """

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(
            Token(type = TokenType.LEFT_PAREN, lexeme = "(", literal = null, lineNumber = 1),
            Token(type = TokenType.RIGHT_PAREN, lexeme = ")", literal = null, lineNumber = 1),
            Token(type = TokenType.LEFT_BRACE, lexeme = "{", literal = null, lineNumber = 1),
            Token(type = TokenType.RIGHT_BRACE, lexeme = "}", literal = null, lineNumber = 1),
            Token(type = TokenType.COMMA, lexeme = ",", literal = null, lineNumber = 1),
            Token(type = TokenType.DOT, lexeme = ".", literal = null, lineNumber = 2),
            Token(type = TokenType.PLUS, lexeme = "+", literal = null, lineNumber = 2),
            Token(type = TokenType.MINUS, lexeme = "-", literal = null, lineNumber = 2),
            Token(type = TokenType.SEMICOLON, lexeme = ";", literal = null, lineNumber = 2),
            Token(type = TokenType.STAR, lexeme = "*", literal = null, lineNumber = 2),
            Token(type = TokenType.SLASH, lexeme = "/", literal = null, lineNumber = 2),
            createEofTokenWithLineNumber(2)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testOneOrTwoCharTokens() {

        // Given
        val source =
            """
                !=! ===>>=<=<
                """

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(
            Token(type = TokenType.BANG_EQUAL, lexeme = "!=", literal = null, lineNumber = 1),
            Token(type = TokenType.BANG, lexeme = "!", literal = null, lineNumber = 1),
            Token(type = TokenType.EQUAL_EQUAL, lexeme = "==", literal = null, lineNumber = 1),
            Token(type = TokenType.EQUAL, lexeme = "=", literal = null, lineNumber = 1),
            Token(type = TokenType.GREATER, lexeme = ">", literal = null, lineNumber = 1),
            Token(type = TokenType.GREATER_EQUAL, lexeme = ">=", literal = null, lineNumber = 1),
            Token(type = TokenType.LESS_EQUAL, lexeme = "<=", literal = null, lineNumber = 1),
            Token(type = TokenType.LESS, lexeme = "<", literal = null, lineNumber = 1),
            createEofTokenWithLineNumber(1)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testKeywords() {

        // Given
        val source =
            """
                and class else false fun for if nil or print return super this true var while
                android classic elsewhere superstitious
                """

        // When
        val actualTokens = scanSource(source)

        // Then
        val expectedTokens = listOf(
            Token(type = TokenType.AND, lexeme = Keywords.AND, literal = null, lineNumber = 1),
            Token(type = TokenType.CLASS, lexeme = Keywords.CLASS, literal = null, lineNumber = 1),
            Token(type = TokenType.ELSE, lexeme = Keywords.ELSE, literal = null, lineNumber = 1),
            Token(type = TokenType.FALSE, lexeme = Keywords.FALSE, literal = null, lineNumber = 1),
            Token(type = TokenType.FUN, lexeme = Keywords.FUN, literal = null, lineNumber = 1),
            Token(type = TokenType.FOR, lexeme = Keywords.FOR, literal = null, lineNumber = 1),
            Token(type = TokenType.IF, lexeme = Keywords.IF, literal = null, lineNumber = 1),
            Token(type = TokenType.NIL, lexeme = Keywords.NIL, literal = null, lineNumber = 1),
            Token(type = TokenType.OR, lexeme = Keywords.OR, literal = null, lineNumber = 1),
            Token(type = TokenType.PRINT, lexeme = Keywords.PRINT, literal = null, lineNumber = 1),
            Token(type = TokenType.RETURN, lexeme = Keywords.RETURN, literal = null, lineNumber = 1),
            Token(type = TokenType.SUPER, lexeme = Keywords.SUPER, literal = null, lineNumber = 1),
            Token(type = TokenType.THIS, lexeme = Keywords.THIS, literal = null, lineNumber = 1),
            Token(type = TokenType.TRUE, lexeme = Keywords.TRUE, literal = null, lineNumber = 1),
            Token(type = TokenType.VAR, lexeme = Keywords.VAR, literal = null, lineNumber = 1),
            Token(type = TokenType.WHILE, lexeme = Keywords.WHILE, literal = null, lineNumber = 1),
            Token(type = TokenType.IDENTIFIER, lexeme = "android", literal = null, lineNumber = 2),
            Token(type = TokenType.IDENTIFIER, lexeme = "classic", literal = null, lineNumber = 2),
            Token(type = TokenType.IDENTIFIER, lexeme = "elsewhere", literal = null, lineNumber = 2),
            Token(type = TokenType.IDENTIFIER, lexeme = "superstitious", literal = null, lineNumber = 2),
            createEofTokenWithLineNumber(2)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testUnexpectedCharError() {

        // Given
        val source =
            """
                $
                """

        // When
        scanSource(source)

        // Then
        Mockito.verify(errorReporter).error(line = 1, error = ErrorReporter.Error.UnexpectedChar('$'))
        Mockito.verifyNoMoreInteractions(errorReporter)
    }

    @Test
    fun testUnterminatedStringError() {

        // Given
        val source =
            """
                "abc
                """

        // When
        scanSource(source)

        // Then
        Mockito.verify(errorReporter).error(line = 1, error = ErrorReporter.Error.UnterminatedString)
        Mockito.verifyNoMoreInteractions(errorReporter)

    }

    @Test
    fun testUnterminatedBlockCommentError() {

        // Given
        val source =
            """
                /* this is an unterminated block comment
                   here we are on the next line
                """

        // When
        scanSource(source)

        // Then
        Mockito.verify(errorReporter).error(line = 2, error = ErrorReporter.Error.UnterminatedBlockComment)
        Mockito.verifyNoMoreInteractions(errorReporter)

    }

    @Test
    fun testUnterminatedNestedBlockCommentError() {

        // Given
        val source =
            """
                /* level 1
                   /* level 2
                       /* level 3
                       level 2
                   */
                   level 1
                */
                123
                """

        // When
        scanSource(source)

        // Then
        Mockito.verify(errorReporter).error(line = 8, error = ErrorReporter.Error.UnterminatedBlockComment)
        Mockito.verifyNoMoreInteractions(errorReporter)

    }

}