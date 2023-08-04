package eapli.base.ordermanagement.dto;

import java.io.Serializable;

/**
 * DTO for orders.
 *
 * @author Rita Ariana Sobral
 *
 */
public class OrderDTO {

    private final long orderId;

    private final String orderDate;

    private final String status;

    public OrderDTO(final long id, final String date,  final String status){
        this.orderId = id;
        this.orderDate = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "------ Order ------\n" +
                "Id: " + orderId +
                "\nDate: " + orderDate+
                "\nStatus: " + status;
    }
}
