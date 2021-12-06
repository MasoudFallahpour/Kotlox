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

// TODO add tests for cases when Evaluator catches a runtime error.

@RunWith(MockitoJUnitRunner::class)
class IfTest {

    @Mock
    private lateinit var errorReporter: ErrorReporter

    @Test
    fun testDanglingElse() {

        // Given
        val source =
            """
                if (true) if (false) print "bad"; else print "good";
                if (false) if (true) print "bad"; else print "bad";
             """

        // When
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf("good")
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
        Mockito.verifyNoInteractions(errorReporter)
    }

    @Test
    fun testElse() {

        // Given
        val source =
            """
                if (true) print "good"; else print "bad";
                if (false) print "bad"; else print "good";
                if (false) nil; else { print "block"; }
             """

        // When
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf("good", "good", "block")
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
        Mockito.verifyNoInteractions(errorReporter)
    }

    @Test
    fun testIf() {

        // Given
        val source =
            """
                if (true) print "good";
                if (false) print "bad";
                if (true) { print "block"; }
                var a = false;
                if (a = true) print a;
             """

        // When
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf("good", "block", "true")
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedOutput)
        Mockito.verifyNoInteractions(errorReporter)
    }

    @Test
    fun testTruth() {

        // Given that everything except "false" and "nil" are true.
        val source =
            """
                if (false) print "bad"; else print "false";
                if (nil) print "bad"; else print "nil";
                if (true) print true;
                if (0) print 0;
                if ("") print "empty";
             """

        // When
        val actualPrinter = TestPrinter()
        interpretSource(source, actualPrinter)

        // Then
        val expectedOutput = listOf("false", "nil", "true", "0", "empty")
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