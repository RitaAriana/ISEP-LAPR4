package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.OrderStatus;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.dto.OrderDTO;
import eapli.base.ordermanagement.repository.OrderRepository;

import java.util.List;

public class ViewOrdersSentToCustomerController {

    ListOrderDTOService service = new ListOrderDTOService();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();

    public Iterable<OrderDTO> getOrdersDispatchedForCustomerDelivery() {
        return service.getOrdersDispatchedForCustomerDelivery();
    }

    public ProductOrder findDispacthedOrderById(String orderId){
        return orderRepository.findDispatchedOrderById(Long.parseLong(orderId));
    }

    public void changeStatusToBeingDelivered(String orderId) {
        ProductOrder order = orderRepository.getOrderById(Long.parseLong(orderId));
        order.changeProductOrderStatus(new OrderStatus(OrderStatus.Status.DELIVERED_BY_CARRIER));
        orderRepository.save(order);
    }
}
