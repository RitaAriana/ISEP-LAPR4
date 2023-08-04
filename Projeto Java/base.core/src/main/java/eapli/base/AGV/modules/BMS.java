package eapli.base.AGV.modules;

import eapli.base.AGV.domain.AGV;

public class BMS extends Thread{

    private final BatteryLevelControl batteryLevelControl;

    public BMS(AGV agv){
        batteryLevelControl = new BatteryLevelControl(agv);
    }

    public void run(){

        while (!batteryLevelControl.isBateryBelowAcceptedLevel()){
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        notifyAll();
    }
}
