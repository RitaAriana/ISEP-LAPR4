package eapli.base.warehouse.repositories;

import eapli.base.warehouse.domain.Warehouse;
import eapli.framework.domain.repositories.DomainRepository;

public interface WarehouseRepository extends DomainRepository<Long, Warehouse> {

    Warehouse findById(String id);

}
