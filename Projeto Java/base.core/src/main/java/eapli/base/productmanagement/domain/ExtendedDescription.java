package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Value Object that will represent the extended description of a product.
 *
 * Created by Rita Ariana Sobral on 29/04/2022.
 */
@Embeddable
public class ExtendedDescription implements ValueObject, Serializable {

    private final String description;


    public ExtendedDescription(final String description) {

        Preconditions.nonEmpty(description, "The extended description of a product cannot be empty!");
        Preconditions.noneNull(description, "The extended description of a product cannot be null!");

        if (description.length() < 20 || description.length() > 100)
            throw new IllegalArgumentException("The extended description is not the size allowed!");

        this.description = description;

    }

    protected ExtendedDescription() {
        this.description = "";
    }

    public static ExtendedDescription valueOf(final String description) {
        return new ExtendedDescription(description);
    }


    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof ExtendedDescription)) {
            return false;
        } else {
            ExtendedDescription shortDescription = (ExtendedDescription)o;
            return this.description.equals(shortDescription.description);
        }
    }

    public int hashCode() {
        HashCoder coder = (new HashCoder()).with(this.description);
        return coder.code();
    }

    public String toString() {
        return this.description;
    }
}
