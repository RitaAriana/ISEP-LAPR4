package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelfTest {

    @Test
    void sameAs() {
        ShelfId shelfId = new ShelfId(1L, new Line());
        Shelf shelf = new ShelfBuilder().withId(shelfId).withEmpty(true).build();
        Shelf shelf2 = shelf;

        assertEquals(true, shelf.sameAs(shelf2));
    }

    @Test
    void identity() {
        ShelfId shelfId = new ShelfId(1L, new Line());
        Shelf shelf = new ShelfBuilder().withId(shelfId).withEmpty(true).build();

        assertEquals(shelfId, shelf.identity());
    }
}