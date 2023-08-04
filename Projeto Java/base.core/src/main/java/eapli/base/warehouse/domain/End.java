package eapli.base.warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class End implements ValueObject {

    private int endLSquare;
    private int endWSquare;

    public End(){}

    public End(final int endLSquare, final int endWSquare){
        setLsquare(endLSquare);
        setWsquare(endWSquare);
    }
    private void setLsquare(final int lSquare){
        if(lSquare <= 0) throw new IllegalArgumentException("lSquare must be bigger than 0.");
        this.endLSquare = lSquare;
    }

    private void setWsquare(final int wSquare){
        if(wSquare <= 0) throw new IllegalArgumentException("wSquare must be bigger than 0.");
        this.endWSquare = wSquare;
    }

    public boolean equals(Object obj){
        if(obj == null) return false;

        if(this == obj) return true;

        End newObj = (End) obj;

        return endLSquare == newObj.endLSquare && endWSquare == newObj.endWSquare;
    }

    public String toString(){
        return String.format("Ends at Length: %d and Width: %d", endLSquare, endWSquare);
    }

    public int getEndLSquare() {
        return endLSquare;
    }

    public int getEndWSquare() {
        return endWSquare;
    }
}
