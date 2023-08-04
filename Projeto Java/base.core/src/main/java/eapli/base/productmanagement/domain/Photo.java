package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Value Object that will represent the photo of a product.
 *
 * Created by Rita Ariana Sobral on 29/04/2022.
 */
@Embeddable
public class Photo implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;

    private static final Pattern VALID_PHOTO_PATH =Pattern.compile("^*.(png|jpg|svg|jped|PNG|JPG|SVG|JPEG)$");

    private final String photoPath;

    public Photo(final String photoPath){
        Preconditions.nonEmpty(photoPath,"Photo path should neither be null nor empty");
        Preconditions.matches(VALID_PHOTO_PATH,photoPath,"The Photo path does not follow the required format.");
        this.photoPath=photoPath;
    }

    protected Photo() {
        this.photoPath = "";
        //for ORM purposes
    }

    public static Photo valueOf(final String photoPath) {
        return new Photo(photoPath);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Photo)) {
            return false;
        } else {
            Photo that =(Photo) o;
            return this.photoPath.equals(that.photoPath);
        }
    }

    public int hashCode() {
        HashCoder coder = (new HashCoder()).with(this.photoPath);
        return coder.code();
    }

    @Override
    public String toString() {
        return this.photoPath;
    }

}
