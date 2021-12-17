package ir.fallahpoor.kotlox.interpreter.interpreter

import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.scanner.Token

class LoxFunction(private val declaration: Stmt.Function) : LoxCallable {

    override fun arity(): Int = declaration.params.size

    override fun call(interpreter: Interpreter, arguments: List<Any?>): Any? {
        val environment = Environment(interpreter.globals)
        declaration.params.zip(arguments).forEach { p: Pair<Token, Any?> ->
            val (param: Token, argument: Any?) = p
            environment.define(
                param.lexeme,
                argument
            )
        }
        return try {
            interpreter.executeBlock(declaration.body, environment)
            null
        } catch (returnValue: Interpreter.ReturnException) {
            returnValue.value
        }
    }

    override fun toString(): String = "<fn " + declaration.name.lexeme + ">"

}