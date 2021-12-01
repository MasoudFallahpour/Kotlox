package ir.fallahpoor.kotlox.interpreter.interpreter

import ir.fallahpoor.kotlox.interpreter.scanner.Token

class RuntimeError(val token: Token, message: String?) : RuntimeException(message)