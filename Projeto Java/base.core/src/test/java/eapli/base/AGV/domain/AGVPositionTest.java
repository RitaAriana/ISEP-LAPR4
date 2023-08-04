package eapli.base.AGV.domain;

import eapli.base.warehouse.domain.AGVDock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AGVPositionTest {

    @Test
    void getAgvPosition() {
        AGVId id = new AGVId("12345678");
        BriefDescription description = new BriefDescription("abcdefg");
        MaxWeightCapacity weight = new MaxWeightCapacity(200.0);
        MaxVolumeCapacity volume = new MaxVolumeCapacity(200);
        Model model = new Model("2.1.1.1");
        Range a = new Range(5.0);
        AGVPosition pos = new AGVPosition("s");
        AGVDock dock = new AGVDock();
        AGVStatus agvStatus = new AGVStatus(AGVStatus.Status.FREE);

        AGV a1 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        AGV a2 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        Assertions.assertEquals(a1.getPosition(), a2.getPosition());
    }

    @Test
    void getAgvPosition2() {
        AGVId id = new AGVId("12345678");
        BriefDescription description = new BriefDescription("abcdefg");
        MaxWeightCapacity weight = new MaxWeightCapacity(200.0);
        MaxVolumeCapacity volume = new MaxVolumeCapacity(200);
        Model model = new Model("2.1.1.1");
        Range a = new Range(5.0);
        AGVPosition pos = new AGVPosition("s");
        AGVPosition pos1 = new AGVPosition("x");
        AGVDock dock = new AGVDock();
        AGVStatus agvStatus = new AGVStatus(AGVStatus.Status.FREE);

        AGV a1 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        AGV a2 = new AGV(id,description,model,weight,volume,a,pos1,dock, agvStatus);
        Assertions.assertNotEquals(a1.getPosition(), a2.getPosition());
    }

    @Test
    void setAgvPosition() {
        AGVId id = new AGVId("12345678");
        BriefDescription description = new BriefDescription("abcdefg");
        MaxWeightCapacity weight = new MaxWeightCapacity(200.0);
        MaxVolumeCapacity volume = new MaxVolumeCapacity(200);
        Model model = new Model("2.1.1.1");
        Range a = new Range(5.0);
        AGVPosition pos = new AGVPosition("s");
        AGVDock dock = new AGVDock();
        AGVStatus agvStatus = new AGVStatus(AGVStatus.Status.FREE);

        AGV a1 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        pos.setAgvPosition("s");
        AGV a2 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        Assertions.assertEquals(a1.getPosition(), a2.getPosition());
    }

    @Test
    void testEquals() {
        AGVPosition pos = new AGVPosition("s");
        AGVPosition pos1 = new AGVPosition("s");
        assertEquals(pos, pos1);
    }

    @Test
    void testEquals1() {
        AGVPosition pos = new AGVPosition("s");
        AGVPosition pos1 = new AGVPosition("x");
        assertNotEquals(pos,pos1);
    }

    @Test
    void testToString() {
        AGVPosition pos = new AGVPosition("s");
        String expected = "AGVPosition{agvPosition='s'}";
        Assertions.assertEquals(pos.toString(),expected);
    }

    @Test
    void testToString1() {
        AGVPosition pos = new AGVPosition("s");
        String expected = "AGVPosition";
        Assertions.assertNotEquals(pos.toString(),expected);
    }

}