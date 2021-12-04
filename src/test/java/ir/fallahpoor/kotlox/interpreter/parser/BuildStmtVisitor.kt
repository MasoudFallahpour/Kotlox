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
                statements += visitDeclaration(ctx.declaration(i))
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
        if (ctx.ifStmt() != null) {
            visitIfStmt(ctx.ifStmt())
        } else if (ctx.printStmt() != null) {
            visitPrintStmt(ctx.printStmt())
        } else if (ctx.block() != null) {
            visitBlock(ctx.block())
        } else if (ctx.exprStmt() != null) {
            visitExprStmt(ctx.exprStmt())
        } else {
            throw RuntimeException()
        }

    override fun visitIfStmt(ctx: LoxParser.IfStmtContext): List<Stmt> {
        val condition: Expr = buildExprVisitor.visitExpression(ctx.expression())
        val thenBranch: List<Stmt> = visitStatement(ctx.thenBranch)
        val ifStmt = if (ctx.elseBranch != null) {
            val elseBranch: List<Stmt> = visitStatement(ctx.elseBranch)
            Stmt.If(condition, thenBranch[0], elseBranch[0])
        } else {
            Stmt.If(condition, thenBranch[0], null)
        }
        return listOf(ifStmt)
    }

    override fun visitPrintStmt(ctx: LoxParser.PrintStmtContext): List<Stmt> {
        val expr: Expr = buildExprVisitor.visitExpression(ctx.expression())
        return listOf(Stmt.Print(expr))
    }

    override fun visitBlock(ctx: LoxParser.BlockContext): List<Stmt> {
        val statements = mutableListOf<Stmt>()
        if (!ctx.declaration().isNullOrEmpty()) {
            ctx.declaration().forEach {
                statements += visitDeclaration(it)
            }
        }
        return listOf(Stmt.Block(statements))
    }

    override fun visitExprStmt(ctx: LoxParser.ExprStmtContext): List<Stmt> {
        val expr: Expr = buildExprVisitor.visitExpression(ctx.expression())
        return listOf(Stmt.Expression(expr))
    }

}