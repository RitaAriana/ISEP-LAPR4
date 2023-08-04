package eapli.base.AGV.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class AGVId implements ValueObject, Comparable<AGVId> {

    private String agvId;

    public AGVId(String agvId) {
        this.agvId = agvId;
    }

    public AGVId() {}

    public String getAGVId() {
        return agvId;
    }

    public void setAGVId(String agvId) {
        this.agvId = agvId;
    }

    @Override
    public String toString() {
        return "AGVId{" +
                "id=" + agvId +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AGVId)) {
            return false;
        }

        final AGVId that = (AGVId) o;
        return this.agvId.equals(that.agvId);
    }

    @Override
    public int hashCode() {
        return this.agvId.hashCode();
    }

    @Override
    public int compareTo(final AGVId arg) {
        return agvId.compareTo(arg.agvId);
    }
}