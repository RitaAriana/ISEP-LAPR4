package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.domain.Aisle;
import eapli.base.warehouse.repositories.AisleRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAisleRepository extends InMemoryDomainRepository<Aisle, Long> implements AisleRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public int totalAisle() {
        int count = 0;
        for (Aisle aisle : findAll()){
            count++;
        }
        return count;
    }
}
