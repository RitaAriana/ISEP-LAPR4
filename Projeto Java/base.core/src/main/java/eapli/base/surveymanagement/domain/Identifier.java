package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.regex.Pattern;

/**
 *
 *
 * Created by Rita Ariana Sobral on 02/06/2022.
 */
@Embeddable
public class Identifier implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    private final String id;

    public Identifier(final String id) {
        this.id= id;
    }

    protected Identifier() {
        this.id = "";
    }

    public static Identifier valueOf(final String id) {
        return new Identifier(id);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Identifier)) {
            return false;
        } else {
            Identifier obj = (Identifier)o;
            return this.id.equals(obj.id);
        }
    }

    public int hashCode() {
        HashCoder coder = (new HashCoder()).with(this.id);
        return coder.code();
    }

    public String toString() {
        return this.id;
    }
}
