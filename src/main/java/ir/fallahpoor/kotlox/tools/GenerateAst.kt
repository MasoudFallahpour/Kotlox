package ir.fallahpoor.kotlox.tools

import java.io.PrintWriter

private const val SINGLE_INDENT = "    "
private const val DOUBLE_INDENT = SINGLE_INDENT + SINGLE_INDENT
private const val TRIPLE_INDENT = SINGLE_INDENT + DOUBLE_INDENT

fun main() {
    val outputDir = "./src/main/java/ir/fallahpoor/kotlox/interpreter"
    defineAst(
        outputDir,
        "Expr",
        listOf(
            "Assign   -> name: Token, value: Expr",
            "Binary   -> left: Expr, operator: Token, right: Expr",
            "Call     -> callee: Expr, paren: Token, arguments: List<Expr>",
            "Grouping -> expression: Expr",
            "Literal  -> value: Any?",
            "Logical  -> left: Expr, operator: Token, right: Expr",
            "Unary    -> operator: Token, right: Expr",
            "Variable -> name: Token"
        )
    )
    defineAst(
        outputDir,
        "Stmt",
        listOf(
            "Block      -> statements: List<Stmt>",
            "Expression -> expression: Expr",
            "Function   -> name: Token, params: List<Token>, body: List<Stmt>",
            "If         -> condition: Expr, thenBranch: Stmt, elseBranch: Stmt?",
            "Print      -> expression: Expr",
            "Var        -> name: Token, initializer: Expr?",
            "While      -> condition: Expr, body: Stmt",
            "Break      ->"
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
    defineVisitor(writer, baseName, types)
    writer.println()
    for (type in types) {
        val className = type.split("->")[0].trim()
        val propertyList = type.split("->")[1].trim()
        defineType(writer, baseName, className, propertyList)
    }
    writer.println("${SINGLE_INDENT}abstract fun <R> accept(visitor: Visitor<R>): R")
    writer.println()
    writer.println("}")
    writer.close()
}

private fun defineType(
    writer: PrintWriter,
    baseName: String,
    className: String,
    propertyList: String
) {
    val properties = propertyList.split(", ").filter { it.isNotBlank() }
    if (properties.isNotEmpty()) {
        writer.println("${SINGLE_INDENT}data class $className(")
        properties.forEachIndexed { i, v ->
            if (i != properties.lastIndex) {
                writer.println("${DOUBLE_INDENT}val $v,")
            } else {
                writer.println("${DOUBLE_INDENT}val $v")
            }
        }
        writer.print("${SINGLE_INDENT})")
    } else {
        writer.print("${SINGLE_INDENT}object $className")
    }
    writer.println(" : $baseName() {")
    writer.println("${DOUBLE_INDENT}override fun <R> accept(visitor: Visitor<R>): R {")
    writer.println("${TRIPLE_INDENT}return visitor.visit$className$baseName(this)")
    writer.println("${DOUBLE_INDENT}}")
    writer.println("${SINGLE_INDENT}}")
    writer.println()
}

private fun defineVisitor(writer: PrintWriter, baseName: String, types: List<String>) {
    writer.println("${SINGLE_INDENT}interface Visitor<R> {")
    for (type: String in types) {
        val typeName = type.split("->")[0].trim()
        writer.println(
            "${DOUBLE_INDENT}fun visit$typeName$baseName(${baseName.lowercase()}: $typeName): R"
        )
    }
    writer.println("${SINGLE_INDENT}}")
}