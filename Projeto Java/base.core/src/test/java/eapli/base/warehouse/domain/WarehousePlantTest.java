package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehousePlantTest {

    @Test
    void sameAs() {
        WarehousePlant warehousePlant = new WarehousePlant("Description", 1, 1, 1, "UNIT");
        WarehousePlant warehousePlant2 = warehousePlant;

        assertEquals(true, warehousePlant.sameAs(warehousePlant2));
    }

    @Test
    void sameAs2() {
        WarehousePlant warehousePlant = new WarehousePlant("Description", 1, 1, 1, "UNIT");
        WarehousePlant warehousePlant2 = null;

        assertEquals(false, warehousePlant.sameAs(warehousePlant2));
    }
}