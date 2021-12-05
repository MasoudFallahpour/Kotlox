package ir.fallahpoor.kotlox.interpreter.antlr.parser

import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.antlr.LoxLexer
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser
import org.antlr.v4.runtime.BailErrorStrategy
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.ByteArrayInputStream

object AntlrParser {

    fun parserSource(source: String): List<Stmt> {
        val loxParser: LoxParser = createParser(source)
        val programContext: LoxParser.ProgramContext = loxParser.program()
        return BuildStmtVisitor(BuildExprVisitor()).visitProgram(programContext)
    }

    private fun createParser(source: String): LoxParser {
        val loxLexer = createLexer(source)
        val tokenStream = CommonTokenStream(loxLexer)
        val loxParser = LoxParser(tokenStream).apply {
            errorHandler = BailErrorStrategy()
        }
        return loxParser
    }

    private fun createLexer(source: String): LoxLexer {
        val inputStream = CharStreams.fromStream(ByteArrayInputStream(source.toByteArray()))
        return LoxLexer(inputStream)
    }

}