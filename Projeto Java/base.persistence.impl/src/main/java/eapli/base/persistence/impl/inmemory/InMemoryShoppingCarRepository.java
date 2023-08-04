package eapli.base.persistence.impl.inmemory;

import eapli.base.clientmanagement.domain.Client;
import eapli.base.shoppingcarmanagement.domain.ShoppingCar;
import eapli.base.shoppingcarmanagement.repository.ShoppingCarRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryShoppingCarRepository extends InMemoryDomainRepository<ShoppingCar, Long>
        implements ShoppingCarRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<ShoppingCar> findByClient(Client client) {
        return matchOne(e -> e.equals(client));
    }
}
