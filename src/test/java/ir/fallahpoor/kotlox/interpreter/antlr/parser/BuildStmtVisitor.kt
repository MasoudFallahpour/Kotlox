package ir.fallahpoor.kotlox.interpreter.antlr.parser

import ir.fallahpoor.kotlox.interpreter.ErrorReporter
import ir.fallahpoor.kotlox.interpreter.Expr
import ir.fallahpoor.kotlox.interpreter.Stmt
import ir.fallahpoor.kotlox.interpreter.antlr.LoxBaseVisitor
import ir.fallahpoor.kotlox.interpreter.antlr.LoxParser
import ir.fallahpoor.kotlox.interpreter.scanner.Token
import ir.fallahpoor.kotlox.interpreter.scanner.TokenType
import org.antlr.v4.runtime.tree.TerminalNode
import java.util.*

class BuildStmtVisitor(
    private val buildExprVisitor: BuildExprVisitor,
    private val errorReporter: ErrorReporter
) : LoxBaseVisitor<List<Stmt>>() {

    companion object {
        private const val FUNCTION_CALL_MAX_ARGUMENT_LIST_SIZE = 255
    }

    private val breakStack = Stack<Boolean>()

    override fun visitProgram(ctx: LoxParser.ProgramContext): List<Stmt> =
        if (ctx.declaration().isNullOrEmpty()) {
            emptyList()
        } else {
            val statements = mutableListOf<Stmt>()
            for (i in ctx.declaration().indices) {
                statements += visitDeclaration(ctx.declaration(i))
            }
            statements
        }

    override fun visitDeclaration(ctx: LoxParser.DeclarationContext): List<Stmt> =
        if (ctx.funcDecl() != null) {
            visitFuncDecl(ctx.funcDecl())
        } else if (ctx.varDecl() != null) {
            visitVarDecl(ctx.varDecl())
        } else if (ctx.statement() != null) {
            visitStatement(ctx.statement())
        } else {
            throw RuntimeException()
        }

    override fun visitFuncDecl(ctx: LoxParser.FuncDeclContext): List<Stmt> =
        visitFunction(ctx.function())

    override fun visitFunction(ctx: LoxParser.FunctionContext): List<Stmt> {
        val parameters: List<Stmt> = if (ctx.parameters() != null) {
            visitParameters(ctx.parameters())
        } else {
            emptyList()
        }
        val functionNameToken = Token(
            type = TokenType.IDENTIFIER,
            lexeme = ctx.IDENTIFIER().symbol.text,
            literal = null,
            line = ctx.IDENTIFIER().symbol.line
        )
        val functionBody: List<Stmt> = visitBlock(ctx.block())
        return listOf(
            Stmt.Function(
                name = functionNameToken,
                params = parameters.map { stmt: Stmt ->
                    val identifier = (stmt as Stmt.Expression).expression as Expr.Variable
                    identifier.name
                },
                body = (functionBody[0] as Stmt.Block).statements
            )
        )
    }

    override fun visitParameters(ctx: LoxParser.ParametersContext): List<Stmt> {
        val parameters = mutableListOf<Stmt.Expression>().apply {
            add(
                Stmt.Expression(
                    Expr.Variable(createIdentifierToken(ctx.IDENTIFIER(0)))
                )
            )
        }
        for (i in ctx.comma.indices) {
            val token: Token = createIdentifierToken(ctx.IDENTIFIER(i + 1))
            if (parameters.size >= FUNCTION_CALL_MAX_ARGUMENT_LIST_SIZE) {
                errorReporter.error(token, "Can't have more than 255 parameters.")
            }
            parameters += Stmt.Expression(Expr.Variable(token))
        }
        return parameters
    }

    private fun createIdentifierToken(identifier: TerminalNode) =
        Token(
            type = TokenType.IDENTIFIER,
            lexeme = identifier.symbol.text,
            literal = null,
            line = identifier.symbol.line
        )

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

    override fun visitStatement(ctx: LoxParser.StatementContext): List<Stmt> {
        val statements: List<Stmt>
        if (ctx.ifStmt() != null) {
            statements = visitIfStmt(ctx.ifStmt())
        } else if (ctx.forStmt() != null) {
            breakStack.push(true)
            statements = visitForStmt(ctx.forStmt())
            breakStack.push(false)
        } else if (ctx.whileStmt() != null) {
            breakStack.push(true)
            statements = visitWhileStmt(ctx.whileStmt())
            breakStack.push(false)
        } else if (ctx.breakStmt() != null) {
            statements = visitBreakStmt(ctx.breakStmt())
        } else if (ctx.block() != null) {
            statements = visitBlock(ctx.block())
        } else if (ctx.printStmt() != null) {
            statements = visitPrintStmt(ctx.printStmt())
        } else if (ctx.returnStmt() != null) {
            statements = visitReturnStmt(ctx.returnStmt())
        } else if (ctx.exprStmt() != null) {
            statements = visitExprStmt(ctx.exprStmt())
        } else {
            throw RuntimeException()
        }
        return statements
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

    override fun visitForStmt(ctx: LoxParser.ForStmtContext): List<Stmt> {
        val initializer: List<Stmt>? = if (ctx.varDecl() != null) {
            visitVarDecl(ctx.varDecl())
        } else if (ctx.exprStmt() != null) {
            visitExprStmt(ctx.exprStmt())
        } else {
            null
        }
        var condition: Expr? = if (ctx.condition != null) {
            buildExprVisitor.visitExpression(ctx.condition)
        } else {
            null
        }
        val increment: Expr? = if (ctx.increment != null) {
            buildExprVisitor.visitExpression(ctx.increment)
        } else {
            null
        }
        var body: List<Stmt> = visitStatement(ctx.body)
        if (increment != null) {
            body = listOf(
                Stmt.Block(
                    listOf(
                        body[0],
                        Stmt.Expression(increment)
                    )
                )
            )
        }
        if (condition == null) {
            condition = Expr.Literal(true)
        }
        body = listOf(Stmt.While(condition, body[0]))
        if (initializer != null) {
            body = listOf(
                Stmt.Block(
                    listOf(
                        initializer[0],
                        body[0]
                    )
                )
            )
        }
        return body
    }

    override fun visitWhileStmt(ctx: LoxParser.WhileStmtContext): List<Stmt> {
        val condition: Expr = buildExprVisitor.visitExpression(ctx.condition)
        val body: List<Stmt> = visitStatement(ctx.body)
        return listOf(Stmt.While(condition, body[0]))
    }

    override fun visitBreakStmt(ctx: LoxParser.BreakStmtContext?): List<Stmt> {
        if (!breakStack.peek()) {
            throw RuntimeException()
        }
        return listOf(Stmt.Break)
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

    override fun visitPrintStmt(ctx: LoxParser.PrintStmtContext): List<Stmt> {
        val expr: Expr = buildExprVisitor.visitExpression(ctx.expression())
        return listOf(Stmt.Print(expr))
    }

    override fun visitReturnStmt(ctx: LoxParser.ReturnStmtContext): List<Stmt> {
        val value: Expr? = if (ctx.expression() == null) {
            null
        } else {
            buildExprVisitor.visitExpression(ctx.expression())
        }
        val keyword = Token(TokenType.RETURN, "return", null, ctx.ret.line)
        return listOf(Stmt.Return(keyword, value))
    }

    override fun visitExprStmt(ctx: LoxParser.ExprStmtContext): List<Stmt> {
        val expr: Expr = buildExprVisitor.visitExpression(ctx.expression())
        return listOf(Stmt.Expression(expr))
    }

}