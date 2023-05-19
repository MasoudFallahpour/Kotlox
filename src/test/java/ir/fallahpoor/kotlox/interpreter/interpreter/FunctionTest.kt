package ir.fallahpoor.kotlox.interpreter.interpreter

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.TestPrinter
import ir.fallahpoor.kotlox.interpreter.parser.Parser
import ir.fallahpoor.kotlox.interpreter.parser.Tokens
import ir.fallahpoor.kotlox.interpreter.scanner.Scanner
import ir.fallahpoor.kotlox.interpreter.scanner.SourceCodeReader
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

// TODO add a test for checking 'too many arguments'
@RunWith(MockitoJUnitRunner::class)
class FunctionTest {

    @Mock
    private lateinit var errorReporter: ErrorReporter

    @Test
    fun extraArguments() {

        // Given
        val source =
            """fun f(a, b) {
                   print a;
                   print b;
               }
               f(1, 2, 3, 4);
            """

        // When
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        Truth.assertThat(actualPrinter.output).isEqualTo(emptyList<String>())
        Mockito.verify(errorReporter).runtimeError(
            RuntimeError(
                token = Token(TokenType.RIGHT_PAREN, ")", null, 5),
                msg = "Expected 2 arguments but got 4."
            )
        )
        Mockito.verifyNoMoreInteractions(errorReporter)

    }

    @Test
    fun missingArguments() {

        // Given
        val source =
            """fun f(a, b) {}
               f(1);
            """

        // When
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        Truth.assertThat(actualPrinter.output).isEqualTo(emptyList<String>())
        Mockito.verify(errorReporter).runtimeError(
            RuntimeError(
                token = Token(TokenType.RIGHT_PAREN, ")", null, 2),
                msg = "Expected 2 arguments but got 1."
            )
        )
        Mockito.verifyNoMoreInteractions(errorReporter)

    }

    @Test
    fun emptyBody() {

        // Given
        val source =
            """fun f() {}
               print f();
            """

        // When
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf("nil")
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun parameters() {

        // Given
        val source =
            """fun f0() { print 0; }
               fun f1(a) { print a; }
               fun f2(a, b) { print a + b; }
               fun f3(a, b, c) { print a + b + c; }
               fun f4(a, b, c, d) { print a + b + c + d; }
               var a = 1;
               var b = 2;
               var c = 3;
               f0();
               f1(a);
               f2(a, 2);
               f3(a, b, 1 + 2);
               f4(a, 1 + 1, c, 2 * 2);
            """

        // When
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf("0", "1", "3", "6", "10")
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
        val scanner = Scanner(SourceCodeReader(source.trimIndent()), errorReporter)
        val tokens: List<Token> = scanner.scanTokens()
        val parser = Parser(Tokens(tokens), errorReporter)
        return parser.parse()
    }

}