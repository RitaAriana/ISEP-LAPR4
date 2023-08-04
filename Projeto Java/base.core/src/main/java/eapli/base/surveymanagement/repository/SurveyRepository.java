package eapli.base.surveymanagement.repository;

import eapli.base.clientmanagement.domain.Client;
import eapli.base.clientmanagement.domain.Email;
import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.Id;
import java.util.Optional;

public interface SurveyRepository extends DomainRepository<Long, Questionnaire> {

    Optional<Questionnaire> findByIdentifier(Identifier identifier);

}
