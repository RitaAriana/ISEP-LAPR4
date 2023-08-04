package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndTest {

    @Test
    void testEquals() {
        End end = new End(1,2);
        End end2 = end;
        assertEquals(true, end.equals(end2));
    }

    @Test
    void testEquals2() {
        End end = new End(1,2);
        End end2 = null;
        assertEquals(false, end.equals(end2));
    }
}