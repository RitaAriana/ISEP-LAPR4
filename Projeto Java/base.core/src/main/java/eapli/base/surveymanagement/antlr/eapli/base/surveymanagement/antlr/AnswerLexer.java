// Generated from C:/Users/arian/lei21_22_s4_2de_01 (base app)/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/antlr/eapli/base/surveymanagement/antlr\Answer.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AnswerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FREE_TEXT=1, NUMERIC=2, SINGLE_CHOICE=3, SINGLE_CHOICE1=4, MULTIPLE_CHOICE=5, 
		MULTIPLE_CHOICE1=6, SORTING_OPTIONS=7, SCALING_OPTIONS=8, NUMERO=9, PALAVRA=10, 
		VIRGULA=11, ESPACO=12, NEWLINE=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FREE_TEXT", "NUMERIC", "SINGLE_CHOICE", "SINGLE_CHOICE1", "MULTIPLE_CHOICE", 
			"MULTIPLE_CHOICE1", "SORTING_OPTIONS", "SCALING_OPTIONS", "NUMERO", "PALAVRA", 
			"VIRGULA", "ESPACO", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Free-Text'", "'Numeric'", "'Single-Choice'", "'Single-Choice with input value'", 
			"'Multiple-Choice'", "'Multiple-Choice with input value'", "'Sorting Options'", 
			"'Scaling Options'", null, null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FREE_TEXT", "NUMERIC", "SINGLE_CHOICE", "SINGLE_CHOICE1", "MULTIPLE_CHOICE", 
			"MULTIPLE_CHOICE1", "SORTING_OPTIONS", "SCALING_OPTIONS", "NUMERO", "PALAVRA", 
			"VIRGULA", "ESPACO", "NEWLINE"
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


	public AnswerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Answer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\r\u00b8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0004\t\u00af\b"+
		"\t\u000b\t\f\t\u00b0\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0000\u0000\r\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u0001\u0000\u0004\u0001\u000009\u0002\u0000AZaz\u0002\u0000\t\t  \u0002"+
		"\u0000\n\n\r\r\u00b8\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0001\u001b\u0001\u0000\u0000"+
		"\u0000\u0003%\u0001\u0000\u0000\u0000\u0005-\u0001\u0000\u0000\u0000\u0007"+
		";\u0001\u0000\u0000\u0000\tZ\u0001\u0000\u0000\u0000\u000bj\u0001\u0000"+
		"\u0000\u0000\r\u008b\u0001\u0000\u0000\u0000\u000f\u009b\u0001\u0000\u0000"+
		"\u0000\u0011\u00ab\u0001\u0000\u0000\u0000\u0013\u00ae\u0001\u0000\u0000"+
		"\u0000\u0015\u00b2\u0001\u0000\u0000\u0000\u0017\u00b4\u0001\u0000\u0000"+
		"\u0000\u0019\u00b6\u0001\u0000\u0000\u0000\u001b\u001c\u0005F\u0000\u0000"+
		"\u001c\u001d\u0005r\u0000\u0000\u001d\u001e\u0005e\u0000\u0000\u001e\u001f"+
		"\u0005e\u0000\u0000\u001f \u0005-\u0000\u0000 !\u0005T\u0000\u0000!\""+
		"\u0005e\u0000\u0000\"#\u0005x\u0000\u0000#$\u0005t\u0000\u0000$\u0002"+
		"\u0001\u0000\u0000\u0000%&\u0005N\u0000\u0000&\'\u0005u\u0000\u0000\'"+
		"(\u0005m\u0000\u0000()\u0005e\u0000\u0000)*\u0005r\u0000\u0000*+\u0005"+
		"i\u0000\u0000+,\u0005c\u0000\u0000,\u0004\u0001\u0000\u0000\u0000-.\u0005"+
		"S\u0000\u0000./\u0005i\u0000\u0000/0\u0005n\u0000\u000001\u0005g\u0000"+
		"\u000012\u0005l\u0000\u000023\u0005e\u0000\u000034\u0005-\u0000\u0000"+
		"45\u0005C\u0000\u000056\u0005h\u0000\u000067\u0005o\u0000\u000078\u0005"+
		"i\u0000\u000089\u0005c\u0000\u00009:\u0005e\u0000\u0000:\u0006\u0001\u0000"+
		"\u0000\u0000;<\u0005S\u0000\u0000<=\u0005i\u0000\u0000=>\u0005n\u0000"+
		"\u0000>?\u0005g\u0000\u0000?@\u0005l\u0000\u0000@A\u0005e\u0000\u0000"+
		"AB\u0005-\u0000\u0000BC\u0005C\u0000\u0000CD\u0005h\u0000\u0000DE\u0005"+
		"o\u0000\u0000EF\u0005i\u0000\u0000FG\u0005c\u0000\u0000GH\u0005e\u0000"+
		"\u0000HI\u0005 \u0000\u0000IJ\u0005w\u0000\u0000JK\u0005i\u0000\u0000"+
		"KL\u0005t\u0000\u0000LM\u0005h\u0000\u0000MN\u0005 \u0000\u0000NO\u0005"+
		"i\u0000\u0000OP\u0005n\u0000\u0000PQ\u0005p\u0000\u0000QR\u0005u\u0000"+
		"\u0000RS\u0005t\u0000\u0000ST\u0005 \u0000\u0000TU\u0005v\u0000\u0000"+
		"UV\u0005a\u0000\u0000VW\u0005l\u0000\u0000WX\u0005u\u0000\u0000XY\u0005"+
		"e\u0000\u0000Y\b\u0001\u0000\u0000\u0000Z[\u0005M\u0000\u0000[\\\u0005"+
		"u\u0000\u0000\\]\u0005l\u0000\u0000]^\u0005t\u0000\u0000^_\u0005i\u0000"+
		"\u0000_`\u0005p\u0000\u0000`a\u0005l\u0000\u0000ab\u0005e\u0000\u0000"+
		"bc\u0005-\u0000\u0000cd\u0005C\u0000\u0000de\u0005h\u0000\u0000ef\u0005"+
		"o\u0000\u0000fg\u0005i\u0000\u0000gh\u0005c\u0000\u0000hi\u0005e\u0000"+
		"\u0000i\n\u0001\u0000\u0000\u0000jk\u0005M\u0000\u0000kl\u0005u\u0000"+
		"\u0000lm\u0005l\u0000\u0000mn\u0005t\u0000\u0000no\u0005i\u0000\u0000"+
		"op\u0005p\u0000\u0000pq\u0005l\u0000\u0000qr\u0005e\u0000\u0000rs\u0005"+
		"-\u0000\u0000st\u0005C\u0000\u0000tu\u0005h\u0000\u0000uv\u0005o\u0000"+
		"\u0000vw\u0005i\u0000\u0000wx\u0005c\u0000\u0000xy\u0005e\u0000\u0000"+
		"yz\u0005 \u0000\u0000z{\u0005w\u0000\u0000{|\u0005i\u0000\u0000|}\u0005"+
		"t\u0000\u0000}~\u0005h\u0000\u0000~\u007f\u0005 \u0000\u0000\u007f\u0080"+
		"\u0005i\u0000\u0000\u0080\u0081\u0005n\u0000\u0000\u0081\u0082\u0005p"+
		"\u0000\u0000\u0082\u0083\u0005u\u0000\u0000\u0083\u0084\u0005t\u0000\u0000"+
		"\u0084\u0085\u0005 \u0000\u0000\u0085\u0086\u0005v\u0000\u0000\u0086\u0087"+
		"\u0005a\u0000\u0000\u0087\u0088\u0005l\u0000\u0000\u0088\u0089\u0005u"+
		"\u0000\u0000\u0089\u008a\u0005e\u0000\u0000\u008a\f\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0005S\u0000\u0000\u008c\u008d\u0005o\u0000\u0000\u008d"+
		"\u008e\u0005r\u0000\u0000\u008e\u008f\u0005t\u0000\u0000\u008f\u0090\u0005"+
		"i\u0000\u0000\u0090\u0091\u0005n\u0000\u0000\u0091\u0092\u0005g\u0000"+
		"\u0000\u0092\u0093\u0005 \u0000\u0000\u0093\u0094\u0005O\u0000\u0000\u0094"+
		"\u0095\u0005p\u0000\u0000\u0095\u0096\u0005t\u0000\u0000\u0096\u0097\u0005"+
		"i\u0000\u0000\u0097\u0098\u0005o\u0000\u0000\u0098\u0099\u0005n\u0000"+
		"\u0000\u0099\u009a\u0005s\u0000\u0000\u009a\u000e\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0005S\u0000\u0000\u009c\u009d\u0005c\u0000\u0000\u009d\u009e"+
		"\u0005a\u0000\u0000\u009e\u009f\u0005l\u0000\u0000\u009f\u00a0\u0005i"+
		"\u0000\u0000\u00a0\u00a1\u0005n\u0000\u0000\u00a1\u00a2\u0005g\u0000\u0000"+
		"\u00a2\u00a3\u0005 \u0000\u0000\u00a3\u00a4\u0005O\u0000\u0000\u00a4\u00a5"+
		"\u0005p\u0000\u0000\u00a5\u00a6\u0005t\u0000\u0000\u00a6\u00a7\u0005i"+
		"\u0000\u0000\u00a7\u00a8\u0005o\u0000\u0000\u00a8\u00a9\u0005n\u0000\u0000"+
		"\u00a9\u00aa\u0005s\u0000\u0000\u00aa\u0010\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0007\u0000\u0000\u0000\u00ac\u0012\u0001\u0000\u0000\u0000\u00ad"+
		"\u00af\u0007\u0001\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b1\u0014\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0005,\u0000\u0000\u00b3\u0016\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0007\u0002\u0000\u0000\u00b5\u0018\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u0007\u0003\u0000\u0000\u00b7\u001a\u0001\u0000\u0000\u0000\u0002\u0000"+
		"\u00b0\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}