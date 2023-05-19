package ir.fallahpoor.kotlox.interpreter.parser

import com.google.common.truth.Truth
import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.antlr.parser.AntlrParser
import ir.fallahpoor.kotlox.interpreter.scanner.Scanner
import ir.fallahpoor.kotlox.interpreter.scanner.SourceCodeReader
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
class ForTest {

    @Mock
    private lateinit var errorReporter: ErrorReporter

    @Test
    fun testSingleExpressionBody() {

        // Given
        val source = "for (var c = 0; c < 3;) print c = c + 1;"

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testBlockBody() {

        // Given
        val source =
            """for (var a = 0; a < 3; a = a + 1) {
                   print a;
               }  
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testNoClauses() {

        // Given
        val source =
            """for (;;) print "done"; 
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testNoInitializer() {

        // Given
        val source =
            """var i = 0;
               for (; i < 2; i = i + 1) print i; 
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testNoCondition() {

        // Given
        val source =
            """for (var i = 0;; i = i + 1) {
                   print i;
               } 
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testNoIncrement() {

        // Given
        val source =
            """for (var i = 0; i < 2;) {
                    print i;
                    i = i + 1;
               } 
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testStatementBodies() {

        // Given
        val source =
            """for (; false;) if (true) 1; else 2;
               for (; false;) while (true) 1;
               for (; false;) for (;;) 1; 
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testSingleBreakStatement() {

        // Given
        val source =
            """for (var a = 1; a <= 10; i = i + 1) break;
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testBreakNestedInsideIf() {

        // Given
        val source =
            """for (var a = 1; a <= 10; a = a + 1) {
                   print a;
                   if (a >= 5) {
                       break;
                   }
               }
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testBreakNestedInsideFor() {

        // Given
        val source =
            """for (var a = 1; a <= 10; a = a + 1) {
                   print a;
                   if (a >= 5) break;
                   for (var b = 10; b <= 100; b = b + 10) {
                       print b;
                       if (b >= 50) {
                           break;
                       }
                   }
               }
            """

        // When
        val actualStatements: List<Stmt> = parseSource(source)

        // Then
        val expectedStatements: List<Stmt> = AntlrParser.parserSource(source)
        Truth.assertThat(actualStatements).isEqualTo(expectedStatements)
        Mockito.verifyNoInteractions(errorReporter)

    }

    @Test
    fun testBreakNestedInsideWhile() {

        // Given
        val source =
            """var b;
               for (var a = 1; a <= 10; a = a + 1) {
                   print a;
                   if (a >= 5) break;
                   b = 10;
                   while (b <= 100) {
                       print b;
                       if (b >= 50) {
                           break;
                       }
                       b = b + 10;
                   }
               }
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
        val scanner = Scanner(SourceCodeReader(source.trimIndent()), errorReporter)
        val tokens: List<Token> = scanner.scanTokens()
        return Parser(Tokens(tokens), errorReporter)
    }

}