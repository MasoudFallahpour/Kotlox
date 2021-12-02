package ir.fallahpoor.kotlox.interpreter

import ir.fallahpoor.kotlox.interpreter.interpreter.RuntimeError
import ir.fallahpoor.kotlox.interpreter.scanner.Token

class Environment {

    private val values = mutableMapOf<String, Any?>()

    @Throws(RuntimeError::class)
    fun get(name: Token): Any? {
        val variableName: String = name.lexeme
        if (values.containsKey(variableName)) {
            return values[variableName]
        } else {
            throw RuntimeError(name, "Undefined variable '$variableName'.")
        }
    }

    fun define(name: String, value: Any?) {
        values[name] = value
    }

    fun assign(name: Token, value: Any?) {
        val variableName: String = name.lexeme
        if (values.containsKey(variableName)) {
            values[variableName] = value
        } else {
            throw RuntimeError(name, "Undefined variable '$variableName'.")
        }
    }

}