package ir.fallahpoor.kotlox.interpreter.parser

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Stmt
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

// TODO add tests to check if Parser handles errors correctly:
//  - proper error message should be displayed
//  - proper synchronization should be done

@RunWith(MockitoJUnitRunner::class)
class ParserTest {

    @Mock
    private lateinit var errorReporter: ErrorReporter

    @Test
    fun test1() {

        // Given
        val source = "1 + 2 / 3 * (4 - 5);"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test2() {

        // Given
        val source = "1 / 2 * 3;"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test3() {

        // Given
        val source = "1 != 3 == 4;"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test4() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6;"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test5() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6 >= (7 - 8) * 9;"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test6() {

        // Given
        val source = "1 + 2 / 3 * -4 - 6 >= (7 - 8) * 9 == !(10.12 <= 13);"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test7() {

        // Given
        val source = "!true == false;"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test8() {

        // Given
        val source = "12 <= -10 * (3 + 10) < 12;"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test9() {

        // Given
        val source = "(1,2,3) == 3;"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test10() {

        // Given
        val source = "1, 2, 3, (4 + 5) / 6 <= 8 == 8;"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test11() {

        // Given
        val source = "\"Lox\" != \"Kotlox\";"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test12() {

        // Given
        val source =
            """print "one";
             print true;
             print 2 + 1;
             """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test13() {

        // Given
        val source =
            """var a = 1;
               var b = 1;
               print a + b;
             """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun test14() {

        // Given
        val source =
            """var a = 1;
               var b = 2;
               a = b;
               b = 10.2 / (3 + 4), 5;
               print a;
               print b;
             """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt>? = getExpectedStatements(source)
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