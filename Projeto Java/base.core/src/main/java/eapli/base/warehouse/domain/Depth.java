package eapli.base.warehouse.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Depth implements ValueObject {
    private int lSquare;
    private int wSquare;

    public Depth(){}

    public Depth(final int lSquare, final int wSquare){
        setLsquare(lSquare);
        setWsquare(wSquare);
    }
    private void setLsquare(final int lSquare){
        if(lSquare <= 0) throw new IllegalArgumentException("lSquare must be bigger than 0.");
        this.lSquare = lSquare;
    }

    private void setWsquare(final int wSquare){
        if(wSquare <= 0) throw new IllegalArgumentException("wSquare must be bigger than 0.");
        this.wSquare = wSquare;
    }

    public boolean equals(Object obj){
        if(obj == null) return false;

        if(this == obj) return true;

        Depth newObj = (Depth) obj;

        return lSquare == newObj.lSquare && wSquare == newObj.wSquare;
    }

    public int getlSquare() {
        return lSquare;
    }

    public int getwSquare() {
        return wSquare;
    }

    public String toString(){
        return String.format("Depth at Length: %d and Width: %d", lSquare, wSquare);
    }

}
