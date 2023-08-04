// Generated from C:/Users/arian/lei21_22_s4_2de_01 (base app)/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/antlr/eapli/base/surveymanagement/antlr\Survey.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SurveyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, MANDATORY=7, OPTIONAL=8, 
		CONDITION_DEPENDENT=9, FREE_TEXT=10, NUMERIC=11, SINGLE_CHOICE=12, SINGLE_CHOICE1=13, 
		MULTIPLE_CHOICE=14, MULTIPLE_CHOICE1=15, SORTING_OPTIONS=16, SCALING_OPTIONS=17, 
		INFO_FREE_TEXT=18, INFO_NUMERIC=19, INFO_SINGLE_CHOICE=20, INFO_CHOICE1=21, 
		INFO_MULTIPLE_CHOICE=22, INFO_SORTING_OPTIONS=23, INFO_SCALING_OPTIONS=24, 
		DECIMALS_ALLOWED=25, NUMERO=26, PALAVRA=27, HIFEN=28, ESPACO=29, PONTO_FINAL=30, 
		DOIS_PONTOS=31, RETICENCIAS=32, VIRGULA=33, PONTO_INTERROGACAO=34, PONTO_EXCLAMACAO=35, 
		PARENTESIS_DIREITO=36, PARENTESIS_ESQUERDO=37, NEWLINE=38;
	public static final int
		RULE_start = 0, RULE_questionario = 1, RULE_regraIdQuestionario = 2, RULE_regraTitulo = 3, 
		RULE_regraMensagem = 4, RULE_seccao = 5, RULE_alfanumerico = 6, RULE_frase = 7, 
		RULE_pontucao = 8, RULE_regraId = 9, RULE_obrigatoriedade = 10, RULE_repetibilidade = 11, 
		RULE_pergunta = 12, RULE_regraPergunta = 13, RULE_type = 14, RULE_opcao = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "questionario", "regraIdQuestionario", "regraTitulo", "regraMensagem", 
			"seccao", "alfanumerico", "frase", "pontucao", "regraId", "obrigatoriedade", 
			"repetibilidade", "pergunta", "regraPergunta", "type", "opcao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Section Obligatoriness: '", "'Repeatability: '", "'Section: '", 
			"'Question: '", "'Type: '", "'Scale: '", "'mandatory'", "'optional'", 
			"'condition dependent'", "'Free-Text'", "'Numeric'", "'Single-Choice'", 
			"'Single-Choice with input value'", "'Multiple-Choice'", "'Multiple-Choice with input value'", 
			"'Sorting Options'", "'Scaling Options'", "'Answer the question by typing some text.'", 
			"'Answer the question by entering a numeric value.'", "'Answer the question by selecting one (and only one) of the options provided.'", 
			"'The last option, if selected, implies that you write a numeric value or free text.'", 
			"'Select more than one.'", "'Sorting the options as desired and according to the instructions provided.'", 
			"'Select a scale value for each of the specified options.'", "'Decimal numbers are allowed!'", 
			null, null, "'-'", null, "'.'", "':'", "'...'", "','", "'?'", "'!'", 
			"')'", "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "MANDATORY", "OPTIONAL", "CONDITION_DEPENDENT", 
			"FREE_TEXT", "NUMERIC", "SINGLE_CHOICE", "SINGLE_CHOICE1", "MULTIPLE_CHOICE", 
			"MULTIPLE_CHOICE1", "SORTING_OPTIONS", "SCALING_OPTIONS", "INFO_FREE_TEXT", 
			"INFO_NUMERIC", "INFO_SINGLE_CHOICE", "INFO_CHOICE1", "INFO_MULTIPLE_CHOICE", 
			"INFO_SORTING_OPTIONS", "INFO_SCALING_OPTIONS", "DECIMALS_ALLOWED", "NUMERO", 
			"PALAVRA", "HIFEN", "ESPACO", "PONTO_FINAL", "DOIS_PONTOS", "RETICENCIAS", 
			"VIRGULA", "PONTO_INTERROGACAO", "PONTO_EXCLAMACAO", "PARENTESIS_DIREITO", 
			"PARENTESIS_ESQUERDO", "NEWLINE"
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
	public String getGrammarFileName() { return "Survey.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SurveyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public QuestionarioContext questionario() {
			return getRuleContext(QuestionarioContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			questionario();
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

	public static class QuestionarioContext extends ParserRuleContext {
		public RegraIdQuestionarioContext regraIdQuestionario() {
			return getRuleContext(RegraIdQuestionarioContext.class,0);
		}
		public TerminalNode ESPACO() { return getToken(SurveyParser.ESPACO, 0); }
		public RegraTituloContext regraTitulo() {
			return getRuleContext(RegraTituloContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SurveyParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SurveyParser.NEWLINE, i);
		}
		public List<RegraMensagemContext> regraMensagem() {
			return getRuleContexts(RegraMensagemContext.class);
		}
		public RegraMensagemContext regraMensagem(int i) {
			return getRuleContext(RegraMensagemContext.class,i);
		}
		public List<SeccaoContext> seccao() {
			return getRuleContexts(SeccaoContext.class);
		}
		public SeccaoContext seccao(int i) {
			return getRuleContext(SeccaoContext.class,i);
		}
		public QuestionarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterQuestionario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitQuestionario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitQuestionario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionarioContext questionario() throws RecognitionException {
		QuestionarioContext _localctx = new QuestionarioContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_questionario);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			regraIdQuestionario();
			setState(35);
			match(ESPACO);
			setState(36);
			regraTitulo();
			setState(37);
			match(NEWLINE);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMERO || _la==PALAVRA) {
				{
				setState(38);
				regraMensagem();
				}
			}

			setState(43); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(41);
					match(NEWLINE);
					setState(42);
					seccao();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(45); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(47);
			match(NEWLINE);
			setState(48);
			match(NEWLINE);
			setState(49);
			regraMensagem();
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

	public static class RegraIdQuestionarioContext extends ParserRuleContext {
		public TerminalNode HIFEN() { return getToken(SurveyParser.HIFEN, 0); }
		public List<AlfanumericoContext> alfanumerico() {
			return getRuleContexts(AlfanumericoContext.class);
		}
		public AlfanumericoContext alfanumerico(int i) {
			return getRuleContext(AlfanumericoContext.class,i);
		}
		public RegraIdQuestionarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraIdQuestionario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterRegraIdQuestionario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitRegraIdQuestionario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitRegraIdQuestionario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraIdQuestionarioContext regraIdQuestionario() throws RecognitionException {
		RegraIdQuestionarioContext _localctx = new RegraIdQuestionarioContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_regraIdQuestionario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(51);
				alfanumerico();
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==PALAVRA );
			setState(56);
			match(HIFEN);
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				alfanumerico();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==PALAVRA );
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

	public static class RegraTituloContext extends ParserRuleContext {
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public RegraTituloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraTitulo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterRegraTitulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitRegraTitulo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitRegraTitulo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraTituloContext regraTitulo() throws RecognitionException {
		RegraTituloContext _localctx = new RegraTituloContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_regraTitulo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			frase();
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

	public static class RegraMensagemContext extends ParserRuleContext {
		public List<FraseContext> frase() {
			return getRuleContexts(FraseContext.class);
		}
		public FraseContext frase(int i) {
			return getRuleContext(FraseContext.class,i);
		}
		public List<PontucaoContext> pontucao() {
			return getRuleContexts(PontucaoContext.class);
		}
		public PontucaoContext pontucao(int i) {
			return getRuleContext(PontucaoContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SurveyParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SurveyParser.NEWLINE, i);
		}
		public RegraMensagemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraMensagem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterRegraMensagem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitRegraMensagem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitRegraMensagem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraMensagemContext regraMensagem() throws RecognitionException {
		RegraMensagemContext _localctx = new RegraMensagemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_regraMensagem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				frase();
				setState(65);
				pontucao();
				setState(66);
				match(NEWLINE);
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==PALAVRA );
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

	public static class SeccaoContext extends ParserRuleContext {
		public RegraIdContext regraId() {
			return getRuleContext(RegraIdContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SurveyParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SurveyParser.NEWLINE, i);
		}
		public RegraTituloContext regraTitulo() {
			return getRuleContext(RegraTituloContext.class,0);
		}
		public ObrigatoriedadeContext obrigatoriedade() {
			return getRuleContext(ObrigatoriedadeContext.class,0);
		}
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public RepetibilidadeContext repetibilidade() {
			return getRuleContext(RepetibilidadeContext.class,0);
		}
		public List<PerguntaContext> pergunta() {
			return getRuleContexts(PerguntaContext.class);
		}
		public PerguntaContext pergunta(int i) {
			return getRuleContext(PerguntaContext.class,i);
		}
		public SeccaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterSeccao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitSeccao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitSeccao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccaoContext seccao() throws RecognitionException {
		SeccaoContext _localctx = new SeccaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_seccao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			regraId();
			setState(73);
			match(NEWLINE);
			setState(74);
			regraTitulo();
			setState(75);
			match(NEWLINE);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMERO || _la==PALAVRA) {
				{
				setState(76);
				regraMensagem();
				}
			}

			setState(79);
			match(T__0);
			setState(80);
			obrigatoriedade();
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(81);
				match(NEWLINE);
				setState(82);
				match(T__1);
				setState(83);
				repetibilidade();
				}
				break;
			}
			setState(86);
			match(NEWLINE);
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				pergunta();
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO );
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
		public TerminalNode PALAVRA() { return getToken(SurveyParser.PALAVRA, 0); }
		public TerminalNode NUMERO() { return getToken(SurveyParser.NUMERO, 0); }
		public AlfanumericoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alfanumerico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterAlfanumerico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitAlfanumerico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitAlfanumerico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlfanumericoContext alfanumerico() throws RecognitionException {
		AlfanumericoContext _localctx = new AlfanumericoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_alfanumerico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
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

	public static class FraseContext extends ParserRuleContext {
		public List<TerminalNode> ESPACO() { return getTokens(SurveyParser.ESPACO); }
		public TerminalNode ESPACO(int i) {
			return getToken(SurveyParser.ESPACO, i);
		}
		public List<TerminalNode> PALAVRA() { return getTokens(SurveyParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(SurveyParser.PALAVRA, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(SurveyParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(SurveyParser.NUMERO, i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(SurveyParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(SurveyParser.VIRGULA, i);
		}
		public FraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterFrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitFrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitFrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FraseContext frase() throws RecognitionException {
		FraseContext _localctx = new FraseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_frase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
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
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==PALAVRA );
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESPACO || _la==VIRGULA) {
				{
				{
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VIRGULA) {
					{
					setState(99);
					match(VIRGULA);
					}
				}

				setState(102);
				match(ESPACO);
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(103);
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
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==PALAVRA );
				}
				}
				setState(112);
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

	public static class PontucaoContext extends ParserRuleContext {
		public TerminalNode PONTO_FINAL() { return getToken(SurveyParser.PONTO_FINAL, 0); }
		public TerminalNode PONTO_INTERROGACAO() { return getToken(SurveyParser.PONTO_INTERROGACAO, 0); }
		public TerminalNode RETICENCIAS() { return getToken(SurveyParser.RETICENCIAS, 0); }
		public TerminalNode PONTO_EXCLAMACAO() { return getToken(SurveyParser.PONTO_EXCLAMACAO, 0); }
		public PontucaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pontucao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterPontucao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitPontucao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitPontucao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PontucaoContext pontucao() throws RecognitionException {
		PontucaoContext _localctx = new PontucaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pontucao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PONTO_FINAL) | (1L << RETICENCIAS) | (1L << PONTO_INTERROGACAO) | (1L << PONTO_EXCLAMACAO))) != 0)) ) {
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

	public static class RegraIdContext extends ParserRuleContext {
		public List<TerminalNode> NUMERO() { return getTokens(SurveyParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(SurveyParser.NUMERO, i);
		}
		public RegraIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterRegraId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitRegraId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitRegraId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraIdContext regraId() throws RecognitionException {
		RegraIdContext _localctx = new RegraIdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_regraId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(115);
				match(NUMERO);
				}
				}
				setState(118); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO );
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

	public static class ObrigatoriedadeContext extends ParserRuleContext {
		public TerminalNode MANDATORY() { return getToken(SurveyParser.MANDATORY, 0); }
		public TerminalNode OPTIONAL() { return getToken(SurveyParser.OPTIONAL, 0); }
		public TerminalNode CONDITION_DEPENDENT() { return getToken(SurveyParser.CONDITION_DEPENDENT, 0); }
		public TerminalNode DOIS_PONTOS() { return getToken(SurveyParser.DOIS_PONTOS, 0); }
		public TerminalNode ESPACO() { return getToken(SurveyParser.ESPACO, 0); }
		public List<RegraIdContext> regraId() {
			return getRuleContexts(RegraIdContext.class);
		}
		public RegraIdContext regraId(int i) {
			return getRuleContext(RegraIdContext.class,i);
		}
		public ObrigatoriedadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obrigatoriedade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterObrigatoriedade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitObrigatoriedade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitObrigatoriedade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObrigatoriedadeContext obrigatoriedade() throws RecognitionException {
		ObrigatoriedadeContext _localctx = new ObrigatoriedadeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_obrigatoriedade);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MANDATORY:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(MANDATORY);
				}
				break;
			case OPTIONAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(OPTIONAL);
				}
				break;
			case CONDITION_DEPENDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(CONDITION_DEPENDENT);
				setState(123);
				match(DOIS_PONTOS);
				setState(124);
				match(ESPACO);
				setState(125);
				match(T__2);
				setState(126);
				regraId();
				setState(127);
				match(T__3);
				setState(128);
				regraId();
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

	public static class RepetibilidadeContext extends ParserRuleContext {
		public List<TerminalNode> NUMERO() { return getTokens(SurveyParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(SurveyParser.NUMERO, i);
		}
		public RepetibilidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetibilidade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterRepetibilidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitRepetibilidade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitRepetibilidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepetibilidadeContext repetibilidade() throws RecognitionException {
		RepetibilidadeContext _localctx = new RepetibilidadeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_repetibilidade);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				match(NUMERO);
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO );
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

	public static class PerguntaContext extends ParserRuleContext {
		public RegraIdContext regraId() {
			return getRuleContext(RegraIdContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SurveyParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SurveyParser.NEWLINE, i);
		}
		public RegraPerguntaContext regraPergunta() {
			return getRuleContext(RegraPerguntaContext.class,0);
		}
		public TerminalNode PARENTESIS_ESQUERDO() { return getToken(SurveyParser.PARENTESIS_ESQUERDO, 0); }
		public ObrigatoriedadeContext obrigatoriedade() {
			return getRuleContext(ObrigatoriedadeContext.class,0);
		}
		public TerminalNode PARENTESIS_DIREITO() { return getToken(SurveyParser.PARENTESIS_DIREITO, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public PerguntaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pergunta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterPergunta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitPergunta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitPergunta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerguntaContext pergunta() throws RecognitionException {
		PerguntaContext _localctx = new PerguntaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pergunta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			regraId();
			setState(138);
			match(NEWLINE);
			setState(139);
			regraPergunta();
			setState(140);
			match(PARENTESIS_ESQUERDO);
			setState(141);
			obrigatoriedade();
			setState(142);
			match(PARENTESIS_DIREITO);
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(143);
				match(NEWLINE);
				setState(144);
				regraMensagem();
				}
				break;
			}
			setState(147);
			match(NEWLINE);
			setState(148);
			match(T__4);
			setState(149);
			type();
			setState(150);
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

	public static class RegraPerguntaContext extends ParserRuleContext {
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public TerminalNode PONTO_INTERROGACAO() { return getToken(SurveyParser.PONTO_INTERROGACAO, 0); }
		public TerminalNode NEWLINE() { return getToken(SurveyParser.NEWLINE, 0); }
		public RegraPerguntaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraPergunta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterRegraPergunta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitRegraPergunta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitRegraPergunta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraPerguntaContext regraPergunta() throws RecognitionException {
		RegraPerguntaContext _localctx = new RegraPerguntaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_regraPergunta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			frase();
			setState(153);
			match(PONTO_INTERROGACAO);
			setState(154);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode FREE_TEXT() { return getToken(SurveyParser.FREE_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SurveyParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SurveyParser.NEWLINE, i);
		}
		public TerminalNode INFO_FREE_TEXT() { return getToken(SurveyParser.INFO_FREE_TEXT, 0); }
		public TerminalNode NUMERIC() { return getToken(SurveyParser.NUMERIC, 0); }
		public TerminalNode INFO_NUMERIC() { return getToken(SurveyParser.INFO_NUMERIC, 0); }
		public TerminalNode ESPACO() { return getToken(SurveyParser.ESPACO, 0); }
		public TerminalNode PARENTESIS_ESQUERDO() { return getToken(SurveyParser.PARENTESIS_ESQUERDO, 0); }
		public TerminalNode DECIMALS_ALLOWED() { return getToken(SurveyParser.DECIMALS_ALLOWED, 0); }
		public TerminalNode PARENTESIS_DIREITO() { return getToken(SurveyParser.PARENTESIS_DIREITO, 0); }
		public TerminalNode SINGLE_CHOICE() { return getToken(SurveyParser.SINGLE_CHOICE, 0); }
		public TerminalNode INFO_SINGLE_CHOICE() { return getToken(SurveyParser.INFO_SINGLE_CHOICE, 0); }
		public List<OpcaoContext> opcao() {
			return getRuleContexts(OpcaoContext.class);
		}
		public OpcaoContext opcao(int i) {
			return getRuleContext(OpcaoContext.class,i);
		}
		public TerminalNode MULTIPLE_CHOICE() { return getToken(SurveyParser.MULTIPLE_CHOICE, 0); }
		public TerminalNode INFO_MULTIPLE_CHOICE() { return getToken(SurveyParser.INFO_MULTIPLE_CHOICE, 0); }
		public TerminalNode SINGLE_CHOICE1() { return getToken(SurveyParser.SINGLE_CHOICE1, 0); }
		public TerminalNode INFO_CHOICE1() { return getToken(SurveyParser.INFO_CHOICE1, 0); }
		public TerminalNode MULTIPLE_CHOICE1() { return getToken(SurveyParser.MULTIPLE_CHOICE1, 0); }
		public TerminalNode SORTING_OPTIONS() { return getToken(SurveyParser.SORTING_OPTIONS, 0); }
		public TerminalNode INFO_SORTING_OPTIONS() { return getToken(SurveyParser.INFO_SORTING_OPTIONS, 0); }
		public TerminalNode SCALING_OPTIONS() { return getToken(SurveyParser.SCALING_OPTIONS, 0); }
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public TerminalNode INFO_SCALING_OPTIONS() { return getToken(SurveyParser.INFO_SCALING_OPTIONS, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		int _la;
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FREE_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(FREE_TEXT);
				setState(157);
				match(NEWLINE);
				setState(158);
				match(NEWLINE);
				setState(159);
				match(INFO_FREE_TEXT);
				}
				break;
			case NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(NUMERIC);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ESPACO) {
					{
					setState(161);
					match(ESPACO);
					setState(162);
					match(PARENTESIS_ESQUERDO);
					setState(163);
					match(DECIMALS_ALLOWED);
					setState(164);
					match(PARENTESIS_DIREITO);
					}
				}

				setState(167);
				match(NEWLINE);
				setState(168);
				match(NEWLINE);
				setState(169);
				match(INFO_NUMERIC);
				}
				break;
			case SINGLE_CHOICE:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(SINGLE_CHOICE);
				setState(171);
				match(NEWLINE);
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(172);
					opcao();
					}
					}
					setState(175); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO );
				setState(177);
				match(NEWLINE);
				setState(178);
				match(INFO_SINGLE_CHOICE);
				}
				break;
			case MULTIPLE_CHOICE:
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
				match(MULTIPLE_CHOICE);
				setState(181);
				match(NEWLINE);
				setState(183); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(182);
					opcao();
					}
					}
					setState(185); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO );
				setState(187);
				match(NEWLINE);
				setState(188);
				match(INFO_MULTIPLE_CHOICE);
				}
				break;
			case SINGLE_CHOICE1:
				enterOuterAlt(_localctx, 5);
				{
				setState(190);
				match(SINGLE_CHOICE1);
				setState(191);
				match(NEWLINE);
				setState(193); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(192);
					opcao();
					}
					}
					setState(195); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO );
				setState(197);
				match(NEWLINE);
				setState(198);
				match(INFO_CHOICE1);
				}
				break;
			case MULTIPLE_CHOICE1:
				enterOuterAlt(_localctx, 6);
				{
				setState(200);
				match(MULTIPLE_CHOICE1);
				setState(201);
				match(NEWLINE);
				setState(203); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(202);
					opcao();
					}
					}
					setState(205); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO );
				setState(207);
				match(NEWLINE);
				setState(208);
				match(INFO_CHOICE1);
				}
				break;
			case SORTING_OPTIONS:
				enterOuterAlt(_localctx, 7);
				{
				setState(210);
				match(SORTING_OPTIONS);
				setState(211);
				match(NEWLINE);
				setState(213); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(212);
					opcao();
					}
					}
					setState(215); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO );
				setState(217);
				match(NEWLINE);
				setState(218);
				match(INFO_SORTING_OPTIONS);
				}
				break;
			case SCALING_OPTIONS:
				enterOuterAlt(_localctx, 8);
				{
				setState(220);
				match(SCALING_OPTIONS);
				setState(221);
				match(NEWLINE);
				setState(222);
				match(T__5);
				setState(223);
				frase();
				setState(224);
				match(NEWLINE);
				setState(226); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(225);
					opcao();
					}
					}
					setState(228); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO );
				setState(230);
				match(NEWLINE);
				setState(231);
				match(INFO_SCALING_OPTIONS);
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

	public static class OpcaoContext extends ParserRuleContext {
		public RegraIdContext regraId() {
			return getRuleContext(RegraIdContext.class,0);
		}
		public TerminalNode PARENTESIS_DIREITO() { return getToken(SurveyParser.PARENTESIS_DIREITO, 0); }
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(SurveyParser.NEWLINE, 0); }
		public TerminalNode DOIS_PONTOS() { return getToken(SurveyParser.DOIS_PONTOS, 0); }
		public OpcaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).enterOpcao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener ) ((SurveyListener)listener).exitOpcao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor ) return ((SurveyVisitor<? extends T>)visitor).visitOpcao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpcaoContext opcao() throws RecognitionException {
		OpcaoContext _localctx = new OpcaoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_opcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			regraId();
			setState(236);
			match(PARENTESIS_DIREITO);
			setState(237);
			frase();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOIS_PONTOS) {
				{
				setState(238);
				match(DOIS_PONTOS);
				}
			}

			setState(241);
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

	public static final String _serializedATN =
		"\u0004\u0001&\u00f4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001(\b\u0001\u0001\u0001\u0001\u0001\u0004\u0001"+
		",\b\u0001\u000b\u0001\f\u0001-\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0004\u00025\b\u0002\u000b\u0002\f\u00026\u0001\u0002"+
		"\u0001\u0002\u0004\u0002;\b\u0002\u000b\u0002\f\u0002<\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004E\b"+
		"\u0004\u000b\u0004\f\u0004F\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005N\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005U\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0004\u0005Y\b\u0005\u000b\u0005\f\u0005Z\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0004\u0007`\b\u0007\u000b\u0007\f\u0007a\u0001\u0007\u0003"+
		"\u0007e\b\u0007\u0001\u0007\u0001\u0007\u0004\u0007i\b\u0007\u000b\u0007"+
		"\f\u0007j\u0005\u0007m\b\u0007\n\u0007\f\u0007p\t\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0004\tu\b\t\u000b\t\f\tv\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0083\b\n\u0001\u000b"+
		"\u0004\u000b\u0086\b\u000b\u000b\u000b\f\u000b\u0087\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0092\b\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u00a6\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u00ae\b\u000e"+
		"\u000b\u000e\f\u000e\u00af\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0004\u000e\u00b8\b\u000e\u000b\u000e\f\u000e"+
		"\u00b9\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0004\u000e\u00c2\b\u000e\u000b\u000e\f\u000e\u00c3\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e"+
		"\u00cc\b\u000e\u000b\u000e\f\u000e\u00cd\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u00d6\b\u000e\u000b"+
		"\u000e\f\u000e\u00d7\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u00e3"+
		"\b\u000e\u000b\u000e\f\u000e\u00e4\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00ea\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00f0\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0000"+
		"\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e\u0000\u0002\u0001\u0000\u001a\u001b\u0003\u0000\u001e"+
		"\u001e  \"#\u0103\u0000 \u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000"+
		"\u0000\u00044\u0001\u0000\u0000\u0000\u0006>\u0001\u0000\u0000\u0000\b"+
		"D\u0001\u0000\u0000\u0000\nH\u0001\u0000\u0000\u0000\f\\\u0001\u0000\u0000"+
		"\u0000\u000e_\u0001\u0000\u0000\u0000\u0010q\u0001\u0000\u0000\u0000\u0012"+
		"t\u0001\u0000\u0000\u0000\u0014\u0082\u0001\u0000\u0000\u0000\u0016\u0085"+
		"\u0001\u0000\u0000\u0000\u0018\u0089\u0001\u0000\u0000\u0000\u001a\u0098"+
		"\u0001\u0000\u0000\u0000\u001c\u00e9\u0001\u0000\u0000\u0000\u001e\u00eb"+
		"\u0001\u0000\u0000\u0000 !\u0003\u0002\u0001\u0000!\u0001\u0001\u0000"+
		"\u0000\u0000\"#\u0003\u0004\u0002\u0000#$\u0005\u001d\u0000\u0000$%\u0003"+
		"\u0006\u0003\u0000%\'\u0005&\u0000\u0000&(\u0003\b\u0004\u0000\'&\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000\u0000"+
		")*\u0005&\u0000\u0000*,\u0003\n\u0005\u0000+)\u0001\u0000\u0000\u0000"+
		",-\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000"+
		"\u0000./\u0001\u0000\u0000\u0000/0\u0005&\u0000\u000001\u0005&\u0000\u0000"+
		"12\u0003\b\u0004\u00002\u0003\u0001\u0000\u0000\u000035\u0003\f\u0006"+
		"\u000043\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000064\u0001\u0000"+
		"\u0000\u000067\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008:\u0005"+
		"\u001c\u0000\u00009;\u0003\f\u0006\u0000:9\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=\u0005\u0001\u0000\u0000\u0000>?\u0003\u000e\u0007\u0000?\u0007\u0001"+
		"\u0000\u0000\u0000@A\u0003\u000e\u0007\u0000AB\u0003\u0010\b\u0000BC\u0005"+
		"&\u0000\u0000CE\u0001\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"G\t\u0001\u0000\u0000\u0000HI\u0003\u0012\t\u0000IJ\u0005&\u0000\u0000"+
		"JK\u0003\u0006\u0003\u0000KM\u0005&\u0000\u0000LN\u0003\b\u0004\u0000"+
		"ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000"+
		"\u0000OP\u0005\u0001\u0000\u0000PT\u0003\u0014\n\u0000QR\u0005&\u0000"+
		"\u0000RS\u0005\u0002\u0000\u0000SU\u0003\u0016\u000b\u0000TQ\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0005"+
		"&\u0000\u0000WY\u0003\u0018\f\u0000XW\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000"+
		"[\u000b\u0001\u0000\u0000\u0000\\]\u0007\u0000\u0000\u0000]\r\u0001\u0000"+
		"\u0000\u0000^`\u0007\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"bn\u0001\u0000\u0000\u0000ce\u0005!\u0000\u0000dc\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fh\u0005\u001d\u0000"+
		"\u0000gi\u0007\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000ij\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001"+
		"\u0000\u0000\u0000ld\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000"+
		"nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\u000f\u0001\u0000"+
		"\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0007\u0001\u0000\u0000r\u0011"+
		"\u0001\u0000\u0000\u0000su\u0005\u001a\u0000\u0000ts\u0001\u0000\u0000"+
		"\u0000uv\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000w\u0013\u0001\u0000\u0000\u0000x\u0083\u0005\u0007\u0000\u0000"+
		"y\u0083\u0005\b\u0000\u0000z{\u0005\t\u0000\u0000{|\u0005\u001f\u0000"+
		"\u0000|}\u0005\u001d\u0000\u0000}~\u0005\u0003\u0000\u0000~\u007f\u0003"+
		"\u0012\t\u0000\u007f\u0080\u0005\u0004\u0000\u0000\u0080\u0081\u0003\u0012"+
		"\t\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082x\u0001\u0000\u0000"+
		"\u0000\u0082y\u0001\u0000\u0000\u0000\u0082z\u0001\u0000\u0000\u0000\u0083"+
		"\u0015\u0001\u0000\u0000\u0000\u0084\u0086\u0005\u001a\u0000\u0000\u0085"+
		"\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u0017\u0001\u0000\u0000\u0000\u0089\u008a\u0003\u0012\t\u0000\u008a\u008b"+
		"\u0005&\u0000\u0000\u008b\u008c\u0003\u001a\r\u0000\u008c\u008d\u0005"+
		"%\u0000\u0000\u008d\u008e\u0003\u0014\n\u0000\u008e\u0091\u0005$\u0000"+
		"\u0000\u008f\u0090\u0005&\u0000\u0000\u0090\u0092\u0003\b\u0004\u0000"+
		"\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0005&\u0000\u0000\u0094"+
		"\u0095\u0005\u0005\u0000\u0000\u0095\u0096\u0003\u001c\u000e\u0000\u0096"+
		"\u0097\u0005&\u0000\u0000\u0097\u0019\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0003\u000e\u0007\u0000\u0099\u009a\u0005\"\u0000\u0000\u009a\u009b\u0005"+
		"&\u0000\u0000\u009b\u001b\u0001\u0000\u0000\u0000\u009c\u009d\u0005\n"+
		"\u0000\u0000\u009d\u009e\u0005&\u0000\u0000\u009e\u009f\u0005&\u0000\u0000"+
		"\u009f\u00ea\u0005\u0012\u0000\u0000\u00a0\u00a5\u0005\u000b\u0000\u0000"+
		"\u00a1\u00a2\u0005\u001d\u0000\u0000\u00a2\u00a3\u0005%\u0000\u0000\u00a3"+
		"\u00a4\u0005\u0019\u0000\u0000\u00a4\u00a6\u0005$\u0000\u0000\u00a5\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005&\u0000\u0000\u00a8\u00a9\u0005"+
		"&\u0000\u0000\u00a9\u00ea\u0005\u0013\u0000\u0000\u00aa\u00ab\u0005\f"+
		"\u0000\u0000\u00ab\u00ad\u0005&\u0000\u0000\u00ac\u00ae\u0003\u001e\u000f"+
		"\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000"+
		"\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005&\u0000\u0000"+
		"\u00b2\u00b3\u0005\u0014\u0000\u0000\u00b3\u00ea\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0005\u000e\u0000\u0000\u00b5\u00b7\u0005&\u0000\u0000\u00b6"+
		"\u00b8\u0003\u001e\u000f\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0005&\u0000\u0000\u00bc\u00bd\u0005\u0016\u0000\u0000\u00bd\u00ea"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0005\r\u0000\u0000\u00bf\u00c1\u0005"+
		"&\u0000\u0000\u00c0\u00c2\u0003\u001e\u000f\u0000\u00c1\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0005&\u0000\u0000\u00c6\u00c7\u0005\u0015\u0000"+
		"\u0000\u00c7\u00ea\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u000f\u0000"+
		"\u0000\u00c9\u00cb\u0005&\u0000\u0000\u00ca\u00cc\u0003\u001e\u000f\u0000"+
		"\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000"+
		"\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005&\u0000\u0000\u00d0"+
		"\u00d1\u0005\u0015\u0000\u0000\u00d1\u00ea\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0005\u0010\u0000\u0000\u00d3\u00d5\u0005&\u0000\u0000\u00d4\u00d6"+
		"\u0003\u001e\u000f\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0005&\u0000\u0000\u00da\u00db\u0005\u0017\u0000\u0000\u00db\u00ea\u0001"+
		"\u0000\u0000\u0000\u00dc\u00dd\u0005\u0011\u0000\u0000\u00dd\u00de\u0005"+
		"&\u0000\u0000\u00de\u00df\u0005\u0006\u0000\u0000\u00df\u00e0\u0003\u000e"+
		"\u0007\u0000\u00e0\u00e2\u0005&\u0000\u0000\u00e1\u00e3\u0003\u001e\u000f"+
		"\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005&\u0000\u0000"+
		"\u00e7\u00e8\u0005\u0018\u0000\u0000\u00e8\u00ea\u0001\u0000\u0000\u0000"+
		"\u00e9\u009c\u0001\u0000\u0000\u0000\u00e9\u00a0\u0001\u0000\u0000\u0000"+
		"\u00e9\u00aa\u0001\u0000\u0000\u0000\u00e9\u00b4\u0001\u0000\u0000\u0000"+
		"\u00e9\u00be\u0001\u0000\u0000\u0000\u00e9\u00c8\u0001\u0000\u0000\u0000"+
		"\u00e9\u00d2\u0001\u0000\u0000\u0000\u00e9\u00dc\u0001\u0000\u0000\u0000"+
		"\u00ea\u001d\u0001\u0000\u0000\u0000\u00eb\u00ec\u0003\u0012\t\u0000\u00ec"+
		"\u00ed\u0005$\u0000\u0000\u00ed\u00ef\u0003\u000e\u0007\u0000\u00ee\u00f0"+
		"\u0005\u001f\u0000\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0005&\u0000\u0000\u00f2\u001f\u0001\u0000\u0000\u0000\u0019\'-6<FMT"+
		"Zadjnv\u0082\u0087\u0091\u00a5\u00af\u00b9\u00c3\u00cd\u00d7\u00e4\u00e9"+
		"\u00ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}