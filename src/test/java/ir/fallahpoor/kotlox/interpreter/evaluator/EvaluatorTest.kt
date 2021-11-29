package ir.fallahpoor.kotlox.interpreter.evaluator

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Expr
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
class EvaluatorTest {

    @Mock
    private lateinit var errorReporter: ErrorReporter

    @Test
    fun test1() {

        // Given
        val source = "1 + 2 / 3 * (4 - 5)"

        // When
        val actualValue: String? = evaluateSource(source)

        // Then
        val expectedValue: String? = evaluateSourceWithAntlr(source)
        Truth.assertThat(actualValue).isEqualTo(expectedValue)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test2() {

        // Given
        val source = "1 / 2 * 3"

        // When
        val actualValue: String? = evaluateSource(source)

        // Then
        val expectedValue: String? = evaluateSourceWithAntlr(source)
        Truth.assertThat(actualValue).isEqualTo(expectedValue)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test3() {

        // Given
        val source = "1 != 3 == 4"

        // When
        val actualValue: String? = evaluateSource(source)

        // Then
        val expectedValue: String? = evaluateSourceWithAntlr(source)
        Truth.assertThat(actualValue).isEqualTo(expectedValue)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test4() {

        // Given
        val source = "-4 - 6"

        // When
        val actualValue: String? = evaluateSource(source)

        // Then
        val expectedValue: String? = evaluateSourceWithAntlr(source)
        Truth.assertThat(actualValue).isEqualTo(expectedValue)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test5() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6 >= (7 - 8) * 9"

        // When
        val actualValue: String? = evaluateSource(source)

        // Then
        val expectedValue: String? = evaluateSourceWithAntlr(source)
        Truth.assertThat(actualValue).isEqualTo(expectedValue)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test6() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6 >= (7 - 8) * 9 == !(10.12 <= 13)"

        // When
        val actualValue: String? = evaluateSource(source)

        // Then
        val expectedValue: String? = evaluateSourceWithAntlr(source)
        Truth.assertThat(actualValue).isEqualTo(expectedValue)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test7() {

        // Given
        val source = "!true == false"

        // When
        val actualValue: String? = evaluateSource(source)

        // Then
        val expectedValue: String? = evaluateSourceWithAntlr(source)
        Truth.assertThat(actualValue).isEqualTo(expectedValue)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test8() {

        // Given
        val source = "(1,2,3) == 3"

        // When
        val actualValue: String? = evaluateSource(source)

        // Then
        val expectedValue: String? = evaluateSourceWithAntlr(source)
        Truth.assertThat(actualValue).isEqualTo(expectedValue)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test9() {

        // Given
        val source = "1, 2, 3, (4 + 5) / 6 <= 8 == 8"

        // When
        val actualValue: String? = evaluateSource(source)

        // Then
        val expectedValue: String? = evaluateSourceWithAntlr(source)
        Truth.assertThat(actualValue).isEqualTo(expectedValue)
        Mockito.verifyNoInteractions(errorReporter)

    }

    private fun evaluateSource(source: String): String? {
        val expr: Expr? = parseSource(source)
        return if (expr == null) {
            null
        } else {
            val evaluator = Evaluator(errorReporter)
            evaluator.evaluate(expr)
        }
    }

    private fun parseSource(source: String): Expr? {
        val scanner = Scanner(source.trimIndent(), errorReporter)
        val tokens: List<Token> = scanner.scanTokens()
        val parser = Parser(Tokens(tokens), errorReporter)
        return parser.parse()
    }

    private fun evaluateSourceWithAntlr(source: String): String? {
        val inputStream = CharStreams.fromStream(ByteArrayInputStream(source.toByteArray()))
        val loxLexer = LoxLexer(inputStream)
        val tokenStream = CommonTokenStream(loxLexer)
        val loxParser = LoxParser(tokenStream).apply {
            errorHandler = BailErrorStrategy()
        }
        return try {
            val expressionContext: LoxParser.ExpressionContext = loxParser.expression()
            val result: Any? = EvaluatorVisitor().visitExpression(expressionContext)
            stringify(result)
        } catch (e: RuntimeException) {
            null
        }
    }

    private fun stringify(any: Any?): String =
        when (any) {
            null -> "nil"
            is Double -> {
                var text = any.toString()
                if (text.endsWith(".0")) {
                    text = text.substring(0, text.length - 2)
                }
                text
            }
            else -> any.toString()
        }

}