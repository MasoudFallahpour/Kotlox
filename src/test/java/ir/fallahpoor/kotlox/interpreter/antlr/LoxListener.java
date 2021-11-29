package ir.fallahpoor.kotlox.interpreter.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LoxParser}.
 */
public interface LoxListener extends ParseTreeListener {
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