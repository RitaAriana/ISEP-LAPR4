package eapli.base.surveymanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr.QuestionnaireMain;
import eapli.base.surveymanagement.domain.Criterio;
import eapli.base.surveymanagement.domain.Period;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Restricao;
import eapli.base.surveymanagement.repository.SurveyRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class CreateNewQuestionnaireController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final SurveyRepository surveyRepository = PersistenceContext.repositories().surveys();
    private final AtribuirQuestionarioAosClientesService atribuirQuestionarioAosClientesService = new AtribuirQuestionarioAosClientesService();

    public Questionnaire createQuestionnaire(final String file, final Calendar finalDate, final List<Criterio> criterios) throws IOException{
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);

        QuestionnaireMain qmain = new QuestionnaireMain();
        Questionnaire questionnaire = qmain.parseWithVisitor(file);
        Period period = new Period(finalDate);
        questionnaire.modifyPeriod(period);

        for (Criterio criterio  : criterios){
            questionnaire.modifyRestricao(new Restricao(criterio));
        }

        surveyRepository.save(questionnaire);

        return null;

    }
}
