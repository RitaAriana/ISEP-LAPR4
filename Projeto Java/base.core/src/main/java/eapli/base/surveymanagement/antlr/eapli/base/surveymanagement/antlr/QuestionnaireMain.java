package eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr;

import eapli.base.surveymanagement.domain.Questionnaire;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class QuestionnaireMain {

    public static Questionnaire parseWithVisitor(String file) {
        try {
            SurveyLexer lexer = new SurveyLexer(CharStreams.fromFileName(file));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SurveyParser parser = new SurveyParser(tokens);
            ParseTree tree = parser.start();
            SurveyVisitor eval = new QuestionnaireVisitor();
            return (Questionnaire) eval.visit(tree);
        } catch(IOException e) {
            System.out.println("Make sure the file has the correct path");
        } catch (Exception e) {
            System.out.println("The Survey does not follow the required format.");
        }
        return null;
    }

    public static void main(String[] args) {
        parseWithVisitor("questionario.txt");
    }

}