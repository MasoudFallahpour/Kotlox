package ir.fallahpoor.kotlox.interpreter.interpreter

import ir.fallahpoor.kotlox.interpreter.scanner.Token

data class RuntimeError(val token: Token, val msg: String?) : RuntimeException(msg)