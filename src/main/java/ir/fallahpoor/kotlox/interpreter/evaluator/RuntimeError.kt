package ir.fallahpoor.kotlox.interpreter.evaluator

import ir.fallahpoor.kotlox.interpreter.scanner.Token

class RuntimeError(val token: Token, message: String?) : RuntimeException(message)