package eapli.base.app.backoffice.console.taskManagement;

import eapli.base.AGV.application.CallAGVManagerController;
import eapli.base.AGV.application.TaskManagement;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class TaskManagementUI extends AbstractUI {

    private final CallAGVManagerController controller = new CallAGVManagerController();

    @Override
    protected boolean doShow() {
        try {
            controller.connectDaemon(8890);
            controller.callFIFO();
            System.out.println("The automatic task assignment service has been called");
        } catch (IOException e) {
            System.out.println("There was an error when executing the Algorithm Call");
        } finally{
            try {
                controller.closeConnection();
            } catch (IOException e) {
                System.out.println("There was an error when closing the connection");
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "Automatically assign Tasks to AGV's";
    }
}
