// Generated from C:/Users/arian/lei21_22_s4_2de_01 (base app)/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/antlr/eapli/base/surveymanagement/antlr\Answer.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnswerParser}.
 */
public interface AnswerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnswerParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(AnswerParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(AnswerParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AnswerParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AnswerParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#frase}.
	 * @param ctx the parse tree
	 */
	void enterFrase(AnswerParser.FraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#frase}.
	 * @param ctx the parse tree
	 */
	void exitFrase(AnswerParser.FraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#opcao}.
	 * @param ctx the parse tree
	 */
	void enterOpcao(AnswerParser.OpcaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#opcao}.
	 * @param ctx the parse tree
	 */
	void exitOpcao(AnswerParser.OpcaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#alfanumerico}.
	 * @param ctx the parse tree
	 */
	void enterAlfanumerico(AnswerParser.AlfanumericoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#alfanumerico}.
	 * @param ctx the parse tree
	 */
	void exitAlfanumerico(AnswerParser.AlfanumericoContext ctx);
}