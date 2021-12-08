package ir.fallahpoor.kotlox.interpreter.parser

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.antlr.parser.AntlrParser
import ir.fallahpoor.kotlox.interpreter.scanner.Scanner
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
class LogicalOperatorsTest {

    @Mock
    private lateinit var errorReporter: ErrorReporter

    @Test
    fun testAnd() {

        // Given
        val source =
            """print false and 1;
               print true and 1;
               print 1 and 2 and false;
               print 1 and true;
               print 1 and 2 and 3;
               var a = "before";
               var b = "before";
               (a = true) and
                   (b = false) and
                   (a = "bad");
               print a;
               print b;
             """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testOr() {

        // Given
        val source =
            """print 1 or true;
               print false or 1;
               print false or false or true;
               print false or false;
               print false or false or false;
               var a = "before";
               var b = "before";
               (a = false) or
                   (b = true) or
                   (a = "bad");
               print a;
               print b;
             """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testAndTruth() {

        // Given
        val source =
            """print false and "bad";
               print nil and "bad";
               print true and "ok";
               print 0 and "ok";
               print "" and "ok";
             """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testOrTruth() {

        // Given
        val source =
            """print false or "ok";
               print nil or "ok";
               print true or "ok";
               print 0 or "ok";
               print "s" or "ok";
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
        val scanner = Scanner(source.trimIndent(), errorReporter)
        val tokens: List<Token> = scanner.scanTokens()
        return Parser(Tokens(tokens), errorReporter)
    }

}