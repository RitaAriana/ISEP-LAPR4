package eapli.base.categorymanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryTest {

    private static final Description CATEGORY_DESCRIPTION = Description.valueOf("This category is intended for consumers.");
    private static final AlphanumericCode ALPHANUMERIC_CODE = AlphanumericCode.valueOf("bv7hsjs");
    private static final SuperCategory SUPER_CATEGORY = SuperCategory.valueOf("Super category.");


    @Test(expected = IllegalStateException.class)
    public void ensureCannotBuildWithNullDescription() {
        new CategoryFactory()
                .withAlphanumericaCode(ALPHANUMERIC_CODE)
                .withDescription(null)
                .withSuperCategory(SUPER_CATEGORY)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void ensureCannotBuildWithNullSuperCategory() {
        new CategoryFactory()
                .withAlphanumericaCode(ALPHANUMERIC_CODE)
                .withDescription(CATEGORY_DESCRIPTION)
                .withSuperCategory(null)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void ensureCannotBuildWithNullAlphanumericCode() {
        new CategoryFactory()
                .withAlphanumericaCode(null)
                .withDescription(CATEGORY_DESCRIPTION)
                .withSuperCategory(SUPER_CATEGORY)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void ensureCannotBuildWithNullAttributes() {
        new CategoryFactory()
                .withAlphanumericaCode(null)
                .withDescription(null)
                .withSuperCategory(null)
                .build();
    }

    @Test
    public void ensureThatAllFieldsNeddToRespectBusinessRules() {

        assertNotNull(new CategoryFactory()
                .withAlphanumericaCode(ALPHANUMERIC_CODE)
                .withDescription(CATEGORY_DESCRIPTION)
                .withSuperCategory(SUPER_CATEGORY)
                .build());
    }

}