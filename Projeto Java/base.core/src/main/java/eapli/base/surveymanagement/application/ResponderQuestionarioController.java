package eapli.base.surveymanagement.application;

import eapli.base.clientmanagement.domain.Email;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr.AnswerMain;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.base.surveymanagement.repository.AnswerRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResponderQuestionarioController {

    private final ResponderQuestionarioService service = new ResponderQuestionarioService();
    private final AnswerRepository repository = PersistenceContext.repositories().answers();

    private String fileName;
    private Answer answer;

    public Iterable<QuestionnaireDTO> getUnansweredCustomerSurveys(String clientEmail) {
        return service.getUnansweredCustomerSurveys(clientEmail);
    }

    public SurveyDTO getSurvey(String surveyId){
        return service.getSurvey(surveyId);
    }

    public void writeFile(String surveyId,String answers){

        try {
            FileWriter myWriter = new FileWriter(getFileName(surveyId));
            myWriter.write(answers);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getFileName(String surveyId){
        fileName = "respostas/" + surveyId + ".txt";
        try {
            File myObj = new File(fileName);
            myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public void validateAnswer(String clientEmail, String surveyId,Long idSection, Long idQuestion){
        AnswerMain amain = new AnswerMain();
        answer = amain.parseWithVisitor(fileName);
        answer.modifyClientEmail(new Email(clientEmail));
        answer.modifyIdSurvey(new Identifier(surveyId));
        answer.modifyIdSection(idSection);
        answer.modifyIdQuestion(idQuestion);
        service.saveAnswer(answer);
    }


    public void finalizarResposta(String clientEmail,String surveyId) {
        service.finalizarResposta(clientEmail,surveyId);
    }

}
