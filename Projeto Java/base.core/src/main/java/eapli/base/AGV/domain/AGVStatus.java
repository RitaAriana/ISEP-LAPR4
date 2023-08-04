package eapli.base.AGV.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

public class AGVStatus implements ValueObject, Serializable{

    private static final long serialVersionUID = 1L;

    public enum Status {
        FREE,
        CHARGING,
        OCCUPIED_SERVING,
        GIVEN_ORDER,
        MAINTENANCE
    }

    @Enumerated(EnumType.STRING)
    private Status AGVStatus;

    public AGVStatus(Status AGVStatus) {
        this.AGVStatus = AGVStatus;
    }

    public AGVStatus(){

    }

    public AGVStatus.Status obtainStatus() {
        return AGVStatus;
    }

    public void changeStatusOfAGVForOccupied(){
        this.AGVStatus = Status.OCCUPIED_SERVING;
    }

    public void changeStatusOfAGVForFree(){
        this.AGVStatus = Status.FREE;
    }

    public void changeStatusOfAGVForCharging(){
        this.AGVStatus = Status.CHARGING;
    }

    public void changeStatusOfAGVForMaintenance(){
        this.AGVStatus = Status.MAINTENANCE;
    }

    public void changeStatusOfAGVForGivenOrder(){
        this.AGVStatus = Status.GIVEN_ORDER;
    }

}

