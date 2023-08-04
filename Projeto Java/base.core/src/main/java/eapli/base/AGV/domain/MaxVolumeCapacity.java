package eapli.base.AGV.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class MaxVolumeCapacity implements ValueObject {
    private Double maxVolumeCapacity;

    public MaxVolumeCapacity(final double maxVolumeCapacity)    {
        this.maxVolumeCapacity = maxVolumeCapacity;
    }

    public MaxVolumeCapacity() {}


    public Double getMaxVolumeCapacity() {
        return maxVolumeCapacity;
    }

    public void setMaxVolumeCapacity(Double maxVolumeCapacity) {
        this.maxVolumeCapacity = maxVolumeCapacity;
    }

    @Override
    public String toString() {
        return "MaxVolumeCapacity{" +
                "volume=" + maxVolumeCapacity +
                '}';
    }
}
