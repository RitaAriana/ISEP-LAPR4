package eapli.base.surveymanagement.application;


import eapli.base.clientmanagement.domain.Client;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.dto.ProductDTO;
import eapli.base.productmanagement.repository.ProductRepository;
import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.base.surveymanagement.repository.SurveyRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * An application service to avoid code duplication.
 *
 * @author Rita Ariana Sobral
 *
 */
public class ListQuestionnaireDTOService {

    private final SurveyRepository surveyRepository = PersistenceContext.repositories().surveys();

    public Iterable<QuestionnaireDTO> getUnansweredSurveys(Client client) {

        final Iterable<Survey> questionnaires = client.getUnansweredQuestionnaires();

        final List<Questionnaire> questionnairesList = new ArrayList<>();

        for (Survey survey: questionnaires){
            questionnairesList.add(survey.questionnaire());
        }

        // transform for the presentation layer
        final List<QuestionnaireDTO> ret = new ArrayList<>();
        questionnairesList.forEach(e -> ret.add(e.toDTO()));
        return ret;
    }

    public SurveyDTO getSurvey(String surveyId) {

        Optional<Questionnaire> questionnaire = surveyRepository.findByIdentifier(new Identifier(surveyId));

        return questionnaire.get().toDto();

    }

    public Iterable<QuestionnaireDTO> getSurveys() {
        final Iterable<Questionnaire> questionnaires = surveyRepository.findAll();

        // transform for the presentation layer
        final List<QuestionnaireDTO> ret = new ArrayList<>();
        questionnaires.forEach(e -> ret.add(e.toDTO()));
        return ret;
    }
}
