package eapli.base.surveymanagement.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToOne
    private final Questionnaire questionnaire;


    protected Survey() {
        // for ORM only
        questionnaire = null;
    }

    public Survey(final Questionnaire questionnaire) {
        Preconditions.nonNull(questionnaire);
        this.questionnaire = questionnaire;
    }

    public Questionnaire questionnaire() {
        return questionnaire;
    }


}
