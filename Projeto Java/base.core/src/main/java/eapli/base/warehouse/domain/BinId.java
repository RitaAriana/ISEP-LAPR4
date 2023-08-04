package eapli.base.warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class BinId implements ValueObject, Comparable<BinId> {

    private Long Id;

    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    private Shelf shelf;

    public BinId(){}

    public BinId(final Long Id, final Shelf shelf){
        this.Id = Id;
        this.shelf = shelf;
    }

    @Override
    public int compareTo(BinId o) {
        if(Id == o.Id && shelf.sameAs(o.shelf)) return 0;
        return -1;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        BinId other = (BinId) obj;

        return shelf.sameAs(other.shelf);
    }

    @Override
    public int hashCode(){
        return Id.hashCode();
    }
}
