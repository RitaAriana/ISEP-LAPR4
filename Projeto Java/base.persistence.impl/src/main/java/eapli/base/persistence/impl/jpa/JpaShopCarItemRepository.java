package eapli.base.persistence.impl.jpa;

import eapli.base.shoppingcarmanagement.domain.ShopCarItem;
import eapli.base.shoppingcarmanagement.repository.ShopCarItemRepository;


public class JpaShopCarItemRepository extends BasepaRepositoryBase<ShopCarItem,Long,Long>
implements ShopCarItemRepository {
    JpaShopCarItemRepository() {
        super("shopCarId");
    }
}
