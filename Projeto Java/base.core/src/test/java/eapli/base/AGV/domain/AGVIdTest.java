package eapli.base.AGV.domain;

import eapli.base.warehouse.domain.AGVDock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AGVIdTest {

    @Test
    void getAGVId() {
        AGVId id = new AGVId("12345678");
        BriefDescription description = new BriefDescription("abcdefg");
        MaxWeightCapacity weight = new MaxWeightCapacity(200.0);
        MaxVolumeCapacity volume = new MaxVolumeCapacity(200);
        Model model = new Model("2.1.1.1");
        Range a = new Range(5.0);
        AGVPosition pos = new AGVPosition("s");
        AGVDock dock = new AGVDock();
        AGVStatus agvStatus = new AGVStatus(AGVStatus.Status.FREE);

        AGV a1 = getAGVId1();
        AGV a2 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        Assertions.assertEquals(a1.agvDock().getId(), a2.agvDock().getId());
    }

    private AGV getAGVId1() {
        AGVId id = new AGVId("12345678");
        BriefDescription description = new BriefDescription("abcdefg");
        MaxWeightCapacity weight = new MaxWeightCapacity(200.0);
        MaxVolumeCapacity volume = new MaxVolumeCapacity(200);
        Model model = new Model("2.1.1.1");
        Range a = new Range(5.0);
        AGVPosition pos = new AGVPosition("s");
        AGVDock dock = new AGVDock();
        AGVStatus agvStatus = new AGVStatus(AGVStatus.Status.FREE);
        AGVBuilder agvBuilder = new AGVBuilder();
        agvBuilder.withId(id).withBriefDescription(description).withMaxWeightCapacity(weight)
                .withModel(model).withMaxVolumeCapacity(volume).withRange(a)
                .withPosition(pos).withAGVDock(dock).withAGVStatus(agvStatus);

        return agvBuilder.build();
    }




    @Test
    void testToString() {
        AGVId m2 = new AGVId("1234");
        String expected = "AGVId{id=1234}";
        Assertions.assertEquals( m2.toString(),expected);
    }

    @Test
    void testToString2() {
        AGVId m = new AGVId();
        AGVId m2 = new AGVId("1234");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testEquals() {
        AGVId a = new AGVId("1234");
        AGVId a1 = new AGVId("1234");
        assertEquals(a, a1);
    }

    @Test
    void testEquals2() {
        AGVId a = new AGVId("134");
        AGVId a1 = new AGVId("1234");
        assertNotEquals(a, a1);
    }
    @Test
    void testEquals3() {
        AGVId m2 = new AGVId("12");
        AGVId m = new AGVId("1234");
        boolean result = m2.equals(m);
        assertFalse(result);
    }


    @Test
    void compareTo() {
        AGVId m = new AGVId("12");
        AGVId m2 = new AGVId("1234");
        int result = m2.compareTo(m);
        Assertions.assertEquals(2,result);
    }

    @Test
    void compareTo2() {
        AGVId m = new AGVId("1234");
        AGVId m2 = new AGVId("1234");
        int result = m2.compareTo(m);
        Assertions.assertEquals(0,result);
    }
    @Test
    void compareTo3() {
        AGVId m = new AGVId("12345");
        AGVId m2 = new AGVId("1234");
        int result = m2.compareTo(m);
        Assertions.assertEquals(-1,result);
    }

    @Test
    void testHashCode() {
        AGVId m2 = new AGVId("1234");
        int result = 1509442;
        assertEquals(result, m2.hashCode());
    }

}