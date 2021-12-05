package ir.fallahpoor.kotlox.interpreter.interpreter

import ir.fallahpoor.kotlox.interpreter.Environment
import ir.fallahpoor.kotlox.interpreter.TestPrinter
import ir.fallahpoor.kotlox.interpreter.antlr.LoxLexer
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser
import org.antlr.v4.runtime.BailErrorStrategy
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.ByteArrayInputStream

object AntlrInterpreter {

    fun interpretSource(source: String, printer: TestPrinter) {
        val loxParser = createParser(source)
        val environment = Environment()
        val programContext: LoxParser.ProgramContext = loxParser.program()
        val interpretStmtVisitor = InterpretStmtVisitor(
            interpretExprVisitor = InterpretExprVisitor(environment),
            environment = environment,
            printer = printer
        )
        interpretStmtVisitor.visitProgram(programContext)
    }

    private fun createParser(source: String): LoxParser {
        val loxLexer: LoxLexer = createLexer(source)
        val tokenStream = CommonTokenStream(loxLexer)
        val loxParser: LoxParser = LoxParser(tokenStream).apply {
            errorHandler = BailErrorStrategy()
        }
        return loxParser
    }

    private fun createLexer(source: String): LoxLexer {
        val inputStream = CharStreams.fromStream(ByteArrayInputStream(source.toByteArray()))
        return LoxLexer(inputStream)
    }

}