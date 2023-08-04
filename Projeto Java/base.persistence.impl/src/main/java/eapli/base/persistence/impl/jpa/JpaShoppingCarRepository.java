package eapli.base.persistence.impl.jpa;

import eapli.base.clientmanagement.domain.Client;
import eapli.base.shoppingcarmanagement.domain.ShoppingCar;
import eapli.base.shoppingcarmanagement.repository.ShoppingCarRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaShoppingCarRepository extends BasepaRepositoryBase<ShoppingCar, Long, Long>
        implements ShoppingCarRepository {

    JpaShoppingCarRepository() {
        super("shoppingCarId");
    }

    @Override
    public Optional<ShoppingCar> findByClient(Client client) {
        final Map<String, Object> params = new HashMap<>();
        params.put("client", client);
        return matchOne("e.client=:client", params);
    }
}
