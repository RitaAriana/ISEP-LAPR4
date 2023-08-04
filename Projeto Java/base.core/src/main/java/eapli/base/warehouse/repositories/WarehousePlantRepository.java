package eapli.base.warehouse.repositories;

import eapli.base.warehouse.domain.WarehousePlant;
import eapli.framework.domain.repositories.DomainRepository;

public interface WarehousePlantRepository extends DomainRepository<Long, WarehousePlant> {
    WarehousePlant findById(String id);
}