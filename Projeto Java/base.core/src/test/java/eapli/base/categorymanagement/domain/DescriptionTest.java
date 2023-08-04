package eapli.base.categorymanagement.domain;

import org.junit.Test;

public class DescriptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionIsNotEmpty() {
        new Description("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionIsNotNull() {
        new Description(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionLenghtIsBiggerThen20Chars() {
        new Description("ajhsyetgduehgsteg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionLenghtHaveNotMoreThen50Chars() {
        new Description("ajhsyetgduehgstegjhfigfrrdkdjhuiygfjeryguygyfreyuerjgehgg");
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionIsAPrhase(){
        new Description("@agsheths_loiiuejks");
    }

}