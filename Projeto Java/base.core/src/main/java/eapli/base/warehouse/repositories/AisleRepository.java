package eapli.base.warehouse.repositories;

import eapli.base.warehouse.domain.Aisle;
import eapli.framework.domain.repositories.DomainRepository;

public interface AisleRepository extends DomainRepository<Long, Aisle> {

    int totalAisle();
}
