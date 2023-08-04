package eapli.base.warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Begin implements ValueObject {
    private int beginLSquare;
    private int beginWSquare;

    public Begin(){}

    public Begin(final int beginLSquare, final int beginWSquare){
        setLsquare(beginLSquare);
        setWsquare(beginWSquare);
    }

    private void setLsquare(final int lSquare){
        if(lSquare <= 0) throw new IllegalArgumentException("lSquare must be bigger than 0.");
        this.beginLSquare = lSquare;
    }

    private void setWsquare(final int wSquare){
        if(wSquare <= 0) throw new IllegalArgumentException("wSquare must be bigger than 0.");
        this.beginWSquare = wSquare;
    }

    public int getBeginLSquare() {
        return beginLSquare;
    }

    public int getBeginWSquare() {
        return beginWSquare;
    }

    public boolean equals(Object obj){
        if(obj == null) return false;

        if(this == obj) return true;

        Begin newObj = (Begin) obj;

        return beginLSquare == newObj.beginLSquare && beginWSquare == newObj.beginWSquare;
    }

    public String toString(){
        return String.format("Starts at Length: %d and Width: %d", beginLSquare, beginWSquare);
    }
}
