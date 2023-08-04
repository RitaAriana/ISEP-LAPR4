package eapli.base.AGV.domain;

import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskQueue {

    private Queue<AGVTask> queue;

    public TaskQueue(){
        this.queue = new LinkedList<>();
    }

    public void retrieveTasks(){
        List<AGVTask> taskList = (List<AGVTask>) PersistenceContext.repositories().agvTask().findAll();
        for(AGVTask task : taskList)
            if(task.getStatus() == 0)
                queue.add(task);
    }

    public boolean removeTask(AGVTask task){
        boolean result = queue.remove(task);
        return result;
    }

    public void displayTasks(){
        for(AGVTask task : queue)
            System.out.println(task);
    }

    public AGVTask getHead(){
        return queue.peek();
    }

}

