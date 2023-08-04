package eapli.base.warehouse.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class Line implements AggregateRoot<LineId> {

    @EmbeddedId
    private LineId Id;

    @Embedded
    private Begin begin;

    @Embedded
    private End end;

    private int numShelves;

    public Line(){}
    public Line(final LineId Id, final Begin begin, final End end, final int numShelves){
        this.Id = Id;
        this.begin = begin;
        this.end = end;
        this.numShelves = numShelves;
    }

    @Override
    public boolean sameAs(Object other) {
        if(other == null) return false;
        if(this == other) return true;

        Line newLine = ((Line) other);

        return Id.compareTo(newLine.Id) == 0 && begin.equals(newLine.begin) && end.equals(newLine.end) && numShelves == newLine.numShelves;
    }

    @Override
    public LineId identity() {
        return Id;
    }
}
