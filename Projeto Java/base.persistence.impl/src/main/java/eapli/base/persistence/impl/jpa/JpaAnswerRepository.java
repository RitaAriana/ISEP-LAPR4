package eapli.base.persistence.impl.jpa;

import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.repository.AnswerRepository;

public class JpaAnswerRepository extends BasepaRepositoryBase<Answer, Long, Long> implements AnswerRepository {

    JpaAnswerRepository() {
        super("id");
    }
}
