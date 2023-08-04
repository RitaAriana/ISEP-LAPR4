package eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr;

import eapli.base.surveymanagement.domain.Answer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class AnswerMain {

    public static Answer parseWithVisitor(String file) {
        try {
            AnswerLexer lexer = new AnswerLexer(CharStreams.fromFileName(file));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            AnswerParser parser = new AnswerParser(tokens);
            ParseTree tree = parser.start();
            AnswerVisitor eval = new AnswersVisitor();
            Answer answer = (Answer) eval.visit(tree);
            return answer;
        } catch(IOException e) {
            System.out.println("Make sure the file has the correct path");
        } catch (Exception e) {
            System.out.println("The Answer does not follow the required format.");
        }
        return null;
    }

    public static void main(String[] args) {
        parseWithVisitor("respostas/resposta.txt");
    }

}