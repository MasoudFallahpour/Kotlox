package ir.fallahpoor.kotlox.interpreter.interpreter

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.Environment
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.TestPrinter
import ir.fallahpoor.kotlox.interpreter.antlr.LoxLexer
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser
import ir.fallahpoor.kotlox.interpreter.parser.Parser
import ir.fallahpoor.kotlox.interpreter.parser.Tokens
import ir.fallahpoor.kotlox.interpreter.scanner.Scanner
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import org.antlr.v4.runtime.BailErrorStrategy
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.io.ByteArrayInputStream

// TODO add tests for cases when Evaluator catches a runtime error.

@RunWith(MockitoJUnitRunner::class)
class InterpreterIfTest {

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
        val expectedPrinter = TestPrinter()
        interpretSourceWithAntlr(source, expectedPrinter)
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedPrinter.output)
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
        val expectedPrinter = TestPrinter()
        interpretSourceWithAntlr(source, expectedPrinter)
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedPrinter.output)
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
        val expectedPrinter = TestPrinter()
        interpretSourceWithAntlr(source, expectedPrinter)
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedPrinter.output)
        Mockito.verifyNoInteractions(errorReporter)
    }

    @Test
    fun testTruth() {

        // Given
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
        val expectedPrinter = TestPrinter()
        interpretSourceWithAntlr(source, expectedPrinter)
        Truth.assertThat(actualPrinter.output).isEqualTo(expectedPrinter.output)
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

    private fun interpretSourceWithAntlr(source: String, printer: TestPrinter) {
        val inputStream = CharStreams.fromStream(ByteArrayInputStream(source.toByteArray()))
        val loxLexer = LoxLexer(inputStream)
        val tokenStream = CommonTokenStream(loxLexer)
        val loxParser = LoxParser(tokenStream).apply {
            errorHandler = BailErrorStrategy()
        }
        val environment = Environment()
        val programContext: LoxParser.ProgramContext = loxParser.program()
        InterpretStmtVisitor(
            interpretExprVisitor = InterpretExprVisitor(environment),
            environment = environment,
            printer = printer
        ).visitProgram(programContext)
    }

}