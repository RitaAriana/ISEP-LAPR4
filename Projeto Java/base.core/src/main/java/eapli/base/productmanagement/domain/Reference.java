package eapli.base.productmanagement.domain;

import eapli.base.categorymanagement.domain.AlphanumericCode;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Value Object that will represent the reference of a product.
 *
 * Created by Rita Ariana Sobral on 29/04/2022.
 */
@Embeddable
public class Reference implements ValueObject, Serializable {

    private final String reference;

    public Reference(String reference) {
        Preconditions.nonEmpty(reference, "The reference cannot be empty!");
        Preconditions.noneNull(reference, "The reference cannot be null!");
        Preconditions.ensure(StringPredicates.containsAlpha(reference), "The reference entered is not alphanumeric.");

        if (reference.length() > 23) {
            throw new IllegalArgumentException("The reference is not in the allowed size!");
        }
        this.reference = reference;
    }

    protected Reference(){
        this.reference = "";
    }

    public static Reference valueOf(final String reference) {
        return new Reference(reference);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Reference)) {
            return false;
        } else {
           Reference reference = (Reference) o;
            return this.reference.equals(reference.reference);
        }
    }

    public int hashCode() {
        HashCoder coder = (new HashCoder()).with(this.reference);
        return coder.code();
    }

    public String toString() {
        return this.reference;
    }
}
