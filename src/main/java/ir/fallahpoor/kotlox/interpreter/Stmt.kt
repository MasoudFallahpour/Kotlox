package ir.fallahpoor.kotlox.interpreter

sealed class Stmt {

    interface Visitor<R> {
        fun visitExpressionStmt(stmt: Expression): R
        fun visitPrintStmt(stmt: Print): R
    }

    data class Expression(
        val expression: Expr
    ) : Stmt() {
        override fun <R> accept(visitor: Visitor<R>): R {
            return visitor.visitExpressionStmt(this)
        }
    }

    data class Print(
        val expression: Expr
    ) : Stmt() {
        override fun <R> accept(visitor: Visitor<R>): R {
            return visitor.visitPrintStmt(this)
        }
    }

    abstract fun <R> accept(visitor: Visitor<R>): R

}
