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
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, NUMBER = 9,
            STRING = 10, WS = 11, OP_BANG = 12, OP_PLUS = 13, OP_MINUS = 14, OP_STAR = 15, OP_SLASH = 16,
            OP_EQUAL = 17, OP_INEQUAL = 18, OP_GREATER = 19, OP_LESS = 20, OP_GREATER_EQUAL = 21,
            OP_LESS_EQUAL = 22;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "NUMBER",
                "STRING", "WS", "OP_BANG", "OP_PLUS", "OP_MINUS", "OP_STAR", "OP_SLASH",
                "OP_EQUAL", "OP_INEQUAL", "OP_GREATER", "OP_LESS", "OP_GREATER_EQUAL",
                "OP_LESS_EQUAL"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "';'", "'print'", "','", "'true'", "'false'", "'nil'", "'('", "')'",
                null, null, null, "'!'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='",
                "'>'", "'<'", "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, "NUMBER", "STRING",
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0083\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
                    "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
                    "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3" +
                    "\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6" +
                    "\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\6\nN\n\n\r\n\16\nO\3\n\3\n\6\nT\n" +
                    "\n\r\n\16\nU\5\nX\n\n\3\13\3\13\7\13\\\n\13\f\13\16\13_\13\13\3\13\3\13" +
                    "\3\f\6\fd\n\f\r\f\16\fe\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20" +
                    "\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26" +
                    "\3\26\3\27\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25" +
                    "\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30\3\2\5\3\2" +
                    "\62;\3\2$$\5\2\13\f\17\17\"\"\2\u0087\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2" +
                    "\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2" +
                    "\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3" +
                    "\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3" +
                    "\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2\7\67\3\2\2\2\t9\3" +
                    "\2\2\2\13>\3\2\2\2\rD\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23M\3\2\2\2\25Y" +
                    "\3\2\2\2\27c\3\2\2\2\31i\3\2\2\2\33k\3\2\2\2\35m\3\2\2\2\37o\3\2\2\2!" +
                    "q\3\2\2\2#s\3\2\2\2%v\3\2\2\2\'y\3\2\2\2){\3\2\2\2+}\3\2\2\2-\u0080\3" +
                    "\2\2\2/\60\7=\2\2\60\4\3\2\2\2\61\62\7r\2\2\62\63\7t\2\2\63\64\7k\2\2" +
                    "\64\65\7p\2\2\65\66\7v\2\2\66\6\3\2\2\2\678\7.\2\28\b\3\2\2\29:\7v\2\2" +
                    ":;\7t\2\2;<\7w\2\2<=\7g\2\2=\n\3\2\2\2>?\7h\2\2?@\7c\2\2@A\7n\2\2AB\7" +
                    "u\2\2BC\7g\2\2C\f\3\2\2\2DE\7p\2\2EF\7k\2\2FG\7n\2\2G\16\3\2\2\2HI\7*" +
                    "\2\2I\20\3\2\2\2JK\7+\2\2K\22\3\2\2\2LN\t\2\2\2ML\3\2\2\2NO\3\2\2\2OM" +
                    "\3\2\2\2OP\3\2\2\2PW\3\2\2\2QS\7\60\2\2RT\t\2\2\2SR\3\2\2\2TU\3\2\2\2" +
                    "US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WQ\3\2\2\2WX\3\2\2\2X\24\3\2\2\2Y]\7$\2" +
                    "\2Z\\\n\3\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2" +
                    "\2\2`a\7$\2\2a\26\3\2\2\2bd\t\4\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3" +
                    "\2\2\2fg\3\2\2\2gh\b\f\2\2h\30\3\2\2\2ij\7#\2\2j\32\3\2\2\2kl\7-\2\2l" +
                    "\34\3\2\2\2mn\7/\2\2n\36\3\2\2\2op\7,\2\2p \3\2\2\2qr\7\61\2\2r\"\3\2" +
                    "\2\2st\7?\2\2tu\7?\2\2u$\3\2\2\2vw\7#\2\2wx\7?\2\2x&\3\2\2\2yz\7@\2\2" +
                    "z(\3\2\2\2{|\7>\2\2|*\3\2\2\2}~\7@\2\2~\177\7?\2\2\177,\3\2\2\2\u0080" +
                    "\u0081\7>\2\2\u0081\u0082\7?\2\2\u0082.\3\2\2\2\b\2OUW]e\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}