package ir.fallahpoor.kotlox.interpreter.parser

import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.antlr.LoxBaseVisitor
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser

class BuildStmtVisitor(
    private val buildExprVisitor: BuildExprVisitor
) : LoxBaseVisitor<List<Stmt>>() {

    override fun visitProgram(ctx: LoxParser.ProgramContext): List<Stmt> =
        if (ctx.statement().isNullOrEmpty()) {
            emptyList()
        } else {
            val statements = mutableListOf<Stmt>()
            for (i in 0..ctx.statement().lastIndex) {
                statements.addAll(visitStatement(ctx.statement(i)))
            }
            statements
        }

    override fun visitStatement(ctx: LoxParser.StatementContext): List<Stmt> =
        if (ctx.exprStmt() != null) {
            visitExprStmt(ctx.exprStmt())
        } else if (ctx.printStmt() != null) {
            visitPrintStmt(ctx.printStmt())
        } else {
            throw RuntimeException()
        }

    override fun visitExprStmt(ctx: LoxParser.ExprStmtContext): List<Stmt> {
        val expr: Expr = buildExprVisitor.visitExpression(ctx.expression())
        return listOf(Stmt.Expression(expr))
    }

    override fun visitPrintStmt(ctx: LoxParser.PrintStmtContext): List<Stmt> {
        val expr: Expr = buildExprVisitor.visitExpression(ctx.expression())
        return listOf(Stmt.Print(expr))
    }

}