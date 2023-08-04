package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.DomainFactory;


/**
 * Factory responsible for creating new categories.
 *
 * Created by Manuela Leite on 27/04/2022.
 */


public class CategoryFactory implements DomainFactory<Category> {

    private Category category;

    private AlphanumericCode alphanumericCode;

    private SuperCategory superCategory;

    private Description description;

    public CategoryFactory withAlphanumericaCode(final AlphanumericCode alphanumericCode) {
        this.alphanumericCode = alphanumericCode;
        return this;
    }

    public CategoryFactory withSuperCategory(final SuperCategory superCategory) {
        this.superCategory = superCategory;
        return this;
    }

    public CategoryFactory withDescription(final Description description) {
        this.description = description;
        return this;
    }

    private Category buildOrThrow() {
        if (category != null) {
            return category;
        } else if (alphanumericCode != null && superCategory != null && description != null) {
            category = new Category(alphanumericCode, description, superCategory);
            return category;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public Category build() {
        final Category ret = buildOrThrow();
        category = null;
        return ret;
    }

}
