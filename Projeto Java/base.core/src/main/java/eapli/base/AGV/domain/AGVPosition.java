package eapli.base.AGV.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class AGVPosition implements ValueObject{

    private String agvPosition;

    public AGVPosition(String position) {
        this.agvPosition = position;
    }

    public AGVPosition() {}

    public String getAgvPosition() {
        return agvPosition;
    }

    public void setAgvPosition(String agvPosition) {
        this.agvPosition = agvPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AGVPosition)) return false;
        AGVPosition that = (AGVPosition) o;
        return Objects.equals(agvPosition, that.agvPosition);
    }

    @Override
    public String toString() {
        return "AGVPosition{" +
                "agvPosition='" + agvPosition + '\'' +
                '}';
    }
}
