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
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, NUMBER = 17,
            STRING = 18, IDENTIFIER = 19, WS = 20, OP_BANG = 21, OP_PLUS = 22, OP_MINUS = 23,
            OP_STAR = 24, OP_SLASH = 25, OP_EQUAL = 26, OP_INEQUAL = 27, OP_GREATER = 28, OP_LESS = 29,
            OP_GREATER_EQUAL = 30, OP_LESS_EQUAL = 31;
    public static final int
            RULE_program = 0, RULE_declaration = 1, RULE_varDecl = 2, RULE_statement = 3,
            RULE_exprStmt = 4, RULE_ifStmt = 5, RULE_printStmt = 6, RULE_block = 7,
            RULE_expression = 8, RULE_assignment = 9, RULE_logicOr = 10, RULE_logicAnd = 11,
            RULE_equality = 12, RULE_comparison = 13, RULE_term = 14, RULE_factor = 15,
            RULE_unary = 16, RULE_primary = 17;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "declaration", "varDecl", "statement", "exprStmt", "ifStmt",
                "printStmt", "block", "expression", "assignment", "logicOr", "logicAnd",
                "equality", "comparison", "term", "factor", "unary", "primary"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'var'", "'='", "';'", "'if'", "'('", "')'", "'else'", "'print'",
                "'{'", "'}'", "','", "'or'", "'and'", "'true'", "'false'", "'nil'", null,
                null, null, null, "'!'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='",
                "'>'", "'<'", "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, "NUMBER", "STRING", "IDENTIFIER", "WS",
                "OP_BANG", "OP_PLUS", "OP_MINUS", "OP_STAR", "OP_SLASH", "OP_EQUAL",
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
                setState(39);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__8) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(36);
                            declaration();
                        }
                    }
                    setState(41);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(42);
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
            setState(46);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__0:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(44);
                    varDecl();
                }
                break;
                case T__3:
                case T__4:
                case T__7:
                case T__8:
                case T__13:
                case T__14:
                case T__15:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(45);
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
                setState(48);
                match(T__0);
                setState(49);
                match(IDENTIFIER);
                setState(52);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__1) {
                    {
                        setState(50);
                        match(T__1);
                        setState(51);
                        expression();
                    }
                }

                setState(54);
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

        public IfStmtContext ifStmt() {
            return getRuleContext(IfStmtContext.class, 0);
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
            setState(60);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__4:
                case T__13:
                case T__14:
                case T__15:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(56);
                    exprStmt();
                }
                break;
                case T__3:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(57);
                    ifStmt();
                }
                break;
                case T__7:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(58);
                    printStmt();
                }
                break;
                case T__8:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(59);
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
                setState(62);
                expression();
                setState(63);
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

    public static class IfStmtContext extends ParserRuleContext {
        public StatementContext thenBranch;
        public StatementContext elseBranch;

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public IfStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ifStmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterIfStmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitIfStmt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitIfStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IfStmtContext ifStmt() throws RecognitionException {
        IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_ifStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(65);
                match(T__3);
                setState(66);
                match(T__4);
                setState(67);
                expression();
                setState(68);
                match(T__5);
                setState(69);
                ((IfStmtContext) _localctx).thenBranch = statement();
                setState(72);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                    case 1: {
                        setState(70);
                        match(T__6);
                        setState(71);
                        ((IfStmtContext) _localctx).elseBranch = statement();
                    }
                    break;
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
        enterRule(_localctx, 12, RULE_printStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(74);
                match(T__7);
                setState(75);
                expression();
                setState(76);
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
        enterRule(_localctx, 14, RULE_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(78);
                match(T__8);
                setState(82);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__8) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(79);
                            declaration();
                        }
                    }
                    setState(84);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(85);
                match(T__9);
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
        enterRule(_localctx, 16, RULE_expression);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(87);
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
        public Token s11;
        public List<Token> op = new ArrayList<Token>();

        public TerminalNode IDENTIFIER() {
            return getToken(LoxParser.IDENTIFIER, 0);
        }

        public AssignmentContext assignment() {
            return getRuleContext(AssignmentContext.class, 0);
        }

        public List<LogicOrContext> logicOr() {
            return getRuleContexts(LogicOrContext.class);
        }

        public LogicOrContext logicOr(int i) {
            return getRuleContext(LogicOrContext.class, i);
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
        enterRule(_localctx, 18, RULE_assignment);
        int _la;
        try {
            setState(100);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(89);
                    match(IDENTIFIER);
                    setState(90);
                    ((AssignmentContext) _localctx).assign = match(T__1);
                    setState(91);
                    assignment();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(92);
                    logicOr();
                    setState(97);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__10) {
                        {
                            {
                                setState(93);
                                ((AssignmentContext) _localctx).s11 = match(T__10);
                                ((AssignmentContext) _localctx).op.add(((AssignmentContext) _localctx).s11);
                                setState(94);
                                logicOr();
                            }
                        }
                        setState(99);
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

    public static class LogicOrContext extends ParserRuleContext {
        public Token s12;
        public List<Token> or = new ArrayList<Token>();

        public List<LogicAndContext> logicAnd() {
            return getRuleContexts(LogicAndContext.class);
        }

        public LogicAndContext logicAnd(int i) {
            return getRuleContext(LogicAndContext.class, i);
        }

        public LogicOrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_logicOr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterLogicOr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitLogicOr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitLogicOr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LogicOrContext logicOr() throws RecognitionException {
        LogicOrContext _localctx = new LogicOrContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_logicOr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(102);
                logicAnd();
                setState(107);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__11) {
                    {
                        {
                            setState(103);
                            ((LogicOrContext) _localctx).s12 = match(T__11);
                            ((LogicOrContext) _localctx).or.add(((LogicOrContext) _localctx).s12);
                            setState(104);
                            logicAnd();
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

    public static class LogicAndContext extends ParserRuleContext {
        public Token s13;
        public List<Token> and = new ArrayList<Token>();

        public List<EqualityContext> equality() {
            return getRuleContexts(EqualityContext.class);
        }

        public EqualityContext equality(int i) {
            return getRuleContext(EqualityContext.class, i);
        }

        public LogicAndContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_logicAnd;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).enterLogicAnd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LoxListener) ((LoxListener) listener).exitLogicAnd(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitLogicAnd(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LogicAndContext logicAnd() throws RecognitionException {
        LogicAndContext _localctx = new LogicAndContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_logicAnd);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(110);
                equality();
                setState(115);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__12) {
                    {
                        {
                            setState(111);
                            ((LogicAndContext) _localctx).s13 = match(T__12);
                            ((LogicAndContext) _localctx).and.add(((LogicAndContext) _localctx).s13);
                            setState(112);
                            equality();
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

    public static class EqualityContext extends ParserRuleContext {
        public Token s27;
        public List<Token> op = new ArrayList<Token>();
        public Token s26;
        public Token _tset206;

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
        enterRule(_localctx, 24, RULE_equality);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(118);
                comparison();
                setState(123);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_EQUAL || _la == OP_INEQUAL) {
                    {
                        {
                            setState(119);
                            ((EqualityContext) _localctx)._tset206 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_EQUAL || _la == OP_INEQUAL)) {
                                ((EqualityContext) _localctx)._tset206 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((EqualityContext) _localctx).op.add(((EqualityContext) _localctx)._tset206);
                            setState(120);
                            comparison();
                        }
                    }
                    setState(125);
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
        public Token s28;
        public List<Token> op = new ArrayList<Token>();
        public Token s30;
        public Token s29;
        public Token s31;
        public Token _tset229;

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
        enterRule(_localctx, 26, RULE_comparison);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(126);
                term();
                setState(131);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0)) {
                    {
                        {
                            setState(127);
                            ((ComparisonContext) _localctx)._tset229 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0))) {
                                ((ComparisonContext) _localctx)._tset229 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((ComparisonContext) _localctx).op.add(((ComparisonContext) _localctx)._tset229);
                            setState(128);
                            term();
                        }
                    }
                    setState(133);
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
        public Token s23;
        public List<Token> op = new ArrayList<Token>();
        public Token s22;
        public Token _tset261;

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
        enterRule(_localctx, 28, RULE_term);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(134);
                factor();
                setState(139);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_PLUS || _la == OP_MINUS) {
                    {
                        {
                            setState(135);
                            ((TermContext) _localctx)._tset261 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_PLUS || _la == OP_MINUS)) {
                                ((TermContext) _localctx)._tset261 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((TermContext) _localctx).op.add(((TermContext) _localctx)._tset261);
                            setState(136);
                            factor();
                        }
                    }
                    setState(141);
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
        public Token s25;
        public List<Token> op = new ArrayList<Token>();
        public Token s24;
        public Token _tset284;

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
        enterRule(_localctx, 30, RULE_factor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(142);
                unary();
                setState(147);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_STAR || _la == OP_SLASH) {
                    {
                        {
                            setState(143);
                            ((FactorContext) _localctx)._tset284 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_STAR || _la == OP_SLASH)) {
                                ((FactorContext) _localctx)._tset284 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((FactorContext) _localctx).op.add(((FactorContext) _localctx)._tset284);
                            setState(144);
                            unary();
                        }
                    }
                    setState(149);
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
        public Token s21;
        public List<Token> op = new ArrayList<Token>();
        public Token s23;
        public Token _tset305;

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
        enterRule(_localctx, 32, RULE_unary);
        int _la;
        try {
            setState(153);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(150);
                    ((UnaryContext) _localctx)._tset305 = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == OP_BANG || _la == OP_MINUS)) {
                        ((UnaryContext) _localctx)._tset305 = (Token) _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    ((UnaryContext) _localctx).op.add(((UnaryContext) _localctx)._tset305);
                    setState(151);
                    unary();
                }
                break;
                case T__4:
                case T__13:
                case T__14:
                case T__15:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(152);
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
        enterRule(_localctx, 34, RULE_primary);
        try {
            setState(165);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NUMBER:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(155);
                    match(NUMBER);
                }
                break;
                case STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(156);
                    match(STRING);
                }
                break;
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(157);
                    match(IDENTIFIER);
                }
                break;
                case T__13:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(158);
                    match(T__13);
                }
                break;
                case T__14:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(159);
                    match(T__14);
                }
                break;
                case T__15:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(160);
                    match(T__15);
                }
                break;
                case T__4:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(161);
                    match(T__4);
                    setState(162);
                    expression();
                    setState(163);
                    match(T__5);
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00aa\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\5\3\61\n\3\3\4" +
                    "\3\4\3\4\3\4\5\4\67\n\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5?\n\5\3\6\3\6\3\6\3" +
                    "\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7K\n\7\3\b\3\b\3\b\3\b\3\t\3\t\7\tS\n\t\f" +
                    "\t\16\tV\13\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13b\n\13" +
                    "\f\13\16\13e\13\13\5\13g\n\13\3\f\3\f\3\f\7\fl\n\f\f\f\16\fo\13\f\3\r" +
                    "\3\r\3\r\7\rt\n\r\f\r\16\rw\13\r\3\16\3\16\3\16\7\16|\n\16\f\16\16\16" +
                    "\177\13\16\3\17\3\17\3\17\7\17\u0084\n\17\f\17\16\17\u0087\13\17\3\20" +
                    "\3\20\3\20\7\20\u008c\n\20\f\20\16\20\u008f\13\20\3\21\3\21\3\21\7\21" +
                    "\u0094\n\21\f\21\16\21\u0097\13\21\3\22\3\22\3\22\5\22\u009c\n\22\3\23" +
                    "\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00a8\n\23\3\23\2\2" +
                    "\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\7\3\2\34\35\3\2\36!\3" +
                    "\2\30\31\3\2\32\33\4\2\27\27\31\31\2\u00ae\2)\3\2\2\2\4\60\3\2\2\2\6\62" +
                    "\3\2\2\2\b>\3\2\2\2\n@\3\2\2\2\fC\3\2\2\2\16L\3\2\2\2\20P\3\2\2\2\22Y" +
                    "\3\2\2\2\24f\3\2\2\2\26h\3\2\2\2\30p\3\2\2\2\32x\3\2\2\2\34\u0080\3\2" +
                    "\2\2\36\u0088\3\2\2\2 \u0090\3\2\2\2\"\u009b\3\2\2\2$\u00a7\3\2\2\2&(" +
                    "\5\4\3\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2" +
                    ",-\7\2\2\3-\3\3\2\2\2.\61\5\6\4\2/\61\5\b\5\2\60.\3\2\2\2\60/\3\2\2\2" +
                    "\61\5\3\2\2\2\62\63\7\3\2\2\63\66\7\25\2\2\64\65\7\4\2\2\65\67\5\22\n" +
                    "\2\66\64\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7\5\2\29\7\3\2\2\2:?\5\n" +
                    "\6\2;?\5\f\7\2<?\5\16\b\2=?\5\20\t\2>:\3\2\2\2>;\3\2\2\2><\3\2\2\2>=\3" +
                    "\2\2\2?\t\3\2\2\2@A\5\22\n\2AB\7\5\2\2B\13\3\2\2\2CD\7\6\2\2DE\7\7\2\2" +
                    "EF\5\22\n\2FG\7\b\2\2GJ\5\b\5\2HI\7\t\2\2IK\5\b\5\2JH\3\2\2\2JK\3\2\2" +
                    "\2K\r\3\2\2\2LM\7\n\2\2MN\5\22\n\2NO\7\5\2\2O\17\3\2\2\2PT\7\13\2\2QS" +
                    "\5\4\3\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2W" +
                    "X\7\f\2\2X\21\3\2\2\2YZ\5\24\13\2Z\23\3\2\2\2[\\\7\25\2\2\\]\7\4\2\2]" +
                    "g\5\24\13\2^c\5\26\f\2_`\7\r\2\2`b\5\26\f\2a_\3\2\2\2be\3\2\2\2ca\3\2" +
                    "\2\2cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2f[\3\2\2\2f^\3\2\2\2g\25\3\2\2\2hm\5" +
                    "\30\r\2ij\7\16\2\2jl\5\30\r\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2" +
                    "n\27\3\2\2\2om\3\2\2\2pu\5\32\16\2qr\7\17\2\2rt\5\32\16\2sq\3\2\2\2tw" +
                    "\3\2\2\2us\3\2\2\2uv\3\2\2\2v\31\3\2\2\2wu\3\2\2\2x}\5\34\17\2yz\t\2\2" +
                    "\2z|\5\34\17\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\33\3\2\2\2" +
                    "\177}\3\2\2\2\u0080\u0085\5\36\20\2\u0081\u0082\t\3\2\2\u0082\u0084\5" +
                    "\36\20\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085" +
                    "\u0086\3\2\2\2\u0086\35\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008d\5 \21" +
                    "\2\u0089\u008a\t\4\2\2\u008a\u008c\5 \21\2\u008b\u0089\3\2\2\2\u008c\u008f" +
                    "\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\37\3\2\2\2\u008f" +
                    "\u008d\3\2\2\2\u0090\u0095\5\"\22\2\u0091\u0092\t\5\2\2\u0092\u0094\5" +
                    "\"\22\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095" +
                    "\u0096\3\2\2\2\u0096!\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\t\6\2\2" +
                    "\u0099\u009c\5\"\22\2\u009a\u009c\5$\23\2\u009b\u0098\3\2\2\2\u009b\u009a" +
                    "\3\2\2\2\u009c#\3\2\2\2\u009d\u00a8\7\23\2\2\u009e\u00a8\7\24\2\2\u009f" +
                    "\u00a8\7\25\2\2\u00a0\u00a8\7\20\2\2\u00a1\u00a8\7\21\2\2\u00a2\u00a8" +
                    "\7\22\2\2\u00a3\u00a4\7\7\2\2\u00a4\u00a5\5\22\n\2\u00a5\u00a6\7\b\2\2" +
                    "\u00a6\u00a8\3\2\2\2\u00a7\u009d\3\2\2\2\u00a7\u009e\3\2\2\2\u00a7\u009f" +
                    "\3\2\2\2\u00a7\u00a0\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7\u00a2\3\2\2\2\u00a7" +
                    "\u00a3\3\2\2\2\u00a8%\3\2\2\2\22)\60\66>JTcfmu}\u0085\u008d\u0095\u009b" +
                    "\u00a7";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}