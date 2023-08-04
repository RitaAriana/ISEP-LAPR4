package eapli.base.warehouse.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aisle implements AggregateRoot<Long> {

    @Id
    private Long Id;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Warehouse warehouse;

    @Embedded
    private Accessibility accessibility;

    @Embedded
    private Depth depth;

    @Embedded
    private Begin begin;

    @Embedded
    private End end;

    public Aisle(){}

    public Aisle(final Long Id, final Warehouse warehouse, final Accessibility accessibility, final Depth depth, final Begin begin,
                 final End end){
        this.Id = Id;
        this.warehouse = warehouse;
        this.accessibility = accessibility;
        this.depth = depth;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public boolean sameAs(Object other) {
        if(other == null) return false;
        if(this == other) return true;

        Aisle newObj = ((Aisle) other);

        return warehouse.equals(newObj.warehouse) && accessibility.equals(newObj.accessibility) && depth.equals(newObj.depth) && begin.equals(newObj.begin)
                && end.equals(newObj.end);
    }

    @Override
    public Long identity() {
        return Id;
    }

    public Accessibility getAccessibility() {
        return accessibility;
    }

    public Depth getDepth() {
        return depth;
    }

    public Begin getBegin() {
        return begin;
    }

    public End getEnd() {
        return end;
    }
}
