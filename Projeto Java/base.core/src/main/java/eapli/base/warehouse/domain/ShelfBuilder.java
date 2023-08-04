package eapli.base.warehouse.domain;

public class ShelfBuilder {

    private ShelfId Id;
    private boolean isEmpty;

    public ShelfBuilder(){}

    public ShelfBuilder withId(final ShelfId Id){
        this.Id = Id;
        return this;
    }

    public ShelfBuilder withEmpty(boolean isEmpty){
        this.isEmpty = isEmpty;
        return this;
    }

    private Shelf buildShelf(){
        return new Shelf(Id, isEmpty);
    }

    public Shelf build(){
        return buildShelf();
    }
}
