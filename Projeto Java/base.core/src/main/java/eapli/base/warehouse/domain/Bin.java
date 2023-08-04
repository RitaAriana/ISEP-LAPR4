package eapli.base.warehouse.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class Bin implements AggregateRoot<BinId> {

    @EmbeddedId
    private BinId Id;

    public Bin(){}

    public Bin(final BinId Id) {
        this.Id = Id;
    }

    @Override
    public boolean sameAs(Object other) {
        if(other == null) return false;

        if(this == other) return true;

        Bin newObj = ((Bin) other);

        return Id.compareTo(newObj.Id) == 0;
    }

    @Override
    public BinId identity() {
        return Id;
    }
}
