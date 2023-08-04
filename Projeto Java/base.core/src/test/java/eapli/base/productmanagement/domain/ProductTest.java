package eapli.base.productmanagement.domain;

import eapli.base.categorymanagement.domain.AlphanumericCode;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Description;
import eapli.base.categorymanagement.domain.SuperCategory;
import eapli.base.clientmanagement.domain.Client;
import eapli.base.clientmanagement.domain.ClientBuilder;
import eapli.base.clientmanagement.domain.PostalAddress;
import eapli.framework.general.domain.model.Money;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ProductTest {

    UniqueInternalCode uniqueInternalCode = new UniqueInternalCode("123ab4");
    ShortDescription shortDescription = new ShortDescription("frigorífico eficiente");
    ExtendedDescription extendedDescription = new ExtendedDescription("frigorífico eficiente e moderno");
    TechnicalDescription technicalDescription = new TechnicalDescription("frigorífico moderno");
    Barcode barcode = new Barcode("123456789123");
    Money priceWithout = Money.euros(15);
    Money priceWith = Money.euros(16);
    BrandName brandName = new BrandName("Samsung");
    Category category = new Category(new AlphanumericCode("12254bg"),new Description("Eletrodomésticos Modernos Eficientes"),new SuperCategory("Eletrodomésticos Eficientes"));
    Reference reference = new Reference("yh65");

    Set<Photo> photos = new HashSet<>();
    Photo photo = new Photo("frigorífico.jpg");

    @Test
    public void ensureProductWithNameEmailPhoneNumberVatAndPostalAddress() {
        photos.add(photo);
        new Product(category,uniqueInternalCode,shortDescription,extendedDescription,technicalDescription,barcode,brandName,reference,priceWithout,priceWith,15.00,30.00,photos,1L,1L,1L);
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveUniqueInternalCode() {
        photos.add(photo);
        new Product(category,new UniqueInternalCode(null),shortDescription,extendedDescription,technicalDescription,barcode,brandName,reference,priceWithout,priceWith,15.00,30.00,photos,1L,1L,1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveShortDescription() {
        photos.add(photo);
        new Product(category,uniqueInternalCode,new ShortDescription(null),extendedDescription,technicalDescription,barcode,brandName,reference,priceWithout,priceWith,15.00,30.00,photos,1L,1L,1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveExtendedDescription() {
        photos.add(photo);
        new Product(category,uniqueInternalCode,shortDescription,new ExtendedDescription(null),technicalDescription,barcode,brandName,reference,priceWithout,priceWith,15.00,30.00,photos,1L,1L,1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveTechnicalDescription() {
        photos.add(photo);
        new Product(category,uniqueInternalCode,shortDescription,extendedDescription,new TechnicalDescription(null),barcode,brandName,reference,priceWithout,priceWith,15.00,30.00,photos,1L,1L,1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveBarcode() {
        photos.add(photo);
        new Product(category,uniqueInternalCode,shortDescription,extendedDescription,technicalDescription,new Barcode(null),brandName,reference,priceWithout,priceWith,15.00,30.00,photos,1L,1L,1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveBrandName() {
        photos.add(photo);
        new Product(category,uniqueInternalCode,shortDescription,extendedDescription,technicalDescription,barcode,new BrandName(null),reference,priceWithout,priceWith,15.00,30.00,photos,1L,1L,1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveReference() {
        photos.add(photo);
        new Product(category,uniqueInternalCode,shortDescription,extendedDescription,technicalDescription,barcode,brandName,new Reference(null),priceWithout,priceWith,15.00,30.00,photos,1L,1L,1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustPhoto() {
        photos.add(photo);
        new Product(category,uniqueInternalCode,shortDescription,extendedDescription,technicalDescription,barcode,brandName,new Reference(null),priceWithout,priceWith,15.00,30.00,photos,1L,1L,1L);
    }


}