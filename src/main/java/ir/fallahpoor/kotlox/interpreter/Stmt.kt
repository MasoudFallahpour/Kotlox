package ir.fallahpoor.kotlox.interpreter

import ir.fallahpoor.kotlox.interpreter.scanner.Token

sealed class Stmt {

    interface Visitor<R> {
        fun visitBlockStmt(stmt: Block): R
        fun visitExpressionStmt(stmt: Expression): R
        fun visitIfStmt(stmt: If): R
        fun visitPrintStmt(stmt: Print): R
        fun visitVarStmt(stmt: Var): R
        fun visitWhileStmt(stmt: While): R
    }

    data class Block(
        val statements: List<Stmt>
    ) : Stmt() {
        override fun <R> accept(visitor: Visitor<R>): R {
            return visitor.visitBlockStmt(this)
        }
    }

    data class Expression(
        val expression: Expr
    ) : Stmt() {
        override fun <R> accept(visitor: Visitor<R>): R {
            return visitor.visitExpressionStmt(this)
        }
    }

    data class If(
        val condition: Expr,
        val thenBranch: Stmt,
        val elseBranch: Stmt?
    ) : Stmt() {
        override fun <R> accept(visitor: Visitor<R>): R {
            return visitor.visitIfStmt(this)
        }
    }

    data class Print(
        val expression: Expr
    ) : Stmt() {
        override fun <R> accept(visitor: Visitor<R>): R {
            return visitor.visitPrintStmt(this)
        }
    }

    data class Var(
        val name: Token,
        val initializer: Expr?
    ) : Stmt() {
        override fun <R> accept(visitor: Visitor<R>): R {
            return visitor.visitVarStmt(this)
        }
    }

    data class While(
        val condition: Expr,
        val body: Stmt
    ) : Stmt() {
        override fun <R> accept(visitor: Visitor<R>): R {
            return visitor.visitWhileStmt(this)
        }
    }

    abstract fun <R> accept(visitor: Visitor<R>): R

}
