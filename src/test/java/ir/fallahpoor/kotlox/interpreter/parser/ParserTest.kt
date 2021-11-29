package ir.fallahpoor.kotlox.interpreter.parser

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.antlr.BuildAstVisitor
import ir.fallahpoor.kotlox.interpreter.antlr.LoxLexer
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser
import ir.fallahpoor.kotlox.interpreter.scanner.Scanner
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import org.antlr.v4.runtime.BailErrorStrategy
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.misc.ParseCancellationException
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.io.ByteArrayInputStream

// TODO add tests for checking if the parser reports syntax errors correctly when
//  error handling is fully in place.

@RunWith(MockitoJUnitRunner::class)
class ParserTest {

    private lateinit var parser: Parser

    @Mock
    private lateinit var errorReporter: ErrorReporter

    @Test
    fun test1() {

        // Given
        val source = "1 + 2 / 3 * (4 - 5)"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test2() {

        // Given
        val source = "1 / 2 * 3"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test3() {

        // Given
        val source = "1 != 3 == 4"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test4() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test5() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6 >= (7 - 8) * 9"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test6() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6 >= (7 - 8) * 9 == !(10.12 <= 13)"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test7() {

        // Given
        val source = "!true == false"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test8() {

        // Given
        val source = "12 <= -10 * (3 + 10) < 12"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test9() {

        // Given
        val source = "(1"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        // TODO Verify that errorReporter reported the error

    }

    @Test
    fun test10() {

        // Given
        val source = "(1,2,3) == 3"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test11() {

        // Given
        val source = "1, 2, 3, (4 + 5) / 6 <= 8 == 8"
        parser = createParser(source)

        // When
        val actualExpr: Expr? = parser.parse()

        // Then
        val expectedExpr: Expr? = getExpectedExpr(source)
        Truth.assertThat(actualExpr).isEqualTo(expectedExpr)
        Mockito.verifyNoInteractions(errorReporter)

    }

    private fun createParser(source: String): Parser {
        val scanner = Scanner(source.trimIndent(), errorReporter)
        val tokens: List<Token> = scanner.scanTokens()
        return Parser(Tokens(tokens), errorReporter)
    }

    private fun getExpectedExpr(source: String): Expr? {
        val inputStream = CharStreams.fromStream(ByteArrayInputStream(source.toByteArray()))
        val loxLexer = LoxLexer(inputStream)
        val tokenStream = CommonTokenStream(loxLexer)
        val loxParser = LoxParser(tokenStream).apply {
            errorHandler = BailErrorStrategy()
        }
        return try {
            val expressionContext: LoxParser.ExpressionContext = loxParser.expression()
            return BuildAstVisitor().visitExpression(expressionContext)
        } catch (e: ParseCancellationException) {
            null
        }
    }

}