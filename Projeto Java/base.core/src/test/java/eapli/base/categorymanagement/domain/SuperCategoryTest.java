package eapli.base.categorymanagement.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuperCategoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureSuperCategoryIsNotEmpty() {
        new SuperCategory("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureSuperCategoryIsNotNull() {
        new SuperCategory(null);
    }

    /*@Test(expected = IllegalArgumentException.class)
    public void ensureSuperCategoryIsAPhrase() {
        new SuperCategory("@a_jahsue;");
    }*/


}