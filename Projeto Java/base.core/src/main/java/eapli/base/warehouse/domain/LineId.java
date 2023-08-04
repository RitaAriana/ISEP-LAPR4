package eapli.base.warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class LineId implements ValueObject, Comparable<LineId> {

    private Long Id;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Aisle aisle;

    public LineId(){}

    public LineId(final Long Id, final Aisle aisle){
        this.Id = Id;
        this.aisle = aisle;
    }

    @Override
    public int compareTo(LineId o) {
        if(Id == o.Id && aisle.sameAs(o.aisle)) return 0;
        return -1;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        LineId other = (LineId) obj;

        return aisle.sameAs(other.aisle);
    }

    @Override
    public int hashCode(){
        return Id.hashCode();
    }
}
