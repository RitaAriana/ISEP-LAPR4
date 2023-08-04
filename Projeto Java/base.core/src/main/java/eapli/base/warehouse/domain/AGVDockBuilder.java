package eapli.base.warehouse.domain;

public class AGVDockBuilder {
    private String Id;

    private Warehouse warehouse;

    private Depth depth;

    private Accessibility accessibility;

    private Begin begin;

    private End end;

    public AGVDockBuilder(){}

    public AGVDockBuilder withId(final String Id){
        this.Id = Id;
        return this;
    }

    public AGVDockBuilder withWarehouse(final Warehouse warehouse){
        this.warehouse = warehouse;
        return this;
    }

    public AGVDockBuilder withDepth(final Depth depth){
        this.depth = depth;
        return this;
    }

    public AGVDockBuilder withAccessibility(final Accessibility accessibility){
        this.accessibility = accessibility;
        return this;
    }

    public AGVDockBuilder withBegin(final Begin begin){
        this.begin = begin;
        return this;
    }

    public AGVDockBuilder withEnd(final End end){
        this.end = end;
        return this;
    }

    private AGVDock buildDock(){
        return new AGVDock(Id, warehouse, depth, accessibility, begin, end);
    }

    public AGVDock build(){
        return buildDock();
    }
}
