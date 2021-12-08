package ir.fallahpoor.kotlox.interpreter.interpreter

import ir.fallahpoor.kotlox.interpreter.scanner.Token

class Environment(private val parentEnvironment: Environment? = null) {

    private object Uninitialized

    private val values = mutableMapOf<String, Any?>()

    @Throws(RuntimeError::class)
    fun get(name: Token): Any? {
        val variableName: String = name.lexeme
        return if (values.containsKey(variableName)) {
            val value: Any? = values[variableName]
            if (value !is Uninitialized) {
                value
            } else {
                throw RuntimeError(name, "Uninitialized variable '$variableName'.")
            }
        } else if (parentEnvironment != null) {
            parentEnvironment.get(name)
        } else {
            throw RuntimeError(name, "Undefined variable '$variableName'.")
        }
    }

    fun define(name: String, value: Any? = Uninitialized) {
        values[name] = value
    }

    fun assign(name: Token, value: Any?) {
        val variableName: String = name.lexeme
        if (values.containsKey(variableName)) {
            values[variableName] = value
        } else if (parentEnvironment != null) {
            parentEnvironment.assign(name, value)
        } else {
            throw RuntimeError(name, "Undefined variable '$variableName'.")
        }
    }

}