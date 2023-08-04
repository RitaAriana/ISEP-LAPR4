package eapli.base.persistence.impl.jpa;

import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.domain.WarehousePlant;
import eapli.base.warehouse.repositories.WarehousePlantRepository;

import javax.persistence.TypedQuery;

public class JpaWarehousePlantRepository extends BasepaRepositoryBase<WarehousePlant, Long, Long>
        implements WarehousePlantRepository {

    public JpaWarehousePlantRepository() {
        super("Id");
    }

    @Override
    public WarehousePlant findById(String id) {
        final TypedQuery<WarehousePlant> query = entityManager().createQuery(
                "SELECT d FROM WarehousePlant d  WHERE d.id = :id",
                WarehousePlant.class);
        query.setParameter("id", Long.parseLong(id));

        return query.getResultList().get(0);

    }
}