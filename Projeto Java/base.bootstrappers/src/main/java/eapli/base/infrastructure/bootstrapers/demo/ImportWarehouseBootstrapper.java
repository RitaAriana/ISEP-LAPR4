package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.warehouse.domain.JsonImport;
import eapli.framework.actions.Action;

public class ImportWarehouseBootstrapper extends BaseDemoBootstrapper implements Action {

    @Override
    public boolean execute() {
        importPlant();
        return true;
    }

    private boolean importPlant(){
        JsonImport jsonImport = new JsonImport();
        return jsonImport.importJson("Projeto Java/warehouse1.json");
    }
}
