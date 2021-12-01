package ir.fallahpoor.kotlox.interpreter

import ir.fallahpoor.kotlox.interpreter.interpreter.RuntimeError
import ir.fallahpoor.kotlox.interpreter.scanner.Token

class Environment {

    private val values = mutableMapOf<String, Any?>()

    @Throws(RuntimeError::class)
    fun get(name: Token): Any? {
        if (values.containsKey(name.lexeme)) {
            return values[name.lexeme]
        } else {
            throw RuntimeError(name, "Undefined variable '" + name.lexeme + "'.")
        }
    }

    fun define(name: String, value: Any?) {
        values[name] = value
    }

}