package eapli.base.persistence.impl.jpa;

import eapli.base.AGV.domain.AGVTask;
import eapli.base.AGV.repositories.AGVTaskRepository;

public class JPAAGVTaskRepository extends BasepaRepositoryBase<AGVTask, Long, Long>
        implements AGVTaskRepository {

    public JPAAGVTaskRepository() {
        super("Id");
    }
}
