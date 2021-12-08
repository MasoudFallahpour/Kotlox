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
            T__17 = 18, T__18 = 19, NUMBER = 20, STRING = 21, IDENTIFIER = 22, WS = 23, OP_BANG = 24,
            OP_PLUS = 25, OP_MINUS = 26, OP_STAR = 27, OP_SLASH = 28, OP_EQUAL = 29, OP_INEQUAL = 30,
            OP_GREATER = 31, OP_LESS = 32, OP_GREATER_EQUAL = 33, OP_LESS_EQUAL = 34;
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
                "T__17", "T__18", "NUMBER", "STRING", "IDENTIFIER", "WS", "OP_BANG",
                "OP_PLUS", "OP_MINUS", "OP_STAR", "OP_SLASH", "OP_EQUAL", "OP_INEQUAL",
                "OP_GREATER", "OP_LESS", "OP_GREATER_EQUAL", "OP_LESS_EQUAL"
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00cb\b\1\4\2\t" +
                    "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6" +
                    "\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3" +
                    "\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16" +
                    "\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22" +
                    "\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\6\25\u008f" +
                    "\n\25\r\25\16\25\u0090\3\25\3\25\6\25\u0095\n\25\r\25\16\25\u0096\5\25" +
                    "\u0099\n\25\3\26\3\26\7\26\u009d\n\26\f\26\16\26\u00a0\13\26\3\26\3\26" +
                    "\3\27\3\27\7\27\u00a6\n\27\f\27\16\27\u00a9\13\27\3\30\6\30\u00ac\n\30" +
                    "\r\30\16\30\u00ad\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3" +
                    "\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3" +
                    "#\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17" +
                    "\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35" +
                    "9\36;\37= ?!A\"C#E$\3\2\7\3\2\62;\3\2$$\5\2C\\aac|\6\2\62;C\\aac|\5\2" +
                    "\13\f\17\17\"\"\2\u00d0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2" +
                    "\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25" +
                    "\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2" +
                    "\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2" +
                    "\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3" +
                    "\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2" +
                    "\2\2E\3\2\2\2\3G\3\2\2\2\5K\3\2\2\2\7M\3\2\2\2\tO\3\2\2\2\13S\3\2\2\2" +
                    "\rU\3\2\2\2\17W\3\2\2\2\21Z\3\2\2\2\23_\3\2\2\2\25e\3\2\2\2\27k\3\2\2" +
                    "\2\31m\3\2\2\2\33o\3\2\2\2\35u\3\2\2\2\37w\3\2\2\2!z\3\2\2\2#~\3\2\2\2" +
                    "%\u0083\3\2\2\2\'\u0089\3\2\2\2)\u008e\3\2\2\2+\u009a\3\2\2\2-\u00a3\3" +
                    "\2\2\2/\u00ab\3\2\2\2\61\u00b1\3\2\2\2\63\u00b3\3\2\2\2\65\u00b5\3\2\2" +
                    "\2\67\u00b7\3\2\2\29\u00b9\3\2\2\2;\u00bb\3\2\2\2=\u00be\3\2\2\2?\u00c1" +
                    "\3\2\2\2A\u00c3\3\2\2\2C\u00c5\3\2\2\2E\u00c8\3\2\2\2GH\7x\2\2HI\7c\2" +
                    "\2IJ\7t\2\2J\4\3\2\2\2KL\7?\2\2L\6\3\2\2\2MN\7=\2\2N\b\3\2\2\2OP\7h\2" +
                    "\2PQ\7q\2\2QR\7t\2\2R\n\3\2\2\2ST\7*\2\2T\f\3\2\2\2UV\7+\2\2V\16\3\2\2" +
                    "\2WX\7k\2\2XY\7h\2\2Y\20\3\2\2\2Z[\7g\2\2[\\\7n\2\2\\]\7u\2\2]^\7g\2\2" +
                    "^\22\3\2\2\2_`\7r\2\2`a\7t\2\2ab\7k\2\2bc\7p\2\2cd\7v\2\2d\24\3\2\2\2" +
                    "ef\7y\2\2fg\7j\2\2gh\7k\2\2hi\7n\2\2ij\7g\2\2j\26\3\2\2\2kl\7}\2\2l\30" +
                    "\3\2\2\2mn\7\177\2\2n\32\3\2\2\2op\7d\2\2pq\7t\2\2qr\7g\2\2rs\7c\2\2s" +
                    "t\7m\2\2t\34\3\2\2\2uv\7.\2\2v\36\3\2\2\2wx\7q\2\2xy\7t\2\2y \3\2\2\2" +
                    "z{\7c\2\2{|\7p\2\2|}\7f\2\2}\"\3\2\2\2~\177\7v\2\2\177\u0080\7t\2\2\u0080" +
                    "\u0081\7w\2\2\u0081\u0082\7g\2\2\u0082$\3\2\2\2\u0083\u0084\7h\2\2\u0084" +
                    "\u0085\7c\2\2\u0085\u0086\7n\2\2\u0086\u0087\7u\2\2\u0087\u0088\7g\2\2" +
                    "\u0088&\3\2\2\2\u0089\u008a\7p\2\2\u008a\u008b\7k\2\2\u008b\u008c\7n\2" +
                    "\2\u008c(\3\2\2\2\u008d\u008f\t\2\2\2\u008e\u008d\3\2\2\2\u008f\u0090" +
                    "\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0098\3\2\2\2\u0092" +
                    "\u0094\7\60\2\2\u0093\u0095\t\2\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3" +
                    "\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098" +
                    "\u0092\3\2\2\2\u0098\u0099\3\2\2\2\u0099*\3\2\2\2\u009a\u009e\7$\2\2\u009b" +
                    "\u009d\n\3\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2" +
                    "\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1" +
                    "\u00a2\7$\2\2\u00a2,\3\2\2\2\u00a3\u00a7\t\4\2\2\u00a4\u00a6\t\5\2\2\u00a5" +
                    "\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2" +
                    "\2\2\u00a8.\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac\t\6\2\2\u00ab\u00aa" +
                    "\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae" +
                    "\u00af\3\2\2\2\u00af\u00b0\b\30\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7#\2" +
                    "\2\u00b2\62\3\2\2\2\u00b3\u00b4\7-\2\2\u00b4\64\3\2\2\2\u00b5\u00b6\7" +
                    "/\2\2\u00b6\66\3\2\2\2\u00b7\u00b8\7,\2\2\u00b88\3\2\2\2\u00b9\u00ba\7" +
                    "\61\2\2\u00ba:\3\2\2\2\u00bb\u00bc\7?\2\2\u00bc\u00bd\7?\2\2\u00bd<\3" +
                    "\2\2\2\u00be\u00bf\7#\2\2\u00bf\u00c0\7?\2\2\u00c0>\3\2\2\2\u00c1\u00c2" +
                    "\7@\2\2\u00c2@\3\2\2\2\u00c3\u00c4\7>\2\2\u00c4B\3\2\2\2\u00c5\u00c6\7" +
                    "@\2\2\u00c6\u00c7\7?\2\2\u00c7D\3\2\2\2\u00c8\u00c9\7>\2\2\u00c9\u00ca" +
                    "\7?\2\2\u00caF\3\2\2\2\t\2\u0090\u0096\u0098\u009e\u00a7\u00ad\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}