package ir.fallahpoor.kotlox.interpreter.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LoxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface LoxVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link LoxParser#program}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram(LoxParser.ProgramContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#declaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDeclaration(LoxParser.DeclarationContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#varDecl}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVarDecl(LoxParser.VarDeclContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatement(LoxParser.StatementContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#exprStmt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprStmt(LoxParser.ExprStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#printStmt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPrintStmt(LoxParser.PrintStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression(LoxParser.ExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#equality}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEquality(LoxParser.EqualityContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#comparison}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComparison(LoxParser.ComparisonContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#term}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTerm(LoxParser.TermContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#factor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFactor(LoxParser.FactorContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#unary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnary(LoxParser.UnaryContext ctx);

    /**
     * Visit a parse tree produced by {@link LoxParser#primary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPrimary(LoxParser.PrimaryContext ctx);
}