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
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, NUMBER = 7, STRING = 8, WS = 9,
            OP_BANG = 10, OP_PLUS = 11, OP_MINUS = 12, OP_STAR = 13, OP_SLASH = 14, OP_EQUAL = 15,
            OP_INEQUAL = 16, OP_GREATER = 17, OP_LESS = 18, OP_GREATER_EQUAL = 19, OP_LESS_EQUAL = 20;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "NUMBER", "STRING", "WS",
                "OP_BANG", "OP_PLUS", "OP_MINUS", "OP_STAR", "OP_SLASH", "OP_EQUAL",
                "OP_INEQUAL", "OP_GREATER", "OP_LESS", "OP_GREATER_EQUAL", "OP_LESS_EQUAL"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "','", "'true'", "'false'", "'nil'", "'('", "')'", null, null,
                null, "'!'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'>'", "'<'",
                "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, "NUMBER", "STRING", "WS", "OP_BANG",
                "OP_PLUS", "OP_MINUS", "OP_STAR", "OP_SLASH", "OP_EQUAL", "OP_INEQUAL",
                "OP_GREATER", "OP_LESS", "OP_GREATER_EQUAL", "OP_LESS_EQUAL"
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26w\b\1\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4" +
                    "\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\6\bB\n\b\r\b\16\bC\3" +
                    "\b\3\b\6\bH\n\b\r\b\16\bI\5\bL\n\b\3\t\3\t\7\tP\n\t\f\t\16\tS\13\t\3\t" +
                    "\3\t\3\n\6\nX\n\n\r\n\16\nY\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16" +
                    "\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24" +
                    "\3\24\3\25\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25" +
                    "\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\5\3\2\62;\3\2" +
                    "$$\5\2\13\f\17\17\"\"\2{\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2" +
                    "\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25" +
                    "\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2" +
                    "\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2" +
                    "\2\5-\3\2\2\2\7\62\3\2\2\2\t8\3\2\2\2\13<\3\2\2\2\r>\3\2\2\2\17A\3\2\2" +
                    "\2\21M\3\2\2\2\23W\3\2\2\2\25]\3\2\2\2\27_\3\2\2\2\31a\3\2\2\2\33c\3\2" +
                    "\2\2\35e\3\2\2\2\37g\3\2\2\2!j\3\2\2\2#m\3\2\2\2%o\3\2\2\2\'q\3\2\2\2" +
                    ")t\3\2\2\2+,\7.\2\2,\4\3\2\2\2-.\7v\2\2./\7t\2\2/\60\7w\2\2\60\61\7g\2" +
                    "\2\61\6\3\2\2\2\62\63\7h\2\2\63\64\7c\2\2\64\65\7n\2\2\65\66\7u\2\2\66" +
                    "\67\7g\2\2\67\b\3\2\2\289\7p\2\29:\7k\2\2:;\7n\2\2;\n\3\2\2\2<=\7*\2\2" +
                    "=\f\3\2\2\2>?\7+\2\2?\16\3\2\2\2@B\t\2\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2" +
                    "\2CD\3\2\2\2DK\3\2\2\2EG\7\60\2\2FH\t\2\2\2GF\3\2\2\2HI\3\2\2\2IG\3\2" +
                    "\2\2IJ\3\2\2\2JL\3\2\2\2KE\3\2\2\2KL\3\2\2\2L\20\3\2\2\2MQ\7$\2\2NP\n" +
                    "\3\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7" +
                    "$\2\2U\22\3\2\2\2VX\t\4\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z[" +
                    "\3\2\2\2[\\\b\n\2\2\\\24\3\2\2\2]^\7#\2\2^\26\3\2\2\2_`\7-\2\2`\30\3\2" +
                    "\2\2ab\7/\2\2b\32\3\2\2\2cd\7,\2\2d\34\3\2\2\2ef\7\61\2\2f\36\3\2\2\2" +
                    "gh\7?\2\2hi\7?\2\2i \3\2\2\2jk\7#\2\2kl\7?\2\2l\"\3\2\2\2mn\7@\2\2n$\3" +
                    "\2\2\2op\7>\2\2p&\3\2\2\2qr\7@\2\2rs\7?\2\2s(\3\2\2\2tu\7>\2\2uv\7?\2" +
                    "\2v*\3\2\2\2\b\2CIKQY\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}