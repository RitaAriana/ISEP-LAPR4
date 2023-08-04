package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


/**
 * Value Object that will represent the description of a category.
 *
 * Created by Manuela Leite on 27/04/2022.
 */

@Embeddable
public class Description implements ValueObject, Serializable, Comparable<Description> {

    private final String description;

    public Description(String description) {
        Preconditions.nonEmpty(description, "The description of a category cannot be empty!");
        Preconditions.noneNull(description, "The description of a category cannot be null!");
        Preconditions.ensure(StringPredicates.isPhrase(description), "Invalid description format!");

        if (description.length() < 20 || description.length() > 50)
            throw new IllegalArgumentException("The description is not the size allowed!");

        this.description = description;
    }

    protected Description(){
        this.description = "";
    }

    @Override
    public String toString() {
        return description;
    }

    public static Description valueOf(final String description) {
        return new Description(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Description)) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(this.description).code();
    }

    @Override
    public int compareTo(Description o) {
        return description.compareTo(o.description);
    }

}
