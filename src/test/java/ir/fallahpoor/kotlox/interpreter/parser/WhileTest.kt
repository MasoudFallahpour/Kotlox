package ir.fallahpoor.kotlox.interpreter.parser

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.antlr.parser.AntlrParser
import ir.fallahpoor.kotlox.interpreter.scanner.Scanner
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

// TODO add tests to check if Parser handles errors correctly:
//  - proper error message should be displayed
//  - proper synchronization should be done

@RunWith(MockitoJUnitRunner::class)
class WhileTest {

    @Mock
    private lateinit var errorReporter: ErrorReporter

    @Test
    fun testSingleExpressionBody() {

        // Given
        val source =
            """var c = 0;
               while (c < 3) print c = c + 1;
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testBlockBody() {

        // Given
        val source =
            """var a = 0;
               while (a < 3) {
                   print a;
                   a = a + 1;
               }
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testStatementBodies() {

        // Given
        val source =
            """while (false) if (true) 1; else 2;
               while (false) while (true) 1;
               while (false) for (;;) 1;
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    private fun parseSource(source: String): List<Stmt> {
        val parser = createParser(source)
        return parser.parse()
    }

    private fun createParser(source: String): Parser {
        val scanner = Scanner(source.trimIndent(), errorReporter)
        val tokens: List<Token> = scanner.scanTokens()
        return Parser(Tokens(tokens), errorReporter)
    }

}