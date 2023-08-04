package eapli.base.persistence.impl.jpa;


import eapli.base.warehouse.domain.Shelf;
import eapli.base.warehouse.domain.ShelfId;
import eapli.base.warehouse.repositories.ShelfRepository;

public class JpaShelfRepository extends BasepaRepositoryBase<Shelf, ShelfId, ShelfId> implements ShelfRepository {

    public JpaShelfRepository() { super("Id");}
}
