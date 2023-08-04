package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Value Object that will represent the barcode of a product.
 *
 * Created by Rita Ariana Sobral on 29/04/2022.
 */
@Embeddable
public class Barcode implements ValueObject, Serializable {
    private final String barcode;

    public Barcode(String barcode){
        Preconditions.nonEmpty(barcode, "Barcode should neither be null nor empty");
        Preconditions.noneNull(barcode,"Barcode should neither be null nor empty");

        if (barcode.length() != 12) {
            throw new IllegalArgumentException("The barcode is not in the allowed size!");
        }
        this.barcode = barcode;
    }

    protected Barcode() {
        this.barcode = "";
        //for ORM purposes
    }

    public static Barcode valueOf(final String barcode) {
        return new Barcode(barcode);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Barcode)) {
            return false;
        } else {
            Barcode that =(Barcode) o;
            return this.barcode.equals(that.barcode);
        }
    }

    public int hashCode() {
        HashCoder coder = (new HashCoder()).with(this.barcode);
        return coder.code();
    }

    @Override
    public String toString() {
        return this.barcode;
    }
}
