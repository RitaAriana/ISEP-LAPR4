package eapli.base.persistence.impl.inmemory;

import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.repository.AnswerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAnswerRepository extends InMemoryDomainRepository<Answer, Long> implements AnswerRepository {
}
