package ir.fallahpoor.kotlox.interpreter.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LoxParser}.
 */
public interface LoxListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link LoxParser#program}.
     *
     * @param ctx the parse tree
     */
    void enterProgram(LoxParser.ProgramContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#program}.
     *
     * @param ctx the parse tree
     */
    void exitProgram(LoxParser.ProgramContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#declaration}.
     *
     * @param ctx the parse tree
     */
    void enterDeclaration(LoxParser.DeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#declaration}.
     *
     * @param ctx the parse tree
     */
    void exitDeclaration(LoxParser.DeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#varDecl}.
     *
     * @param ctx the parse tree
     */
    void enterVarDecl(LoxParser.VarDeclContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#varDecl}.
     *
     * @param ctx the parse tree
     */
    void exitVarDecl(LoxParser.VarDeclContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStatement(LoxParser.StatementContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStatement(LoxParser.StatementContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#exprStmt}.
     *
     * @param ctx the parse tree
     */
    void enterExprStmt(LoxParser.ExprStmtContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#exprStmt}.
     *
     * @param ctx the parse tree
     */
    void exitExprStmt(LoxParser.ExprStmtContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#printStmt}.
     *
     * @param ctx the parse tree
     */
    void enterPrintStmt(LoxParser.PrintStmtContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#printStmt}.
     *
     * @param ctx the parse tree
     */
    void exitPrintStmt(LoxParser.PrintStmtContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#expression}.
     *
     * @param ctx the parse tree
     */
    void enterExpression(LoxParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#expression}.
     *
     * @param ctx the parse tree
     */
    void exitExpression(LoxParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#assignment}.
     *
     * @param ctx the parse tree
     */
    void enterAssignment(LoxParser.AssignmentContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#assignment}.
     *
     * @param ctx the parse tree
     */
    void exitAssignment(LoxParser.AssignmentContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#equality}.
     *
     * @param ctx the parse tree
     */
    void enterEquality(LoxParser.EqualityContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#equality}.
     *
     * @param ctx the parse tree
     */
    void exitEquality(LoxParser.EqualityContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#comparison}.
     *
     * @param ctx the parse tree
     */
    void enterComparison(LoxParser.ComparisonContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#comparison}.
     *
     * @param ctx the parse tree
     */
    void exitComparison(LoxParser.ComparisonContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#term}.
     *
     * @param ctx the parse tree
     */
    void enterTerm(LoxParser.TermContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#term}.
     *
     * @param ctx the parse tree
     */
    void exitTerm(LoxParser.TermContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#factor}.
     *
     * @param ctx the parse tree
     */
    void enterFactor(LoxParser.FactorContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#factor}.
     *
     * @param ctx the parse tree
     */
    void exitFactor(LoxParser.FactorContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#unary}.
     *
     * @param ctx the parse tree
     */
    void enterUnary(LoxParser.UnaryContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#unary}.
     *
     * @param ctx the parse tree
     */
    void exitUnary(LoxParser.UnaryContext ctx);

    /**
     * Enter a parse tree produced by {@link LoxParser#primary}.
     *
     * @param ctx the parse tree
     */
    void enterPrimary(LoxParser.PrimaryContext ctx);

    /**
     * Exit a parse tree produced by {@link LoxParser#primary}.
     *
     * @param ctx the parse tree
     */
    void exitPrimary(LoxParser.PrimaryContext ctx);
}