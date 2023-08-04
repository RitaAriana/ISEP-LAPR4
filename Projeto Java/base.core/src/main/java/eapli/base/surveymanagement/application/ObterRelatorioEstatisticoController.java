package eapli.base.surveymanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;
import eapli.base.surveymanagement.repository.AnswerRepository;
import eapli.base.surveymanagement.repository.SurveyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ObterRelatorioEstatisticoController {

    private ListQuestionnaireDTOService service = new ListQuestionnaireDTOService();
    private SurveyRepository surveyRepository = PersistenceContext.repositories().surveys();
    private AnswerRepository answerRepository = PersistenceContext.repositories().answers();

    public Iterable<QuestionnaireDTO> findAllQuestionnaires() {
        return service.getSurveys();
    }

    public int obterQuantidadeClientesInquiridos(String id) {
        Optional<Questionnaire> questionnaire = surveyRepository.findByIdentifier(new Identifier(id));
        return questionnaire.get().getQuantityInquiredCustomers();
    }

    public int obterQuantidadeRespostas(String id) {
        Optional<Questionnaire> questionnaire = surveyRepository.findByIdentifier(new Identifier(id));
        return questionnaire.get().getAmountAnswered();
    }

    public List<Question> obterQuestoes(String id) {
        Optional<Questionnaire> questionnaire = surveyRepository.findByIdentifier(new Identifier(id));
        List<Question> questions = new ArrayList<>();
        for (Section section : questionnaire.get().getSections()){
            for (Question question: section.getQuestions()){
                questions.add(question);
            }
        }
        return questions;
    }

    public int obterQuantidadeRespostasOpcao(Long questionId, Long op, String surveyId) {
        int num = 0;
        for (Answer answer : answerRepository.findAll()){
            if (answer.getIdSurvey().toString().equals(surveyId)){
                if (answer.getIdQuestion().equals(questionId)){
                    for (String as : answer.getRespostas()){
                        if (as.length()<=2){
                            if (op.equals(Long.parseLong(as))){
                                num++;
                            }
                        }

                    }
                }
            }
        }
        return num;
    }


    public int obterQuantClientesRespondeuPergunta(Long questionId, String surveyId){
        int num = 0;
        for (Answer answer : answerRepository.findAll()){
            if (answer.getIdSurvey().toString().equals(surveyId)){
                if (answer.getIdQuestion().equals(questionId)) {
                    num++;
                }
            }
        }
        return num;
    }

    public double obterRespostaMedia(Long questionId, String id) {
        double num = 0;
        double soma=0;
        for (Answer answer : answerRepository.findAll()){
            if (answer.getIdSurvey().toString().equals(id)){
                if (answer.getIdQuestion().equals(questionId)) {
                    for (String respostas:answer.getRespostas()){
                        int indexInicial = respostas.indexOf("[");
                        int indexFinal = respostas.indexOf("]");
                        String resultado = respostas.substring(indexInicial + 1, indexFinal);
                        soma+=Double.parseDouble(resultado);
                        num++;
                    }
                }
            }
        }
        return (soma/num);
    }

    public int obterQuantidadeRespostasOutra(Long questionId, Long op, String id) {
        int aux = 0;
        for (Answer answer : answerRepository.findAll()) {
            if (answer.getIdSurvey().toString().equals(id)) {
                if (answer.getIdQuestion().equals(questionId)) {
                    for (String as : answer.getRespostas()){
                        if (as.length() > 2){
                            aux++;
                        }
                    }
                }
            }
        }
        return aux;
    }

    public int obterPercentagemPorLugar(int lugar, Long question, Long op, String id) {
        int num = 0;
        for (Answer answer : answerRepository.findAll()) {
            if (answer.getIdSurvey().toString().equals(id)) {
                if (answer.getIdQuestion().equals(question)) {
                    if (!answer.getRespostas().get(lugar).isBlank()){
                        if (op == Long.parseLong(answer.getRespostas().get(lugar))){
                            num++;
                        }
                    }
                }
            }
        }
        return num;
    }

    public int obterNumeroEscalaOpcao(Long question, String scale, int index,String id) {
        int num = 0;
        StringBuilder s = new StringBuilder();
        s.append(scale);
        for (Answer answer : answerRepository.findAll()) {
            if (answer.getIdSurvey().toString().equals(id)) {
                if (answer.getIdQuestion().equals(question)) {
                    if (answer.getRespostas().get(index).equals(s.toString())) {
                        num++;
                    }
                }
            }
        }
        return num;
    }
}
