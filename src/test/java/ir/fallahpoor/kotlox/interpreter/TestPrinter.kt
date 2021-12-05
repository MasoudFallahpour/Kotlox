package ir.fallahpoor.kotlox.interpreter

class TestPrinter : Printer() {

    val output = mutableListOf<String>()

    override fun println(message: String) {
        output += message
    }

}