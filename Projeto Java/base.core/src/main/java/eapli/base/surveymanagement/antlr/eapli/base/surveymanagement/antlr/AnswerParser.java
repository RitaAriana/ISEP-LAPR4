// Generated from C:/Users/arian/lei21_22_s4_2de_01 (base app)/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/antlr/eapli/base/surveymanagement/antlr\Answer.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AnswerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FREE_TEXT=1, NUMERIC=2, SINGLE_CHOICE=3, SINGLE_CHOICE1=4, MULTIPLE_CHOICE=5, 
		MULTIPLE_CHOICE1=6, SORTING_OPTIONS=7, SCALING_OPTIONS=8, NUMERO=9, PALAVRA=10, 
		VIRGULA=11, ESPACO=12, NEWLINE=13;
	public static final int
		RULE_start = 0, RULE_type = 1, RULE_frase = 2, RULE_opcao = 3, RULE_alfanumerico = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "type", "frase", "opcao", "alfanumerico"
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

	@Override
	public String getGrammarFileName() { return "Answer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnswerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode FREE_TEXT() { return getToken(AnswerParser.FREE_TEXT, 0); }
		public TerminalNode ESPACO() { return getToken(AnswerParser.ESPACO, 0); }
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public TerminalNode NUMERIC() { return getToken(AnswerParser.NUMERIC, 0); }
		public List<TerminalNode> NUMERO() { return getTokens(AnswerParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(AnswerParser.NUMERO, i);
		}
		public TerminalNode SINGLE_CHOICE() { return getToken(AnswerParser.SINGLE_CHOICE, 0); }
		public List<OpcaoContext> opcao() {
			return getRuleContexts(OpcaoContext.class);
		}
		public OpcaoContext opcao(int i) {
			return getRuleContext(OpcaoContext.class,i);
		}
		public TerminalNode MULTIPLE_CHOICE() { return getToken(AnswerParser.MULTIPLE_CHOICE, 0); }
		public TerminalNode SINGLE_CHOICE1() { return getToken(AnswerParser.SINGLE_CHOICE1, 0); }
		public TerminalNode NEWLINE() { return getToken(AnswerParser.NEWLINE, 0); }
		public TerminalNode MULTIPLE_CHOICE1() { return getToken(AnswerParser.MULTIPLE_CHOICE1, 0); }
		public TerminalNode SORTING_OPTIONS() { return getToken(AnswerParser.SORTING_OPTIONS, 0); }
		public TerminalNode SCALING_OPTIONS() { return getToken(AnswerParser.SCALING_OPTIONS, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			int _alt;
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FREE_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				match(FREE_TEXT);
				setState(13);
				match(ESPACO);
				setState(14);
				frase();
				}
				break;
			case NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(15);
				match(NUMERIC);
				setState(16);
				match(ESPACO);
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(17);
					match(NUMERO);
					}
					}
					setState(20); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO );
				}
				break;
			case SINGLE_CHOICE:
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
				match(SINGLE_CHOICE);
				setState(23);
				match(ESPACO);
				setState(24);
				opcao();
				}
				break;
			case MULTIPLE_CHOICE:
				enterOuterAlt(_localctx, 4);
				{
				setState(25);
				match(MULTIPLE_CHOICE);
				setState(26);
				match(ESPACO);
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(27);
					opcao();
					}
					}
					setState(30); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==PALAVRA );
				}
				break;
			case SINGLE_CHOICE1:
				enterOuterAlt(_localctx, 5);
				{
				setState(32);
				match(SINGLE_CHOICE1);
				setState(33);
				match(ESPACO);
				setState(38);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(34);
					opcao();
					}
					break;
				case 2:
					{
					{
					setState(35);
					frase();
					setState(36);
					match(NEWLINE);
					}
					}
					break;
				}
				}
				break;
			case MULTIPLE_CHOICE1:
				enterOuterAlt(_localctx, 6);
				{
				setState(40);
				match(MULTIPLE_CHOICE1);
				setState(41);
				match(ESPACO);
				setState(43); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(42);
						opcao();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(45); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMERO || _la==PALAVRA) {
					{
					setState(47);
					frase();
					setState(48);
					match(NEWLINE);
					}
				}

				}
				break;
			case SORTING_OPTIONS:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				match(SORTING_OPTIONS);
				setState(53);
				match(ESPACO);
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(54);
					opcao();
					}
					}
					setState(57); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==PALAVRA );
				}
				break;
			case SCALING_OPTIONS:
				enterOuterAlt(_localctx, 8);
				{
				setState(59);
				match(SCALING_OPTIONS);
				setState(60);
				match(ESPACO);
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(61);
					opcao();
					}
					}
					setState(64); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==PALAVRA );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FraseContext extends ParserRuleContext {
		public List<TerminalNode> ESPACO() { return getTokens(AnswerParser.ESPACO); }
		public TerminalNode ESPACO(int i) {
			return getToken(AnswerParser.ESPACO, i);
		}
		public List<TerminalNode> PALAVRA() { return getTokens(AnswerParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(AnswerParser.PALAVRA, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(AnswerParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(AnswerParser.NUMERO, i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(AnswerParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(AnswerParser.VIRGULA, i);
		}
		public FraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterFrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitFrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitFrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FraseContext frase() throws RecognitionException {
		FraseContext _localctx = new FraseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_frase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				_la = _input.LA(1);
				if ( !(_la==NUMERO || _la==PALAVRA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==PALAVRA );
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA || _la==ESPACO) {
				{
				{
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VIRGULA) {
					{
					setState(73);
					match(VIRGULA);
					}
				}

				setState(76);
				match(ESPACO);
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(77);
					_la = _input.LA(1);
					if ( !(_la==NUMERO || _la==PALAVRA) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(80); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==PALAVRA );
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpcaoContext extends ParserRuleContext {
		public AlfanumericoContext alfanumerico() {
			return getRuleContext(AlfanumericoContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(AnswerParser.NEWLINE, 0); }
		public OpcaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterOpcao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitOpcao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitOpcao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpcaoContext opcao() throws RecognitionException {
		OpcaoContext _localctx = new OpcaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_opcao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			alfanumerico();
			setState(88);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlfanumericoContext extends ParserRuleContext {
		public TerminalNode PALAVRA() { return getToken(AnswerParser.PALAVRA, 0); }
		public TerminalNode NUMERO() { return getToken(AnswerParser.NUMERO, 0); }
		public AlfanumericoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alfanumerico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterAlfanumerico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitAlfanumerico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitAlfanumerico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlfanumericoContext alfanumerico() throws RecognitionException {
		AlfanumericoContext _localctx = new AlfanumericoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_alfanumerico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_la = _input.LA(1);
			if ( !(_la==NUMERO || _la==PALAVRA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\r]\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u0001\u0013\b\u0001\u000b\u0001\f\u0001\u0014"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0004\u0001\u001d\b\u0001\u000b\u0001\f\u0001\u001e\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\'\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001,\b\u0001\u000b"+
		"\u0001\f\u0001-\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00013\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u00018\b\u0001\u000b\u0001"+
		"\f\u00019\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001?\b\u0001\u000b"+
		"\u0001\f\u0001@\u0003\u0001C\b\u0001\u0001\u0002\u0004\u0002F\b\u0002"+
		"\u000b\u0002\f\u0002G\u0001\u0002\u0003\u0002K\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0004\u0002O\b\u0002\u000b\u0002\f\u0002P\u0005\u0002S\b\u0002"+
		"\n\u0002\f\u0002V\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0000\u0000\u0005\u0000\u0002\u0004\u0006\b\u0000"+
		"\u0001\u0001\u0000\t\ni\u0000\n\u0001\u0000\u0000\u0000\u0002B\u0001\u0000"+
		"\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006W\u0001\u0000\u0000\u0000"+
		"\bZ\u0001\u0000\u0000\u0000\n\u000b\u0003\u0002\u0001\u0000\u000b\u0001"+
		"\u0001\u0000\u0000\u0000\f\r\u0005\u0001\u0000\u0000\r\u000e\u0005\f\u0000"+
		"\u0000\u000eC\u0003\u0004\u0002\u0000\u000f\u0010\u0005\u0002\u0000\u0000"+
		"\u0010\u0012\u0005\f\u0000\u0000\u0011\u0013\u0005\t\u0000\u0000\u0012"+
		"\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014"+
		"\u0012\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015"+
		"C\u0001\u0000\u0000\u0000\u0016\u0017\u0005\u0003\u0000\u0000\u0017\u0018"+
		"\u0005\f\u0000\u0000\u0018C\u0003\u0006\u0003\u0000\u0019\u001a\u0005"+
		"\u0005\u0000\u0000\u001a\u001c\u0005\f\u0000\u0000\u001b\u001d\u0003\u0006"+
		"\u0003\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000"+
		"\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000"+
		"\u0000\u0000\u001fC\u0001\u0000\u0000\u0000 !\u0005\u0004\u0000\u0000"+
		"!&\u0005\f\u0000\u0000\"\'\u0003\u0006\u0003\u0000#$\u0003\u0004\u0002"+
		"\u0000$%\u0005\r\u0000\u0000%\'\u0001\u0000\u0000\u0000&\"\u0001\u0000"+
		"\u0000\u0000&#\u0001\u0000\u0000\u0000\'C\u0001\u0000\u0000\u0000()\u0005"+
		"\u0006\u0000\u0000)+\u0005\f\u0000\u0000*,\u0003\u0006\u0003\u0000+*\u0001"+
		"\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000"+
		"-.\u0001\u0000\u0000\u0000.2\u0001\u0000\u0000\u0000/0\u0003\u0004\u0002"+
		"\u000001\u0005\r\u0000\u000013\u0001\u0000\u0000\u00002/\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u00003C\u0001\u0000\u0000\u000045\u0005\u0007"+
		"\u0000\u000057\u0005\f\u0000\u000068\u0003\u0006\u0003\u000076\u0001\u0000"+
		"\u0000\u000089\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:C\u0001\u0000\u0000\u0000;<\u0005\b\u0000\u0000<>\u0005"+
		"\f\u0000\u0000=?\u0003\u0006\u0003\u0000>=\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"AC\u0001\u0000\u0000\u0000B\f\u0001\u0000\u0000\u0000B\u000f\u0001\u0000"+
		"\u0000\u0000B\u0016\u0001\u0000\u0000\u0000B\u0019\u0001\u0000\u0000\u0000"+
		"B \u0001\u0000\u0000\u0000B(\u0001\u0000\u0000\u0000B4\u0001\u0000\u0000"+
		"\u0000B;\u0001\u0000\u0000\u0000C\u0003\u0001\u0000\u0000\u0000DF\u0007"+
		"\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HT\u0001\u0000\u0000"+
		"\u0000IK\u0005\u000b\u0000\u0000JI\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0005\f\u0000\u0000MO\u0007\u0000"+
		"\u0000\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000"+
		"RJ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000U\u0005\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000WX\u0003\b\u0004\u0000XY\u0005\r\u0000\u0000Y\u0007"+
		"\u0001\u0000\u0000\u0000Z[\u0007\u0000\u0000\u0000[\t\u0001\u0000\u0000"+
		"\u0000\f\u0014\u001e&-29@BGJPT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}