package eapli.base.ordermanagement.domain;

import eapli.base.clientmanagement.domain.*;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ProductOrderTest {


    @Test(expected = IllegalArgumentException.class)
    public void ensureOrderAddressMustHaveStreeName() {
        new Address(null, "353", "4505-102", "Aveiro", "Portugal");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureOrderAddressMustHaveDoorNumber() {
        new Address("Rua", null, "4505-102", "Aveiro", "Portugal");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureOrderAddressMustHavePostalCode() {
        new Address("Rua", "353", null, "Aveiro", "Portugal");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureOrderAddressMustHaveCity() {
        new Address("Rua", "353", "4505-102", null, "Portugal");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureOrderAddressMustHaveCountry() {
        new Address("Rua", "353", "4505-102", "Aveiro", null);
    }

    @Test
    public void ensureModifyStatus(){
        ProductOrder order = new ProductOrder();
        order.changeProductOrderStatus(new OrderStatus(OrderStatus.Status.DELIVERED_BY_CARRIER));
        assertEquals(order.getOrderStatus().toString(),new OrderStatus(OrderStatus.Status.DELIVERED_BY_CARRIER).toString());
    }


}