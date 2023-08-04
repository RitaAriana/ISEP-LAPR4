package eapli.base.categorymanagement.domain;

import org.junit.Test;

public class AlphanumericCodeTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureAlphanumericCodeMustNotBeEmpty() {
        new AlphanumericCode("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAlphanumericCodeMustNotBeNull() {
        new AlphanumericCode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAlphanumericCodeMustHaveRightLenght() {
        new AlphanumericCode("1jahyeui3hsgte");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAlphanumericCodeMustBeAlphanumeric() {
        new AlphanumericCode("111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAlphanumericCodeMustBeAlphanumeric2() {
        new AlphanumericCode("aaaaaaaaa");
    }



}