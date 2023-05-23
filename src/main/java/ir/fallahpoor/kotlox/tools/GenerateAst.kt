package ir.fallahpoor.kotlox.tools

import java.io.PrintWriter

private const val SINGLE_INDENT = "    "
private const val DOUBLE_INDENT = SINGLE_INDENT + SINGLE_INDENT
private const val TRIPLE_INDENT = SINGLE_INDENT + DOUBLE_INDENT
private const val PACKAGE_NAME = "ir.fallahpoor.kotlox.interpreter"

// We use this code to generate the Expr.kt and Stmt.kt automatically without the
// need to create them manually. So here we're generating Kotlin classes. We could use
// a library like KotlinPoet to do this, but it's too much for what we want to do.
fun main() {
    val outputDir = "./src/main/java/ir/fallahpoor/kotlox/interpreter"
    defineAbstractSyntaxTree(
            outputDir = outputDir,
            className = "Expr",
            subclasses = listOf(
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
    defineAbstractSyntaxTree(
            outputDir = outputDir,
            className = "Stmt",
            subclasses = listOf(
                    "Block      -> statements: List<Stmt>",
                    "Expression -> expression: Expr",
                    "Function   -> name: Token, params: List<Token>, body: List<Stmt>",
                    "If         -> condition: Expr, thenBranch: Stmt, elseBranch: Stmt?",
                    "Print      -> expression: Expr",
                    "Return     -> keyword: Token, value: Expr?",
                    "Var        -> name: Token, initializer: Expr?",
                    "While      -> condition: Expr, body: Stmt",
                    "Break      ->"
            )
    )
}

private fun defineAbstractSyntaxTree(outputDir: String, className: String, subclasses: List<String>) {
    val path = "$outputDir/$className.kt"
    val writer = PrintWriter(path, "UTF-8")
    writer.println("package $PACKAGE_NAME")
    writer.println()
    writer.println("import $PACKAGE_NAME.scanner.Token")
    writer.println()
    writer.println("sealed class $className {")
    writer.println()
    defineVisitorInterface(writer = writer, className = className, types = subclasses)
    writer.println()
    for (type in subclasses) {
        val subclassName = type.split("->")[0].trim()
        val propertyList = type.split("->")[1].trim()
        defineSubclass(writer = writer, className = className, subclassName = subclassName, propertyList = propertyList)
    }
    writer.println("${SINGLE_INDENT}abstract fun <R> accept(visitor: Visitor<R>): R")
    writer.println()
    writer.println("}")
    writer.close()
}

private fun defineSubclass(
        writer: PrintWriter,
        className: String,
        subclassName: String,
        propertyList: String
) {
    val properties = propertyList.split(", ").filter { it.isNotBlank() }
    if (properties.isNotEmpty()) {
        writer.println("${SINGLE_INDENT}data class $subclassName(")
        properties.forEachIndexed { i, v ->
            if (i != properties.lastIndex) {
                writer.println("${DOUBLE_INDENT}val $v,")
            } else {
                writer.println("${DOUBLE_INDENT}val $v")
            }
        }
        writer.print("${SINGLE_INDENT})")
    } else {
        writer.print("${SINGLE_INDENT}object $subclassName")
    }
    writer.println(" : $className() {")
    writer.println("${DOUBLE_INDENT}override fun <R> accept(visitor: Visitor<R>): R {")
    writer.println("${TRIPLE_INDENT}return visitor.visit$subclassName$className(this)")
    writer.println("$DOUBLE_INDENT}")
    writer.println("$SINGLE_INDENT}")
    writer.println()
}

private fun defineVisitorInterface(writer: PrintWriter, className: String, types: List<String>) {
    writer.println("${SINGLE_INDENT}interface Visitor<R> {")
    for (type: String in types) {
        val typeName = type.split("->")[0].trim()
        writer.println(
                "${DOUBLE_INDENT}fun visit$typeName$className(${className.lowercase()}: $typeName): R"
        )
    }
    writer.println("$SINGLE_INDENT}")
}