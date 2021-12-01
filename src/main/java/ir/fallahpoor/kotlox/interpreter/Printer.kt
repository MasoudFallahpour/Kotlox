package ir.fallahpoor.kotlox.interpreter

open class Printer {

    open fun println(message: String) {
        kotlin.io.println(message)
    }

    open fun printlnError(message: String) {
        System.err.println(message)
    }

}