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
            T__17 = 18, T__18 = 19, T__19 = 20, NUMBER = 21, STRING = 22, IDENTIFIER = 23, WS = 24,
            OP_BANG = 25, OP_PLUS = 26, OP_MINUS = 27, OP_STAR = 28, OP_SLASH = 29, OP_EQUAL = 30,
            OP_INEQUAL = 31, OP_GREATER = 32, OP_LESS = 33, OP_GREATER_EQUAL = 34, OP_LESS_EQUAL = 35;
    public static final int
            RULE_program = 0, RULE_declaration = 1, RULE_funcDecl = 2, RULE_function = 3,
            RULE_parameters = 4, RULE_varDecl = 5, RULE_statement = 6, RULE_ifStmt = 7,
            RULE_forStmt = 8, RULE_whileStmt = 9, RULE_breakStmt = 10, RULE_block = 11,
            RULE_printStmt = 12, RULE_exprStmt = 13, RULE_expression = 14, RULE_assignment = 15,
            RULE_logicOr = 16, RULE_logicAnd = 17, RULE_equality = 18, RULE_comparison = 19,
            RULE_term = 20, RULE_factor = 21, RULE_unary = 22, RULE_call = 23, RULE_arguments = 24,
            RULE_primary = 25;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "declaration", "funcDecl", "function", "parameters", "varDecl",
                "statement", "ifStmt", "forStmt", "whileStmt", "breakStmt", "block",
                "printStmt", "exprStmt", "expression", "assignment", "logicOr", "logicAnd",
                "equality", "comparison", "term", "factor", "unary", "call", "arguments",
                "primary"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'fun'", "'('", "')'", "','", "'var'", "'='", "';'", "'if'", "'else'",
                "'for'", "'while'", "'break'", "'{'", "'}'", "'print'", "'or'", "'and'",
                "'true'", "'false'", "'nil'", null, null, null, null, "'!'", "'+'", "'-'",
                "'*'", "'/'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, "NUMBER", "STRING",
                "IDENTIFIER", "WS", "OP_BANG", "OP_PLUS", "OP_MINUS", "OP_STAR", "OP_SLASH",
                "OP_EQUAL", "OP_INEQUAL", "OP_GREATER", "OP_LESS", "OP_GREATER_EQUAL",
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
                setState(55);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(52);
                            declaration();
                        }
                    }
                    setState(57);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(58);
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
            setState(63);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__0:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(60);
                    funcDecl();
                }
                break;
                case T__4:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(61);
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
                case T__17:
                case T__18:
                case T__19:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(62);
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
                setState(65);
                match(T__0);
                setState(66);
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
                setState(68);
                match(IDENTIFIER);
                setState(69);
                match(T__1);
                setState(71);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == IDENTIFIER) {
                    {
                        setState(70);
                        parameters();
                    }
                }

                setState(73);
                match(T__2);
                setState(74);
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
                setState(76);
                match(IDENTIFIER);
                setState(81);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__3) {
                    {
                        {
                            setState(77);
                            ((ParametersContext) _localctx).s4 = match(T__3);
                            ((ParametersContext) _localctx).comma.add(((ParametersContext) _localctx).s4);
                            setState(78);
                            match(IDENTIFIER);
                        }
                    }
                    setState(83);
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
                setState(84);
                match(T__4);
                setState(85);
                match(IDENTIFIER);
                setState(88);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__5) {
                    {
                        setState(86);
                        match(T__5);
                        setState(87);
                        expression();
                    }
                }

                setState(90);
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
            setState(99);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__7:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(92);
                    ifStmt();
                }
                break;
                case T__9:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(93);
                    forStmt();
                }
                break;
                case T__10:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(94);
                    whileStmt();
                }
                break;
                case T__11:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(95);
                    breakStmt();
                }
                break;
                case T__12:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(96);
                    block();
                }
                break;
                case T__14:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(97);
                    printStmt();
                }
                break;
                case T__1:
                case T__17:
                case T__18:
                case T__19:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(98);
                    exprStmt();
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
                setState(101);
                match(T__7);
                setState(102);
                match(T__1);
                setState(103);
                expression();
                setState(104);
                match(T__2);
                setState(105);
                ((IfStmtContext) _localctx).thenBranch = statement();
                setState(108);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                    case 1: {
                        setState(106);
                        match(T__8);
                        setState(107);
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
                setState(110);
                match(T__9);
                setState(111);
                match(T__1);
                setState(115);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__4: {
                        setState(112);
                        varDecl();
                    }
                    break;
                    case T__1:
                    case T__17:
                    case T__18:
                    case T__19:
                    case NUMBER:
                    case STRING:
                    case IDENTIFIER:
                    case OP_BANG:
                    case OP_MINUS: {
                        setState(113);
                        exprStmt();
                    }
                    break;
                    case T__6: {
                        setState(114);
                        match(T__6);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(118);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        setState(117);
                        ((ForStmtContext) _localctx).condition = expression();
                    }
                }

                setState(120);
                match(T__6);
                setState(122);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        setState(121);
                        ((ForStmtContext) _localctx).increment = expression();
                    }
                }

                setState(124);
                match(T__2);
                setState(125);
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
                setState(127);
                match(T__10);
                setState(128);
                match(T__1);
                setState(129);
                ((WhileStmtContext) _localctx).condition = expression();
                setState(130);
                match(T__2);
                setState(131);
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
                setState(133);
                match(T__11);
                setState(134);
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
                setState(136);
                match(T__12);
                setState(140);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                    {
                        {
                            setState(137);
                            declaration();
                        }
                    }
                    setState(142);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(143);
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
                setState(145);
                match(T__14);
                setState(146);
                expression();
                setState(147);
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
        enterRule(_localctx, 28, RULE_expression);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(152);
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
        enterRule(_localctx, 30, RULE_assignment);
        try {
            int _alt;
            setState(165);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 12, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(154);
                    match(IDENTIFIER);
                    setState(155);
                    ((AssignmentContext) _localctx).assign = match(T__5);
                    setState(156);
                    assignment();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(157);
                    logicOr();
                    setState(162);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 11, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(158);
                                    ((AssignmentContext) _localctx).s4 = match(T__3);
                                    ((AssignmentContext) _localctx).op.add(((AssignmentContext) _localctx).s4);
                                    setState(159);
                                    logicOr();
                                }
                            }
                        }
                        setState(164);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 11, _ctx);
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
        public Token s16;
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
        enterRule(_localctx, 32, RULE_logicOr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(167);
                logicAnd();
                setState(172);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__15) {
                    {
                        {
                            setState(168);
                            ((LogicOrContext) _localctx).s16 = match(T__15);
                            ((LogicOrContext) _localctx).or.add(((LogicOrContext) _localctx).s16);
                            setState(169);
                            logicAnd();
                        }
                    }
                    setState(174);
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
        public Token s17;
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
        enterRule(_localctx, 34, RULE_logicAnd);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(175);
                equality();
                setState(180);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__16) {
                    {
                        {
                            setState(176);
                            ((LogicAndContext) _localctx).s17 = match(T__16);
                            ((LogicAndContext) _localctx).and.add(((LogicAndContext) _localctx).s17);
                            setState(177);
                            equality();
                        }
                    }
                    setState(182);
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
        public Token s31;
        public List<Token> op = new ArrayList<Token>();
        public Token s30;
        public Token _tset337;

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
        enterRule(_localctx, 36, RULE_equality);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(183);
                comparison();
                setState(188);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_EQUAL || _la == OP_INEQUAL) {
                    {
                        {
                            setState(184);
                            ((EqualityContext) _localctx)._tset337 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_EQUAL || _la == OP_INEQUAL)) {
                                ((EqualityContext) _localctx)._tset337 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((EqualityContext) _localctx).op.add(((EqualityContext) _localctx)._tset337);
                            setState(185);
                            comparison();
                        }
                    }
                    setState(190);
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
        public Token s32;
        public List<Token> op = new ArrayList<Token>();
        public Token s34;
        public Token s33;
        public Token s35;
        public Token _tset360;

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
        enterRule(_localctx, 38, RULE_comparison);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(191);
                term();
                setState(196);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0)) {
                    {
                        {
                            setState(192);
                            ((ComparisonContext) _localctx)._tset360 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GREATER) | (1L << OP_LESS) | (1L << OP_GREATER_EQUAL) | (1L << OP_LESS_EQUAL))) != 0))) {
                                ((ComparisonContext) _localctx)._tset360 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((ComparisonContext) _localctx).op.add(((ComparisonContext) _localctx)._tset360);
                            setState(193);
                            term();
                        }
                    }
                    setState(198);
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
        public Token s27;
        public List<Token> op = new ArrayList<Token>();
        public Token s26;
        public Token _tset392;

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
        enterRule(_localctx, 40, RULE_term);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(199);
                factor();
                setState(204);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_PLUS || _la == OP_MINUS) {
                    {
                        {
                            setState(200);
                            ((TermContext) _localctx)._tset392 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_PLUS || _la == OP_MINUS)) {
                                ((TermContext) _localctx)._tset392 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((TermContext) _localctx).op.add(((TermContext) _localctx)._tset392);
                            setState(201);
                            factor();
                        }
                    }
                    setState(206);
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
        public Token s29;
        public List<Token> op = new ArrayList<Token>();
        public Token s28;
        public Token _tset415;

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
        enterRule(_localctx, 42, RULE_factor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(207);
                unary();
                setState(212);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_STAR || _la == OP_SLASH) {
                    {
                        {
                            setState(208);
                            ((FactorContext) _localctx)._tset415 = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == OP_STAR || _la == OP_SLASH)) {
                                ((FactorContext) _localctx)._tset415 = (Token) _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            ((FactorContext) _localctx).op.add(((FactorContext) _localctx)._tset415);
                            setState(209);
                            unary();
                        }
                    }
                    setState(214);
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
        public Token s25;
        public List<Token> op = new ArrayList<Token>();
        public Token s27;
        public Token _tset436;

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
        enterRule(_localctx, 44, RULE_unary);
        int _la;
        try {
            setState(218);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case OP_BANG:
                case OP_MINUS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(215);
                    ((UnaryContext) _localctx)._tset436 = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == OP_BANG || _la == OP_MINUS)) {
                        ((UnaryContext) _localctx)._tset436 = (Token) _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    ((UnaryContext) _localctx).op.add(((UnaryContext) _localctx)._tset436);
                    setState(216);
                    unary();
                }
                break;
                case T__1:
                case T__17:
                case T__18:
                case T__19:
                case NUMBER:
                case STRING:
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(217);
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
        enterRule(_localctx, 46, RULE_call);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(220);
                primary();
                setState(228);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(221);
                            ((CallContext) _localctx).s2 = match(T__1);
                            ((CallContext) _localctx).leftParen.add(((CallContext) _localctx).s2);
                            setState(223);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << NUMBER) | (1L << STRING) | (1L << IDENTIFIER) | (1L << OP_BANG) | (1L << OP_MINUS))) != 0)) {
                                {
                                    setState(222);
                                    arguments();
                                }
                            }

                            setState(225);
                            ((CallContext) _localctx).s3 = match(T__2);
                            ((CallContext) _localctx).rightParen.add(((CallContext) _localctx).s3);
                        }
                    }
                    setState(230);
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
        enterRule(_localctx, 48, RULE_arguments);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(231);
                expression();
                setState(236);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__3) {
                    {
                        {
                            setState(232);
                            ((ArgumentsContext) _localctx).s4 = match(T__3);
                            ((ArgumentsContext) _localctx).comma.add(((ArgumentsContext) _localctx).s4);
                            setState(233);
                            expression();
                        }
                    }
                    setState(238);
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
        enterRule(_localctx, 50, RULE_primary);
        try {
            setState(249);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NUMBER:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(239);
                    match(NUMBER);
                }
                break;
                case STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(240);
                    match(STRING);
                }
                break;
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(241);
                    match(IDENTIFIER);
                }
                break;
                case T__17:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(242);
                    match(T__17);
                }
                break;
                case T__18:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(243);
                    match(T__18);
                }
                break;
                case T__19:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(244);
                    match(T__19);
                }
                break;
                case T__1:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(245);
                    match(T__1);
                    setState(246);
                    expression();
                    setState(247);
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00fe\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\3\3\3\3\3\5" +
                    "\3B\n\3\3\4\3\4\3\4\3\5\3\5\3\5\5\5J\n\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6R" +
                    "\n\6\f\6\16\6U\13\6\3\7\3\7\3\7\3\7\5\7[\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3" +
                    "\b\3\b\3\b\5\bf\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\to\n\t\3\n\3\n\3\n\3" +
                    "\n\3\n\5\nv\n\n\3\n\5\ny\n\n\3\n\3\n\5\n}\n\n\3\n\3\n\3\n\3\13\3\13\3" +
                    "\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\7\r\u008d\n\r\f\r\16\r\u0090\13" +
                    "\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21" +
                    "\3\21\3\21\3\21\7\21\u00a3\n\21\f\21\16\21\u00a6\13\21\5\21\u00a8\n\21" +
                    "\3\22\3\22\3\22\7\22\u00ad\n\22\f\22\16\22\u00b0\13\22\3\23\3\23\3\23" +
                    "\7\23\u00b5\n\23\f\23\16\23\u00b8\13\23\3\24\3\24\3\24\7\24\u00bd\n\24" +
                    "\f\24\16\24\u00c0\13\24\3\25\3\25\3\25\7\25\u00c5\n\25\f\25\16\25\u00c8" +
                    "\13\25\3\26\3\26\3\26\7\26\u00cd\n\26\f\26\16\26\u00d0\13\26\3\27\3\27" +
                    "\3\27\7\27\u00d5\n\27\f\27\16\27\u00d8\13\27\3\30\3\30\3\30\5\30\u00dd" +
                    "\n\30\3\31\3\31\3\31\5\31\u00e2\n\31\3\31\7\31\u00e5\n\31\f\31\16\31\u00e8" +
                    "\13\31\3\32\3\32\3\32\7\32\u00ed\n\32\f\32\16\32\u00f0\13\32\3\33\3\33" +
                    "\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00fc\n\33\3\33\2\2\34\2" +
                    "\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\7\3\2 !\3\2" +
                    "\"%\3\2\34\35\3\2\36\37\4\2\33\33\35\35\2\u0107\29\3\2\2\2\4A\3\2\2\2" +
                    "\6C\3\2\2\2\bF\3\2\2\2\nN\3\2\2\2\fV\3\2\2\2\16e\3\2\2\2\20g\3\2\2\2\22" +
                    "p\3\2\2\2\24\u0081\3\2\2\2\26\u0087\3\2\2\2\30\u008a\3\2\2\2\32\u0093" +
                    "\3\2\2\2\34\u0097\3\2\2\2\36\u009a\3\2\2\2 \u00a7\3\2\2\2\"\u00a9\3\2" +
                    "\2\2$\u00b1\3\2\2\2&\u00b9\3\2\2\2(\u00c1\3\2\2\2*\u00c9\3\2\2\2,\u00d1" +
                    "\3\2\2\2.\u00dc\3\2\2\2\60\u00de\3\2\2\2\62\u00e9\3\2\2\2\64\u00fb\3\2" +
                    "\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2" +
                    "\2;9\3\2\2\2<=\7\2\2\3=\3\3\2\2\2>B\5\6\4\2?B\5\f\7\2@B\5\16\b\2A>\3\2" +
                    "\2\2A?\3\2\2\2A@\3\2\2\2B\5\3\2\2\2CD\7\3\2\2DE\5\b\5\2E\7\3\2\2\2FG\7" +
                    "\31\2\2GI\7\4\2\2HJ\5\n\6\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\5\2\2LM" +
                    "\5\30\r\2M\t\3\2\2\2NS\7\31\2\2OP\7\6\2\2PR\7\31\2\2QO\3\2\2\2RU\3\2\2" +
                    "\2SQ\3\2\2\2ST\3\2\2\2T\13\3\2\2\2US\3\2\2\2VW\7\7\2\2WZ\7\31\2\2XY\7" +
                    "\b\2\2Y[\5\36\20\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\t\2\2]\r\3\2\2" +
                    "\2^f\5\20\t\2_f\5\22\n\2`f\5\24\13\2af\5\26\f\2bf\5\30\r\2cf\5\32\16\2" +
                    "df\5\34\17\2e^\3\2\2\2e_\3\2\2\2e`\3\2\2\2ea\3\2\2\2eb\3\2\2\2ec\3\2\2" +
                    "\2ed\3\2\2\2f\17\3\2\2\2gh\7\n\2\2hi\7\4\2\2ij\5\36\20\2jk\7\5\2\2kn\5" +
                    "\16\b\2lm\7\13\2\2mo\5\16\b\2nl\3\2\2\2no\3\2\2\2o\21\3\2\2\2pq\7\f\2" +
                    "\2qu\7\4\2\2rv\5\f\7\2sv\5\34\17\2tv\7\t\2\2ur\3\2\2\2us\3\2\2\2ut\3\2" +
                    "\2\2vx\3\2\2\2wy\5\36\20\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z|\7\t\2\2{}\5" +
                    "\36\20\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\5\2\2\177\u0080\5\16\b\2" +
                    "\u0080\23\3\2\2\2\u0081\u0082\7\r\2\2\u0082\u0083\7\4\2\2\u0083\u0084" +
                    "\5\36\20\2\u0084\u0085\7\5\2\2\u0085\u0086\5\16\b\2\u0086\25\3\2\2\2\u0087" +
                    "\u0088\7\16\2\2\u0088\u0089\7\t\2\2\u0089\27\3\2\2\2\u008a\u008e\7\17" +
                    "\2\2\u008b\u008d\5\4\3\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e" +
                    "\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2" +
                    "\2\2\u0091\u0092\7\20\2\2\u0092\31\3\2\2\2\u0093\u0094\7\21\2\2\u0094" +
                    "\u0095\5\36\20\2\u0095\u0096\7\t\2\2\u0096\33\3\2\2\2\u0097\u0098\5\36" +
                    "\20\2\u0098\u0099\7\t\2\2\u0099\35\3\2\2\2\u009a\u009b\5 \21\2\u009b\37" +
                    "\3\2\2\2\u009c\u009d\7\31\2\2\u009d\u009e\7\b\2\2\u009e\u00a8\5 \21\2" +
                    "\u009f\u00a4\5\"\22\2\u00a0\u00a1\7\6\2\2\u00a1\u00a3\5\"\22\2\u00a2\u00a0" +
                    "\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5" +
                    "\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u009c\3\2\2\2\u00a7\u009f\3\2" +
                    "\2\2\u00a8!\3\2\2\2\u00a9\u00ae\5$\23\2\u00aa\u00ab\7\22\2\2\u00ab\u00ad" +
                    "\5$\23\2\u00ac\u00aa\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae" +
                    "\u00af\3\2\2\2\u00af#\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b6\5&\24\2" +
                    "\u00b2\u00b3\7\23\2\2\u00b3\u00b5\5&\24\2\u00b4\u00b2\3\2\2\2\u00b5\u00b8" +
                    "\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7%\3\2\2\2\u00b8" +
                    "\u00b6\3\2\2\2\u00b9\u00be\5(\25\2\u00ba\u00bb\t\2\2\2\u00bb\u00bd\5(" +
                    "\25\2\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be" +
                    "\u00bf\3\2\2\2\u00bf\'\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c6\5*\26\2" +
                    "\u00c2\u00c3\t\3\2\2\u00c3\u00c5\5*\26\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8" +
                    "\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7)\3\2\2\2\u00c8" +
                    "\u00c6\3\2\2\2\u00c9\u00ce\5,\27\2\u00ca\u00cb\t\4\2\2\u00cb\u00cd\5," +
                    "\27\2\u00cc\u00ca\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce" +
                    "\u00cf\3\2\2\2\u00cf+\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d6\5.\30\2" +
                    "\u00d2\u00d3\t\5\2\2\u00d3\u00d5\5.\30\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8" +
                    "\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7-\3\2\2\2\u00d8" +
                    "\u00d6\3\2\2\2\u00d9\u00da\t\6\2\2\u00da\u00dd\5.\30\2\u00db\u00dd\5\60" +
                    "\31\2\u00dc\u00d9\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd/\3\2\2\2\u00de\u00e6" +
                    "\5\64\33\2\u00df\u00e1\7\4\2\2\u00e0\u00e2\5\62\32\2\u00e1\u00e0\3\2\2" +
                    "\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\7\5\2\2\u00e4\u00df" +
                    "\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7" +
                    "\61\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ee\5\36\20\2\u00ea\u00eb\7\6" +
                    "\2\2\u00eb\u00ed\5\36\20\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee" +
                    "\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\63\3\2\2\2\u00f0\u00ee\3\2\2" +
                    "\2\u00f1\u00fc\7\27\2\2\u00f2\u00fc\7\30\2\2\u00f3\u00fc\7\31\2\2\u00f4" +
                    "\u00fc\7\24\2\2\u00f5\u00fc\7\25\2\2\u00f6\u00fc\7\26\2\2\u00f7\u00f8" +
                    "\7\4\2\2\u00f8\u00f9\5\36\20\2\u00f9\u00fa\7\5\2\2\u00fa\u00fc\3\2\2\2" +
                    "\u00fb\u00f1\3\2\2\2\u00fb\u00f2\3\2\2\2\u00fb\u00f3\3\2\2\2\u00fb\u00f4" +
                    "\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fb\u00f6\3\2\2\2\u00fb\u00f7\3\2\2\2\u00fc" +
                    "\65\3\2\2\2\329AISZenux|\u008e\u00a4\u00a7\u00ae\u00b6\u00be\u00c6\u00ce" +
                    "\u00d6\u00dc\u00e1\u00e6\u00ee\u00fb";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}