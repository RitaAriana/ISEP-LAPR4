package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity Root that will represent a Category.
 *
 * Created by Manuela Leite on 27/04/2022.
 */

@Entity
public class Category implements AggregateRoot<Long>, Serializable {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long categoryId;

    @Column
    private AlphanumericCode alphanumericCode;

    @Column
    private Description description;

    @Column
    private SuperCategory superCategory;


    public Category(AlphanumericCode alphanumericCode, Description description, SuperCategory superCategory) {
        this.alphanumericCode = alphanumericCode;
        this.description = description;
        this.superCategory = superCategory;
    }

    protected Category(){

    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public Long identity() {
        return this.categoryId;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    @Override
    public boolean equals(Object o) {
       return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }
}
