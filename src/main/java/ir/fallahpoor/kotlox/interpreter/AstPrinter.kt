package ir.fallahpoor.kotlox.interpreter

class AstPrinter : Expr.Visitor<String> {

    fun print(expr: Expr): String = expr.accept(this)

    override fun visitBinaryExpr(expr: Expr.Binary): String =
        parenthesize(
            expr.operator.lexeme,
            expr.left,
            expr.right
        )

    override fun visitGroupingExpr(expr: Expr.Grouping): String =
        parenthesize("group", expr.expression)

    override fun visitLiteralExpr(expr: Expr.Literal): String =
        if (expr.value == null) {
            "nil"
        } else {
            expr.value.toString()
        }

    override fun visitUnaryExpr(expr: Expr.Unary): String =
        parenthesize(expr.operator.lexeme, expr.right)

    private fun parenthesize(name: String, vararg exprs: Expr): String {
        val builder = StringBuilder()
        builder.append("(").append(name)
        for (expr in exprs) {
            builder.append(" ")
            builder.append(expr.accept(this))
        }
        builder.append(")")
        return builder.toString()
    }

    override fun visitVariableExpr(expr: Expr.Variable): String {
        TODO("Not yet implemented")
    }

    override fun visitAssignExpr(expr: Expr.Assign): String {
        TODO("Not yet implemented")
    }

    override fun visitLogicalExpr(expr: Expr.Logical): String {
        TODO("Not yet implemented")
    }

}