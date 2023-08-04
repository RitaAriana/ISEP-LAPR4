package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.domain.Bin;
import eapli.base.warehouse.domain.BinId;
import eapli.base.warehouse.repositories.BinRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryBinRepository extends InMemoryDomainRepository<Bin, BinId> implements BinRepository {

    static {
        InMemoryInitializer.init();
    }
}
