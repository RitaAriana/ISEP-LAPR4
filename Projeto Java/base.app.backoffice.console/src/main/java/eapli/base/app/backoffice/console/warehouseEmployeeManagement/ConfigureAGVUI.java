package eapli.base.app.backoffice.console.warehouseEmployeeManagement;

import eapli.base.AGV.application.ConfigureAGVController;
import eapli.base.AGV.domain.AGVStatus;
import eapli.base.warehouse.domain.AGVDock;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;


/**
 * UI for configuring a warehouse AGV
 *
 * Created by Pedro Rocha
 */
public class ConfigureAGVUI extends AbstractUI {
    private final ConfigureAGVController configureAGVController = new ConfigureAGVController();


    @Override
    protected boolean doShow() {

        final String agvId = Console.readLine("AGV Id: (8 chars)");
        final String briefDescription = Console.readLine("Brief Description: (30max)");
        final String model = Console.readLine("Model: (50max)");
        final String maxWeightCapacity = Console.readLine("Max Weight Capacity: (kg)");
        final String maxVolumeCapacity = Console.readLine("Max Volume Capacity: (cm3)");
        final String range = Console.readLine("Range: (hours)");
        final String position = Console.readLine("Position:");


        boolean flag = configureAGVController.validateData(agvId, briefDescription, model, maxWeightCapacity, maxVolumeCapacity, range, position);
        if(!flag){
            throw new IllegalArgumentException();
        }

        List<AGVDock> list = (List<AGVDock>) configureAGVController.configureAGVDock();
        int index = 1;
        for(AGVDock agvDock: list) {
            System.out.println(index + " - " + agvDock.getId());
            index++;
        }
        int a = Integer.parseInt(Console.readLine("Choose an agvdock"));
        AGVDock dock = list.get(a-1);

        Boolean flag1 = false;
        if(configureAGVController.configureAGV(agvId,briefDescription,model,Double.parseDouble(maxWeightCapacity), Double.parseDouble(maxVolumeCapacity), Double.parseDouble(range), position, dock)==null){
            System.out.println("AGV Dock occupied");
            flag1 = true;

        }
        if(!flag1){
            System.out.println("*================== AGV Created ================*");
            System.out.printf("AGVId: %s; \nBrief Description: %s; \nModel: %s \nMax Weight Capacity: %s \nMax Volume Capacity: %s \nRange: %s \nPosition: %s \nDock ID: %s\nStatus: %s\n",
                    agvId,briefDescription,model,maxWeightCapacity,maxVolumeCapacity,range,position,dock.getId(), AGVStatus.Status.FREE);
        }

        return true;
    }

    @Override
    public String headline() {
        return "Register an AGV";
    }

}
