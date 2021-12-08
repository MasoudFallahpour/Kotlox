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
            T__17 = 18, T__18 = 19, NUMBER = 20, STRING = 21, IDENTIFIER = 22, WS = 23, OP_BANG = 24,
            OP_PLUS = 25, OP_MINUS = 26, OP_STAR = 27, OP_SLASH = 28, OP_EQUAL = 29, OP_INEQUAL = 30,
            OP_GREATER = 31, OP_LESS = 32, OP_GREATER_EQUAL = 33, OP_LESS_EQUAL = 34;
    public static final int
            RULE_program = 0, RULE_declaration = 1, RULE_varDecl = 2, RULE_statement = 3,
            RULE_exprStmt = 4, RULE_forStmt = 5, RULE_ifStmt = 6, RULE_printStmt = 7,
            RULE_whileStmt = 8, RULE_block = 9, RULE_breakStmt = 10, RULE_expression = 11,
            RULE_assignment = 12, RULE_logicOr = 13, RULE_logicAnd = 14, RULE_equality = 15,
            RULE_comparison = 16, RULE_term = 17, RULE_factor = 18, RULE_unary = 19,
            RULE_primary = 20;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "declaration", "varDecl", "statement", "exprStmt", "forStmt",
                "ifStmt", "printStmt", "whileStmt", "block", "breakStmt", "expression",
                "assignment", "logicOr", "logicAnd", "equality", "comparison", "term",
                "factor", "unary", "primary"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'var'", "'='", "';'", "'for'", "'('", "')'", "'if'", "'else'",
                "'print'", "'while'", "'{'", "'}'", "'break'", "','", "'or'", "'and'",
                "'true'", "'false'", "'nil'", null, null, null, null, "'!'", "'+'", "'-'",
                "'*'", "'/'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, "NUMBER", "STRING", "IDENTIFIER",
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
                setState(45);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(42);
                            declaration();
                        }
                    }
                    setState(47);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(48);
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
            setState(52);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__0:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(50);
                    varDecl();
                }
                break;
                case T__3:
                case T__4:
                case T__6:
                case T__8:
                case T__9:
                case T__10:
                case T__12:
                case T__16:
                case T__17:
                case T__18:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(51);
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
                setState(54);
                match(T__0);
                setState(55);
                match(IDENTIFIER);
                setState(58);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__1) {
                    {
                        setState(56);
                        match(T__1);
                        setState(57);
                        expression();
                    }
                }

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

    public static class StatementContext extends ParserRuleContext {
        public ExprStmtContext exprStmt() {
            return getRuleContext(ExprStmtContext.class, 0);
        }

        public ForStmtContext forStmt() {
            return getRuleContext(ForStmtContext.class, 0);
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

        public BreakStmtContext breakStmt() {
            return getRuleContext(BreakStmtContext.class, 0);
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
            setState(69);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__4:
                case T__16:
                case T__17:
                case T__18:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(62);
                    exprStmt();
                }
                break;
                case T__3:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(63);
                    forStmt();
                }
                break;
                case T__6:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(64);
                    ifStmt();
                }
                break;
                case T__8:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(65);
                    printStmt();
                }
                break;
                case T__9:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(66);
                    whileStmt();
                }
                break;
                case T__10:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(67);
                    block();
                }
                break;
                case T__12:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(68);
                    breakStmt();
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
                setState(71);
                expression();
                setState(72);
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

    public static class ForStmtContext extends ParserRuleContext {
        public ExpressionContext condition;
        public ExpressionContext increment;
        public StatementContext body;

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public VarDeclContext varDecl() {
            return getRuleContext(VarDeclContext.class, 0);
        }

        public ExprStmtContext exprStmt() {
            return getRuleContext(ExprStmtContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public ForStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitForStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ForStmtContext forStmt() throws RecognitionException {
        ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_forStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(74);
                match(T__3);
                setState(75);
                match(T__4);
                setState(79);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__0: {
                        setState(76);
                        varDecl();
                    }
                    break;
                    case T__4:
                    case T__16:
                    case T__17:
                    case T__18:
                    case NUMBER:
                    case STRING:
                    case IDENTIFIER:
                    case OP_BANG:
                    case OP_MINUS: {
                        setState(77);
                        exprStmt();
                    }
                    break;
                    case T__2: {
                        setState(78);
                        match(T__2);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(82);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        setState(81);
                        ((ForStmtContext) _localctx).condition = expression();
                    }
                }

                setState(84);
                match(T__2);
                setState(86);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        setState(85);
                        ((ForStmtContext) _localctx).increment = expression();
                    }
                }

                setState(88);
                match(T__5);
                setState(89);
                ((ForStmtContext) _localctx).body = statement();
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
        enterRule(_localctx, 12, RULE_ifStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(91);
                match(T__6);
                setState(92);
                match(T__4);
                setState(93);
                expression();
                setState(94);
                match(T__5);
                setState(95);
                ((IfStmtContext) _localctx).thenBranch = statement();
                setState(98);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                    case 1: {
                        setState(96);
                        match(T__7);
                        setState(97);
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
        enterRule(_localctx, 14, RULE_printStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(100);
                match(T__8);
                setState(101);
                expression();
                setState(102);
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
        enterRule(_localctx, 16, RULE_whileStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(104);
                match(T__9);
                setState(105);
                match(T__4);
                setState(106);
                ((WhileStmtContext) _localctx).condition = expression();
                setState(107);
                match(T__5);
                setState(108);
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
        enterRule(_localctx, 18, RULE_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(110);
                match(T__10);
                setState(114);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(111);
                            declaration();
                        }
                    }
                    setState(116);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(117);
                match(T__11);
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

    public static class BreakStmtContext extends ParserRuleContext {
        public BreakStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_breakStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitBreakStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BreakStmtContext breakStmt() throws RecognitionException {
        BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_breakStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(119);
                match(T__12);
                setState(120);
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
        enterRule(_localctx, 22, RULE_expression);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(122);
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
        public Token s14;
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
        enterRule(_localctx, 24, RULE_assignment);
        int _la;
        try {
            setState(135);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(124);
                    match(IDENTIFIER);
                    setState(125);
                    ((AssignmentContext) _localctx).assign = match(T__1);
                    setState(126);
                    assignment();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(127);
                    logicOr();
                    setState(132);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__13) {
                        {
                            {
                                setState(128);
                                ((AssignmentContext) _localctx).s14 = match(T__13);
                                ((AssignmentContext) _localctx).op.add(((AssignmentContext) _localctx).s14);
                                setState(129);
                                logicOr();
                            }
                        }
                        setState(134);
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
        public Token s15;
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
        enterRule(_localctx, 26, RULE_logicOr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(137);
                logicAnd();
                setState(142);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__14) {
                    {
                        {
                            setState(138);
                            ((LogicOrContext) _localctx).s15 = match(T__14);
                            ((LogicOrContext) _localctx).or.add(((LogicOrContext) _localctx).s15);
                            setState(139);
                            logicAnd();
                        }
                    }
                    setState(144);
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
        public Token s16;
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
        enterRule(_localctx, 28, RULE_logicAnd);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(145);
                equality();
                setState(150);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__15) {
                    {
                        {
                            setState(146);
                            ((LogicAndContext) _localctx).s16 = match(T__15);
                            ((LogicAndContext) _localctx).and.add(((LogicAndContext) _localctx).s16);
                            setState(147);
                            equality();
                        }
                    }
                    setState(152);
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
        public Token s30;
        public List<Token> op = new ArrayList<Token>();
        public Token s29;
        public Token _tset288;

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
        enterRule(_localctx, 30, RULE_equality);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(153);
                comparison();
                setState(158);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_EQUAL || _la == OP_INEQUAL) {
                    {
                        {
                            setState(154);
                            ((EqualityContext) _localctx)._tset288 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_EQUAL || _la == OP_INEQUAL)) {
                                ((EqualityContext) _localctx)._tset288 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((EqualityContext) _localctx).op.add(((EqualityContext) _localctx)._tset288);
                            setState(155);
                            comparison();
                        }
                    }
                    setState(160);
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
        public Token s31;
        public List<Token> op = new ArrayList<Token>();
        public Token s33;
        public Token s32;
        public Token s34;
        public Token _tset311;

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
        enterRule(_localctx, 32, RULE_comparison);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(161);
                term();
                setState(166);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0)) {
                    {
                        {
                            setState(162);
                            ((ComparisonContext) _localctx)._tset311 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0))) {
                                ((ComparisonContext) _localctx)._tset311 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((ComparisonContext) _localctx).op.add(((ComparisonContext) _localctx)._tset311);
                            setState(163);
                            term();
                        }
                    }
                    setState(168);
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
        public Token s26;
        public List<Token> op = new ArrayList<Token>();
        public Token s25;
        public Token _tset343;

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
        enterRule(_localctx, 34, RULE_term);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(169);
                factor();
                setState(174);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_PLUS || _la == OP_MINUS) {
                    {
                        {
                            setState(170);
                            ((TermContext) _localctx)._tset343 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_PLUS || _la == OP_MINUS)) {
                                ((TermContext) _localctx)._tset343 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((TermContext) _localctx).op.add(((TermContext) _localctx)._tset343);
                            setState(171);
                            factor();
                        }
                    }
                    setState(176);
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
        public Token s28;
        public List<Token> op = new ArrayList<Token>();
        public Token s27;
        public Token _tset366;

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
        enterRule(_localctx, 36, RULE_factor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(177);
                unary();
                setState(182);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_STAR || _la == OP_SLASH) {
                    {
                        {
                            setState(178);
                            ((FactorContext) _localctx)._tset366 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_STAR || _la == OP_SLASH)) {
                                ((FactorContext) _localctx)._tset366 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((FactorContext) _localctx).op.add(((FactorContext) _localctx)._tset366);
                            setState(179);
                            unary();
                        }
                    }
                    setState(184);
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
        public Token s24;
        public List<Token> op = new ArrayList<Token>();
        public Token s26;
        public Token _tset387;

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
        enterRule(_localctx, 38, RULE_unary);
        int _la;
        try {
            setState(188);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(185);
                    ((UnaryContext) _localctx)._tset387 = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == OP_BANG || _la == OP_MINUS)) {
                        ((UnaryContext) _localctx)._tset387 = (Token) _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    ((UnaryContext) _localctx).op.add(((UnaryContext) _localctx)._tset387);
                    setState(186);
                    unary();
                }
                break;
                case T__4:
                case T__16:
                case T__17:
                case T__18:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(187);
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
        enterRule(_localctx, 40, RULE_primary);
        try {
            setState(200);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NUMBER:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(190);
                    match(NUMBER);
                }
                break;
                case STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(191);
                    match(STRING);
                }
                break;
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(192);
                    match(IDENTIFIER);
                }
                break;
                case T__16:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(193);
                    match(T__16);
                }
                break;
                case T__17:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(194);
                    match(T__17);
                }
                break;
                case T__18:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(195);
                    match(T__18);
                }
                break;
                case T__4:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(196);
                    match(T__4);
                    setState(197);
                    expression();
                    setState(198);
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00cd\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\7\2.\n\2\f\2\16\2\61\13\2" +
                    "\3\2\3\2\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\5\4=\n\4\3\4\3\4\3\5\3\5\3" +
                    "\5\3\5\3\5\3\5\3\5\5\5H\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7R\n\7\3" +
                    "\7\5\7U\n\7\3\7\3\7\5\7Y\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5" +
                    "\be\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\7\13s\n\13\f" +
                    "\13\16\13v\13\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16" +
                    "\3\16\7\16\u0085\n\16\f\16\16\16\u0088\13\16\5\16\u008a\n\16\3\17\3\17" +
                    "\3\17\7\17\u008f\n\17\f\17\16\17\u0092\13\17\3\20\3\20\3\20\7\20\u0097" +
                    "\n\20\f\20\16\20\u009a\13\20\3\21\3\21\3\21\7\21\u009f\n\21\f\21\16\21" +
                    "\u00a2\13\21\3\22\3\22\3\22\7\22\u00a7\n\22\f\22\16\22\u00aa\13\22\3\23" +
                    "\3\23\3\23\7\23\u00af\n\23\f\23\16\23\u00b2\13\23\3\24\3\24\3\24\7\24" +
                    "\u00b7\n\24\f\24\16\24\u00ba\13\24\3\25\3\25\3\25\5\25\u00bf\n\25\3\26" +
                    "\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00cb\n\26\3\26\2\2" +
                    "\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\7\3\2\37 \3\2!$\3" +
                    "\2\33\34\3\2\35\36\4\2\32\32\34\34\2\u00d5\2/\3\2\2\2\4\66\3\2\2\2\68" +
                    "\3\2\2\2\bG\3\2\2\2\nI\3\2\2\2\fL\3\2\2\2\16]\3\2\2\2\20f\3\2\2\2\22j" +
                    "\3\2\2\2\24p\3\2\2\2\26y\3\2\2\2\30|\3\2\2\2\32\u0089\3\2\2\2\34\u008b" +
                    "\3\2\2\2\36\u0093\3\2\2\2 \u009b\3\2\2\2\"\u00a3\3\2\2\2$\u00ab\3\2\2" +
                    "\2&\u00b3\3\2\2\2(\u00be\3\2\2\2*\u00ca\3\2\2\2,.\5\4\3\2-,\3\2\2\2.\61" +
                    "\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\2\2\3" +
                    "\63\3\3\2\2\2\64\67\5\6\4\2\65\67\5\b\5\2\66\64\3\2\2\2\66\65\3\2\2\2" +
                    "\67\5\3\2\2\289\7\3\2\29<\7\30\2\2:;\7\4\2\2;=\5\30\r\2<:\3\2\2\2<=\3" +
                    "\2\2\2=>\3\2\2\2>?\7\5\2\2?\7\3\2\2\2@H\5\n\6\2AH\5\f\7\2BH\5\16\b\2C" +
                    "H\5\20\t\2DH\5\22\n\2EH\5\24\13\2FH\5\26\f\2G@\3\2\2\2GA\3\2\2\2GB\3\2" +
                    "\2\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2H\t\3\2\2\2IJ\5\30\r\2JK\7" +
                    "\5\2\2K\13\3\2\2\2LM\7\6\2\2MQ\7\7\2\2NR\5\6\4\2OR\5\n\6\2PR\7\5\2\2Q" +
                    "N\3\2\2\2QO\3\2\2\2QP\3\2\2\2RT\3\2\2\2SU\5\30\r\2TS\3\2\2\2TU\3\2\2\2" +
                    "UV\3\2\2\2VX\7\5\2\2WY\5\30\r\2XW\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\b\2" +
                    "\2[\\\5\b\5\2\\\r\3\2\2\2]^\7\t\2\2^_\7\7\2\2_`\5\30\r\2`a\7\b\2\2ad\5" +
                    "\b\5\2bc\7\n\2\2ce\5\b\5\2db\3\2\2\2de\3\2\2\2e\17\3\2\2\2fg\7\13\2\2" +
                    "gh\5\30\r\2hi\7\5\2\2i\21\3\2\2\2jk\7\f\2\2kl\7\7\2\2lm\5\30\r\2mn\7\b" +
                    "\2\2no\5\b\5\2o\23\3\2\2\2pt\7\r\2\2qs\5\4\3\2rq\3\2\2\2sv\3\2\2\2tr\3" +
                    "\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\7\16\2\2x\25\3\2\2\2yz\7\17\2\2" +
                    "z{\7\5\2\2{\27\3\2\2\2|}\5\32\16\2}\31\3\2\2\2~\177\7\30\2\2\177\u0080" +
                    "\7\4\2\2\u0080\u008a\5\32\16\2\u0081\u0086\5\34\17\2\u0082\u0083\7\20" +
                    "\2\2\u0083\u0085\5\34\17\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086" +
                    "\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2" +
                    "\2\2\u0089~\3\2\2\2\u0089\u0081\3\2\2\2\u008a\33\3\2\2\2\u008b\u0090\5" +
                    "\36\20\2\u008c\u008d\7\21\2\2\u008d\u008f\5\36\20\2\u008e\u008c\3\2\2" +
                    "\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\35" +
                    "\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0098\5 \21\2\u0094\u0095\7\22\2\2" +
                    "\u0095\u0097\5 \21\2\u0096\u0094\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096" +
                    "\3\2\2\2\u0098\u0099\3\2\2\2\u0099\37\3\2\2\2\u009a\u0098\3\2\2\2\u009b" +
                    "\u00a0\5\"\22\2\u009c\u009d\t\2\2\2\u009d\u009f\5\"\22\2\u009e\u009c\3" +
                    "\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1" +
                    "!\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a8\5$\23\2\u00a4\u00a5\t\3\2\2" +
                    "\u00a5\u00a7\5$\23\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6" +
                    "\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9#\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab" +
                    "\u00b0\5&\24\2\u00ac\u00ad\t\4\2\2\u00ad\u00af\5&\24\2\u00ae\u00ac\3\2" +
                    "\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1" +
                    "%\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b8\5(\25\2\u00b4\u00b5\t\5\2\2" +
                    "\u00b5\u00b7\5(\25\2\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6" +
                    "\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\'\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb" +
                    "\u00bc\t\6\2\2\u00bc\u00bf\5(\25\2\u00bd\u00bf\5*\26\2\u00be\u00bb\3\2" +
                    "\2\2\u00be\u00bd\3\2\2\2\u00bf)\3\2\2\2\u00c0\u00cb\7\26\2\2\u00c1\u00cb" +
                    "\7\27\2\2\u00c2\u00cb\7\30\2\2\u00c3\u00cb\7\23\2\2\u00c4\u00cb\7\24\2" +
                    "\2\u00c5\u00cb\7\25\2\2\u00c6\u00c7\7\7\2\2\u00c7\u00c8\5\30\r\2\u00c8" +
                    "\u00c9\7\b\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c0\3\2\2\2\u00ca\u00c1\3\2" +
                    "\2\2\u00ca\u00c2\3\2\2\2\u00ca\u00c3\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca" +
                    "\u00c5\3\2\2\2\u00ca\u00c6\3\2\2\2\u00cb+\3\2\2\2\25/\66<GQTXdt\u0086" +
                    "\u0089\u0090\u0098\u00a0\u00a8\u00b0\u00b8\u00be\u00ca";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}