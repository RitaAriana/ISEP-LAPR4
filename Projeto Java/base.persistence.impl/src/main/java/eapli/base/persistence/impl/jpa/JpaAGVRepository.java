package eapli.base.persistence.impl.jpa;

import eapli.base.AGV.domain.AGV;
import eapli.base.AGV.domain.AGVId;
import eapli.base.AGV.domain.AGVStatus;
import eapli.base.AGV.repositories.AGVRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaAGVRepository extends JpaAutoTxRepository<AGV, AGVId, AGVId> implements AGVRepository {

    public JpaAGVRepository(String persistenceName, String name) {
        super(persistenceName, name);
    }

    public JpaAGVRepository(TransactionalContext autoTx, String name){
        super(autoTx, name);
    }

    @Override
    public Iterable<AGV> getAGVsAvaiable() {

        final TypedQuery<AGV> query = entityManager().createQuery(
                "SELECT d FROM AGV d  WHERE d.agvStatus = :status",
                AGV.class);
        query.setParameter("status", new AGVStatus(AGVStatus.Status.FREE));

        return query.getResultList();
    }


    @Override
    public AGV getAGVById(final AGVId agvId) {
        final TypedQuery<AGV> query = super.createQuery(
                "SELECT d FROM AGV d  WHERE agvId ='" + agvId.getAGVId() + "'",
                AGV.class);

        return query.getSingleResult();
    }

    @Override
    public AGV getAGVByIdSt(final String agvId) {
        final TypedQuery<AGV> query = super.createQuery(
                "SELECT d FROM AGV d  WHERE agvId ='" + agvId + "'",
                AGV.class);

        return query.getSingleResult();
    }

    @Override
    public int totalAGVs() {
        int count = 0;
        for (AGV agv : findAll()){
            count++;
        }
        return count;
    }
}
