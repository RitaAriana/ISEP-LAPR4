package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.repositories.WarehouseRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryWarehouseRepository extends InMemoryDomainRepository<Warehouse, Long> implements WarehouseRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Warehouse findById(String id) {
        return matchOne(e->e.identity() == Long.parseLong(id)).get();
    }
}
