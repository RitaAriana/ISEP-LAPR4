package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Value Object that will represent the brand name of a product.
 *
 * Created by Rita Ariana Sobral on 29/04/2022.
 */
@Embeddable
public class BrandName implements ValueObject, Serializable {

    private final String brandName;


    public BrandName(final String brandName) {

        Preconditions.nonEmpty(brandName, "The brand name of a product cannot be empty!");
        Preconditions.noneNull(brandName, "The brand name of a product cannot be null!");

        if ( brandName.length() > 50)
            throw new IllegalArgumentException("The brand name is not the size allowed!");

        this.brandName = brandName;

    }

    protected BrandName() {
        this.brandName = "";
    }

    public static BrandName valueOf(final String brandName) {
        return new BrandName(brandName);
    }


    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof BrandName)) {
            return false;
        } else {
           BrandName brandName = (BrandName)o;
            return this.brandName.equals(brandName.brandName);
        }
    }

    public int hashCode() {
        HashCoder coder = (new HashCoder()).with(this.brandName);
        return coder.code();
    }

    public String toString() {
        return this.brandName;
    }
}
