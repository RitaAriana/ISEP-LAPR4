// Generated from C:/Users/arian/lei21_22_s4_2de_01 (base app)/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/antlr/eapli/base/surveymanagement/antlr\Survey.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SurveyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SurveyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SurveyParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(SurveyParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#questionario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionario(SurveyParser.QuestionarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#regraIdQuestionario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraIdQuestionario(SurveyParser.RegraIdQuestionarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#regraTitulo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraTitulo(SurveyParser.RegraTituloContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#regraMensagem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraMensagem(SurveyParser.RegraMensagemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#seccao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccao(SurveyParser.SeccaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#alfanumerico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlfanumerico(SurveyParser.AlfanumericoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#frase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrase(SurveyParser.FraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#pontucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPontucao(SurveyParser.PontucaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#regraId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraId(SurveyParser.RegraIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#obrigatoriedade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObrigatoriedade(SurveyParser.ObrigatoriedadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#repetibilidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepetibilidade(SurveyParser.RepetibilidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#pergunta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPergunta(SurveyParser.PerguntaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#regraPergunta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraPergunta(SurveyParser.RegraPerguntaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SurveyParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#opcao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcao(SurveyParser.OpcaoContext ctx);
}