package eapli.base.persistence.impl.jpa;

import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.repositories.WarehouseRepository;

import javax.persistence.TypedQuery;

public class JpaWarehouseRepository extends BasepaRepositoryBase<Warehouse, Long, Long> implements WarehouseRepository {

    public JpaWarehouseRepository() {
        super("Id");
    }

    @Override
    public Warehouse findById(String id) {
        final TypedQuery<Warehouse> query = entityManager().createQuery(
                "SELECT d FROM Warehouse d  WHERE d.id = :id",
                Warehouse.class);
        query.setParameter("id", Long.parseLong(id));

        return query.getResultList().get(0);

    }
}
