package ir.fallahpoor.kotlox.interpreter.interpreter

interface LoxCallable {
    fun arity(): Int

    fun call(interpreter: Interpreter, arguments: List<Any?>): Any?
}