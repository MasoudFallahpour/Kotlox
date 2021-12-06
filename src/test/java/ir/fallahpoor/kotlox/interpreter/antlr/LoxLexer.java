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
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, NUMBER = 19, STRING = 20, IDENTIFIER = 21, WS = 22, OP_BANG = 23, OP_PLUS = 24,
            OP_MINUS = 25, OP_STAR = 26, OP_SLASH = 27, OP_EQUAL = 28, OP_INEQUAL = 29, OP_GREATER = 30,
            OP_LESS = 31, OP_GREATER_EQUAL = 32, OP_LESS_EQUAL = 33;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
                "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16",
                "T__17", "NUMBER", "STRING", "IDENTIFIER", "WS", "OP_BANG", "OP_PLUS",
                "OP_MINUS", "OP_STAR", "OP_SLASH", "OP_EQUAL", "OP_INEQUAL", "OP_GREATER",
                "OP_LESS", "OP_GREATER_EQUAL", "OP_LESS_EQUAL"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'var'", "'='", "';'", "'for'", "'('", "')'", "'if'", "'else'",
                "'print'", "'while'", "'{'", "'}'", "','", "'or'", "'and'", "'true'",
                "'false'", "'nil'", null, null, null, null, "'!'", "'+'", "'-'", "'*'",
                "'/'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, "NUMBER", "STRING", "IDENTIFIER",
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00c3\b\1\4\2\t" +
                    "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3" +
                    "\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3" +
                    "\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20" +
                    "\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22" +
                    "\3\23\3\23\3\23\3\23\3\24\6\24\u0087\n\24\r\24\16\24\u0088\3\24\3\24\6" +
                    "\24\u008d\n\24\r\24\16\24\u008e\5\24\u0091\n\24\3\25\3\25\7\25\u0095\n" +
                    "\25\f\25\16\25\u0098\13\25\3\25\3\25\3\26\3\26\7\26\u009e\n\26\f\26\16" +
                    "\26\u00a1\13\26\3\27\6\27\u00a4\n\27\r\27\16\27\u00a5\3\27\3\27\3\30\3" +
                    "\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3" +
                    "\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b" +
                    "\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26" +
                    "+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#\3\2\7\3\2\62;\3" +
                    "\2$$\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00c8\2\3\3\2\2\2" +
                    "\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2" +
                    "\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2" +
                    "\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2" +
                    "\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2" +
                    "\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2" +
                    "\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5I\3\2\2\2\7K\3\2\2\2" +
                    "\tM\3\2\2\2\13Q\3\2\2\2\rS\3\2\2\2\17U\3\2\2\2\21X\3\2\2\2\23]\3\2\2\2" +
                    "\25c\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33m\3\2\2\2\35o\3\2\2\2\37r\3\2\2" +
                    "\2!v\3\2\2\2#{\3\2\2\2%\u0081\3\2\2\2\'\u0086\3\2\2\2)\u0092\3\2\2\2+" +
                    "\u009b\3\2\2\2-\u00a3\3\2\2\2/\u00a9\3\2\2\2\61\u00ab\3\2\2\2\63\u00ad" +
                    "\3\2\2\2\65\u00af\3\2\2\2\67\u00b1\3\2\2\29\u00b3\3\2\2\2;\u00b6\3\2\2" +
                    "\2=\u00b9\3\2\2\2?\u00bb\3\2\2\2A\u00bd\3\2\2\2C\u00c0\3\2\2\2EF\7x\2" +
                    "\2FG\7c\2\2GH\7t\2\2H\4\3\2\2\2IJ\7?\2\2J\6\3\2\2\2KL\7=\2\2L\b\3\2\2" +
                    "\2MN\7h\2\2NO\7q\2\2OP\7t\2\2P\n\3\2\2\2QR\7*\2\2R\f\3\2\2\2ST\7+\2\2" +
                    "T\16\3\2\2\2UV\7k\2\2VW\7h\2\2W\20\3\2\2\2XY\7g\2\2YZ\7n\2\2Z[\7u\2\2" +
                    "[\\\7g\2\2\\\22\3\2\2\2]^\7r\2\2^_\7t\2\2_`\7k\2\2`a\7p\2\2ab\7v\2\2b" +
                    "\24\3\2\2\2cd\7y\2\2de\7j\2\2ef\7k\2\2fg\7n\2\2gh\7g\2\2h\26\3\2\2\2i" +
                    "j\7}\2\2j\30\3\2\2\2kl\7\177\2\2l\32\3\2\2\2mn\7.\2\2n\34\3\2\2\2op\7" +
                    "q\2\2pq\7t\2\2q\36\3\2\2\2rs\7c\2\2st\7p\2\2tu\7f\2\2u \3\2\2\2vw\7v\2" +
                    "\2wx\7t\2\2xy\7w\2\2yz\7g\2\2z\"\3\2\2\2{|\7h\2\2|}\7c\2\2}~\7n\2\2~\177" +
                    "\7u\2\2\177\u0080\7g\2\2\u0080$\3\2\2\2\u0081\u0082\7p\2\2\u0082\u0083" +
                    "\7k\2\2\u0083\u0084\7n\2\2\u0084&\3\2\2\2\u0085\u0087\t\2\2\2\u0086\u0085" +
                    "\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089" +
                    "\u0090\3\2\2\2\u008a\u008c\7\60\2\2\u008b\u008d\t\2\2\2\u008c\u008b\3" +
                    "\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f" +
                    "\u0091\3\2\2\2\u0090\u008a\3\2\2\2\u0090\u0091\3\2\2\2\u0091(\3\2\2\2" +
                    "\u0092\u0096\7$\2\2\u0093\u0095\n\3\2\2\u0094\u0093\3\2\2\2\u0095\u0098" +
                    "\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098" +
                    "\u0096\3\2\2\2\u0099\u009a\7$\2\2\u009a*\3\2\2\2\u009b\u009f\t\4\2\2\u009c" +
                    "\u009e\t\5\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2" +
                    "\2\2\u009f\u00a0\3\2\2\2\u00a0,\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4" +
                    "\t\6\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5" +
                    "\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\27\2\2\u00a8.\3\2\2\2" +
                    "\u00a9\u00aa\7#\2\2\u00aa\60\3\2\2\2\u00ab\u00ac\7-\2\2\u00ac\62\3\2\2" +
                    "\2\u00ad\u00ae\7/\2\2\u00ae\64\3\2\2\2\u00af\u00b0\7,\2\2\u00b0\66\3\2" +
                    "\2\2\u00b1\u00b2\7\61\2\2\u00b28\3\2\2\2\u00b3\u00b4\7?\2\2\u00b4\u00b5" +
                    "\7?\2\2\u00b5:\3\2\2\2\u00b6\u00b7\7#\2\2\u00b7\u00b8\7?\2\2\u00b8<\3" +
                    "\2\2\2\u00b9\u00ba\7@\2\2\u00ba>\3\2\2\2\u00bb\u00bc\7>\2\2\u00bc@\3\2" +
                    "\2\2\u00bd\u00be\7@\2\2\u00be\u00bf\7?\2\2\u00bfB\3\2\2\2\u00c0\u00c1" +
                    "\7>\2\2\u00c1\u00c2\7?\2\2\u00c2D\3\2\2\2\t\2\u0088\u008e\u0090\u0096" +
                    "\u009f\u00a5\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}