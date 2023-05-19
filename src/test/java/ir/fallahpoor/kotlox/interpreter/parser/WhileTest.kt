package ir.fallahpoor.kotlox.interpreter.parser

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.antlr.parser.AntlrParser
import ir.fallahpoor.kotlox.interpreter.scanner.Scanner
import ir.fallahpoor.kotlox.interpreter.scanner.SourceCodeReader
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

    @Test
    fun testSingleBreakStatement() {

        // Given
        val source =
            """var a = 1;
               while (a <= 10) break;
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testBreakNestedInsideIf() {

        // Given
        val source =
            """var a = 1;
               while (a <= 10) {
                   print a;
                   if (a >= 5) {
                       break;
                   }
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
    fun testBreakNestedInsideWhile() {

        // Given
        val source =
            """var a = 1;
               var b;
               while (a <= 10) {
                   print a;
                   if (a >= 5) {
                       break;
                   }
                   a = a + 1;
                   b = 10;
                   while (b <= 100) {
                       print b;
                       if (b >= 50) break;
                       b = b + 10;
                    }
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
    fun testBreakNestedInsideFor() {

        // Given
        val source =
            """var a = 1;
               while (a <= 10) {
                   print a;
                   if (a >= 5) {
                       break;
                   }
                   a = a + 1;
                   for (var b = 10; b <= 100; b = b + 10) {
                       print b;
                       if (b >= 50) break;
                   }
               }
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
        val scanner = Scanner(SourceCodeReader(source.trimIndent()), errorReporter)
        val tokens: List<Token> = scanner.scanTokens()
        return Parser(Tokens(tokens), errorReporter)
    }

}