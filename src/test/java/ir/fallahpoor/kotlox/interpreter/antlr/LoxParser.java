package ir.fallahpoor.kotlox.interpreter.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
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
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            NUMBER = 18, STRING = 19, IDENTIFIER = 20, WS = 21, OP_BANG = 22, OP_PLUS = 23, OP_MINUS = 24,
            OP_STAR = 25, OP_SLASH = 26, OP_EQUAL = 27, OP_INEQUAL = 28, OP_GREATER = 29, OP_LESS = 30,
            OP_GREATER_EQUAL = 31, OP_LESS_EQUAL = 32;
    public static final int
            RULE_program = 0, RULE_declaration = 1, RULE_varDecl = 2, RULE_statement = 3,
            RULE_exprStmt = 4, RULE_ifStmt = 5, RULE_printStmt = 6, RULE_whileStmt = 7,
            RULE_block = 8, RULE_expression = 9, RULE_assignment = 10, RULE_logicOr = 11,
            RULE_logicAnd = 12, RULE_equality = 13, RULE_comparison = 14, RULE_term = 15,
            RULE_factor = 16, RULE_unary = 17, RULE_primary = 18;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "declaration", "varDecl", "statement", "exprStmt", "ifStmt",
                "printStmt", "whileStmt", "block", "expression", "assignment", "logicOr",
                "logicAnd", "equality", "comparison", "term", "factor", "unary", "primary"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'var'", "'='", "';'", "'if'", "'('", "')'", "'else'", "'print'",
                "'while'", "'{'", "'}'", "','", "'or'", "'and'", "'true'", "'false'",
                "'nil'", null, null, null, null, "'!'", "'+'", "'-'", "'*'", "'/'", "'=='",
                "'!='", "'>'", "'<'", "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, "NUMBER", "STRING", "IDENTIFIER",
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
                setState(41);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(38);
                            declaration();
                        }
                    }
                    setState(43);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(44);
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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitDeclaration(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DeclarationContext declaration() throws RecognitionException {
        DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_declaration);
        try {
            setState(48);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__0:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(46);
                    varDecl();
                }
                break;
                case T__3:
                case T__4:
                case T__7:
                case T__8:
                case T__9:
                case T__14:
                case T__15:
                case T__16:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(47);
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
                setState(50);
                match(T__0);
                setState(51);
                match(IDENTIFIER);
                setState(54);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__1) {
                    {
                        setState(52);
                        match(T__1);
                        setState(53);
                        expression();
                    }
                }

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

        public WhileStmtContext whileStmt() {
            return getRuleContext(WhileStmtContext.class, 0);
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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_statement);
        try {
            setState(63);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__4:
                case T__14:
                case T__15:
                case T__16:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(58);
                    exprStmt();
                }
                break;
                case T__3:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(59);
                    ifStmt();
                }
                break;
                case T__7:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(60);
                    printStmt();
                }
                break;
                case T__8:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(61);
                    whileStmt();
                }
                break;
                case T__9:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(62);
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
                setState(65);
                expression();
                setState(66);
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
                setState(68);
                match(T__3);
                setState(69);
                match(T__4);
                setState(70);
                expression();
                setState(71);
                match(T__5);
                setState(72);
                ((IfStmtContext) _localctx).thenBranch = statement();
                setState(75);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                    case 1: {
                        setState(73);
                        match(T__6);
                        setState(74);
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
                setState(77);
                match(T__7);
                setState(78);
                expression();
                setState(79);
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

    public static class WhileStmtContext extends ParserRuleContext {
        public ExpressionContext condition;
        public StatementContext body;

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public WhileStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whileStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitWhileStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final WhileStmtContext whileStmt() throws RecognitionException {
        WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_whileStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(81);
                match(T__8);
                setState(82);
                match(T__4);
                setState(83);
                ((WhileStmtContext) _localctx).condition = expression();
                setState(84);
                match(T__5);
                setState(85);
                ((WhileStmtContext) _localctx).body = statement();
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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BlockContext block() throws RecognitionException {
        BlockContext _localctx = new BlockContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(87);
                match(T__9);
                setState(91);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(88);
                            declaration();
                        }
                    }
                    setState(93);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(94);
                match(T__10);
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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_expression);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(96);
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
        public Token s12;
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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitAssignment(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AssignmentContext assignment() throws RecognitionException {
        AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_assignment);
        int _la;
        try {
            setState(109);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(98);
                    match(IDENTIFIER);
                    setState(99);
                    ((AssignmentContext) _localctx).assign = match(T__1);
                    setState(100);
                    assignment();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(101);
                    logicOr();
                    setState(106);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__11) {
                        {
                            {
                                setState(102);
                                ((AssignmentContext) _localctx).s12 = match(T__11);
                                ((AssignmentContext) _localctx).op.add(((AssignmentContext) _localctx).s12);
                                setState(103);
                                logicOr();
                            }
                        }
                        setState(108);
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
        public Token s13;
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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitLogicOr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LogicOrContext logicOr() throws RecognitionException {
        LogicOrContext _localctx = new LogicOrContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_logicOr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(111);
                logicAnd();
                setState(116);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__12) {
                    {
                        {
                            setState(112);
                            ((LogicOrContext) _localctx).s13 = match(T__12);
                            ((LogicOrContext) _localctx).or.add(((LogicOrContext) _localctx).s13);
                            setState(113);
                            logicAnd();
                        }
                    }
                    setState(118);
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
        public Token s14;
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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitLogicAnd(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LogicAndContext logicAnd() throws RecognitionException {
        LogicAndContext _localctx = new LogicAndContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_logicAnd);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(119);
                equality();
                setState(124);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__13) {
                    {
                        {
                            setState(120);
                            ((LogicAndContext) _localctx).s14 = match(T__13);
                            ((LogicAndContext) _localctx).and.add(((LogicAndContext) _localctx).s14);
                            setState(121);
                            equality();
                        }
                    }
                    setState(126);
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
        public Token s28;
        public List<Token> op = new ArrayList<Token>();
        public Token s27;
        public Token _tset231;

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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitEquality(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EqualityContext equality() throws RecognitionException {
        EqualityContext _localctx = new EqualityContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_equality);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(127);
                comparison();
                setState(132);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_EQUAL || _la == OP_INEQUAL) {
                    {
                        {
                            setState(128);
                            ((EqualityContext) _localctx)._tset231 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_EQUAL || _la == OP_INEQUAL)) {
                                ((EqualityContext) _localctx)._tset231 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((EqualityContext) _localctx).op.add(((EqualityContext) _localctx)._tset231);
                            setState(129);
                            comparison();
                        }
                    }
                    setState(134);
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
        public Token s29;
        public List<Token> op = new ArrayList<Token>();
        public Token s31;
        public Token s30;
        public Token s32;
        public Token _tset254;

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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitComparison(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ComparisonContext comparison() throws RecognitionException {
        ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_comparison);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(135);
                term();
                setState(140);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0)) {
                    {
                        {
                            setState(136);
                            ((ComparisonContext) _localctx)._tset254 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0))) {
                                ((ComparisonContext) _localctx)._tset254 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((ComparisonContext) _localctx).op.add(((ComparisonContext) _localctx)._tset254);
                            setState(137);
                            term();
                        }
                    }
                    setState(142);
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
        public Token s24;
        public List<Token> op = new ArrayList<Token>();
        public Token s23;
        public Token _tset286;

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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitTerm(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TermContext term() throws RecognitionException {
        TermContext _localctx = new TermContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_term);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(143);
                factor();
                setState(148);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_PLUS || _la == OP_MINUS) {
                    {
                        {
                            setState(144);
                            ((TermContext) _localctx)._tset286 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_PLUS || _la == OP_MINUS)) {
                                ((TermContext) _localctx)._tset286 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((TermContext) _localctx).op.add(((TermContext) _localctx)._tset286);
                            setState(145);
                            factor();
                        }
                    }
                    setState(150);
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
        public Token s26;
        public List<Token> op = new ArrayList<Token>();
        public Token s25;
        public Token _tset309;

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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitFactor(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FactorContext factor() throws RecognitionException {
        FactorContext _localctx = new FactorContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_factor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(151);
                unary();
                setState(156);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_STAR || _la == OP_SLASH) {
                    {
                        {
                            setState(152);
                            ((FactorContext) _localctx)._tset309 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_STAR || _la == OP_SLASH)) {
                                ((FactorContext) _localctx)._tset309 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((FactorContext) _localctx).op.add(((FactorContext) _localctx)._tset309);
                            setState(153);
                            unary();
                        }
                    }
                    setState(158);
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
        public Token s22;
        public List<Token> op = new ArrayList<Token>();
        public Token s24;
        public Token _tset330;

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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitUnary(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UnaryContext unary() throws RecognitionException {
        UnaryContext _localctx = new UnaryContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_unary);
        int _la;
        try {
            setState(162);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(159);
                    ((UnaryContext) _localctx)._tset330 = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == OP_BANG || _la == OP_MINUS)) {
                        ((UnaryContext) _localctx)._tset330 = (Token) _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    ((UnaryContext) _localctx).op.add(((UnaryContext) _localctx)._tset330);
                    setState(160);
                    unary();
                }
                break;
                case T__4:
                case T__14:
                case T__15:
                case T__16:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(161);
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
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitPrimary(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PrimaryContext primary() throws RecognitionException {
        PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_primary);
        try {
            setState(174);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NUMBER:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(164);
                    match(NUMBER);
                }
                break;
                case STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(165);
                    match(STRING);
                }
                break;
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(166);
                    match(IDENTIFIER);
                }
                break;
                case T__14:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(167);
                    match(T__14);
                }
                break;
                case T__15:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(168);
                    match(T__15);
                }
                break;
                case T__16:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(169);
                    match(T__16);
                }
                break;
                case T__4:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(170);
                    match(T__4);
                    setState(171);
                    expression();
                    setState(172);
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00b3\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\3\3\3\3\5\3\63" +
                    "\n\3\3\4\3\4\3\4\3\4\5\49\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5B\n\5\3\6" +
                    "\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7N\n\7\3\b\3\b\3\b\3\b\3\t\3\t" +
                    "\3\t\3\t\3\t\3\t\3\n\3\n\7\n\\\n\n\f\n\16\n_\13\n\3\n\3\n\3\13\3\13\3" +
                    "\f\3\f\3\f\3\f\3\f\3\f\7\fk\n\f\f\f\16\fn\13\f\5\fp\n\f\3\r\3\r\3\r\7" +
                    "\ru\n\r\f\r\16\rx\13\r\3\16\3\16\3\16\7\16}\n\16\f\16\16\16\u0080\13\16" +
                    "\3\17\3\17\3\17\7\17\u0085\n\17\f\17\16\17\u0088\13\17\3\20\3\20\3\20" +
                    "\7\20\u008d\n\20\f\20\16\20\u0090\13\20\3\21\3\21\3\21\7\21\u0095\n\21" +
                    "\f\21\16\21\u0098\13\21\3\22\3\22\3\22\7\22\u009d\n\22\f\22\16\22\u00a0" +
                    "\13\22\3\23\3\23\3\23\5\23\u00a5\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3" +
                    "\24\3\24\3\24\3\24\5\24\u00b1\n\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24" +
                    "\26\30\32\34\36 \"$&\2\7\3\2\35\36\3\2\37\"\3\2\31\32\3\2\33\34\4\2\30" +
                    "\30\32\32\2\u00b7\2+\3\2\2\2\4\62\3\2\2\2\6\64\3\2\2\2\bA\3\2\2\2\nC\3" +
                    "\2\2\2\fF\3\2\2\2\16O\3\2\2\2\20S\3\2\2\2\22Y\3\2\2\2\24b\3\2\2\2\26o" +
                    "\3\2\2\2\30q\3\2\2\2\32y\3\2\2\2\34\u0081\3\2\2\2\36\u0089\3\2\2\2 \u0091" +
                    "\3\2\2\2\"\u0099\3\2\2\2$\u00a4\3\2\2\2&\u00b0\3\2\2\2(*\5\4\3\2)(\3\2" +
                    "\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\2\2\3/\3\3" +
                    "\2\2\2\60\63\5\6\4\2\61\63\5\b\5\2\62\60\3\2\2\2\62\61\3\2\2\2\63\5\3" +
                    "\2\2\2\64\65\7\3\2\2\658\7\26\2\2\66\67\7\4\2\2\679\5\24\13\28\66\3\2" +
                    "\2\289\3\2\2\29:\3\2\2\2:;\7\5\2\2;\7\3\2\2\2<B\5\n\6\2=B\5\f\7\2>B\5" +
                    "\16\b\2?B\5\20\t\2@B\5\22\n\2A<\3\2\2\2A=\3\2\2\2A>\3\2\2\2A?\3\2\2\2" +
                    "A@\3\2\2\2B\t\3\2\2\2CD\5\24\13\2DE\7\5\2\2E\13\3\2\2\2FG\7\6\2\2GH\7" +
                    "\7\2\2HI\5\24\13\2IJ\7\b\2\2JM\5\b\5\2KL\7\t\2\2LN\5\b\5\2MK\3\2\2\2M" +
                    "N\3\2\2\2N\r\3\2\2\2OP\7\n\2\2PQ\5\24\13\2QR\7\5\2\2R\17\3\2\2\2ST\7\13" +
                    "\2\2TU\7\7\2\2UV\5\24\13\2VW\7\b\2\2WX\5\b\5\2X\21\3\2\2\2Y]\7\f\2\2Z" +
                    "\\\5\4\3\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2" +
                    "\2`a\7\r\2\2a\23\3\2\2\2bc\5\26\f\2c\25\3\2\2\2de\7\26\2\2ef\7\4\2\2f" +
                    "p\5\26\f\2gl\5\30\r\2hi\7\16\2\2ik\5\30\r\2jh\3\2\2\2kn\3\2\2\2lj\3\2" +
                    "\2\2lm\3\2\2\2mp\3\2\2\2nl\3\2\2\2od\3\2\2\2og\3\2\2\2p\27\3\2\2\2qv\5" +
                    "\32\16\2rs\7\17\2\2su\5\32\16\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2" +
                    "\2w\31\3\2\2\2xv\3\2\2\2y~\5\34\17\2z{\7\20\2\2{}\5\34\17\2|z\3\2\2\2" +
                    "}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\33\3\2\2\2\u0080~\3\2\2\2\u0081" +
                    "\u0086\5\36\20\2\u0082\u0083\t\2\2\2\u0083\u0085\5\36\20\2\u0084\u0082" +
                    "\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087" +
                    "\35\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008e\5 \21\2\u008a\u008b\t\3\2" +
                    "\2\u008b\u008d\5 \21\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c" +
                    "\3\2\2\2\u008e\u008f\3\2\2\2\u008f\37\3\2\2\2\u0090\u008e\3\2\2\2\u0091" +
                    "\u0096\5\"\22\2\u0092\u0093\t\4\2\2\u0093\u0095\5\"\22\2\u0094\u0092\3" +
                    "\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097" +
                    "!\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009e\5$\23\2\u009a\u009b\t\5\2\2" +
                    "\u009b\u009d\5$\23\2\u009c\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c" +
                    "\3\2\2\2\u009e\u009f\3\2\2\2\u009f#\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1" +
                    "\u00a2\t\6\2\2\u00a2\u00a5\5$\23\2\u00a3\u00a5\5&\24\2\u00a4\u00a1\3\2" +
                    "\2\2\u00a4\u00a3\3\2\2\2\u00a5%\3\2\2\2\u00a6\u00b1\7\24\2\2\u00a7\u00b1" +
                    "\7\25\2\2\u00a8\u00b1\7\26\2\2\u00a9\u00b1\7\21\2\2\u00aa\u00b1\7\22\2" +
                    "\2\u00ab\u00b1\7\23\2\2\u00ac\u00ad\7\7\2\2\u00ad\u00ae\5\24\13\2\u00ae" +
                    "\u00af\7\b\2\2\u00af\u00b1\3\2\2\2\u00b0\u00a6\3\2\2\2\u00b0\u00a7\3\2" +
                    "\2\2\u00b0\u00a8\3\2\2\2\u00b0\u00a9\3\2\2\2\u00b0\u00aa\3\2\2\2\u00b0" +
                    "\u00ab\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b1\'\3\2\2\2\22+\628AM]lov~\u0086" +
                    "\u008e\u0096\u009e\u00a4\u00b0";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}