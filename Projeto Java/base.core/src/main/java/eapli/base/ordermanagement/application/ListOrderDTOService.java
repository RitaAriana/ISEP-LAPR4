package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.dto.OrderDTO;
import eapli.base.ordermanagement.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * An application service to avoid code duplication.
 *
 * @author Rita Ariana Sobral
 *
 */
public class ListOrderDTOService {

    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();

    public Iterable<OrderDTO> getOrdersDispatchedForCustomerDelivery(){

        final Iterable<ProductOrder> orders = this.orderRepository.findOrdersDispatchedForCustomerDelivery();

        // transform for the presentation layer
        final List<OrderDTO> ret = new ArrayList<>();
        orders.forEach(e -> ret.add(e.toDTO()));
        return ret;
    }
}
