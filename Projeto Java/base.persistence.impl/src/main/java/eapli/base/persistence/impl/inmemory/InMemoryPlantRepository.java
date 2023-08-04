package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.domain.WarehousePlant;
import eapli.base.warehouse.repositories.WarehousePlantRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryPlantRepository extends InMemoryDomainRepository<WarehousePlant, Long> implements WarehousePlantRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public WarehousePlant findById(String id) {
        return matchOne(e->e.identity() == Long.parseLong(id)).get();
    }
}
