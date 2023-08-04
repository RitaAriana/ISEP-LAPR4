package eapli.base.AGV.application;

import eapli.base.AGV.domain.AGV;
import eapli.base.AGV.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;


public class GetAGVInformation implements AGVDigitalTwinController{

    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();

    public String getAGVsInformationForDashBoard(String agvID){
        AGV agv = agvRepository.getAGVByIdSt(agvID);

        return String.format("%s,%s,%s,", agv.getAgvId().getAGVId(), agv.getAgvPosition().getAgvPosition(), agv.getAgvStatus().obtainStatus().name());
    }
}
