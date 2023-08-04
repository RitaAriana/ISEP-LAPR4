package eapli.base.AGV.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class Range implements ValueObject {
    private Double range;

    public Range(Double range) {
        this.range = range;
    }

    public Range(){}

    public Double getRange() {
        return range;
    }

    @Override
    public String toString() {
        return "Range{" +
                "range=" + range +
                '}';
    }
}
