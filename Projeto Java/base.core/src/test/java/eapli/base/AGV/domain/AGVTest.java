package eapli.base.AGV.domain;

import eapli.base.warehouse.domain.AGVDock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AGVTest {

    private static final AGVId ID = new AGVId("12345678");
    private static final BriefDescription DESCRIPTION = new BriefDescription("abcdefg");
    private static final MaxWeightCapacity WEIGHT = new MaxWeightCapacity(300.00);
    private static final MaxVolumeCapacity VOLUME = new MaxVolumeCapacity(600.00);
    private static final Model MODEL = new Model("2.1.1.1");
    private static final Range RANGE = new Range(5.0);
    private static final AGVPosition POSITION = new AGVPosition("s");
    private static final AGVDock DOCK = new AGVDock();
    private static final AGVStatus STATUS = new AGVStatus(AGVStatus.Status.FREE);

    private AGV buildAGV(){
        return new AGVBuilder().withId(ID).withBriefDescription(DESCRIPTION).withMaxWeightCapacity(WEIGHT).withMaxVolumeCapacity(VOLUME).withModel(MODEL).withRange(RANGE).withPosition(POSITION).withAGVDock(DOCK).withAGVStatus(STATUS).build();
    }

    @Test
    void sameAs() {
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
        Object a2 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        Assertions.assertTrue(a1.sameAs(a2));
    }

    @Test
    void sameAs2() {
        AGVId id = new AGVId("12345678");
        AGVId id1 = new AGVId("12345678");
        BriefDescription description = new BriefDescription("abcdefg");
        MaxWeightCapacity weight = new MaxWeightCapacity(200.0);
        MaxVolumeCapacity volume = new MaxVolumeCapacity(500);
        Model model = new Model("2.1.1.1");
        Range a = new Range(5.0);
        AGVPosition pos = new AGVPosition("s");
        AGVDock dock = new AGVDock();
        AGVStatus agvStatus = new AGVStatus(AGVStatus.Status.FREE);

        AGV a1 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        Object a2 = new AGV(id1,description,model,weight,volume,a,pos,dock, agvStatus);
        Assertions.assertFalse(a1.sameAs(a2));
    }


    @Test
    void agvDock() {
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
        assertEquals(a1.agvDock().getId(), a2.agvDock().getId());
    }

    @Test
    void agvDock2() {
        AGVId id = new AGVId("12345678");
        BriefDescription description = new BriefDescription("abcdefg");
        MaxWeightCapacity weight = new MaxWeightCapacity(200.0);
        MaxVolumeCapacity volume = new MaxVolumeCapacity(200);
        Model model = new Model("2.1.1.1");
        Range a = new Range(5.0);
        AGVPosition pos = new AGVPosition("s");
        AGVDock dock = new AGVDock();
        AGVDock dock2 = new AGVDock();
        AGVStatus agvStatus = new AGVStatus(AGVStatus.Status.FREE);

        AGV a1 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        AGV a2 = new AGV(id,description,model,weight,volume,a,pos,dock2, agvStatus);
        Assertions.assertNotEquals(a1.agvDock(), a2.agvDock());
    }


    @Test
    void identity() {
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
        assertEquals(a1.identity(), a2.identity());
    }

    @Test
    void identity2() {
        AGVId id = new AGVId("12345678");
        AGVId id1 = new AGVId("87654321");
        BriefDescription description = new BriefDescription("abcdefg");
        MaxWeightCapacity weight = new MaxWeightCapacity(200.0);
        MaxVolumeCapacity volume = new MaxVolumeCapacity(200);
        Model model = new Model("2.1.1.1");
        Range a = new Range(5.0);
        AGVPosition pos = new AGVPosition("s");
        AGVDock dock = new AGVDock();
        AGVStatus agvStatus = new AGVStatus(AGVStatus.Status.FREE);

        AGV a1 = new AGV(id,description,model,weight,volume,a,pos,dock, agvStatus);
        AGV a2 = new AGV(id1,description,model,weight,volume,a,pos,dock, agvStatus);
        Assertions.assertNotEquals(a1.identity(), a2.identity());
    }

    @Test
    void changeStatusOfAGVForFree(){
        AGV agv = buildAGV();
        agv.changeStatusOfAGVForFree();

        assertEquals(agv.getAgvStatus().obtainStatus(), AGVStatus.Status.FREE);
    }

    @Test
    void changeStatusOfAGVForCharging(){
        AGV agv = buildAGV();
        agv.changeStatusOfAGVForCharging();

        assertEquals(agv.getAgvStatus().obtainStatus(), AGVStatus.Status.CHARGING);
    }

    @Test
    void changeStatusOfAGVForGivenOrder(){
        AGV agv = buildAGV();
        agv.changeStatusOfAGVForGivenOrder();

        assertEquals(agv.getAgvStatus().obtainStatus(), AGVStatus.Status.GIVEN_ORDER);
    }

    @Test
    void changeStatusOfAGVForOccupied(){
        AGV agv = buildAGV();
        agv.changeStatusOfAGVForOccupied();

        assertEquals(agv.getAgvStatus().obtainStatus(), AGVStatus.Status.OCCUPIED_SERVING);
    }



}