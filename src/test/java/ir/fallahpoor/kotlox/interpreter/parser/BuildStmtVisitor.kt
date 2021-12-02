package ir.fallahpoor.kotlox.interpreter.parser

import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.antlr.LoxBaseVisitor
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType

class BuildStmtVisitor(
    private val buildExprVisitor: BuildExprVisitor
) : LoxBaseVisitor<List<Stmt>>() {

    override fun visitProgram(ctx: LoxParser.ProgramContext): List<Stmt> =
        if (ctx.declaration().isNullOrEmpty()) {
            emptyList()
        } else {
            val statements = mutableListOf<Stmt>()
            for (i in 0..ctx.declaration().lastIndex) {
                statements.addAll(visitDeclaration(ctx.declaration(i)))
            }
            statements
        }

    override fun visitDeclaration(ctx: LoxParser.DeclarationContext): List<Stmt> =
        if (ctx.varDecl() != null) {
            visitVarDecl(ctx.varDecl())
        } else if (ctx.statement() != null) {
            visitStatement(ctx.statement())
        } else {
            throw RuntimeException()
        }

    override fun visitVarDecl(ctx: LoxParser.VarDeclContext): List<Stmt> {
        val name = ctx.IDENTIFIER().symbol.text
        val initializer: Expr? = if (ctx.expression() != null) {
            buildExprVisitor.visitExpression(ctx.expression())
        } else {
            null
        }
        val token = Token(TokenType.IDENTIFIER, name, null, ctx.IDENTIFIER().symbol.line)
        return listOf(Stmt.Var(token, initializer))
    }

    override fun visitStatement(ctx: LoxParser.StatementContext): List<Stmt> =
        if (ctx.exprStmt() != null) {
            visitExprStmt(ctx.exprStmt())
        } else if (ctx.printStmt() != null) {
            visitPrintStmt(ctx.printStmt())
        } else if (ctx.block() != null) {
            visitBlock(ctx.block())
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

    override fun visitBlock(ctx: LoxParser.BlockContext): List<Stmt> {
        val statements = mutableListOf<Stmt>()
        if (ctx.declaration() != null && ctx.declaration().isNotEmpty()) {
            ctx.declaration().forEach {
                statements.addAll(visitDeclaration(it))
            }
        }
        return listOf(Stmt.Block(statements))
    }

}