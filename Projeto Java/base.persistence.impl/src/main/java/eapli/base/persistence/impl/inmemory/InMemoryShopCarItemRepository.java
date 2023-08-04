package eapli.base.persistence.impl.inmemory;

import eapli.base.shoppingcarmanagement.domain.ShopCarItem;
import eapli.base.shoppingcarmanagement.repository.ShopCarItemRepository;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryShopCarItemRepository extends InMemoryDomainRepository<ShopCarItem, Long>
implements ShopCarItemRepository {

    static {
        InMemoryInitializer.init();
    }
}
