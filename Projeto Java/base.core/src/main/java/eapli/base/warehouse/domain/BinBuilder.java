package eapli.base.warehouse.domain;

public class BinBuilder {

    private BinId Id;

    public BinBuilder(){}

    public BinBuilder withId(BinId Id){
        this.Id = Id;
        return this;
    }

    private Bin buildBin(){
        return new Bin(Id);
    }

    public Bin build(){
        return buildBin();
    }
}
