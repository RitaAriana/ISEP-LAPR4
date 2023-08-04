package eapli.base.categorymanagement.domain;

import antlr.StringUtils;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;


/**
 * Value Object that will represent the alphanumeric code of a category.
 *
 * Created by Manuela Leite on 27/04/2022.
 */

@Embeddable
public class AlphanumericCode implements ValueObject, Serializable, Comparable<AlphanumericCode> {

    private final String alphanumericCode;



    public AlphanumericCode(String alphanumericCode) {
        final Pattern p = Pattern.compile("[0-9]+[a-zA-Z]+[a-zA-Z0-9]*$");

        Preconditions.nonEmpty(alphanumericCode, "The alphanumeric code cannot be empty!");
        Preconditions.noneNull(alphanumericCode, "The alphanumeric code cannot be null!");

        if (!p.matcher(alphanumericCode).find()) throw new IllegalArgumentException("The code entered is not alphanumeric.");

        if (alphanumericCode.length() > 10 || alphanumericCode.length() <= 0) throw new IllegalArgumentException("The alphanumeric code is not in the allowed size!");
        this.alphanumericCode = alphanumericCode;
    }

    protected AlphanumericCode(){
        this.alphanumericCode = "";
    }


    public static AlphanumericCode valueOf(final String alphanumericCode) {
        return new AlphanumericCode(alphanumericCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlphanumericCode)) return false;
        AlphanumericCode that = (AlphanumericCode) o;
        return Objects.equals(alphanumericCode, that.alphanumericCode);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(this.alphanumericCode).code();
    }

    @Override
    public String toString() {
        return alphanumericCode;
    }

    @Override
    public int compareTo(AlphanumericCode o) {
        return alphanumericCode.compareTo(o.alphanumericCode);
    }
}
