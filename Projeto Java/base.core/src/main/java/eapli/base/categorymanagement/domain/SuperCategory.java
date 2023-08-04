package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Value Object that will represent the super category of a category.
 *
 * Created by Manuela Leite on 27/04/2022.
 */
@Embeddable
public class SuperCategory implements ValueObject, Serializable, Comparable<SuperCategory> {
    private static final long serialVersionUID = 1L;

    private final String superCategory;

    public SuperCategory(final String superCategory) {
        Preconditions.nonEmpty(superCategory, "Super category cannot be initialized empty!");
        Preconditions.ensure(StringPredicates.isPhrase(superCategory), "Super Category must be a text.");
        this.superCategory = superCategory;
    }

    protected SuperCategory() {
        this.superCategory = "";
    }

    public static SuperCategory valueOf(final String superCategory) {
        return new SuperCategory(superCategory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuperCategory)) return false;
        SuperCategory that = (SuperCategory) o;
        return Objects.equals(superCategory, that.superCategory);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(this.superCategory).code();
    }

    @Override
    public String toString() {
        return superCategory;
    }

    @Override
    public int compareTo(final SuperCategory otherSuperCategory) {
        return superCategory.compareTo(otherSuperCategory.superCategory);
    }

}
