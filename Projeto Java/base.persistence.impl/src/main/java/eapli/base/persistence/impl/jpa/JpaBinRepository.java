package eapli.base.persistence.impl.jpa;

import eapli.base.warehouse.domain.Bin;
import eapli.base.warehouse.domain.BinId;
import eapli.base.warehouse.repositories.BinRepository;

public class JpaBinRepository extends BasepaRepositoryBase<Bin, BinId, BinId> implements BinRepository {

    public JpaBinRepository() { super("Id");}
}
