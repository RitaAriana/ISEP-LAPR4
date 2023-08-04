package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthTest {

    @Test
    void testEquals() {
        Depth depth = new Depth(1, 2);

        Depth depth2 = depth;

        assertEquals(true, depth.equals(depth2));
    }

    @Test
    void testEquals2() {
        Depth depth = new Depth(1, 2);

        Depth depth2 = new Depth(1,3);

        assertEquals(false, depth.equals(depth2));
    }
}