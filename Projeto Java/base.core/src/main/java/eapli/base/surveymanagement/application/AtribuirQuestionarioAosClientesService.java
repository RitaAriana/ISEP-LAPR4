package eapli.base.surveymanagement.application;

import eapli.base.clientmanagement.domain.Client;
import eapli.base.clientmanagement.repositories.ClientRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Restricao;
import eapli.base.surveymanagement.repository.SurveyRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public class AtribuirQuestionarioAosClientesService {

    ClientRepository clientRepository = PersistenceContext.repositories().client();
    SurveyRepository surveyRepository = PersistenceContext.repositories().surveys();

    @Transactional
    public int assignQuestionnaireToCustomers(Questionnaire questionnaire){
        Optional<Questionnaire> temp = surveyRepository.findByIdentifier(questionnaire.getSurveyId());
        int aux = 0;
        for (Restricao restricao: temp.get().restricoes()){
            if(restricao.criterio().name().equals("NONE")){
                Iterable<Client> clients = clientRepository.findAll();
                for (Client client :  clients){
                    client.addUnansweredQuestionnaire(temp.get());
                    clientRepository.save(client);
                    temp.get().addQuantityInquiredCustomers(1);
                }
            } else if (restricao.criterio().name().equals("ORDER")){

            } else if (restricao.criterio().name().equals("PRODUCT")){

            } else {

            }
        }
        surveyRepository.save(temp.get());
        return aux;
    }
}
