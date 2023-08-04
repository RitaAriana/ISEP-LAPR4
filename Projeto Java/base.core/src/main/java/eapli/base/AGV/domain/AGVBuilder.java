package eapli.base.AGV.domain;

import eapli.base.warehouse.domain.AGVDock;
import eapli.framework.domain.model.DomainFactory;

public class AGVBuilder implements DomainFactory<AGV> {

    private AGV agv;

    private AGVId id;

    private AGVDock agvDock;

    private Range range;

    private MaxWeightCapacity maxWeightCapacity;

    private MaxVolumeCapacity maxVolumeCapacity;

    private Model model;

    private BriefDescription briefDescription;

    private AGVPosition position;

    private AGVStatus agvStatus;

    public AGVBuilder withId(final AGVId id) {
        this.id = id;
        return this;
    }

    public AGVBuilder withAGVDock(final AGVDock agvDock){
        this.agvDock = agvDock;
        return this;
    }

    public AGVBuilder withRange(final Range range) {
        this.range = range;
        return this;
    }

    public AGVBuilder withMaxWeightCapacity(final MaxWeightCapacity maxWeightCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
        return this;
    }

    public AGVBuilder withMaxVolumeCapacity(final MaxVolumeCapacity maxVolumeCapacity) {
        this.maxVolumeCapacity = maxVolumeCapacity;
        return this;
    }

    public AGVBuilder withModel(final Model model) {
        this.model = model;
        return this;
    }

    public AGVBuilder withBriefDescription(final BriefDescription briefDescription) {
        this.briefDescription = briefDescription;
        return this;
    }

    public AGVBuilder withPosition(final AGVPosition position){
        this.position = position;
        return this;
    }

    public AGVBuilder withAGVStatus(final AGVStatus status){
        this.agvStatus = status;
        return this;
    }

    @Override
    public AGV build() {
        final AGV ret = buildOrThrow();
        agv = null;
        return  ret;
    }

    private AGV buildOrThrow() {
        if (agv != null) {
            return agv;
        } else if (id != null && range != null && maxWeightCapacity != null && maxVolumeCapacity != null && model != null && briefDescription != null && agvDock != null) {
            agv = new AGV(id,briefDescription, model, maxWeightCapacity, maxVolumeCapacity, range, position, agvDock, agvStatus);
            return agv;
        } else {
            throw new IllegalStateException();
        }
    }
}