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
            T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, NUMBER = 22, STRING = 23, IDENTIFIER = 24,
            WS = 25, OP_BANG = 26, OP_PLUS = 27, OP_MINUS = 28, OP_STAR = 29, OP_SLASH = 30, OP_EQUAL = 31,
            OP_INEQUAL = 32, OP_GREATER = 33, OP_LESS = 34, OP_GREATER_EQUAL = 35, OP_LESS_EQUAL = 36;
    public static final int
            RULE_program = 0, RULE_declaration = 1, RULE_funcDecl = 2, RULE_function = 3,
            RULE_parameters = 4, RULE_varDecl = 5, RULE_statement = 6, RULE_ifStmt = 7,
            RULE_forStmt = 8, RULE_whileStmt = 9, RULE_breakStmt = 10, RULE_block = 11,
            RULE_printStmt = 12, RULE_exprStmt = 13, RULE_returnStmt = 14, RULE_expression = 15,
            RULE_assignment = 16, RULE_logicOr = 17, RULE_logicAnd = 18, RULE_equality = 19,
            RULE_comparison = 20, RULE_term = 21, RULE_factor = 22, RULE_unary = 23,
            RULE_call = 24, RULE_arguments = 25, RULE_primary = 26;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "declaration", "funcDecl", "function", "parameters", "varDecl",
                "statement", "ifStmt", "forStmt", "whileStmt", "breakStmt", "block",
                "printStmt", "exprStmt", "returnStmt", "expression", "assignment", "logicOr",
                "logicAnd", "equality", "comparison", "term", "factor", "unary", "call",
                "arguments", "primary"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'fun'", "'('", "')'", "','", "'var'", "'='", "';'", "'if'", "'else'",
                "'for'", "'while'", "'break'", "'{'", "'}'", "'print'", "'return'", "'or'",
                "'and'", "'true'", "'false'", "'nil'", null, null, null, null, "'!'",
                "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, "NUMBER",
                "STRING", "IDENTIFIER", "WS", "OP_BANG", "OP_PLUS", "OP_MINUS", "OP_STAR",
                "OP_SLASH", "OP_EQUAL", "OP_INEQUAL", "OP_GREATER", "OP_LESS", "OP_GREATER_EQUAL",
                "OP_LESS_EQUAL"
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
                setState(57);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(54);
                            declaration();
                        }
                    }
                    setState(59);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(60);
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
        public FuncDeclContext funcDecl() {
            return getRuleContext(FuncDeclContext.class, 0);
        }

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
            setState(65);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__0:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(62);
                    funcDecl();
                }
                break;
                case T__4:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(63);
                    varDecl();
                }
                break;
                case T__1:
                case T__7:
                case T__9:
                case T__10:
                case T__11:
                case T__12:
                case T__14:
                case T__15:
                case T__18:
                case T__19:
                case T__20:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(64);
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

    public static class FuncDeclContext extends ParserRuleContext {
        public FunctionContext function() {
            return getRuleContext(FunctionContext.class, 0);
        }

        public FuncDeclContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcDecl;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitFuncDecl(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FuncDeclContext funcDecl() throws RecognitionException {
        FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_funcDecl);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(67);
                match(T__0);
                setState(68);
                function();
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

    public static class FunctionContext extends ParserRuleContext {
        public TerminalNode IDENTIFIER() {
            return getToken(LoxParser.IDENTIFIER, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public ParametersContext parameters() {
            return getRuleContext(ParametersContext.class, 0);
        }

        public FunctionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitFunction(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FunctionContext function() throws RecognitionException {
        FunctionContext _localctx = new FunctionContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_function);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(70);
                match(IDENTIFIER);
                setState(71);
                match(T__1);
                setState(73);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == IDENTIFIER) {
                    {
                        setState(72);
                        parameters();
                    }
                }

                setState(75);
                match(T__2);
                setState(76);
                block();
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

    public static class ParametersContext extends ParserRuleContext {
        public Token s4;
        public List<Token> comma = new ArrayList<Token>();

        public List<TerminalNode> IDENTIFIER() {
            return getTokens(LoxParser.IDENTIFIER);
        }

        public TerminalNode IDENTIFIER(int i) {
            return getToken(LoxParser.IDENTIFIER, i);
        }

        public ParametersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameters;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitParameters(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParametersContext parameters() throws RecognitionException {
        ParametersContext _localctx = new ParametersContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_parameters);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(78);
                match(IDENTIFIER);
                setState(83);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__3) {
                    {
                        {
                            setState(79);
                            ((ParametersContext) _localctx).s4 = match(T__3);
                            ((ParametersContext) _localctx).comma.add(((ParametersContext) _localctx).s4);
                            setState(80);
                            match(IDENTIFIER);
                        }
                    }
                    setState(85);
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
        enterRule(_localctx, 10, RULE_varDecl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(86);
                match(T__4);
                setState(87);
                match(IDENTIFIER);
                setState(90);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__5) {
                    {
                        setState(88);
                        match(T__5);
                        setState(89);
                        expression();
                    }
                }

                setState(92);
                match(T__6);
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
        public IfStmtContext ifStmt() {
            return getRuleContext(IfStmtContext.class, 0);
        }

        public ForStmtContext forStmt() {
            return getRuleContext(ForStmtContext.class, 0);
        }

        public WhileStmtContext whileStmt() {
            return getRuleContext(WhileStmtContext.class, 0);
        }

        public BreakStmtContext breakStmt() {
            return getRuleContext(BreakStmtContext.class, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public PrintStmtContext printStmt() {
            return getRuleContext(PrintStmtContext.class, 0);
        }

        public ExprStmtContext exprStmt() {
            return getRuleContext(ExprStmtContext.class, 0);
        }

        public ReturnStmtContext returnStmt() {
            return getRuleContext(ReturnStmtContext.class, 0);
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
        enterRule(_localctx, 12, RULE_statement);
        try {
            setState(102);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__7:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(94);
                    ifStmt();
                }
                break;
                case T__9:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(95);
                    forStmt();
                }
                break;
                case T__10:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(96);
                    whileStmt();
                }
                break;
                case T__11:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(97);
                    breakStmt();
                }
                break;
                case T__12:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(98);
                    block();
                }
                break;
                case T__14:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(99);
                    printStmt();
                }
                break;
                case T__1:
                case T__18:
                case T__19:
                case T__20:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(100);
                    exprStmt();
                }
                break;
                case T__15:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(101);
                    returnStmt();
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
        enterRule(_localctx, 14, RULE_ifStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(104);
                match(T__7);
                setState(105);
                match(T__1);
                setState(106);
                expression();
                setState(107);
                match(T__2);
                setState(108);
                ((IfStmtContext) _localctx).thenBranch = statement();
                setState(111);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                    case 1: {
                        setState(109);
                        match(T__8);
                        setState(110);
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
        enterRule(_localctx, 16, RULE_forStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(113);
                match(T__9);
                setState(114);
                match(T__1);
                setState(118);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__4: {
                        setState(115);
                        varDecl();
                    }
                    break;
                    case T__1:
                    case T__18:
                    case T__19:
                    case T__20:
                    case NUMBER:
                    case STRING:
                    case IDENTIFIER:
                    case OP_BANG:
                    case OP_MINUS: {
                        setState(116);
                        exprStmt();
                    }
                    break;
                    case T__6: {
                        setState(117);
                        match(T__6);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(121);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        setState(120);
                        ((ForStmtContext) _localctx).condition = expression();
                    }
                }

                setState(123);
                match(T__6);
                setState(125);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        setState(124);
                        ((ForStmtContext) _localctx).increment = expression();
                    }
                }

                setState(127);
                match(T__2);
                setState(128);
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
        enterRule(_localctx, 18, RULE_whileStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(130);
                match(T__10);
                setState(131);
                match(T__1);
                setState(132);
                ((WhileStmtContext) _localctx).condition = expression();
                setState(133);
                match(T__2);
                setState(134);
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
                setState(136);
                match(T__11);
                setState(137);
                match(T__6);
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
        enterRule(_localctx, 22, RULE_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(139);
                match(T__12);
                setState(143);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(140);
                            declaration();
                        }
                    }
                    setState(145);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(146);
                match(T__13);
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
        enterRule(_localctx, 24, RULE_printStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(148);
                match(T__14);
                setState(149);
                expression();
                setState(150);
                match(T__6);
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
        enterRule(_localctx, 26, RULE_exprStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(152);
                expression();
                setState(153);
                match(T__6);
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

    public static class ReturnStmtContext extends ParserRuleContext {
        public Token ret;

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_returnStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitReturnStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ReturnStmtContext returnStmt() throws RecognitionException {
        ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_returnStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(155);
                ((ReturnStmtContext) _localctx).ret = match(T__15);
                setState(157);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        setState(156);
                        expression();
                    }
                }

                setState(159);
                match(T__6);
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
        enterRule(_localctx, 30, RULE_expression);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(161);
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
        public Token s4;
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
        enterRule(_localctx, 32, RULE_assignment);
        try {
            int _alt;
            setState(174);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(163);
                    match(IDENTIFIER);
                    setState(164);
                    ((AssignmentContext) _localctx).assign = match(T__5);
                    setState(165);
                    assignment();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(166);
                    logicOr();
                    setState(171);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                    while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(167);
                                    ((AssignmentContext) _localctx).s4 = match(T__3);
                                    ((AssignmentContext) _localctx).op.add(((AssignmentContext) _localctx).s4);
                                    setState(168);
                                    logicOr();
                                }
                            }
                        }
                        setState(173);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
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
        public Token s17;
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
        enterRule(_localctx, 34, RULE_logicOr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(176);
                logicAnd();
                setState(181);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__16) {
                    {
                        {
                            setState(177);
                            ((LogicOrContext) _localctx).s17 = match(T__16);
                            ((LogicOrContext) _localctx).or.add(((LogicOrContext) _localctx).s17);
                            setState(178);
                            logicAnd();
                        }
                    }
                    setState(183);
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
        public Token s18;
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
        enterRule(_localctx, 36, RULE_logicAnd);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(184);
                equality();
                setState(189);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__17) {
                    {
                        {
                            setState(185);
                            ((LogicAndContext) _localctx).s18 = match(T__17);
                            ((LogicAndContext) _localctx).and.add(((LogicAndContext) _localctx).s18);
                            setState(186);
                            equality();
                        }
                    }
                    setState(191);
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
        public Token s32;
        public List<Token> op = new ArrayList<Token>();
        public Token s31;
        public Token _tset355;

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
        enterRule(_localctx, 38, RULE_equality);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(192);
                comparison();
                setState(197);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_EQUAL || _la == OP_INEQUAL) {
                    {
                        {
                            setState(193);
                            ((EqualityContext) _localctx)._tset355 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_EQUAL || _la == OP_INEQUAL)) {
                                ((EqualityContext) _localctx)._tset355 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((EqualityContext) _localctx).op.add(((EqualityContext) _localctx)._tset355);
                            setState(194);
                            comparison();
                        }
                    }
                    setState(199);
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
        public Token s33;
        public List<Token> op = new ArrayList<Token>();
        public Token s35;
        public Token s34;
        public Token s36;
        public Token _tset378;

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
        enterRule(_localctx, 40, RULE_comparison);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(200);
                term();
                setState(205);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0)) {
                    {
                        {
                            setState(201);
                            ((ComparisonContext) _localctx)._tset378 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0))) {
                                ((ComparisonContext) _localctx)._tset378 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((ComparisonContext) _localctx).op.add(((ComparisonContext) _localctx)._tset378);
                            setState(202);
                            term();
                        }
                    }
                    setState(207);
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
        public Token s28;
        public List<Token> op = new ArrayList<Token>();
        public Token s27;
        public Token _tset410;

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
        enterRule(_localctx, 42, RULE_term);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(208);
                factor();
                setState(213);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_PLUS || _la == OP_MINUS) {
                    {
                        {
                            setState(209);
                            ((TermContext) _localctx)._tset410 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_PLUS || _la == OP_MINUS)) {
                                ((TermContext) _localctx)._tset410 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((TermContext) _localctx).op.add(((TermContext) _localctx)._tset410);
                            setState(210);
                            factor();
                        }
                    }
                    setState(215);
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
        public Token s30;
        public List<Token> op = new ArrayList<Token>();
        public Token s29;
        public Token _tset433;

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
        enterRule(_localctx, 44, RULE_factor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(216);
                unary();
                setState(221);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_STAR || _la == OP_SLASH) {
                    {
                        {
                            setState(217);
                            ((FactorContext) _localctx)._tset433 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_STAR || _la == OP_SLASH)) {
                                ((FactorContext) _localctx)._tset433 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((FactorContext) _localctx).op.add(((FactorContext) _localctx)._tset433);
                            setState(218);
                            unary();
                        }
                    }
                    setState(223);
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
        public Token s26;
        public List<Token> op = new ArrayList<Token>();
        public Token s28;
        public Token _tset454;

        public UnaryContext unary() {
            return getRuleContext(UnaryContext.class, 0);
        }

        public TerminalNode OP_BANG() {
            return getToken(LoxParser.OP_BANG, 0);
        }

        public TerminalNode OP_MINUS() {
            return getToken(LoxParser.OP_MINUS, 0);
        }

        public CallContext call() {
            return getRuleContext(CallContext.class, 0);
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
        enterRule(_localctx, 46, RULE_unary);
        int _la;
        try {
            setState(227);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(224);
                    ((UnaryContext) _localctx)._tset454 = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == OP_BANG || _la == OP_MINUS)) {
                        ((UnaryContext) _localctx)._tset454 = (Token) _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    ((UnaryContext) _localctx).op.add(((UnaryContext) _localctx)._tset454);
                    setState(225);
                    unary();
                }
                break;
                case T__1:
                case T__18:
                case T__19:
                case T__20:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(226);
                    call();
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

    public static class CallContext extends ParserRuleContext {
        public Token s2;
        public List<Token> leftParen = new ArrayList<Token>();
        public Token s3;
        public List<Token> rightParen = new ArrayList<Token>();

        public PrimaryContext primary() {
            return getRuleContext(PrimaryContext.class, 0);
        }

        public List<ArgumentsContext> arguments() {
            return getRuleContexts(ArgumentsContext.class);
        }

        public ArgumentsContext arguments(int i) {
            return getRuleContext(ArgumentsContext.class, i);
        }

        public CallContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_call;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitCall(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CallContext call() throws RecognitionException {
        CallContext _localctx = new CallContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_call);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(229);
                primary();
                setState(237);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(230);
                            ((CallContext) _localctx).s2 = match(T__1);
                            ((CallContext) _localctx).leftParen.add(((CallContext) _localctx).s2);
                            setState(232);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                                {
                                    setState(231);
                                    arguments();
                                }
                            }

                            setState(234);
                            ((CallContext) _localctx).s3 = match(T__2);
                            ((CallContext) _localctx).rightParen.add(((CallContext) _localctx).s3);
                        }
                    }
                    setState(239);
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

    public static class ArgumentsContext extends ParserRuleContext {
        public Token s4;
        public List<Token> comma = new ArrayList<Token>();

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public ArgumentsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arguments;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LoxVisitor) return ((LoxVisitor<? extends T>) visitor).visitArguments(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ArgumentsContext arguments() throws RecognitionException {
        ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_arguments);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(240);
                expression();
                setState(245);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__3) {
                    {
                        {
                            setState(241);
                            ((ArgumentsContext) _localctx).s4 = match(T__3);
                            ((ArgumentsContext) _localctx).comma.add(((ArgumentsContext) _localctx).s4);
                            setState(242);
                            expression();
                        }
                    }
                    setState(247);
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
        enterRule(_localctx, 52, RULE_primary);
        try {
            setState(258);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NUMBER:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(248);
                    match(NUMBER);
                }
                break;
                case STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(249);
                    match(STRING);
                }
                break;
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(250);
                    match(IDENTIFIER);
                }
                break;
                case T__18:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(251);
                    match(T__18);
                }
                break;
                case T__19:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(252);
                    match(T__19);
                }
                break;
                case T__20:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(253);
                    match(T__20);
                }
                break;
                case T__1:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(254);
                    match(T__1);
                    setState(255);
                    expression();
                    setState(256);
                    match(T__2);
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u0107\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\3" +
                    "\3\3\3\3\5\3D\n\3\3\4\3\4\3\4\3\5\3\5\3\5\5\5L\n\5\3\5\3\5\3\5\3\6\3\6" +
                    "\3\6\7\6T\n\6\f\6\16\6W\13\6\3\7\3\7\3\7\3\7\5\7]\n\7\3\7\3\7\3\b\3\b" +
                    "\3\b\3\b\3\b\3\b\3\b\3\b\5\bi\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tr\n\t" +
                    "\3\n\3\n\3\n\3\n\3\n\5\ny\n\n\3\n\5\n|\n\n\3\n\3\n\5\n\u0080\n\n\3\n\3" +
                    "\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\7\r\u0090\n\r" +
                    "\f\r\16\r\u0093\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3" +
                    "\20\5\20\u00a0\n\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22" +
                    "\7\22\u00ac\n\22\f\22\16\22\u00af\13\22\5\22\u00b1\n\22\3\23\3\23\3\23" +
                    "\7\23\u00b6\n\23\f\23\16\23\u00b9\13\23\3\24\3\24\3\24\7\24\u00be\n\24" +
                    "\f\24\16\24\u00c1\13\24\3\25\3\25\3\25\7\25\u00c6\n\25\f\25\16\25\u00c9" +
                    "\13\25\3\26\3\26\3\26\7\26\u00ce\n\26\f\26\16\26\u00d1\13\26\3\27\3\27" +
                    "\3\27\7\27\u00d6\n\27\f\27\16\27\u00d9\13\27\3\30\3\30\3\30\7\30\u00de" +
                    "\n\30\f\30\16\30\u00e1\13\30\3\31\3\31\3\31\5\31\u00e6\n\31\3\32\3\32" +
                    "\3\32\5\32\u00eb\n\32\3\32\7\32\u00ee\n\32\f\32\16\32\u00f1\13\32\3\33" +
                    "\3\33\3\33\7\33\u00f6\n\33\f\33\16\33\u00f9\13\33\3\34\3\34\3\34\3\34" +
                    "\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0105\n\34\3\34\2\2\35\2\4\6\b\n\f" +
                    "\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\7\3\2!\"\3\2#&\3\2" +
                    "\35\36\3\2\37 \4\2\34\34\36\36\2\u0111\2;\3\2\2\2\4C\3\2\2\2\6E\3\2\2" +
                    "\2\bH\3\2\2\2\nP\3\2\2\2\fX\3\2\2\2\16h\3\2\2\2\20j\3\2\2\2\22s\3\2\2" +
                    "\2\24\u0084\3\2\2\2\26\u008a\3\2\2\2\30\u008d\3\2\2\2\32\u0096\3\2\2\2" +
                    "\34\u009a\3\2\2\2\36\u009d\3\2\2\2 \u00a3\3\2\2\2\"\u00b0\3\2\2\2$\u00b2" +
                    "\3\2\2\2&\u00ba\3\2\2\2(\u00c2\3\2\2\2*\u00ca\3\2\2\2,\u00d2\3\2\2\2." +
                    "\u00da\3\2\2\2\60\u00e5\3\2\2\2\62\u00e7\3\2\2\2\64\u00f2\3\2\2\2\66\u0104" +
                    "\3\2\2\28:\5\4\3\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=" +
                    ";\3\2\2\2>?\7\2\2\3?\3\3\2\2\2@D\5\6\4\2AD\5\f\7\2BD\5\16\b\2C@\3\2\2" +
                    "\2CA\3\2\2\2CB\3\2\2\2D\5\3\2\2\2EF\7\3\2\2FG\5\b\5\2G\7\3\2\2\2HI\7\32" +
                    "\2\2IK\7\4\2\2JL\5\n\6\2KJ\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\5\2\2NO\5\30" +
                    "\r\2O\t\3\2\2\2PU\7\32\2\2QR\7\6\2\2RT\7\32\2\2SQ\3\2\2\2TW\3\2\2\2US" +
                    "\3\2\2\2UV\3\2\2\2V\13\3\2\2\2WU\3\2\2\2XY\7\7\2\2Y\\\7\32\2\2Z[\7\b\2" +
                    "\2[]\5 \21\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7\t\2\2_\r\3\2\2\2`i\5" +
                    "\20\t\2ai\5\22\n\2bi\5\24\13\2ci\5\26\f\2di\5\30\r\2ei\5\32\16\2fi\5\34" +
                    "\17\2gi\5\36\20\2h`\3\2\2\2ha\3\2\2\2hb\3\2\2\2hc\3\2\2\2hd\3\2\2\2he" +
                    "\3\2\2\2hf\3\2\2\2hg\3\2\2\2i\17\3\2\2\2jk\7\n\2\2kl\7\4\2\2lm\5 \21\2" +
                    "mn\7\5\2\2nq\5\16\b\2op\7\13\2\2pr\5\16\b\2qo\3\2\2\2qr\3\2\2\2r\21\3" +
                    "\2\2\2st\7\f\2\2tx\7\4\2\2uy\5\f\7\2vy\5\34\17\2wy\7\t\2\2xu\3\2\2\2x" +
                    "v\3\2\2\2xw\3\2\2\2y{\3\2\2\2z|\5 \21\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2" +
                    "}\177\7\t\2\2~\u0080\5 \21\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081" +
                    "\3\2\2\2\u0081\u0082\7\5\2\2\u0082\u0083\5\16\b\2\u0083\23\3\2\2\2\u0084" +
                    "\u0085\7\r\2\2\u0085\u0086\7\4\2\2\u0086\u0087\5 \21\2\u0087\u0088\7\5" +
                    "\2\2\u0088\u0089\5\16\b\2\u0089\25\3\2\2\2\u008a\u008b\7\16\2\2\u008b" +
                    "\u008c\7\t\2\2\u008c\27\3\2\2\2\u008d\u0091\7\17\2\2\u008e\u0090\5\4\3" +
                    "\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092" +
                    "\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\20\2\2" +
                    "\u0095\31\3\2\2\2\u0096\u0097\7\21\2\2\u0097\u0098\5 \21\2\u0098\u0099" +
                    "\7\t\2\2\u0099\33\3\2\2\2\u009a\u009b\5 \21\2\u009b\u009c\7\t\2\2\u009c" +
                    "\35\3\2\2\2\u009d\u009f\7\22\2\2\u009e\u00a0\5 \21\2\u009f\u009e\3\2\2" +
                    "\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\t\2\2\u00a2\37" +
                    "\3\2\2\2\u00a3\u00a4\5\"\22\2\u00a4!\3\2\2\2\u00a5\u00a6\7\32\2\2\u00a6" +
                    "\u00a7\7\b\2\2\u00a7\u00b1\5\"\22\2\u00a8\u00ad\5$\23\2\u00a9\u00aa\7" +
                    "\6\2\2\u00aa\u00ac\5$\23\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad" +
                    "\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2" +
                    "\2\2\u00b0\u00a5\3\2\2\2\u00b0\u00a8\3\2\2\2\u00b1#\3\2\2\2\u00b2\u00b7" +
                    "\5&\24\2\u00b3\u00b4\7\23\2\2\u00b4\u00b6\5&\24\2\u00b5\u00b3\3\2\2\2" +
                    "\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8%\3" +
                    "\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bf\5(\25\2\u00bb\u00bc\7\24\2\2\u00bc" +
                    "\u00be\5(\25\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2" +
                    "\2\2\u00bf\u00c0\3\2\2\2\u00c0\'\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c7" +
                    "\5*\26\2\u00c3\u00c4\t\2\2\2\u00c4\u00c6\5*\26\2\u00c5\u00c3\3\2\2\2\u00c6" +
                    "\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8)\3\2\2\2" +
                    "\u00c9\u00c7\3\2\2\2\u00ca\u00cf\5,\27\2\u00cb\u00cc\t\3\2\2\u00cc\u00ce" +
                    "\5,\27\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf" +
                    "\u00d0\3\2\2\2\u00d0+\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d7\5.\30\2" +
                    "\u00d3\u00d4\t\4\2\2\u00d4\u00d6\5.\30\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9" +
                    "\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8-\3\2\2\2\u00d9" +
                    "\u00d7\3\2\2\2\u00da\u00df\5\60\31\2\u00db\u00dc\t\5\2\2\u00dc\u00de\5" +
                    "\60\31\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df" +
                    "\u00e0\3\2\2\2\u00e0/\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\t\6\2\2" +
                    "\u00e3\u00e6\5\60\31\2\u00e4\u00e6\5\62\32\2\u00e5\u00e2\3\2\2\2\u00e5" +
                    "\u00e4\3\2\2\2\u00e6\61\3\2\2\2\u00e7\u00ef\5\66\34\2\u00e8\u00ea\7\4" +
                    "\2\2\u00e9\u00eb\5\64\33\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb" +
                    "\u00ec\3\2\2\2\u00ec\u00ee\7\5\2\2\u00ed\u00e8\3\2\2\2\u00ee\u00f1\3\2" +
                    "\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\63\3\2\2\2\u00f1\u00ef" +
                    "\3\2\2\2\u00f2\u00f7\5 \21\2\u00f3\u00f4\7\6\2\2\u00f4\u00f6\5 \21\2\u00f5" +
                    "\u00f3\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2" +
                    "\2\2\u00f8\65\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u0105\7\30\2\2\u00fb\u0105" +
                    "\7\31\2\2\u00fc\u0105\7\32\2\2\u00fd\u0105\7\25\2\2\u00fe\u0105\7\26\2" +
                    "\2\u00ff\u0105\7\27\2\2\u0100\u0101\7\4\2\2\u0101\u0102\5 \21\2\u0102" +
                    "\u0103\7\5\2\2\u0103\u0105\3\2\2\2\u0104\u00fa\3\2\2\2\u0104\u00fb\3\2" +
                    "\2\2\u0104\u00fc\3\2\2\2\u0104\u00fd\3\2\2\2\u0104\u00fe\3\2\2\2\u0104" +
                    "\u00ff\3\2\2\2\u0104\u0100\3\2\2\2\u0105\67\3\2\2\2\33;CKU\\hqx{\177\u0091" +
                    "\u009f\u00ad\u00b0\u00b7\u00bf\u00c7\u00cf\u00d7\u00df\u00e5\u00ea\u00ef" +
                    "\u00f7\u0104";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}