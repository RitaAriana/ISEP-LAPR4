package eapli.base.AGV.modules;

import eapli.base.AGV.domain.AGV;
import eapli.base.AGV.domain.AGVTask;

import java.util.ArrayList;
import java.util.List;

public class ControlSystem extends Thread {

    private final Thread csThread;

    private final MoveAGV moveAGV;

    private final AGV agv;

    public ControlSystem(final AGV agv) {
        csThread = new Thread(this);
        this.agv = agv;
        this.moveAGV = new MoveAGV(agv, WarehouseMovement.getWarehouseMovement(), this);
    }

    public Thread getControlSystemThread() {
        return csThread;
    }

    @Override
    public void run() {
        var taskList = agv.getAgvTask();
        List<AGVTask> oldList = new ArrayList<>();

        while (true) {
            taskList = agv.getAgvTask();
            if (oldList != taskList)
                taskService(taskList);
            oldList = taskList;
            try {
                sleep(100);
            } catch (Exception e) {
                System.out.println("There was an error when refreshing the Control System.");
            }

        }
    }

    private void taskService(List<AGVTask> taskList) {
        for (var task : taskList) {
            synchronized (this) {
                if (task.getStatus() == 1) {
                    var array = task.getLocation().split(",");
                    moveAGV.setCoordinates(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
                    task.updateStatus(2);
                    moveAGV.start();
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("There was an error when using the Task Service");
                    }
                }
            }
        }
    }

    public void disableLock() {
        synchronized (this) {
            notify();
        }
    }
}