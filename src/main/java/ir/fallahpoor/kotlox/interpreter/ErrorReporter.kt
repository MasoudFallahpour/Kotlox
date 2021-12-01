package ir.fallahpoor.kotlox.interpreter

import ir.fallahpoor.kotlox.interpreter.interpreter.RuntimeError
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

class ErrorReporter(
    private val printer: Printer
) {

    sealed class Error(val message: String) {
        data class UnexpectedChar(private val char: Char) : Error("Unexpected char '$char'")
        object UnterminatedBlockComment : Error("Unterminated block comment")
        object UnterminatedString : Error("Unterminated string")
    }

    var hadError = false
    var hadRuntimeError = false

    fun runtimeError(error: RuntimeError) {
        printer.printlnError("[line " + error.token.line + "] " + error.message)
        hadRuntimeError = true
    }

    fun error(line: Int, error: Error) {
        report(line, "", error.message)
    }

    fun error(token: Token, message: String) {
        if (token.type == TokenType.EOF) {
            report(token.line, " at end", message)
        } else {
            report(token.line, " at '" + token.lexeme + "'", message)
        }
    }

    private fun report(line: Int, where: String, message: String) {
        printer.printlnError("[line $line] Error$where: $message")
        hadError = true
    }

}