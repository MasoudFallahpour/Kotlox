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
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, NUMBER = 13, STRING = 14, IDENTIFIER = 15, WS = 16,
            OP_BANG = 17, OP_PLUS = 18, OP_MINUS = 19, OP_STAR = 20, OP_SLASH = 21, OP_EQUAL = 22,
            OP_INEQUAL = 23, OP_GREATER = 24, OP_LESS = 25, OP_GREATER_EQUAL = 26, OP_LESS_EQUAL = 27;
    public static final int
            RULE_program = 0, RULE_declaration = 1, RULE_varDecl = 2, RULE_statement = 3,
            RULE_exprStmt = 4, RULE_printStmt = 5, RULE_block = 6, RULE_expression = 7,
            RULE_assignment = 8, RULE_equality = 9, RULE_comparison = 10, RULE_term = 11,
            RULE_factor = 12, RULE_unary = 13, RULE_primary = 14;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "declaration", "varDecl", "statement", "exprStmt", "printStmt",
                "block", "expression", "assignment", "equality", "comparison", "term",
                "factor", "unary", "primary"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'var'", "'='", "';'", "'print'", "'{'", "'}'", "','", "'true'",
                "'false'", "'nil'", "'('", "')'", null, null, null, null, "'!'", "'+'",
                "'-'", "'*'", "'/'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, "NUMBER", "STRING", "IDENTIFIER", "WS", "OP_BANG", "OP_PLUS", "OP_MINUS",
                "OP_STAR", "OP_SLASH", "OP_EQUAL", "OP_INEQUAL", "OP_GREATER", "OP_LESS",
                "OP_GREATER_EQUAL", "OP_LESS_EQUAL"
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

        public List<DeclarationContext> declaration() {
            return getRuleContexts(DeclarationContext.class);
        }

        public DeclarationContext declaration(int i) {
            return getRuleContext(DeclarationContext.class, i);
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
                setState(33);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(30);
                            declaration();
                        }
                    }
                    setState(35);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(36);
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

    public static class DeclarationContext extends ParserRuleContext {
        public VarDeclContext varDecl() {
            return getRuleContext(VarDeclContext.class, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public DeclarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_declaration;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterDeclaration(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitDeclaration(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitDeclaration(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DeclarationContext declaration() throws RecognitionException {
        DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_declaration);
        try {
            setState(40);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__0:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(38);
                    varDecl();
                }
                break;
                case T__3:
                case T__4:
                case T__7:
                case T__8:
                case T__9:
                case T__10:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(39);
                    statement();
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

    public static class VarDeclContext extends ParserRuleContext {
        public TerminalNode IDENTIFIER() {
            return getToken(LoxParser.IDENTIFIER, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public VarDeclContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_varDecl;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterVarDecl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitVarDecl(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitVarDecl(this);
            else return visitor.visitChildren(this);
        }
    }

    public final VarDeclContext varDecl() throws RecognitionException {
        VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_varDecl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(42);
                match(T__0);
                setState(43);
                match(IDENTIFIER);
                setState(46);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__1) {
                    {
                        setState(44);
                        match(T__1);
                        setState(45);
                        expression();
                    }
                }

                setState(48);
                match(T__2);
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

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
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
        enterRule(_localctx, 6, RULE_statement);
        try {
            setState(53);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__7:
                case T__8:
                case T__9:
                case T__10:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(50);
                    exprStmt();
                }
                break;
                case T__3:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(51);
                    printStmt();
                }
                break;
                case T__4:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(52);
                    block();
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
        enterRule(_localctx, 8, RULE_exprStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(55);
                expression();
                setState(56);
                match(T__2);
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
        enterRule(_localctx, 10, RULE_printStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(58);
                match(T__3);
                setState(59);
                expression();
                setState(60);
                match(T__2);
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

    public static class BlockContext extends ParserRuleContext {
        public List<DeclarationContext> declaration() {
            return getRuleContexts(DeclarationContext.class);
        }

        public DeclarationContext declaration(int i) {
            return getRuleContext(DeclarationContext.class, i);
        }

        public BlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitBlock(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BlockContext block() throws RecognitionException {
        BlockContext _localctx = new BlockContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(62);
                match(T__4);
                setState(66);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(63);
                            declaration();
                        }
                    }
                    setState(68);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(69);
                match(T__5);
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
        public AssignmentContext assignment() {
            return getRuleContext(AssignmentContext.class, 0);
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
        enterRule(_localctx, 14, RULE_expression);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(71);
                assignment();
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

    public static class AssignmentContext extends ParserRuleContext {
        public Token assign;
        public Token s7;
        public List<Token> op = new ArrayList<Token>();

        public TerminalNode IDENTIFIER() {
            return getToken(LoxParser.IDENTIFIER, 0);
        }

        public AssignmentContext assignment() {
            return getRuleContext(AssignmentContext.class, 0);
        }

        public List<EqualityContext> equality() {
            return getRuleContexts(EqualityContext.class);
        }

        public EqualityContext equality(int i) {
            return getRuleContext(EqualityContext.class, i);
        }

        public AssignmentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignment;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterAssignment(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitAssignment(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitAssignment(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AssignmentContext assignment() throws RecognitionException {
        AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_assignment);
        int _la;
        try {
            setState(84);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(73);
                    match(IDENTIFIER);
                    setState(74);
                    ((AssignmentContext) _localctx).assign = match(T__1);
                    setState(75);
                    assignment();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(76);
                    equality();
                    setState(81);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__6) {
                        {
                            {
                                setState(77);
                                ((AssignmentContext) _localctx).s7 = match(T__6);
                                ((AssignmentContext) _localctx).op.add(((AssignmentContext) _localctx).s7);
                                setState(78);
                                equality();
                            }
                        }
                        setState(83);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                break;
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
        public Token s23;
        public List<Token> op = new ArrayList<Token>();
        public Token s22;
        public Token _tset142;

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
        enterRule(_localctx, 18, RULE_equality);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(86);
                comparison();
                setState(91);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_EQUAL || _la == OP_INEQUAL) {
                    {
                        {
                            setState(87);
                            ((EqualityContext) _localctx)._tset142 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_EQUAL || _la == OP_INEQUAL)) {
                                ((EqualityContext) _localctx)._tset142 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((EqualityContext) _localctx).op.add(((EqualityContext) _localctx)._tset142);
                            setState(88);
                            comparison();
                        }
                    }
                    setState(93);
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
        public Token s24;
        public List<Token> op = new ArrayList<Token>();
        public Token s26;
        public Token s25;
        public Token s27;
        public Token _tset165;

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
        enterRule(_localctx, 20, RULE_comparison);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(94);
                term();
                setState(99);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0)) {
                    {
                        {
                            setState(95);
                            ((ComparisonContext) _localctx)._tset165 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0))) {
                                ((ComparisonContext) _localctx)._tset165 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((ComparisonContext) _localctx).op.add(((ComparisonContext) _localctx)._tset165);
                            setState(96);
                            term();
                        }
                    }
                    setState(101);
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
        public Token s19;
        public List<Token> op = new ArrayList<Token>();
        public Token s18;
        public Token _tset197;

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
        enterRule(_localctx, 22, RULE_term);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(102);
                factor();
                setState(107);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_PLUS || _la == OP_MINUS) {
                    {
                        {
                            setState(103);
                            ((TermContext) _localctx)._tset197 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_PLUS || _la == OP_MINUS)) {
                                ((TermContext) _localctx)._tset197 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((TermContext) _localctx).op.add(((TermContext) _localctx)._tset197);
                            setState(104);
                            factor();
                        }
                    }
                    setState(109);
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
        public Token s21;
        public List<Token> op = new ArrayList<Token>();
        public Token s20;
        public Token _tset220;

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
        enterRule(_localctx, 24, RULE_factor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(110);
                unary();
                setState(115);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_STAR || _la == OP_SLASH) {
                    {
                        {
                            setState(111);
                            ((FactorContext) _localctx)._tset220 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_STAR || _la == OP_SLASH)) {
                                ((FactorContext) _localctx)._tset220 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((FactorContext) _localctx).op.add(((FactorContext) _localctx)._tset220);
                            setState(112);
                            unary();
                        }
                    }
                    setState(117);
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
        public Token s17;
        public List<Token> op = new ArrayList<Token>();
        public Token s19;
        public Token _tset241;

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
        enterRule(_localctx, 26, RULE_unary);
        int _la;
        try {
            setState(121);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(118);
                    ((UnaryContext) _localctx)._tset241 = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == OP_BANG || _la == OP_MINUS)) {
                        ((UnaryContext) _localctx)._tset241 = (Token) _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    ((UnaryContext) _localctx).op.add(((UnaryContext) _localctx)._tset241);
                    setState(119);
                    unary();
                }
                break;
                case T__7:
                case T__8:
                case T__9:
                case T__10:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(120);
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

        public TerminalNode IDENTIFIER() {
            return getToken(LoxParser.IDENTIFIER, 0);
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
        enterRule(_localctx, 28, RULE_primary);
        try {
            setState(133);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NUMBER:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(123);
                    match(NUMBER);
                }
                break;
                case STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(124);
                    match(STRING);
                }
                break;
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(125);
                    match(IDENTIFIER);
                }
                break;
                case T__7:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(126);
                    match(T__7);
                }
                break;
                case T__8:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(127);
                    match(T__8);
                }
                break;
                case T__9:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(128);
                    match(T__9);
                }
                break;
                case T__10:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(129);
                    match(T__10);
                    setState(130);
                    expression();
                    setState(131);
                    match(T__11);
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u008a\4\2\t\2" +
                    "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2" +
                    "\16\2%\13\2\3\2\3\2\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\5\4\61\n\4\3\4\3" +
                    "\4\3\5\3\5\3\5\5\58\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\7\bC\n\b\f" +
                    "\b\16\bF\13\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\nR\n\n\f\n\16" +
                    "\nU\13\n\5\nW\n\n\3\13\3\13\3\13\7\13\\\n\13\f\13\16\13_\13\13\3\f\3\f" +
                    "\3\f\7\fd\n\f\f\f\16\fg\13\f\3\r\3\r\3\r\7\rl\n\r\f\r\16\ro\13\r\3\16" +
                    "\3\16\3\16\7\16t\n\16\f\16\16\16w\13\16\3\17\3\17\3\17\5\17|\n\17\3\20" +
                    "\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0088\n\20\3\20\2\2" +
                    "\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\7\3\2\30\31\3\2\32\35\3\2" +
                    "\24\25\3\2\26\27\4\2\23\23\25\25\2\u008d\2#\3\2\2\2\4*\3\2\2\2\6,\3\2" +
                    "\2\2\b\67\3\2\2\2\n9\3\2\2\2\f<\3\2\2\2\16@\3\2\2\2\20I\3\2\2\2\22V\3" +
                    "\2\2\2\24X\3\2\2\2\26`\3\2\2\2\30h\3\2\2\2\32p\3\2\2\2\34{\3\2\2\2\36" +
                    "\u0087\3\2\2\2 \"\5\4\3\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3" +
                    "\2\2\2%#\3\2\2\2&\'\7\2\2\3\'\3\3\2\2\2(+\5\6\4\2)+\5\b\5\2*(\3\2\2\2" +
                    "*)\3\2\2\2+\5\3\2\2\2,-\7\3\2\2-\60\7\21\2\2./\7\4\2\2/\61\5\20\t\2\60" +
                    ".\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\5\2\2\63\7\3\2\2\2\648\5" +
                    "\n\6\2\658\5\f\7\2\668\5\16\b\2\67\64\3\2\2\2\67\65\3\2\2\2\67\66\3\2" +
                    "\2\28\t\3\2\2\29:\5\20\t\2:;\7\5\2\2;\13\3\2\2\2<=\7\6\2\2=>\5\20\t\2" +
                    ">?\7\5\2\2?\r\3\2\2\2@D\7\7\2\2AC\5\4\3\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2" +
                    "\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\b\2\2H\17\3\2\2\2IJ\5\22\n\2J\21" +
                    "\3\2\2\2KL\7\21\2\2LM\7\4\2\2MW\5\22\n\2NS\5\24\13\2OP\7\t\2\2PR\5\24" +
                    "\13\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TW\3\2\2\2US\3\2\2\2VK\3" +
                    "\2\2\2VN\3\2\2\2W\23\3\2\2\2X]\5\26\f\2YZ\t\2\2\2Z\\\5\26\f\2[Y\3\2\2" +
                    "\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\25\3\2\2\2_]\3\2\2\2`e\5\30\r\2ab\t" +
                    "\3\2\2bd\5\30\r\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\27\3\2\2\2" +
                    "ge\3\2\2\2hm\5\32\16\2ij\t\4\2\2jl\5\32\16\2ki\3\2\2\2lo\3\2\2\2mk\3\2" +
                    "\2\2mn\3\2\2\2n\31\3\2\2\2om\3\2\2\2pu\5\34\17\2qr\t\5\2\2rt\5\34\17\2" +
                    "sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\33\3\2\2\2wu\3\2\2\2xy\t\6\2" +
                    "\2y|\5\34\17\2z|\5\36\20\2{x\3\2\2\2{z\3\2\2\2|\35\3\2\2\2}\u0088\7\17" +
                    "\2\2~\u0088\7\20\2\2\177\u0088\7\21\2\2\u0080\u0088\7\n\2\2\u0081\u0088" +
                    "\7\13\2\2\u0082\u0088\7\f\2\2\u0083\u0084\7\r\2\2\u0084\u0085\5\20\t\2" +
                    "\u0085\u0086\7\16\2\2\u0086\u0088\3\2\2\2\u0087}\3\2\2\2\u0087~\3\2\2" +
                    "\2\u0087\177\3\2\2\2\u0087\u0080\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0082" +
                    "\3\2\2\2\u0087\u0083\3\2\2\2\u0088\37\3\2\2\2\17#*\60\67DSV]emu{\u0087";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}