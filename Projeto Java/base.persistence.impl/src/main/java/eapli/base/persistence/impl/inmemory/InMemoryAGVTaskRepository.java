package eapli.base.persistence.impl.inmemory;

import eapli.base.AGV.domain.AGVTask;
import eapli.base.AGV.repositories.AGVTaskRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;


public class InMemoryAGVTaskRepository extends InMemoryDomainRepository<AGVTask, Long> implements AGVTaskRepository {

    static {
        InMemoryInitializer.init();
    }
}
