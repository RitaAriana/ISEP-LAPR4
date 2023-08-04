package eapli.base.clientmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Value Object that will represent the postal address of a client.
 *
 * Created by Rita Ariana Sobral on 29/04/2022.
 */
@Embeddable
public class PostalAddress implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    private static final Pattern VALID_POSTAL_CODE_REGEX = Pattern.compile("[0-9]{4}-[0-9]{3}");

    private final String streetName;

    private final String doorNumber;

    private final String postalCode;

    private final String city;

    private final String country;

    public PostalAddress(final String streetName, final String doorNumber, final String postalCode,
                         final String city, final String country) {
        Preconditions.nonEmpty(streetName, "Street name should neither be null nor empty");
        Preconditions.nonEmpty(doorNumber, "Door Number should neither be null nor empty");
        Preconditions.nonEmpty(postalCode, "Postal Code should neither be null nor empty");
        Preconditions.nonEmpty(city, "City should neither be null nor empty");
        Preconditions.nonEmpty(country, "Country should neither be null nor empty");
        Preconditions.isPositive(Integer.parseInt(doorNumber), "Door Number cannot be negative.");
        Preconditions.matches(VALID_POSTAL_CODE_REGEX, postalCode, "The Postal Code does not follow standards");

        this.streetName = streetName;
        this.doorNumber = doorNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    protected PostalAddress() {
        this.streetName = this.doorNumber = this.postalCode = this.city = this.country = "";
        //for ORM purposes
    }

    public static PostalAddress valueOf(final String streetName, final String doorNumber, final String postalCode,
                                        final String city, final String country) {
        return new PostalAddress(streetName, doorNumber, postalCode, city, country);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof PostalAddress)) {
            return false;
        } else {
            PostalAddress that = (PostalAddress) o;
            return this.streetName.equals(that.streetName) && this.doorNumber.equals(that.doorNumber)
                    && this.postalCode.equals(that.postalCode) && this.city.equals(that.city)
                    && this.country.equals(that.country);
        }
    }

    @Override
    public int hashCode() {
        return (new HashCoder()).with(this.streetName).with(doorNumber).with(postalCode).with(city).with(country).code();
    }

    public String toString() {
        return this.streetName + ", nº" + this.doorNumber + "\n" + this.postalCode + " - " + this.city + ", " + this.country;
    }
}

