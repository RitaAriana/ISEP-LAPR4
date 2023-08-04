package eapli.base.shoppingcarmanagement.domain;

import eapli.base.categorymanagement.domain.AlphanumericCode;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Description;
import eapli.base.categorymanagement.domain.SuperCategory;
import eapli.base.productmanagement.domain.*;
import eapli.framework.general.domain.model.Money;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShopCarItemTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureShopCartItemHasProduct() {
        new ShopCarItem(3, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureShopCartItemHasQuantityGreater0() {
        Category category1 = new Category(new AlphanumericCode("11hagsb"),new Description("This medicine is for the eyes"),new SuperCategory("Eye Category"));
        new ShopCarItem(-1,new Product(category1,new UniqueInternalCode("EYES123"),new ShortDescription("eye product"),new ExtendedDescription("Efficient and practical eye product"),new TechnicalDescription("Modern Eye Product"),new Barcode("123456789122"),new BrandName("La Roche Posay"),new Reference("EYES123"), Money.euros(13.0),Money.euros(15.0),17.0,25.0,null, 1L,1L,1L));
    }

}