// Generated from C:/Users/arian/lei21_22_s4_2de_01 (base app)/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/antlr/eapli/base/surveymanagement/antlr\Survey.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SurveyParser}.
 */
public interface SurveyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SurveyParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(SurveyParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(SurveyParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#questionario}.
	 * @param ctx the parse tree
	 */
	void enterQuestionario(SurveyParser.QuestionarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#questionario}.
	 * @param ctx the parse tree
	 */
	void exitQuestionario(SurveyParser.QuestionarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#regraIdQuestionario}.
	 * @param ctx the parse tree
	 */
	void enterRegraIdQuestionario(SurveyParser.RegraIdQuestionarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#regraIdQuestionario}.
	 * @param ctx the parse tree
	 */
	void exitRegraIdQuestionario(SurveyParser.RegraIdQuestionarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#regraTitulo}.
	 * @param ctx the parse tree
	 */
	void enterRegraTitulo(SurveyParser.RegraTituloContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#regraTitulo}.
	 * @param ctx the parse tree
	 */
	void exitRegraTitulo(SurveyParser.RegraTituloContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#regraMensagem}.
	 * @param ctx the parse tree
	 */
	void enterRegraMensagem(SurveyParser.RegraMensagemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#regraMensagem}.
	 * @param ctx the parse tree
	 */
	void exitRegraMensagem(SurveyParser.RegraMensagemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#seccao}.
	 * @param ctx the parse tree
	 */
	void enterSeccao(SurveyParser.SeccaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#seccao}.
	 * @param ctx the parse tree
	 */
	void exitSeccao(SurveyParser.SeccaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#alfanumerico}.
	 * @param ctx the parse tree
	 */
	void enterAlfanumerico(SurveyParser.AlfanumericoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#alfanumerico}.
	 * @param ctx the parse tree
	 */
	void exitAlfanumerico(SurveyParser.AlfanumericoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#frase}.
	 * @param ctx the parse tree
	 */
	void enterFrase(SurveyParser.FraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#frase}.
	 * @param ctx the parse tree
	 */
	void exitFrase(SurveyParser.FraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#pontucao}.
	 * @param ctx the parse tree
	 */
	void enterPontucao(SurveyParser.PontucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#pontucao}.
	 * @param ctx the parse tree
	 */
	void exitPontucao(SurveyParser.PontucaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#regraId}.
	 * @param ctx the parse tree
	 */
	void enterRegraId(SurveyParser.RegraIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#regraId}.
	 * @param ctx the parse tree
	 */
	void exitRegraId(SurveyParser.RegraIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#obrigatoriedade}.
	 * @param ctx the parse tree
	 */
	void enterObrigatoriedade(SurveyParser.ObrigatoriedadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#obrigatoriedade}.
	 * @param ctx the parse tree
	 */
	void exitObrigatoriedade(SurveyParser.ObrigatoriedadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#repetibilidade}.
	 * @param ctx the parse tree
	 */
	void enterRepetibilidade(SurveyParser.RepetibilidadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#repetibilidade}.
	 * @param ctx the parse tree
	 */
	void exitRepetibilidade(SurveyParser.RepetibilidadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#pergunta}.
	 * @param ctx the parse tree
	 */
	void enterPergunta(SurveyParser.PerguntaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#pergunta}.
	 * @param ctx the parse tree
	 */
	void exitPergunta(SurveyParser.PerguntaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#regraPergunta}.
	 * @param ctx the parse tree
	 */
	void enterRegraPergunta(SurveyParser.RegraPerguntaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#regraPergunta}.
	 * @param ctx the parse tree
	 */
	void exitRegraPergunta(SurveyParser.RegraPerguntaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SurveyParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SurveyParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#opcao}.
	 * @param ctx the parse tree
	 */
	void enterOpcao(SurveyParser.OpcaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#opcao}.
	 * @param ctx the parse tree
	 */
	void exitOpcao(SurveyParser.OpcaoContext ctx);
}