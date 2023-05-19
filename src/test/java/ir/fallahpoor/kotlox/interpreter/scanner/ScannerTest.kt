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
        val scanner = Scanner(source.trimIndent(), errorReporter)
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
            Token(TokenType.TRUE, "true", null, 2),
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
            Token(TokenType.FOR, "for", null, 1),
            Token(TokenType.NUMBER, "123", 123.0, 7),
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
                   // some line comment here! *
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
            Token(type = TokenType.NUMBER, lexeme = "123", literal = 123.0, lineNumber = 8),
            createEofTokenWithLineNumber(8)
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
            Token(TokenType.NUMBER, "123", 123.0, 1),
            Token(TokenType.NUMBER, "123.456", 123.456, 2),
            Token(TokenType.DOT, ".", null, 3),
            Token(TokenType.NUMBER, "456", 456.0, 3),
            Token(TokenType.NUMBER, "123", 123.0, 4),
            Token(TokenType.DOT, ".", null, 4),
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
            Token(TokenType.IDENTIFIER, "formation", null, 1),
            Token(TokenType.IDENTIFIER, "_private", null, 1),
            Token(TokenType.IDENTIFIER, "ARRAY_LENGTH", null, 1),
            Token(TokenType.IDENTIFIER, "andy", null, 1),
            Token(TokenType.IDENTIFIER, "fo", null, 1),
            Token(TokenType.IDENTIFIER, "_", null, 1),
            Token(TokenType.IDENTIFIER, "_123", null, 1),
            Token(TokenType.IDENTIFIER, "_abc", null, 1),
            Token(TokenType.IDENTIFIER, "ab123", null, 1),
            Token(TokenType.IDENTIFIER, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_", null, 1),
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
            Token(TokenType.STRING, "\"This is a string\"", "This is a string", 1),
            Token(TokenType.STRING, "\"This is a multi-line\nstring\"", "This is a multi-line\nstring", 2),
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
            Token(TokenType.LEFT_PAREN, "(", null, 1),
            Token(TokenType.RIGHT_PAREN, ")", null, 1),
            Token(TokenType.LEFT_BRACE, "{", null, 1),
            Token(TokenType.RIGHT_BRACE, "}", null, 1),
            Token(TokenType.COMMA, ",", null, 1),
            Token(TokenType.DOT, ".", null, 2),
            Token(TokenType.PLUS, "+", null, 2),
            Token(TokenType.MINUS, "-", null, 2),
            Token(TokenType.SEMICOLON, ";", null, 2),
            Token(TokenType.STAR, "*", null, 2),
            Token(TokenType.SLASH, "/", null, 2),
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
            Token(TokenType.BANG_EQUAL, "!=", null, 1),
            Token(TokenType.BANG, "!", null, 1),
            Token(TokenType.EQUAL_EQUAL, "==", null, 1),
            Token(TokenType.EQUAL, "=", null, 1),
            Token(TokenType.GREATER, ">", null, 1),
            Token(TokenType.GREATER_EQUAL, ">=", null, 1),
            Token(TokenType.LESS_EQUAL, "<=", null, 1),
            Token(TokenType.LESS, "<", null, 1),
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
            Token(TokenType.AND, Keywords.AND, null, 1),
            Token(TokenType.CLASS, Keywords.CLASS, null, 1),
            Token(TokenType.ELSE, Keywords.ELSE, null, 1),
            Token(TokenType.FALSE, Keywords.FALSE, null, 1),
            Token(TokenType.FUN, Keywords.FUN, null, 1),
            Token(TokenType.FOR, Keywords.FOR, null, 1),
            Token(TokenType.IF, Keywords.IF, null, 1),
            Token(TokenType.NIL, Keywords.NIL, null, 1),
            Token(TokenType.OR, Keywords.OR, null, 1),
            Token(TokenType.PRINT, Keywords.PRINT, null, 1),
            Token(TokenType.RETURN, Keywords.RETURN, null, 1),
            Token(TokenType.SUPER, Keywords.SUPER, null, 1),
            Token(TokenType.THIS, Keywords.THIS, null, 1),
            Token(TokenType.TRUE, Keywords.TRUE, null, 1),
            Token(TokenType.VAR, Keywords.VAR, null, 1),
            Token(TokenType.WHILE, Keywords.WHILE, null, 1),
            Token(TokenType.IDENTIFIER, "android", null, 2),
            Token(TokenType.IDENTIFIER, "classic", null, 2),
            Token(TokenType.IDENTIFIER, "elsewhere", null, 2),
            Token(TokenType.IDENTIFIER, "superstitious", null, 2),
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
        Mockito.verify(errorReporter).error(1, ErrorReporter.Error.UnexpectedChar('$'))
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
        Mockito.verify(errorReporter).error(1, ErrorReporter.Error.UnterminatedString)
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
        Mockito.verify(errorReporter).error(2, ErrorReporter.Error.UnterminatedBlockComment)
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
        Mockito.verify(errorReporter).error(8, ErrorReporter.Error.UnterminatedBlockComment)
        Mockito.verifyNoMoreInteractions(errorReporter)

    }

}