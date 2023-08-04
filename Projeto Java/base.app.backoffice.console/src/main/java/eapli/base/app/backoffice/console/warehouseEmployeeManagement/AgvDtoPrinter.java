package eapli.base.app.backoffice.console.warehouseEmployeeManagement;

import eapli.base.AGV.dto.AgvDto;
import eapli.framework.visitor.Visitor;

public class AgvDtoPrinter implements Visitor {

    @Override
    public void visit(Object visitee) {
        AgvDto agvDto = (AgvDto) visitee;
        System.out.printf("AGV ID - %s\n", agvDto.id);
    }
}
