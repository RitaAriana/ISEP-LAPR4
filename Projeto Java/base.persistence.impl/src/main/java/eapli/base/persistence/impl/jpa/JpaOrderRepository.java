package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.OrderStatus;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repository.OrderRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaOrderRepository extends JpaAutoTxRepository<ProductOrder, Long, Long>
    implements OrderRepository {


    public JpaOrderRepository(String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),"eapli.base");
    }


    public JpaOrderRepository(TransactionalContext autoTx, String name) {
        super(autoTx, name);
    }

    @Override
    public ProductOrder getOrderById (Long id){
        final TypedQuery<ProductOrder> query = super.createQuery(
                "SELECT d FROM ProductOrder d WHERE orderid = '" + id + "'",
                ProductOrder.class);
        return query.getSingleResult();

    }


    @Override
    public Iterable<ProductOrder> getOrdersWhoNeedToBePrepared () {
        final TypedQuery<ProductOrder> query = entityManager().createQuery(
                "SELECT d FROM ProductOrder d  WHERE d.status = :status",
                ProductOrder.class);
        query.setParameter("status", new OrderStatus(OrderStatus.Status.TO_BE_PREPARED));

        return query.getResultList();
    }

    @Override
    public Iterable<ProductOrder> findOrdersDispatchedForCustomerDelivery() {
        final TypedQuery<ProductOrder> query = entityManager().createQuery(
                "SELECT d FROM ProductOrder d  WHERE d.status = :status",
                ProductOrder.class);
        query.setParameter("status", new OrderStatus(OrderStatus.Status.DISPATCHED_FOR_COSTUMER));

        return query.getResultList();
    }

    @Override
    public Iterable<ProductOrder> getOpenOrdersOfAClient(Long clientId) {
        final TypedQuery<ProductOrder> query = entityManager().createQuery(
                "SELECT d1 FROM ProductOrder d1 WHERE d1.client.id = :client AND (d1.status = :status OR d1.status = :status1 OR d1.status = :status2 OR d1.status = :status3 OR d1.status = :status4 OR d1.status = :status5 OR d1.status = :status6 OR d1.status = :status7)",
                ProductOrder.class);
        query.setParameter("client", clientId);
        query.setParameter("status", new OrderStatus(OrderStatus.Status.REGISTERED));
        query.setParameter("status1", new OrderStatus(OrderStatus.Status.TO_BE_PREPARED));
        query.setParameter("status2", new OrderStatus(OrderStatus.Status.BEING_PREPARED_BY_AGV));
        query.setParameter("status3", new OrderStatus(OrderStatus.Status.DELIVERED_BY_CARRIER));
        query.setParameter("status4", new OrderStatus(OrderStatus.Status.READY_FOR_CARRIER_DISPATCHING));
        query.setParameter("status5", new OrderStatus(OrderStatus.Status.PAYMENT_PENDING));
        query.setParameter("status6", new OrderStatus(OrderStatus.Status.DISPATCHED_FOR_COSTUMER));
        query.setParameter("status7", new OrderStatus(OrderStatus.Status.READY_FOR_PACKAGING));
        return query.getResultList();
    }


    @Override
    public ProductOrder findDispatchedOrderById(Long orderID) {
        final TypedQuery<ProductOrder> query = entityManager().createQuery(
                "SELECT d FROM ProductOrder d  WHERE d.status = :status AND d.id= :id",
                ProductOrder.class);
        query.setParameter("status", new OrderStatus(OrderStatus.Status.DISPATCHED_FOR_COSTUMER));
        query.setParameter("id", orderID);

        return query.getSingleResult();
    }
}
