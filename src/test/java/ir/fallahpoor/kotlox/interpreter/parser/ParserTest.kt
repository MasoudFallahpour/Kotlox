package ir.fallahpoor.kotlox.interpreter.parser

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.antlr.LoxLexer
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser
import ir.fallahpoor.kotlox.interpreter.scanner.Scanner
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType
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
        val source = "1 + 2 / 3 * (4 - 5);"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test2() {

        // Given
        val source = "1 / 2 * 3;"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test3() {

        // Given
        val source = "1 != 3 == 4;"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test4() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6;"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test5() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6 >= (7 - 8) * 9;"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test6() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6 >= (7 - 8) * 9 == !(10.12 <= 13);"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test7() {

        // Given
        val source = "!true == false;"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test8() {

        // Given
        val source = "12 <= -10 * (3 + 10) < 12;"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test(expected = Parser.ParseError::class)
    fun test9() {

        // Given
        val source = "(1;"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verify(errorReporter).error(
            Token(TokenType.RIGHT_PAREN, ")", null, 1),
            "Expect ')' after expression."
        )

    }

    @Test
    fun test10() {

        // Given
        val source = "(1,2,3) == 3;"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test11() {

        // Given
        val source = "1, 2, 3, (4 + 5) / 6 <= 8 == 8;"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test12() {

        // Given
        val source = "\"Lox\" != \"Kotlox\";"
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
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
        parser = createParser(source)

        // When
        val actualStatements: List<Stmt> = parser.parse()

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    private fun createParser(source: String): Parser {
        val scanner = Scanner(source.trimIndent(), errorReporter)
        val tokens: List<Token> = scanner.scanTokens()
        return Parser(Tokens(tokens), errorReporter)
    }

    private fun getExpectedStatements(source: String): List<Stmt>? {
        val inputStream = CharStreams.fromStream(ByteArrayInputStream(source.toByteArray()))
        val loxLexer = LoxLexer(inputStream)
        val tokenStream = CommonTokenStream(loxLexer)
        val loxParser = LoxParser(tokenStream).apply {
            errorHandler = BailErrorStrategy()
        }
        return try {
            val programContext: LoxParser.ProgramContext = loxParser.program()
            return BuildStmtVisitor(BuildExprVisitor()).visitProgram(programContext)
        } catch (e: ParseCancellationException) {
            null
        }
    }

}