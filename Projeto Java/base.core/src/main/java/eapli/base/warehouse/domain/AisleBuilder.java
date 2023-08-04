package eapli.base.warehouse.domain;

public class AisleBuilder {

    private Long Id;

    private Warehouse warehouse;

    private Accessibility accessibility;

    private Depth depth;

    private Begin begin;

    private End end;

    public AisleBuilder(){}

    public AisleBuilder withId(final Long Id){
        this.Id = Id;
        return this;
    }

    public AisleBuilder withWarehouse(final Warehouse warehouse){
        this.warehouse = warehouse;
        return this;
    }

    public AisleBuilder withAccessibility(final Accessibility accessibility){
        this.accessibility = accessibility;
        return this;
    }

    public AisleBuilder withDepth(final Depth depth){
        this.depth = depth;
        return this;
    }

    public AisleBuilder withBegin(final Begin begin){
        this.begin = begin;
        return this;
    }

    public AisleBuilder withEnd(final End end){
        this.end = end;
        return this;
    }

    private Aisle buildAisle(){
        return new Aisle(Id, warehouse, accessibility, depth, begin, end);
    }

    public Aisle build() {
        return buildAisle();
    }
}
