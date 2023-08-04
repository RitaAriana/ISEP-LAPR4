package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouse.domain.Shelf;
import eapli.base.warehouse.domain.ShelfId;
import eapli.base.warehouse.repositories.ShelfRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryShelfRepository extends InMemoryDomainRepository<Shelf, ShelfId> implements ShelfRepository {

    static {
        InMemoryInitializer.init();
    }
}
