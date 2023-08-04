package eapli.base.app.backoffice.console.presentation.authz;

import eapli.base.warehouse.application.ImportJsonController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 * The ImportJsonUi, which allows the User to import a file containing all the info from a warehouse (.json)
 *
 * @author Francisco Redol (1201239@isep.ipp.pt)
 */
public class ImportJsonUI extends AbstractUI {

    private final ImportJsonController importJsonController = new ImportJsonController();

    @Override
    protected boolean doShow() {

        String fileName = Console.readLine("Please Insert the .json file containing the Warehouse info: ");

        boolean operationSuccess = importJsonController.importWarehouse(fileName);

        if(operationSuccess) {
            System.out.println("The .json file was successfully imported!");
            return true;
        } else {
            System.out.println("The operation was aborted.\n");
            return false;
        }
    }

    @Override
    public String headline() {
        return "Import a Warehouse's info.";
    }
}
