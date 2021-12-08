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
        interpreter.executeBlock(declaration.body, environment)
        return null
    }

    override fun toString(): String = "<fn " + declaration.name.lexeme + ">"

}