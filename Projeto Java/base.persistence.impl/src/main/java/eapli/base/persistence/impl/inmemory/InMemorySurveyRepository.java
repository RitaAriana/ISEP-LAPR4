package eapli.base.persistence.impl.inmemory;

import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.repository.SurveyRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemorySurveyRepository extends InMemoryDomainRepository<Questionnaire, Long>
        implements SurveyRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Questionnaire> findByIdentifier(Identifier identifier) {
        return Optional.empty();
    }
}
