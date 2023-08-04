package eapli.base.productmanagement.domain;

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
public class UniqueInternalCode implements ValueObject, Serializable {

    private final String uniqueInternalCode;

    public UniqueInternalCode(String uniqueInternalCode){
        Preconditions.nonEmpty(uniqueInternalCode, "Unique Internal Code should neither be null nor empty");
        Preconditions.noneNull(uniqueInternalCode,"Unique Internal Code should neither be null nor empty");
        Preconditions.ensure(StringPredicates.containsAlpha(uniqueInternalCode), "The unique internal code entered is not alphanumeric.");

        if (uniqueInternalCode.length() > 23) {
            throw new IllegalArgumentException("The unique internal code is not in the allowed size!");
        }
        this.uniqueInternalCode = uniqueInternalCode;
    }

    protected UniqueInternalCode() {
        this.uniqueInternalCode = "";
        //for ORM purposes
    }

    public static UniqueInternalCode valueOf(final String uniqueInternalCode) {
        return new UniqueInternalCode(uniqueInternalCode);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof UniqueInternalCode)) {
            return false;
        } else {
            UniqueInternalCode that = (UniqueInternalCode) o;
            return this.uniqueInternalCode.equals(that.uniqueInternalCode);
        }
    }

    public int hashCode() {
        HashCoder coder = (new HashCoder()).with(this.uniqueInternalCode);
        return coder.code();
    }

    @Override
    public String toString() {
        return this.uniqueInternalCode;
    }

}
