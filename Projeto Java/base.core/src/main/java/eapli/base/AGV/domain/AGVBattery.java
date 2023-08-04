package eapli.base.AGV.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class AGVBattery implements ValueObject {

    private int battery;

    public AGVBattery(int batteryLevel){
        this.battery = batteryLevel;
    }

    protected AGVBattery(){

    }

    public int getBatteryLevel(){
        return battery;
    }

    public void decresyBatteryLevel(int decrements){
        if (this.battery >= decrements){
            battery -= decrements;
        }
    }

    public void chargeBattery(){
        this.battery = 100;

    }

    @Override
    public String toString() {
        return "AGVBattery{" +
                "battery=" + battery +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AGVBattery)) return false;
        AGVBattery that = (AGVBattery) o;
        return battery == that.battery;
    }

    @Override
    public int hashCode() {
        return Objects.hash(battery);
    }
}
