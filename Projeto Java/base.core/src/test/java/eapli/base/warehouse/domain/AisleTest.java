package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AisleTest {

    @Test
    void sameAs() {
        Aisle aisle = new AisleBuilder().withId(1L).withWarehouse(new Warehouse()).withAccessibility(new Accessibility()).withDepth(new Depth()).withBegin(new Begin()).withEnd(new End()).build();
        Aisle aisle2 = aisle;

        assertEquals(true, aisle.sameAs(aisle2));
    }

    @Test
    void sameAs2() {
        Aisle aisle = new AisleBuilder().withId(1L).withWarehouse(new Warehouse()).withAccessibility(new Accessibility()).withDepth(new Depth()).withBegin(new Begin()).withEnd(new End()).build();
        Aisle aisle2 = null;

        assertEquals(false, aisle.sameAs(aisle2));
    }

    @Test
    void identity() {
        Aisle aisle = new AisleBuilder().withId(1L).withWarehouse(new Warehouse()).withAccessibility(new Accessibility()).withDepth(new Depth()).withBegin(new Begin()).withEnd(new End()).build();
        assertEquals(1L, aisle.identity());
    }
}