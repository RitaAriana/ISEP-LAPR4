package eapli.base.AGV.modules;

import eapli.base.AGV.domain.AGV;
import eapli.base.AGV.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class BatteryLevelControl {

    private final AGV agv;

    private final AGVRepository agvRepository;

    private static final int ACCEPTED_LEVEL = 10;

    public BatteryLevelControl(AGV agv) {
        this.agv = agv;
        this.agvRepository = PersistenceContext.repositories().agv();
    }

    public synchronized boolean isBateryBelowAcceptedLevel(){

        if (agv.getBattery().getBatteryLevel() <= ACCEPTED_LEVEL){
            returnToAGVDock();
            changeAGVStatus();
            return true;
        }

        return false;
    }

    private void returnToAGVDock(){
        agv.updateAGVPosition(agv.getAgvDock().getId());
    }

    private void changeAGVStatus(){
        agvRepository.save(agv);
        agv.changeStatusOfAGVForCharging();
    }


}
