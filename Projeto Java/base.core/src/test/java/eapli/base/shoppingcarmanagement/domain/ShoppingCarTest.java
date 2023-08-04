package eapli.base.shoppingcarmanagement.domain;

import eapli.base.categorymanagement.aplication.CreateCategoryController;
import eapli.base.categorymanagement.domain.AlphanumericCode;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Description;
import eapli.base.categorymanagement.domain.SuperCategory;
import eapli.base.clientmanagement.application.RegisterClientController;
import eapli.base.clientmanagement.domain.*;
import eapli.base.productmanagement.application.RegisterProductController;
import eapli.base.productmanagement.domain.*;
import eapli.framework.general.domain.model.Money;
import eapli.framework.time.util.Calendars;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class ShoppingCarTest {

    private final Product product;

    private static final Name CLIENT_NAME = Name.valueOf("Rita Ariana","de Castro Ribeiro e Pereira Sobral");
    private static final Email CLIENT_EMAIL = Email.valueOf("arianasobral26@outlook.pt");
    private static final VAT CLIENT_VAT = VAT.valueOf("PT999999999");
    private static final PhoneNumber CLIENT_PHONE_NUMBER = PhoneNumber.valueOf("+351939213522");
    private static final PostalAddress CLIENT_POSTAL_ADDRESS = PostalAddress.valueOf("Rua do Ouro","353","4505-102","Aveiro","Portugal");

    private Set<PostalAddress> postalAddresses = new HashSet<>();

    private Client buildClient() {
        postalAddresses.add(CLIENT_POSTAL_ADDRESS);
        return new ClientBuilder().named(CLIENT_NAME).withEmail(CLIENT_EMAIL).withVAT(CLIENT_VAT).withPhoneNumber(CLIENT_PHONE_NUMBER).withAddresses(postalAddresses).build();
    }

    public ShoppingCarTest() throws ParseException {
        Category category1 = new Category(new AlphanumericCode("11hagsb"),new Description("This medicine is for the eyes"),new SuperCategory("Eye Category"));
        product = new Product(category1,new UniqueInternalCode("EYES123"),new ShortDescription("eye product"),new ExtendedDescription("Efficient and practical eye product"),new TechnicalDescription("Modern Eye Product"),new Barcode("123456789122"),new BrandName("La Roche Posay"),new Reference("EYES123"), Money.euros(13.0),Money.euros(15.0),17.0,25.0,null, 1L,1L,1L);

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void ensureShoppingCartHasClient() {
        new ShoppingCar(null);
    }

    @Test
    public void addProductToShoppingCar() {
        ShoppingCar shoppingCart = new ShoppingCar(buildClient());

        int expQuantity = 3;
        int expSize = 1;
        ShopCarItem item = new ShopCarItem(3,product);

        shoppingCart.addProductToShoppingCar(item);
        assertEquals(expSize, shoppingCart.getItems().size());
        assertEquals(expQuantity, shoppingCart.getItems().get(0).quantity());
    }



}