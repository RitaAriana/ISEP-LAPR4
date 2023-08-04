package eapli.base.warehouse.repositories;

import eapli.base.warehouse.domain.AGVDock;
import eapli.framework.domain.repositories.DomainRepository;

public interface AGVDockRepository extends DomainRepository<String, AGVDock> {

    int totalAGVDocks();
}
