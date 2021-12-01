package ir.fallahpoor.kotlox.interpreter.interpreter

import com.google.common.truth.Truth
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
class InterpreterTest {

    @Mock
    private lateinit var errorReporter: ErrorReporter

    @Test
    fun test1() {

        // Given
        val source = "print 1 + 2 / 3 * (4 - 5);"

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
    fun test2() {

        // Given
        val source = "print 1 / 2 * 3;"

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
    fun test3() {

        // Given
        val source = "print 1 != 3 == 4;"

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
    fun test4() {

        // Given
        val source = "print -4 - 6;"

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
    fun test5() {

        // Given
        val source = "print 1 + 2 / 3 * -4 - 6 > (7 - 8) * 9;"

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
    fun test6() {

        // Given
        val source = "print 1 + 2 / 3 * -4 - 6 >= (7 - 8) * 9 == !(10.12 <= 13);"

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
    fun test7() {

        // Given
        val source = "print !true == false;"

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
    fun test8() {

        // Given
        val source = "print (1,2,3) == 3;"

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
    fun test9() {

        // Given
        val source = "print 1, 2, 3, (4 + 5) / 6 <= 8 == 8;"

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
    fun test10() {

        // Given
        val source = "print nil == nil;"

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
    fun test11() {

        // Given
        val source = "print 1 + \"hello\" + 1;"

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
    fun test12() {

        // Given
        val source = "print \"Hello\" + \" World!\";"

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
    fun test13() {

        // Given
        val source =
            """print "one";
             print true;
             print 2 + 1;
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
        try {
            val programContext: LoxParser.ProgramContext = loxParser.program()
            InterpretStmtVisitor(InterpretExprVisitor(), printer).visitProgram(programContext)
        } catch (e: RuntimeException) {
        }
    }

}