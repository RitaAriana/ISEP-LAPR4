package eapli.base.persistence.impl.jpa;

import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.repository.SurveyRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaSurveyRepository extends BasepaRepositoryBase<Questionnaire, Long, Long>
        implements SurveyRepository {

    JpaSurveyRepository() {
        super("idBaseDeDados");
    }

    @Override
    public Optional<Questionnaire> findByIdentifier(Identifier surveyId) {
        final Map<String, Object> params = new HashMap<>();
        params.put("surveyId", surveyId);
        return matchOne("e.surveyId=:surveyId", params);
    }
}
