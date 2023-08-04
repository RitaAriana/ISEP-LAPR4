package eapli.base.AGV.domain;

import eapli.base.warehouse.domain.AGVDock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxWeightCapacityTest {

    @Test
    void getMaxWeightCapacity() {
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
        Assertions.assertEquals(a1.getMaxWeightCapacity(), a2.getMaxWeightCapacity());
    }

    @Test
    void setMaxWeightCapacity() {
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
        weight.setMaxWeightCapacity(10.0);
        AGV a2 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        Assertions.assertEquals(a1.getMaxWeightCapacity(), a2.getMaxWeightCapacity());
    }

    @Test
    void testToString() {
        MaxWeightCapacity m2 = new MaxWeightCapacity(10.0);
        String expected = "MaxWeightCapacity{maxWeightCapacity=10.0}";
        Assertions.assertEquals( m2.toString(),expected);
    }

    @Test
    void testToString2() {
        MaxWeightCapacity m = new MaxWeightCapacity();
        MaxWeightCapacity m2 = new MaxWeightCapacity(10.0);
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }
}