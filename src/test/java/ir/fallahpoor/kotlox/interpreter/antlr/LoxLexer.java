package ir.fallahpoor.kotlox.interpreter.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LoxLexer extends Lexer {
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
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
                "T__9", "T__10", "T__11", "NUMBER", "STRING", "IDENTIFIER", "WS", "OP_BANG",
                "OP_PLUS", "OP_MINUS", "OP_STAR", "OP_SLASH", "OP_EQUAL", "OP_INEQUAL",
                "OP_GREATER", "OP_LESS", "OP_GREATER_EQUAL", "OP_LESS_EQUAL"
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


    public LoxLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u009e\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
                    "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
                    "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31" +
                    "\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3" +
                    "\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n" +
                    "\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16b\n" +
                    "\16\r\16\16\16c\3\16\3\16\6\16h\n\16\r\16\16\16i\5\16l\n\16\3\17\3\17" +
                    "\7\17p\n\17\f\17\16\17s\13\17\3\17\3\17\3\20\3\20\7\20y\n\20\f\20\16\20" +
                    "|\13\20\3\21\6\21\177\n\21\r\21\16\21\u0080\3\21\3\21\3\22\3\22\3\23\3" +
                    "\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3" +
                    "\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13" +
                    "\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'" +
                    "\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\7\3\2\62;\3\2$$\5\2C\\" +
                    "aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00a3\2\3\3\2\2\2\2\5\3\2\2\2" +
                    "\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3" +
                    "\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2" +
                    "\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2" +
                    "\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2" +
                    "\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2" +
                    "\2\2\13G\3\2\2\2\rI\3\2\2\2\17K\3\2\2\2\21M\3\2\2\2\23R\3\2\2\2\25X\3" +
                    "\2\2\2\27\\\3\2\2\2\31^\3\2\2\2\33a\3\2\2\2\35m\3\2\2\2\37v\3\2\2\2!~" +
                    "\3\2\2\2#\u0084\3\2\2\2%\u0086\3\2\2\2\'\u0088\3\2\2\2)\u008a\3\2\2\2" +
                    "+\u008c\3\2\2\2-\u008e\3\2\2\2/\u0091\3\2\2\2\61\u0094\3\2\2\2\63\u0096" +
                    "\3\2\2\2\65\u0098\3\2\2\2\67\u009b\3\2\2\29:\7x\2\2:;\7c\2\2;<\7t\2\2" +
                    "<\4\3\2\2\2=>\7?\2\2>\6\3\2\2\2?@\7=\2\2@\b\3\2\2\2AB\7r\2\2BC\7t\2\2" +
                    "CD\7k\2\2DE\7p\2\2EF\7v\2\2F\n\3\2\2\2GH\7}\2\2H\f\3\2\2\2IJ\7\177\2\2" +
                    "J\16\3\2\2\2KL\7.\2\2L\20\3\2\2\2MN\7v\2\2NO\7t\2\2OP\7w\2\2PQ\7g\2\2" +
                    "Q\22\3\2\2\2RS\7h\2\2ST\7c\2\2TU\7n\2\2UV\7u\2\2VW\7g\2\2W\24\3\2\2\2" +
                    "XY\7p\2\2YZ\7k\2\2Z[\7n\2\2[\26\3\2\2\2\\]\7*\2\2]\30\3\2\2\2^_\7+\2\2" +
                    "_\32\3\2\2\2`b\t\2\2\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2dk\3\2\2" +
                    "\2eg\7\60\2\2fh\t\2\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2" +
                    "\2\2ke\3\2\2\2kl\3\2\2\2l\34\3\2\2\2mq\7$\2\2np\n\3\2\2on\3\2\2\2ps\3" +
                    "\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7$\2\2u\36\3\2\2\2vz" +
                    "\t\4\2\2wy\t\5\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{ \3\2\2\2|" +
                    "z\3\2\2\2}\177\t\6\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080" +
                    "\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\b\21\2\2\u0083\"\3\2\2" +
                    "\2\u0084\u0085\7#\2\2\u0085$\3\2\2\2\u0086\u0087\7-\2\2\u0087&\3\2\2\2" +
                    "\u0088\u0089\7/\2\2\u0089(\3\2\2\2\u008a\u008b\7,\2\2\u008b*\3\2\2\2\u008c" +
                    "\u008d\7\61\2\2\u008d,\3\2\2\2\u008e\u008f\7?\2\2\u008f\u0090\7?\2\2\u0090" +
                    ".\3\2\2\2\u0091\u0092\7#\2\2\u0092\u0093\7?\2\2\u0093\60\3\2\2\2\u0094" +
                    "\u0095\7@\2\2\u0095\62\3\2\2\2\u0096\u0097\7>\2\2\u0097\64\3\2\2\2\u0098" +
                    "\u0099\7@\2\2\u0099\u009a\7?\2\2\u009a\66\3\2\2\2\u009b\u009c\7>\2\2\u009c" +
                    "\u009d\7?\2\2\u009d8\3\2\2\2\t\2cikqz\u0080\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}