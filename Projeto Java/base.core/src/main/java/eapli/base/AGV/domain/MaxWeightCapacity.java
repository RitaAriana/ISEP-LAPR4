package eapli.base.AGV.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class MaxWeightCapacity implements ValueObject {

    private Double maxWeightCapacity;

    public MaxWeightCapacity(Double maxWeightCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
    }

    public MaxWeightCapacity(){}

    public Double getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public void setMaxWeightCapacity(Double maxWeightCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
    }

    @Override
    public String toString() {
        return "MaxWeightCapacity{" +
                "maxWeightCapacity=" + maxWeightCapacity +
                '}';
    }


}
