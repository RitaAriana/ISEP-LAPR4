package eapli.base.app.backoffice.console.warehouseEmployeeManagement;

import eapli.base.AGV.application.DashBoardController;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class DashboardUI extends AbstractUI {

    private final DashBoardController theController = new DashBoardController();


    @Override
    protected boolean doShow() {

        try {

            theController.runDashboard();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public String headline() {
        return "Opening dashboard";
    }
}
