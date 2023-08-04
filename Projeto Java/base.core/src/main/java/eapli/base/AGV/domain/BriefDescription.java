package eapli.base.AGV.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class BriefDescription implements ValueObject {

    private String briefDescription;

    public BriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public BriefDescription(){}

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    @Override
    public String toString() {
        return "BriefDescription{" +
                "briefDescription='" + briefDescription + '\'' +
                '}';
    }
}