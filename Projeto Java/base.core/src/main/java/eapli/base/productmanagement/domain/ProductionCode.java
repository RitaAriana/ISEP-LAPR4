package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Value Object that will represent the production code of a product.
 *
 * Created by Rita Ariana Sobral on 29/04/2022.
 */
@Embeddable
public class ProductionCode implements ValueObject, Serializable {

    private final String productionCode;

    public ProductionCode(String productionCode){
        Preconditions.ensure(StringPredicates.containsAlpha(productionCode), "The production code entered is not alphanumeric.");

        if (productionCode.length() > 23) {
            throw new IllegalArgumentException("The production code is not in the allowed size!");
        }
        this.productionCode = productionCode;
    }

    protected ProductionCode() {
        this.productionCode = "";
        //for ORM purposes
    }

    public static ProductionCode valueOf(final String productionCode) {
        return new ProductionCode(productionCode);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof ProductionCode)) {
            return false;
        } else {
            ProductionCode that = (ProductionCode) o;
            return this.productionCode.equals(that.productionCode);
        }
    }

    public int hashCode() {
        HashCoder coder = (new HashCoder()).with(this.productionCode);
        return coder.code();
    }

    @Override
    public String toString() {
        return this.productionCode;
    }
}
