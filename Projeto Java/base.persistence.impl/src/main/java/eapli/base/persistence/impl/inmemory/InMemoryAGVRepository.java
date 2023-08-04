package eapli.base.persistence.impl.inmemory;

import eapli.base.AGV.domain.AGV;
import eapli.base.AGV.domain.AGVId;
import eapli.base.AGV.domain.AGVStatus;
import eapli.base.AGV.repositories.AGVRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAGVRepository extends InMemoryDomainRepository<AGV, AGVId> implements AGVRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public int totalAGVs() {
        int count = 0;
        for (AGV agv : findAll()){
            count++;
        }
        return count;
    }

    @Override
    public Iterable<AGV> getAGVsAvaiable() {
        return match(e->e.getAgvStatus().obtainStatus().equals(AGVStatus.Status.FREE));
    }

    @Override
    public AGV getAGVById(AGVId agvId) {
        return matchOne(e->e.getAgvId().equals(agvId)).get();
    }

    @Override
    public AGV getAGVByIdSt(String agvId) {
        return null;
    }



}
