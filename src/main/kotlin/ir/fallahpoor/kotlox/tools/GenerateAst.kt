package ir.fallahpoor.kotlox.tools

import java.io.PrintWriter

private const val SINGLE_INDENT = "    "
private const val DOUBLE_INDENT = "        "

fun main() {
    val outputDir = "./src/main/kotlin/ir/fallahpoor/kotlox/interpreter"
    defineAst(
        outputDir,
        "Expr",
        listOf(
            "Binary   -> left: Expr, operator: Token, right: Expr",
            "Grouping -> expression: Expr",
            "Literal  -> value: Any?",
            "Unary    -> operator: Token, right: Expr"
        )
    )
}

private fun defineAst(outputDir: String, baseName: String, types: List<String>) {
    val path = "$outputDir/$baseName.kt"
    val writer = PrintWriter(path, "UTF-8")
    writer.println("package ir.fallahpoor.kotlox.interpreter")
    writer.println()
    writer.println("import ir.fallahpoor.kotlox.interpreter.scanner.Token")
    writer.println()
    writer.println("sealed class $baseName {")
    writer.println()
    for (type in types) {
        val className = type.split("->")[0].trim()
        val propertyList = type.split("->")[1].trim()
        defineType(writer, baseName, className, propertyList)
    }
    writer.println("}")
    writer.close()
}

private fun defineType(
    writer: PrintWriter,
    baseName: String,
    className: String,
    propertyList: String
) {
    writer.println("${SINGLE_INDENT}class $className(")
    val properties = propertyList.split(", ")
    properties.forEachIndexed { i, v ->
        if (i != properties.lastIndex) {
            writer.println("${DOUBLE_INDENT}val $v,")
        } else {
            writer.println("${DOUBLE_INDENT}val $v")
        }
    }
    writer.println("${SINGLE_INDENT}) : $baseName()")
    writer.println()
}