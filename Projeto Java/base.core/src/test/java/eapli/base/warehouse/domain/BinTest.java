package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinTest {

    @Test
    void sameAs() {
        Bin bin = new BinBuilder().withId(new BinId(1L, new Shelf())).build();
        Bin bin2 = bin;

        assertEquals(true, bin.equals(bin2));
    }

    @Test
    void sameAs2() {
        Bin bin = new BinBuilder().withId(new BinId(1L, new Shelf())).build();
        Bin bin2 = null;

        assertEquals(false, bin.equals(bin2));
    }

    @Test
    void identity() {
        BinId binId = new BinId(1L, new Shelf());
        Bin bin = new BinBuilder().withId(binId).build();

        assertEquals(binId, bin.identity());
    }
}