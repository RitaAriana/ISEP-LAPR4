package eapli.base.AGV.modules;

import eapli.base.AGV.domain.AGV;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class MoveAGV extends Thread {

    private final AGV agv;

    private final WarehouseMovement whMovement;

    private static final int ACCEPTED_LEVEL_BATTERY = 38;

    private int desiredX;

    private int desiredY;

    private int speed;

    private final ControlSystem controlSystem;

    public MoveAGV(final AGV agv, final WarehouseMovement whMovement, final ControlSystem controlSystem) {
        this.agv = agv;
        this.whMovement = whMovement;
        this.speed = 0;
        this.controlSystem = controlSystem;
    }

    public void run() {
        agv.activateSensors();
        do {
            moveAGV();
        } while(speed == -1);
        var dock = agv.getAgvDock();
        setCoordinates(dock.getBegin().getBeginLSquare()-1, dock.getBegin().getBeginWSquare()-1);
        moveAGV();
        changeAGVStatus();
        chargeAGV();
        agv.deactivateSensors();
        controlSystem.disableLock();
    }

    private void moveAGV() {

        var array = agv.getPosition().getAgvPosition().split(",");
        var x = Integer.parseInt(array[0]);
        var y = Integer.parseInt(array[1]);
        var coordinate = WarehouseMovement.minDistance(whMovement.getGrid(), x, y, desiredX, desiredY);

        if(coordinate == null) {
            System.out.println("There is no available Path");
            speed = 0;
            return;
        }

        if (!checkBattery()){
            System.out.println("There is no sufficient battery to perform the trip");
            speed = 0;
            return;
        }

        if (x == desiredX && y == desiredY) {
            System.out.println("The AGV is already placed at the desired Location");
            speed = 0;
            return;
        }

        List<Coordinate> pathList = WarehouseMovement.backTrackPath(coordinate);
        for (var path : pathList) {
            array = agv.getPosition().getAgvPosition().split(",");
            x = Integer.parseInt(array[0]);
            y = Integer.parseInt(array[1]);
            updateGrid(path, x, y);

            if (!checkBattery()){
                System.out.println("There is no sufficient battery to perform the trip");
                speed = 0;
                return;
            }

            updateAGV(path);
            speed = getAction();
            changeSpeed();

            whMovement.printMatrix();

            if(path.getRow() == desiredX && path.getCol() == desiredY) {
                speed = 0;
                return;
            }
            try {
                if(speed != -1)
                    sleep(speed);
                else {
                    sleep(3000);
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("There was a problem regulating the AGV speed.");
            }
        }
    }

    protected void setCoordinates(final int desiredX, final int desiredY) {
        this.desiredX = desiredX;
        this.desiredY = desiredY;
    }

    private void updateAGV(final Coordinate path) {
        agv.updateAGVPosition(path.getRow() + "," + path.getCol());
        agv.getBattery().decresyBatteryLevel(1);
        updateDatabase();
    }

    private void updateGrid(final Coordinate path, final int x, final int y) {
        whMovement.updateGrid(x, y, path.getRow(), path.getCol());
    }

    private void updateDatabase() {
        var repo = PersistenceContext.repositories().newTransactionalContext();
        repo.beginTransaction();
        PersistenceContext.repositories().agv().save(agv);
        repo.commit();
    }

    private void changeAGVStatus(){
        agv.changeStatusOfAGVForCharging();
        updateDatabase();
    }

    private void chargeAGV(){
        agv.setSpeed(speed);
        agv.getBattery().chargeBattery();
        updateDatabase();
    }

    private int getAction(){
        int best = -1, control;

        var sensorList = agv.getSensors();

        for (var sensor : sensorList){
            control = sensor.getControl();
            if(best < control)
                best = control;
            sensor.disableLock();
        }

        if(best == 0)
            return 1000;
        else if(best == 1)
            return 2000;
        else
            return -1;
    }

    private boolean checkBattery(){
        return agv.getBattery().getBatteryLevel() > ACCEPTED_LEVEL_BATTERY;
    }

    private void changeSpeed(){
        agv.setSpeed(speed/1000);
        updateDatabase();
    }
}
