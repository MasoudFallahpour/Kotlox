package ir.fallahpoor.kotlox.interpreter

import ir.fallahpoor.kotlox.interpreter.interpreter.Interpreter
import ir.fallahpoor.kotlox.interpreter.parser.Parser
import ir.fallahpoor.kotlox.interpreter.parser.Tokens
import ir.fallahpoor.kotlox.interpreter.scanner.Scanner
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.system.exitProcess

class Lox(private val commandLineArgs: Array<String>) {

    private val errorReporter = ErrorReporter(Printer())
    private val interpreter = Interpreter(errorReporter, Printer())

    private object ErrorCode {
        // Wrong number of arguments when invoking Kotlox
        const val WRONG_USAGE = 64

        // Syntax error
        const val WRONG_SYNTAX = 65

        // Internal error like adding a number to a string
        const val RUNTIME_ERROR = 70
    }

    fun run() {
        when (commandLineArgs.size) {
            0 -> runPrompt()
            1 -> runFile(commandLineArgs[0])
            else -> {
                println("Usage: Kotlox [script_file]")
                exitProcess(ErrorCode.WRONG_USAGE)
            }
        }
    }

    @Throws(IOException::class)
    private fun runPrompt() {
        val input = java.util.Scanner(System.`in`)
        while (true) {
            print("> ")
            // The only case that readLine returns null is when user presses Ctrl+C to exit the interactive mode.
            // That's the time to break out of the loop.
            val line = input.nextLine() ?: break
            run(line)
            errorReporter.hadError = false
            errorReporter.hadRuntimeError = false
        }
    }

    @Throws(IOException::class)
    private fun runFile(path: String) {
        val source = String(Files.readAllBytes(Paths.get(path)))
        run(source)
        if (errorReporter.hadError) {
            exitProcess(ErrorCode.WRONG_SYNTAX)
        }
        if (errorReporter.hadRuntimeError) {
            exitProcess(ErrorCode.RUNTIME_ERROR)
        }
    }

    private fun run(source: String) {
        val statements: List<Stmt> = parseSource(source)
        // Stop if there was a syntax error.
        if (errorReporter.hadError) {
            println()
            return
        }
        if (statements.isEmpty()) {
            return
        }
        if (statements.size == 1) {
            val statement = statements[0]
            if (statement is Stmt.Expression) {
                val printStmt = Stmt.Print(statement.expression)
                interpreter.interpret(listOf(printStmt))
            } else {
                interpreter.interpret(statements)
            }
        } else {
            interpreter.interpret(statements)
        }
        if (errorReporter.hadRuntimeError) {
            println()
        }
    }

    private fun parseSource(source: String): List<Stmt> {
        val scanner = Scanner(source, errorReporter)
        val tokens: List<Token> = scanner.scanTokens()
        val parser = Parser(Tokens(tokens), errorReporter)
        return parser.parse()
    }

}

fun main(args: Array<String>) {
    Lox(args).run()
}