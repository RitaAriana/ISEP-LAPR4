package eapli.base.surveymanagement.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Restricao implements ValueObject, Serializable {

    @Enumerated(EnumType.STRING)
    private final Criterio criterio;

    @ManyToOne
    private Product product;

    private int minimumAge;

    private int maximumAge;

    public Restricao(final Criterio criterio) {
        this.criterio = criterio;
    }

    public Restricao() {
        criterio = null;
    }

    public void modifyProduct(Product product) {
        this.product = product;
    }

    public void modifyMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public void modifyMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    public Criterio criterio(){
        return this.criterio;
    }
}
