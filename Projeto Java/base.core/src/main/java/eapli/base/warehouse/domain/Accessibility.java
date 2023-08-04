package eapli.base.warehouse.domain;

import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;
@Embeddable
public class Accessibility implements ValueObject {

    private String rating;

    public Accessibility(){}

    public Accessibility(final String rating){
        setRating(rating);
    }

    private void setRating(final String rating){
        if(rating == null || rating.isBlank()) throw new IllegalArgumentException("Rating cannot be Empty");
        this.rating = rating;
    }

    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj) return true;

        return rating == ((Accessibility) obj).rating;
    }

    public String toString(){
        return "Rating: " + rating;
    }
}
