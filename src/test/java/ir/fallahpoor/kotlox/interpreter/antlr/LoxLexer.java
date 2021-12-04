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
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, NUMBER = 17,
            STRING = 18, IDENTIFIER = 19, WS = 20, OP_BANG = 21, OP_PLUS = 22, OP_MINUS = 23,
            OP_STAR = 24, OP_SLASH = 25, OP_EQUAL = 26, OP_INEQUAL = 27, OP_GREATER = 28, OP_LESS = 29,
            OP_GREATER_EQUAL = 30, OP_LESS_EQUAL = 31;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
                "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "NUMBER",
                "STRING", "IDENTIFIER", "WS", "OP_BANG", "OP_PLUS", "OP_MINUS", "OP_STAR",
                "OP_SLASH", "OP_EQUAL", "OP_INEQUAL", "OP_GREATER", "OP_LESS", "OP_GREATER_EQUAL",
                "OP_LESS_EQUAL"
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00b5\b\1\4\2\t" +
                    "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2" +
                    "\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3" +
                    "\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3" +
                    "\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3" +
                    "\20\3\21\3\21\3\21\3\21\3\22\6\22y\n\22\r\22\16\22z\3\22\3\22\6\22\177" +
                    "\n\22\r\22\16\22\u0080\5\22\u0083\n\22\3\23\3\23\7\23\u0087\n\23\f\23" +
                    "\16\23\u008a\13\23\3\23\3\23\3\24\3\24\7\24\u0090\n\24\f\24\16\24\u0093" +
                    "\13\24\3\25\6\25\u0096\n\25\r\25\16\25\u0097\3\25\3\25\3\26\3\26\3\27" +
                    "\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35" +
                    "\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b" +
                    "\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26" +
                    "+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\7\3\2\62;\3\2$$\5" +
                    "\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00ba\2\3\3\2\2\2\2\5\3" +
                    "\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2" +
                    "\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3" +
                    "\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'" +
                    "\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63" +
                    "\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2" +
                    "?\3\2\2\2\3A\3\2\2\2\5E\3\2\2\2\7G\3\2\2\2\tI\3\2\2\2\13L\3\2\2\2\rN\3" +
                    "\2\2\2\17P\3\2\2\2\21U\3\2\2\2\23[\3\2\2\2\25]\3\2\2\2\27_\3\2\2\2\31" +
                    "a\3\2\2\2\33d\3\2\2\2\35h\3\2\2\2\37m\3\2\2\2!s\3\2\2\2#x\3\2\2\2%\u0084" +
                    "\3\2\2\2\'\u008d\3\2\2\2)\u0095\3\2\2\2+\u009b\3\2\2\2-\u009d\3\2\2\2" +
                    "/\u009f\3\2\2\2\61\u00a1\3\2\2\2\63\u00a3\3\2\2\2\65\u00a5\3\2\2\2\67" +
                    "\u00a8\3\2\2\29\u00ab\3\2\2\2;\u00ad\3\2\2\2=\u00af\3\2\2\2?\u00b2\3\2" +
                    "\2\2AB\7x\2\2BC\7c\2\2CD\7t\2\2D\4\3\2\2\2EF\7?\2\2F\6\3\2\2\2GH\7=\2" +
                    "\2H\b\3\2\2\2IJ\7k\2\2JK\7h\2\2K\n\3\2\2\2LM\7*\2\2M\f\3\2\2\2NO\7+\2" +
                    "\2O\16\3\2\2\2PQ\7g\2\2QR\7n\2\2RS\7u\2\2ST\7g\2\2T\20\3\2\2\2UV\7r\2" +
                    "\2VW\7t\2\2WX\7k\2\2XY\7p\2\2YZ\7v\2\2Z\22\3\2\2\2[\\\7}\2\2\\\24\3\2" +
                    "\2\2]^\7\177\2\2^\26\3\2\2\2_`\7.\2\2`\30\3\2\2\2ab\7q\2\2bc\7t\2\2c\32" +
                    "\3\2\2\2de\7c\2\2ef\7p\2\2fg\7f\2\2g\34\3\2\2\2hi\7v\2\2ij\7t\2\2jk\7" +
                    "w\2\2kl\7g\2\2l\36\3\2\2\2mn\7h\2\2no\7c\2\2op\7n\2\2pq\7u\2\2qr\7g\2" +
                    "\2r \3\2\2\2st\7p\2\2tu\7k\2\2uv\7n\2\2v\"\3\2\2\2wy\t\2\2\2xw\3\2\2\2" +
                    "yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\u0082\3\2\2\2|~\7\60\2\2}\177\t\2\2\2" +
                    "~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081" +
                    "\u0083\3\2\2\2\u0082|\3\2\2\2\u0082\u0083\3\2\2\2\u0083$\3\2\2\2\u0084" +
                    "\u0088\7$\2\2\u0085\u0087\n\3\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2" +
                    "\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a" +
                    "\u0088\3\2\2\2\u008b\u008c\7$\2\2\u008c&\3\2\2\2\u008d\u0091\t\4\2\2\u008e" +
                    "\u0090\t\5\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2" +
                    "\2\2\u0091\u0092\3\2\2\2\u0092(\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0096" +
                    "\t\6\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097" +
                    "\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\b\25\2\2\u009a*\3\2\2\2" +
                    "\u009b\u009c\7#\2\2\u009c,\3\2\2\2\u009d\u009e\7-\2\2\u009e.\3\2\2\2\u009f" +
                    "\u00a0\7/\2\2\u00a0\60\3\2\2\2\u00a1\u00a2\7,\2\2\u00a2\62\3\2\2\2\u00a3" +
                    "\u00a4\7\61\2\2\u00a4\64\3\2\2\2\u00a5\u00a6\7?\2\2\u00a6\u00a7\7?\2\2" +
                    "\u00a7\66\3\2\2\2\u00a8\u00a9\7#\2\2\u00a9\u00aa\7?\2\2\u00aa8\3\2\2\2" +
                    "\u00ab\u00ac\7@\2\2\u00ac:\3\2\2\2\u00ad\u00ae\7>\2\2\u00ae<\3\2\2\2\u00af" +
                    "\u00b0\7@\2\2\u00b0\u00b1\7?\2\2\u00b1>\3\2\2\2\u00b2\u00b3\7>\2\2\u00b3" +
                    "\u00b4\7?\2\2\u00b4@\3\2\2\2\t\2z\u0080\u0082\u0088\u0091\u0097\3\b\2" +
                    "\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}