package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    @Test
    void sameAs() {
        Warehouse warehouse = new WarehouseBuilder().withId(1L).withPlant(new WarehousePlant()).withDashboard(new Dashboard()).build();
        Warehouse warehouse2 = warehouse;

        assertEquals(true, warehouse.sameAs(warehouse2));
    }

    @Test
    void sameAs2() {
        Warehouse warehouse = new WarehouseBuilder().withId(1L).withPlant(new WarehousePlant()).withDashboard(new Dashboard()).build();
        Warehouse warehouse2 = null;

        assertEquals(false, warehouse.sameAs(warehouse2));
    }

    @Test
    void identity() {
        Warehouse warehouse = new WarehouseBuilder().withId(1L).withPlant(new WarehousePlant()).withDashboard(new Dashboard()).build();

        assertEquals(1L, warehouse.identity());
    }
}