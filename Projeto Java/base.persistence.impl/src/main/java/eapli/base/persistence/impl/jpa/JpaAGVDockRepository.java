package eapli.base.persistence.impl.jpa;

import eapli.base.warehouse.domain.AGVDock;
import eapli.base.warehouse.repositories.AGVDockRepository;

public class JpaAGVDockRepository extends BasepaRepositoryBase<AGVDock, String, String> implements AGVDockRepository {

    JpaAGVDockRepository(){super("Id");}

    @Override
    public int totalAGVDocks() {
        int count = 0;
        for (AGVDock agvDock : findAll()){
            count++;
        }
        return count;
    }
}
