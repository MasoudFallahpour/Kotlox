package ir.fallahpoor.kotlox.interpreter.interpreter

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.TestPrinter
import ir.fallahpoor.kotlox.interpreter.parser.Parser
import ir.fallahpoor.kotlox.interpreter.parser.Tokens
import ir.fallahpoor.kotlox.interpreter.scanner.Scanner
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

// TODO add tests for cases when Interpreter catches a runtime error.

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
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf("1", "2", "3")
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
        Mockito.verifyNoInteractions(errorReporter)
    }

    @Test
    fun testSingleBlockBody() {

        // Given
        val source =
            """var a = 0;
               while (a < 3) {
                   print a;
                   a = a + 1;
               }
             """

        // When
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf("0", "1", "2")
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
        Mockito.verifyNoInteractions(errorReporter)
    }

    @Test
    fun testStatementBody() {

        // Given
        val source =
            """while (false) if (true) 1; else 2;
               while (false) while (true) 1;
             """

        // When
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = emptyList<String>()
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
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
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = emptyList<String>()
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
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
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf("1", "2", "3", "4", "5")
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
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
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf(
            "1", "10", "20", "30", "40", "50",
            "2", "10", "20", "30", "40", "50",
            "3", "10", "20", "30", "40", "50",
            "4", "10", "20", "30", "40", "50",
            "5"
        )
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
        Mockito.verifyNoInteractions(errorReporter)
    }

    @Test
    fun testBreakNestedInsideFor() {

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
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf(
            "1", "10", "20", "30", "40", "50",
            "2", "10", "20", "30", "40", "50",
            "3", "10", "20", "30", "40", "50",
            "4", "10", "20", "30", "40", "50",
            "5"
        )
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
        Mockito.verifyNoInteractions(errorReporter)
    }

    private fun interpretSource(source: String, printer: TestPrinter) {
        val statements: List<Stmt> = parseSource(source)
        if (statements.isNotEmpty()) {
            val interpreter = Interpreter(errorReporter, printer)
            interpreter.interpret(statements)
        }
    }

    private fun parseSource(source: String): List<Stmt> {
        val scanner = Scanner(source.trimIndent(), errorReporter)
        val tokens: List<Token> = scanner.scanTokens()
        val parser = Parser(Tokens(tokens), errorReporter)
        return parser.parse()
    }

}