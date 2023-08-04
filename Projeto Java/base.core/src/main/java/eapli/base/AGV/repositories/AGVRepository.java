package eapli.base.AGV.repositories;

import eapli.base.AGV.domain.AGV;
import eapli.base.AGV.domain.AGVId;
import eapli.framework.domain.repositories.DomainRepository;

public interface AGVRepository extends DomainRepository<AGVId, AGV> {

    int totalAGVs();

    Iterable<AGV> getAGVsAvaiable();

    AGV getAGVById(AGVId agvId);

    AGV getAGVByIdSt(String agvId);



}
