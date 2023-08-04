package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeginTest {

    @Test
    void testEquals() {
        Begin begin = new Begin(1,2);
        Begin begin2 = begin;

        assertEquals(true, begin.equals(begin2));
    }

    @Test
    void testEquals2() {
        Begin begin = new Begin(1,2);
        Begin begin2 = null;

        assertEquals(false, begin.equals(begin2));
    }
}