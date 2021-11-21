package ir.fallahpoor.kotlox.scanner

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.ErrorReporter
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ScannerTest {

    private lateinit var scanner: Scanner

    @Mock
    private val errorReporter = ErrorReporter()

    @Test
    fun emptySource() {

        // Given
        scanner = createScannerWithSource(source = "")

        // When
        val actualTokens = scanner.scanTokens()

        // Then
        val expectedTokens = listOf(
            Token(TokenType.EOF, "", null, 1)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)

    }

    @Test
    fun testLineComment() {

        // Given
        scanner = createScannerWithSource(
            """
                // This is a comment and placing some token likes 'var a = 12' should not produce any token
                true
                """
        )

        // When
        val actualTokens = scanner.scanTokens()

        // Then
        val expectedTokens = listOf(
            Token(TokenType.TRUE, "true", null, 2),
            Token(TokenType.EOF, "", null, 2)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)

    }

    @Test
    fun testBlockComment() {

        // Given
        scanner = createScannerWithSource(
            """
                for
                /* 
                 This is a block comment / and * // placing some tokens like 'var a = 12'
                 should not produce any token
                */
                /* another block comment */
                123
                """
        )

        // When
        val actualTokens = scanner.scanTokens()

        // Then
        val expectedTokens = listOf(
            Token(TokenType.FOR, "for", null, 1),
            Token(TokenType.NUMBER, "123", 123.0, 7),
            Token(TokenType.EOF, "", null, 7)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)

    }

    @Test
    fun testNumber() {

        // Given
        scanner = createScannerWithSource(
            """
                123
                123.456
                """
        )

        // When
        val actualTokens = scanner.scanTokens()

        // Then
        val expectedTokens = listOf(
            Token(TokenType.NUMBER, "123", 123.0, 1),
            Token(TokenType.NUMBER, "123.456", 123.456, 2),
            Token(TokenType.EOF, "", null, 2)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)

    }

    @Test
    fun testIdentifier() {

        // Given
        scanner = createScannerWithSource(
            """
                formation
                _private
                ARRAY_LENGTH
            """
        )

        // When
        val actualTokens = scanner.scanTokens()

        // Then
        val expectedTokens = listOf(
            Token(TokenType.IDENTIFIER, "formation", null, 1),
            Token(TokenType.IDENTIFIER, "_private", null, 2),
            Token(TokenType.IDENTIFIER, "ARRAY_LENGTH", null, 3),
            Token(TokenType.EOF, "", null, 3)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)

    }

    @Test
    fun testString() {

        // Given
        scanner = createScannerWithSource(
            """
                "This is a string"
                "This is a multi-line
                string"
            """
        )

        // When
        val actualTokens = scanner.scanTokens()

        // Then
        val expectedTokens = listOf(
            Token(TokenType.STRING, "\"This is a string\"", "This is a string", 1),
            Token(TokenType.STRING, "\"This is a multi-line\nstring\"", "This is a multi-line\nstring", 3),
            Token(TokenType.EOF, "", null, 3)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)

    }

    @Test
    fun testSingleCharTokens() {

        // Given
        scanner = createScannerWithSource(
            """
                (){},
                .+-;*/
                """
        )

        // When
        val actualTokens = scanner.scanTokens()

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
            Token(TokenType.EOF, "", null, 2)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)

    }

    @Test
    fun testOneOrTwoCharTokens() {

        // Given
        scanner = createScannerWithSource(
            """
                !=! ===>>=<=< 
                """
        )

        // When
        val actualTokens = scanner.scanTokens()

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
            Token(TokenType.EOF, "", null, 1)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)

    }

    @Test
    fun testKeywords() {

        // Given
        scanner = createScannerWithSource(
            """
                and class else false fun for if nil or print return super this true var while
                android classic elsewhere superstitious
                """
        )

        // When
        val actualTokens = scanner.scanTokens()

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
            Token(TokenType.EOF, "", null, 2)
        )
        Truth.assertThat(actualTokens).isEqualTo(expectedTokens)

    }

    @Test
    fun testUnexpectedCharError() {

        // Given
        scanner = createScannerWithSource(
            """
                $
                """
        )

        // When
        scanner.scanTokens()

        // Then
        Mockito.verify(errorReporter).error(1, ErrorReporter.Error.UNEXPECTED_CHAR)

    }

    @Test
    fun testUnterminatedStringError() {

        // Given
        scanner = createScannerWithSource(
            """
                "abc
                """
        )

        // When
        scanner.scanTokens()

        // Then
        Mockito.verify(errorReporter).error(1, ErrorReporter.Error.UNTERMINATED_STRING)

    }

    @Test
    fun testUnterminatedBlockCommentError() {

        // Given
        scanner = createScannerWithSource(
            """
                /* this is an unterminated block comment
                """
        )

        // When
        scanner.scanTokens()

        // Then
        Mockito.verify(errorReporter).error(1, ErrorReporter.Error.UNTERMINATED_BLOCK_COMMENT)

    }

    private fun createScannerWithSource(source: String) = Scanner(source.trimIndent(), errorReporter)

}