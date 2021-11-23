package ir.fallahpoor.kotlox.interpreter.parser.antlr;

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
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, NUMBER = 6, WS = 7, OP_BANG = 8, OP_PLUS = 9,
            OP_MINUS = 10, OP_STAR = 11, OP_SLASH = 12, OP_EQUAL = 13, OP_INEQUAL = 14, OP_GREATER = 15,
            OP_LESS = 16, OP_GREATER_EQUAL = 17, OP_LESS_EQUAL = 18;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "T__4", "NUMBER", "WS", "OP_BANG", "OP_PLUS",
                "OP_MINUS", "OP_STAR", "OP_SLASH", "OP_EQUAL", "OP_INEQUAL", "OP_GREATER",
                "OP_LESS", "OP_GREATER_EQUAL", "OP_LESS_EQUAL"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'true'", "'false'", "'nil'", "'('", "')'", null, null, "'!'",
                "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, "NUMBER", "WS", "OP_BANG", "OP_PLUS",
                "OP_MINUS", "OP_STAR", "OP_SLASH", "OP_EQUAL", "OP_INEQUAL", "OP_GREATER",
                "OP_LESS", "OP_GREATER_EQUAL", "OP_LESS_EQUAL"
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24h\b\1\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4" +
                    "\3\5\3\5\3\6\3\6\3\7\6\7<\n\7\r\7\16\7=\3\7\3\7\6\7B\n\7\r\7\16\7C\5\7" +
                    "F\n\7\3\b\6\bI\n\b\r\b\16\bJ\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f" +
                    "\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3" +
                    "\22\3\23\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25" +
                    "\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\4\3\2\62;\5\2\13\f\17" +
                    "\17\"\"\2k\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2" +
                    "\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27" +
                    "\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2" +
                    "\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5,\3\2\2\2\7\62\3\2\2\2\t\66\3\2" +
                    "\2\2\138\3\2\2\2\r;\3\2\2\2\17H\3\2\2\2\21N\3\2\2\2\23P\3\2\2\2\25R\3" +
                    "\2\2\2\27T\3\2\2\2\31V\3\2\2\2\33X\3\2\2\2\35[\3\2\2\2\37^\3\2\2\2!`\3" +
                    "\2\2\2#b\3\2\2\2%e\3\2\2\2\'(\7v\2\2()\7t\2\2)*\7w\2\2*+\7g\2\2+\4\3\2" +
                    "\2\2,-\7h\2\2-.\7c\2\2./\7n\2\2/\60\7u\2\2\60\61\7g\2\2\61\6\3\2\2\2\62" +
                    "\63\7p\2\2\63\64\7k\2\2\64\65\7n\2\2\65\b\3\2\2\2\66\67\7*\2\2\67\n\3" +
                    "\2\2\289\7+\2\29\f\3\2\2\2:<\t\2\2\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3" +
                    "\2\2\2>E\3\2\2\2?A\7\60\2\2@B\t\2\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD" +
                    "\3\2\2\2DF\3\2\2\2E?\3\2\2\2EF\3\2\2\2F\16\3\2\2\2GI\t\3\2\2HG\3\2\2\2" +
                    "IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\b\b\2\2M\20\3\2\2\2NO\7#\2" +
                    "\2O\22\3\2\2\2PQ\7-\2\2Q\24\3\2\2\2RS\7/\2\2S\26\3\2\2\2TU\7,\2\2U\30" +
                    "\3\2\2\2VW\7\61\2\2W\32\3\2\2\2XY\7?\2\2YZ\7?\2\2Z\34\3\2\2\2[\\\7#\2" +
                    "\2\\]\7?\2\2]\36\3\2\2\2^_\7@\2\2_ \3\2\2\2`a\7>\2\2a\"\3\2\2\2bc\7@\2" +
                    "\2cd\7?\2\2d$\3\2\2\2ef\7>\2\2fg\7?\2\2g&\3\2\2\2\7\2=CEJ\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}