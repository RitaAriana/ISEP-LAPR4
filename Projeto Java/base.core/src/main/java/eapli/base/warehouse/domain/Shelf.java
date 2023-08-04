package eapli.base.warehouse.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class Shelf implements AggregateRoot<ShelfId> {

    @EmbeddedId
    private ShelfId Id;
    private boolean isEmpty;

    public Shelf(){}

    public Shelf(final ShelfId Id, final boolean isEmpty) {
        this.Id = Id;
        this.isEmpty = isEmpty;
    }

    @Override
    public boolean sameAs(Object other) {
        if(other == null) return false;
        if(this == other) return true;

        Shelf otherShelf = ((Shelf) other);

        return Id.compareTo(otherShelf.Id) == 0 && isEmpty == otherShelf.isEmpty;
    }

    @Override
    public ShelfId identity() {
        return Id;
    }
}
