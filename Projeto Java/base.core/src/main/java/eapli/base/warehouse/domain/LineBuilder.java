package eapli.base.warehouse.domain;
public class LineBuilder {

    private LineId Id;

    private Begin begin;

    private End end;

    private int numShelves;

    public LineBuilder(){}

    public LineBuilder withId(final LineId Id){
        this.Id = Id;
        return this;
    }

    public LineBuilder withBegin(final Begin begin){
        this.begin = begin;
        return this;
    }

    public LineBuilder withEnd(final End end){
        this.end = end;
        return this;
    }

    public LineBuilder withNumShelves(final int numShelves){
        this.numShelves = numShelves;
        return this;
    }
    private Line buildLine(){
        return new Line(Id, begin, end, numShelves);
    }

    public Line build(){
        return buildLine();
    }
}
