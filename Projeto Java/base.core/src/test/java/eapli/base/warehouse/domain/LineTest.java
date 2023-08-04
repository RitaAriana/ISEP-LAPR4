package eapli.base.warehouse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void sameAs() {
        LineId lineId = new LineId(1L, new Aisle());
        Line line = new LineBuilder().withId(lineId).withBegin(new Begin()).withEnd(new End()).withNumShelves(1).build();
        Line line2 = line;

        assertEquals(true, line.sameAs(line2));
    }

    @Test
    void sameAs2() {
        LineId lineId = new LineId(1L, new Aisle());
        Line line = new LineBuilder().withId(lineId).withBegin(new Begin()).withEnd(new End()).withNumShelves(1).build();
        Line line2 = null;

        assertEquals(false, line.sameAs(line2));
    }

    @Test
    void identity() {
        LineId lineId = new LineId(1L, new Aisle());
        Line line = new LineBuilder().withId(lineId).withBegin(new Begin()).withEnd(new End()).withNumShelves(1).build();

        assertEquals(lineId, line.identity());
    }
}