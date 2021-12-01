package ir.fallahpoor.kotlox.interpreter.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LoxParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, NUMBER = 9,
            STRING = 10, WS = 11, OP_BANG = 12, OP_PLUS = 13, OP_MINUS = 14, OP_STAR = 15, OP_SLASH = 16,
            OP_EQUAL = 17, OP_INEQUAL = 18, OP_GREATER = 19, OP_LESS = 20, OP_GREATER_EQUAL = 21,
            OP_LESS_EQUAL = 22;
    public static final int
            RULE_program = 0, RULE_statement = 1, RULE_exprStmt = 2, RULE_printStmt = 3,
            RULE_expression = 4, RULE_equality = 5, RULE_comparison = 6, RULE_term = 7,
            RULE_factor = 8, RULE_unary = 9, RULE_primary = 10;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "statement", "exprStmt", "printStmt", "expression", "equality",
                "comparison", "term", "factor", "unary", "primary"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "';'", "'print'", "','", "'true'", "'false'", "'nil'", "'('", "')'",
                null, null, null, "'!'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='",
                "'>'", "'<'", "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, "NUMBER", "STRING",
                "WS", "OP_BANG", "OP_PLUS", "OP_MINUS", "OP_STAR", "OP_SLASH", "OP_EQUAL",
                "OP_INEQUAL", "OP_GREATER", "OP_LESS", "OP_GREATER_EQUAL", "OP_LESS_EQUAL"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "Lox.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public LoxParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class ProgramContext extends ParserRuleContext {
        public TerminalNode EOF() {
            return getToken(LoxParser.EOF, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_program;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterProgram(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitProgram(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitProgram(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ProgramContext program() throws RecognitionException {
        ProgramContext _localctx = new ProgramContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_program);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(25);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << NUMBER) | (1L << STRING) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(22);
                            statement();
                        }
                    }
                    setState(27);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(28);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StatementContext extends ParserRuleContext {
        public ExprStmtContext exprStmt() {
            return getRuleContext(ExprStmtContext.class, 0);
        }

        public PrintStmtContext printStmt() {
            return getRuleContext(PrintStmtContext.class, 0);
        }

        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_statement);
        try {
            setState(32);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__3:
                case T__4:
                case T__5:
                case T__6:
                case NUMBER:
                case STRING:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(30);
                    exprStmt();
                }
                break;
                case T__1:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(31);
                    printStmt();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprStmtContext extends ParserRuleContext {
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public ExprStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprStmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterExprStmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitExprStmt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitExprStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprStmtContext exprStmt() throws RecognitionException {
        ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_exprStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(34);
                expression();
                setState(35);
                match(T__0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PrintStmtContext extends ParserRuleContext {
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public PrintStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_printStmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterPrintStmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitPrintStmt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitPrintStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PrintStmtContext printStmt() throws RecognitionException {
        PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_printStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(37);
                match(T__1);
                setState(38);
                expression();
                setState(39);
                match(T__0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExpressionContext extends ParserRuleContext {
        public Token s3;
        public List<Token> op = new ArrayList<Token>();

        public List<EqualityContext> equality() {
            return getRuleContexts(EqualityContext.class);
        }

        public EqualityContext equality(int i) {
            return getRuleContext(EqualityContext.class, i);
        }

        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_expression);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(41);
                equality();
                setState(46);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__2) {
                    {
                        {
                            setState(42);
                            ((ExpressionContext) _localctx).s3 = match(T__2);
                            ((ExpressionContext) _localctx).op.add(((ExpressionContext) _localctx).s3);
                            setState(43);
                            equality();
                        }
                    }
                    setState(48);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EqualityContext extends ParserRuleContext {
        public Token s18;
        public List<Token> op = new ArrayList<Token>();
        public Token s17;
        public Token _tset76;

        public List<ComparisonContext> comparison() {
            return getRuleContexts(ComparisonContext.class);
        }

        public ComparisonContext comparison(int i) {
            return getRuleContext(ComparisonContext.class, i);
        }

        public List<TerminalNode> OP_INEQUAL() {
            return getTokens(LoxParser.OP_INEQUAL);
        }

        public TerminalNode OP_INEQUAL(int i) {
            return getToken(LoxParser.OP_INEQUAL, i);
        }

        public List<TerminalNode> OP_EQUAL() {
            return getTokens(LoxParser.OP_EQUAL);
        }

        public TerminalNode OP_EQUAL(int i) {
            return getToken(LoxParser.OP_EQUAL, i);
        }

        public EqualityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_equality;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterEquality(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitEquality(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitEquality(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EqualityContext equality() throws RecognitionException {
        EqualityContext _localctx = new EqualityContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_equality);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(49);
                comparison();
                setState(54);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_EQUAL || _la == OP_INEQUAL) {
                    {
                        {
                            setState(50);
                            ((EqualityContext) _localctx)._tset76 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_EQUAL || _la == OP_INEQUAL)) {
                                ((EqualityContext) _localctx)._tset76 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((EqualityContext) _localctx).op.add(((EqualityContext) _localctx)._tset76);
                            setState(51);
                            comparison();
                        }
                    }
                    setState(56);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ComparisonContext extends ParserRuleContext {
        public Token s19;
        public List<Token> op = new ArrayList<Token>();
        public Token s21;
        public Token s20;
        public Token s22;
        public Token _tset99;

        public List<TermContext> term() {
            return getRuleContexts(TermContext.class);
        }

        public TermContext term(int i) {
            return getRuleContext(TermContext.class, i);
        }

        public List<TerminalNode> OP_GREATER() {
            return getTokens(LoxParser.OP_GREATER);
        }

        public TerminalNode OP_GREATER(int i) {
            return getToken(LoxParser.OP_GREATER, i);
        }

        public List<TerminalNode> OP_GREATER_EQUAL() {
            return getTokens(LoxParser.OP_GREATER_EQUAL);
        }

        public TerminalNode OP_GREATER_EQUAL(int i) {
            return getToken(LoxParser.OP_GREATER_EQUAL, i);
        }

        public List<TerminalNode> OP_LESS() {
            return getTokens(LoxParser.OP_LESS);
        }

        public TerminalNode OP_LESS(int i) {
            return getToken(LoxParser.OP_LESS, i);
        }

        public List<TerminalNode> OP_LESS_EQUAL() {
            return getTokens(LoxParser.OP_LESS_EQUAL);
        }

        public TerminalNode OP_LESS_EQUAL(int i) {
            return getToken(LoxParser.OP_LESS_EQUAL, i);
        }

        public ComparisonContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_comparison;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterComparison(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitComparison(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitComparison(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ComparisonContext comparison() throws RecognitionException {
        ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_comparison);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(57);
                term();
                setState(62);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0)) {
                    {
                        {
                            setState(58);
                            ((ComparisonContext) _localctx)._tset99 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0))) {
                                ((ComparisonContext) _localctx)._tset99 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((ComparisonContext) _localctx).op.add(((ComparisonContext) _localctx)._tset99);
                            setState(59);
                            term();
                        }
                    }
                    setState(64);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TermContext extends ParserRuleContext {
        public Token s14;
        public List<Token> op = new ArrayList<Token>();
        public Token s13;
        public Token _tset131;

        public List<FactorContext> factor() {
            return getRuleContexts(FactorContext.class);
        }

        public FactorContext factor(int i) {
            return getRuleContext(FactorContext.class, i);
        }

        public List<TerminalNode> OP_MINUS() {
            return getTokens(LoxParser.OP_MINUS);
        }

        public TerminalNode OP_MINUS(int i) {
            return getToken(LoxParser.OP_MINUS, i);
        }

        public List<TerminalNode> OP_PLUS() {
            return getTokens(LoxParser.OP_PLUS);
        }

        public TerminalNode OP_PLUS(int i) {
            return getToken(LoxParser.OP_PLUS, i);
        }

        public TermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_term;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitTerm(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitTerm(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TermContext term() throws RecognitionException {
        TermContext _localctx = new TermContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_term);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(65);
                factor();
                setState(70);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_PLUS || _la == OP_MINUS) {
                    {
                        {
                            setState(66);
                            ((TermContext) _localctx)._tset131 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_PLUS || _la == OP_MINUS)) {
                                ((TermContext) _localctx)._tset131 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((TermContext) _localctx).op.add(((TermContext) _localctx)._tset131);
                            setState(67);
                            factor();
                        }
                    }
                    setState(72);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FactorContext extends ParserRuleContext {
        public Token s16;
        public List<Token> op = new ArrayList<Token>();
        public Token s15;
        public Token _tset154;

        public List<UnaryContext> unary() {
            return getRuleContexts(UnaryContext.class);
        }

        public UnaryContext unary(int i) {
            return getRuleContext(UnaryContext.class, i);
        }

        public List<TerminalNode> OP_SLASH() {
            return getTokens(LoxParser.OP_SLASH);
        }

        public TerminalNode OP_SLASH(int i) {
            return getToken(LoxParser.OP_SLASH, i);
        }

        public List<TerminalNode> OP_STAR() {
            return getTokens(LoxParser.OP_STAR);
        }

        public TerminalNode OP_STAR(int i) {
            return getToken(LoxParser.OP_STAR, i);
        }

        public FactorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_factor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterFactor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitFactor(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitFactor(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FactorContext factor() throws RecognitionException {
        FactorContext _localctx = new FactorContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_factor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(73);
                unary();
                setState(78);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_STAR || _la == OP_SLASH) {
                    {
                        {
                            setState(74);
                            ((FactorContext) _localctx)._tset154 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_STAR || _la == OP_SLASH)) {
                                ((FactorContext) _localctx)._tset154 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((FactorContext) _localctx).op.add(((FactorContext) _localctx)._tset154);
                            setState(75);
                            unary();
                        }
                    }
                    setState(80);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UnaryContext extends ParserRuleContext {
        public Token s12;
        public List<Token> op = new ArrayList<Token>();
        public Token s14;
        public Token _tset175;

        public UnaryContext unary() {
            return getRuleContext(UnaryContext.class, 0);
        }

        public TerminalNode OP_BANG() {
            return getToken(LoxParser.OP_BANG, 0);
        }

        public TerminalNode OP_MINUS() {
            return getToken(LoxParser.OP_MINUS, 0);
        }

        public PrimaryContext primary() {
            return getRuleContext(PrimaryContext.class, 0);
        }

        public UnaryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_unary;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterUnary(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitUnary(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitUnary(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UnaryContext unary() throws RecognitionException {
        UnaryContext _localctx = new UnaryContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_unary);
        int _la;
        try {
            setState(84);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(81);
                    ((UnaryContext) _localctx)._tset175 = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == OP_BANG || _la == OP_MINUS)) {
                        ((UnaryContext) _localctx)._tset175 = (Token) _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    ((UnaryContext) _localctx).op.add(((UnaryContext) _localctx)._tset175);
                    setState(82);
                    unary();
                }
                break;
                case T__3:
                case T__4:
                case T__5:
                case T__6:
                case NUMBER:
                case STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(83);
                    primary();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PrimaryContext extends ParserRuleContext {
        public TerminalNode NUMBER() {
            return getToken(LoxParser.NUMBER, 0);
        }

        public TerminalNode STRING() {
            return getToken(LoxParser.STRING, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public PrimaryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_primary;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterPrimary(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitPrimary(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitPrimary(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PrimaryContext primary() throws RecognitionException {
        PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_primary);
        try {
            setState(95);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NUMBER:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(86);
                    match(NUMBER);
                }
                break;
                case STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(87);
                    match(STRING);
                }
                break;
                case T__3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(88);
                    match(T__3);
                }
                break;
                case T__4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(89);
                    match(T__4);
                }
                break;
                case T__5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(90);
                    match(T__5);
                }
                break;
                case T__6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(91);
                    match(T__6);
                    setState(92);
                    expression();
                    setState(93);
                    match(T__7);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30d\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4" +
                    "\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\3\3\3\5\3#\n\3\3\4\3" +
                    "\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6/\n\6\f\6\16\6\62\13\6\3\7\3\7\3" +
                    "\7\7\7\67\n\7\f\7\16\7:\13\7\3\b\3\b\3\b\7\b?\n\b\f\b\16\bB\13\b\3\t\3" +
                    "\t\3\t\7\tG\n\t\f\t\16\tJ\13\t\3\n\3\n\3\n\7\nO\n\n\f\n\16\nR\13\n\3\13" +
                    "\3\13\3\13\5\13W\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fb\n\f\3\f" +
                    "\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\7\3\2\23\24\3\2\25\30\3\2\17\20\3" +
                    "\2\21\22\4\2\16\16\20\20\2e\2\33\3\2\2\2\4\"\3\2\2\2\6$\3\2\2\2\b\'\3" +
                    "\2\2\2\n+\3\2\2\2\f\63\3\2\2\2\16;\3\2\2\2\20C\3\2\2\2\22K\3\2\2\2\24" +
                    "V\3\2\2\2\26a\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31" +
                    "\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36\37\7\2\2\3\37\3" +
                    "\3\2\2\2 #\5\6\4\2!#\5\b\5\2\" \3\2\2\2\"!\3\2\2\2#\5\3\2\2\2$%\5\n\6" +
                    "\2%&\7\3\2\2&\7\3\2\2\2\'(\7\4\2\2()\5\n\6\2)*\7\3\2\2*\t\3\2\2\2+\60" +
                    "\5\f\7\2,-\7\5\2\2-/\5\f\7\2.,\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3" +
                    "\2\2\2\61\13\3\2\2\2\62\60\3\2\2\2\638\5\16\b\2\64\65\t\2\2\2\65\67\5" +
                    "\16\b\2\66\64\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\r\3\2\2\2:8\3" +
                    "\2\2\2;@\5\20\t\2<=\t\3\2\2=?\5\20\t\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@" +
                    "A\3\2\2\2A\17\3\2\2\2B@\3\2\2\2CH\5\22\n\2DE\t\4\2\2EG\5\22\n\2FD\3\2" +
                    "\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\21\3\2\2\2JH\3\2\2\2KP\5\24\13\2L" +
                    "M\t\5\2\2MO\5\24\13\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\23\3\2" +
                    "\2\2RP\3\2\2\2ST\t\6\2\2TW\5\24\13\2UW\5\26\f\2VS\3\2\2\2VU\3\2\2\2W\25" +
                    "\3\2\2\2Xb\7\13\2\2Yb\7\f\2\2Zb\7\6\2\2[b\7\7\2\2\\b\7\b\2\2]^\7\t\2\2" +
                    "^_\5\n\6\2_`\7\n\2\2`b\3\2\2\2aX\3\2\2\2aY\3\2\2\2aZ\3\2\2\2a[\3\2\2\2" +
                    "a\\\3\2\2\2a]\3\2\2\2b\27\3\2\2\2\13\33\"\608@HPVa";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}