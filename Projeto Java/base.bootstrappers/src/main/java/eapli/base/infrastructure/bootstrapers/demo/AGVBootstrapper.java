package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.AGV.application.ConfigureAGVController;
import eapli.base.warehouse.domain.AGVDock;
import eapli.framework.actions.Action;

import java.util.List;

public class AGVBootstrapper extends BaseDemoBootstrapper implements Action {

    private final ConfigureAGVController configureAGVController = new ConfigureAGVController();

    @Override
    public boolean execute() {
        createAGV();
        return true;
    }

    private boolean createAGV(){
        List<AGVDock> list = (List<AGVDock>) configureAGVController.configureAGVDock();

        configureAGVController.configureAGV("12345678","AGV1","ASD56S",30.0,100.0,5.0,list.get(0).getBegin().getBeginLSquare() + "," + list.get(0).getBegin().getBeginWSquare(), list.get(0));
        configureAGVController.configureAGV("12347678","AGV2","ASD56A",35.0,35.0,4.0,list.get(1).getBegin().getBeginLSquare() + "," + list.get(1).getBegin().getBeginWSquare(), list.get(1));
        configureAGVController.configureAGV("12345688","AGV3","ASD56B",40.0,25.0,6.0,list.get(2).getBegin().getBeginLSquare() + "," + list.get(2).getBegin().getBeginWSquare(), list.get(2));
        configureAGVController.configureAGV("12445678","AGV4","ASD56C",10.0,250.0,7.0,list.get(3).getBegin().getBeginLSquare() + "," + list.get(3).getBegin().getBeginWSquare(), list.get(3));
        configureAGVController.configureAGV("11345678","AGV5","ASD56D",100.0,27.0,8.0,list.get(4).getBegin().getBeginLSquare() + "," + list.get(4).getBegin().getBeginWSquare(), list.get(4));

        return true;
    }





}
