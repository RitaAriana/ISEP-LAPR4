package eapli.base.ordermanagement.repository;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.framework.domain.repositories.DomainRepository;

public interface OrderRepository extends DomainRepository<Long, ProductOrder> {


    Iterable<ProductOrder> getOrdersWhoNeedToBePrepared();

    ProductOrder getOrderById(Long id);

    Iterable<ProductOrder> findOrdersDispatchedForCustomerDelivery();

    Iterable<ProductOrder> getOpenOrdersOfAClient(Long clientId);

    ProductOrder findDispatchedOrderById(Long orderId);
}
