package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AGVDockTest {

    @Test
    void sameAs() {
        AGVDock agvDock = new AGVDockBuilder().withId("1L").withWarehouse(new Warehouse()).withDepth(new Depth()).withAccessibility(new Accessibility()).withBegin(new Begin()).withEnd(new End()).build();
        AGVDock agvDock2 = agvDock;

        assertEquals(true, agvDock.sameAs(agvDock2));
    }

    @Test
    void sameAs2() {
        AGVDock agvDock = new AGVDockBuilder().withId("1L").withWarehouse(new Warehouse()).withDepth(new Depth()).withAccessibility(new Accessibility()).withBegin(new Begin()).withEnd(new End()).build();
        AGVDock agvDock2 = null;

        assertEquals(false, agvDock.sameAs(agvDock2));
    }

    @Test
    void identity() {
        AGVDock agvDock = new AGVDockBuilder().withId("1L").withWarehouse(new Warehouse()).withDepth(new Depth()).withAccessibility(new Accessibility()).withBegin(new Begin()).withEnd(new End()).build();

        assertEquals("1L", agvDock.identity());
    }

    @Test
    void getId() {
        AGVDock agvDock = new AGVDockBuilder().withId("1L").withWarehouse(new Warehouse()).withDepth(new Depth()).withAccessibility(new Accessibility()).withBegin(new Begin()).withEnd(new End()).build();

        assertEquals("1L", agvDock.getId());
    }
}