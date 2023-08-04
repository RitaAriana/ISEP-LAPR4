package eapli.base.AGV.application;

import eapli.base.AGV.domain.AGV;
import eapli.base.AGV.domain.AGVStatus;
import eapli.base.AGV.domain.AGVTask;
import eapli.base.AGV.domain.TaskQueue;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class TaskManagement {

    private final TaskQueue taskQueue;

    public TaskManagement(){
        this.taskQueue = new TaskQueue();
    }
    
    public boolean assignTasks(){
        List<AGV> agvList = (List<AGV>) PersistenceContext.repositories().agv().findAll();
        removeUnfittedAGVs(agvList);

        taskQueue.retrieveTasks();

        AGVTask agvTask;

        for(AGV agv : agvList){
            try {
                agvTask = taskQueue.getHead();
            } catch (Exception e){
                agvTask = null;
            }

            boolean available = true;
            for(AGVTask task : agv.getAgvTask()){
                if(task.getStatus() == 1) {
                    available = false;
                    break;
                }
            }

            if(available) {
                agv.changeStatusOfAGVForOccupied();
                agvTask.updateStatus(1);
                agv.assignATaskForAGV(agvTask);
                PersistenceContext.repositories().agvTask().save(agvTask);
                PersistenceContext.repositories().agv().save(agv);
                taskQueue.removeTask(agvTask);
            }
        }
        return true;
    }

    private void removeUnfittedAGVs(List<AGV> agvList){
        agvList.removeIf(agv -> !(agv.getAgvStatus().obtainStatus().equals(AGVStatus.Status.FREE)));
    }
}
