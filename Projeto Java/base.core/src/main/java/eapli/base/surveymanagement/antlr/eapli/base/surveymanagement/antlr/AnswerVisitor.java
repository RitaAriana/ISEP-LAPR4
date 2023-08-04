// Generated from C:/Users/arian/lei21_22_s4_2de_01 (base app)/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/antlr/eapli/base/surveymanagement/antlr\Answer.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AnswerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnswerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AnswerParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(AnswerParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(AnswerParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#frase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrase(AnswerParser.FraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#opcao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcao(AnswerParser.OpcaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#alfanumerico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlfanumerico(AnswerParser.AlfanumericoContext ctx);
}