package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.categorymanagement.aplication.CreateCategoryController;
import eapli.base.categorymanagement.domain.AlphanumericCode;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Description;
import eapli.base.categorymanagement.domain.SuperCategory;
import eapli.base.productmanagement.application.RegisterProductController;
import eapli.framework.actions.Action;

import java.util.HashSet;
import java.util.Set;

public class ProductBootstrapper extends BaseDemoBootstrapper implements Action {

    private final RegisterProductController registerProductController = new RegisterProductController();
    private final CreateCategoryController createCategoryController = new CreateCategoryController();

    @Override
    public boolean execute() {
        createProducts();
        return true;
    }

    private void createProducts(){
        Set<String> photos = new HashSet<>();
        photos.add("Fridge.jpg");
        Category category = createCategoryController.createCategory(new AlphanumericCode("123dc"),new Description("Efficient Appliances"),new SuperCategory("Modern and Efficient Appliances"));
        registerProductController.registerProduct(category,"FRIG123","Efficient Refrigerator","Modern and Efficient Refrigerator","Modern Refrigerator","123456789123","Samsung","frig937",null,150.0,160.0,20.0,30.0, photos, 1L,1L,1L);

        Set<String> photos1 = new HashSet<>();
        photos.add("Eye.png");
        Category category1 = createCategoryController.createCategory(new AlphanumericCode("11hagsb"),new Description("This medicine is for the eyes"),new SuperCategory("Eye Category"));
        registerProductController.registerProduct(category1,"EYES123","eye product","Efficient and practical eye product","Modern Eye Product","123456789122","La Roche Posay","EYES123",null,15.0,17.0,25.0,40.0, photos1, 1L,1L,1L);

        Set<String> photos2 = new HashSet<>();
        photos.add("Hands.png");
        Category category2 = createCategoryController.createCategory(new AlphanumericCode("34fghj"),new Description("This medicine is for the hands"),new SuperCategory("Hand Category"));
        registerProductController.registerProduct(category2,"HAND123","hand product","Efficient and practical hand product","Modern hand Product","123456789121","La Roche Posay","HAND123",null,91.0,112.0,5.0,10.0, photos2, 1L,1L,1L);

        Set<String> photos3 = new HashSet<>();
        photos.add("Foots.png");
        Category category3 = createCategoryController.createCategory(new AlphanumericCode("35fghj"),new Description("This medicine is for the foots"),new SuperCategory("Foots Category"));
        registerProductController.registerProduct(category3,"FOOT123","Foots product","Efficient and practical foots product","Modern foots Product","123456789124","La Roche Posay","FOOT123",null,67.0,83.0,10.0,15.0, photos3, 1L,1L,1L);

        Set<String> photos4 = new HashSet<>();
        photos.add("Mouth.png");
        Category category4 = createCategoryController.createCategory(new AlphanumericCode("36fghj"),new Description("This medicine is for the mouth"),new SuperCategory("Mouth Category"));
        registerProductController.registerProduct(category4,"MOUT123","Mouth product","Efficient and practical mouth product","Modern mouth Product","123456789125","La Roche Posay","MOUT123",null,22.0,37.0,50.0,30.0, photos4, 1L,1L,1L);

        Set<String> photos5 = new HashSet<>();
        photos.add("Ear.png");
        Category category5 = createCategoryController.createCategory(new AlphanumericCode("37fghj"),new Description("This medicine is for the ear"),new SuperCategory("Ear Category"));
        registerProductController.registerProduct(category5,"EARS123","Ear product","Efficient and practical ear product","Modern ear Product","123456789126","La Roche Posay","EARS123",null,33.0,37.0,10.0,70.0, photos5, 1L,1L,1L);

        Set<String> photos6 = new HashSet<>();
        photos.add("Legs.png");
        Category category6 = createCategoryController.createCategory(new AlphanumericCode("38fghj"),new Description("This medicine is for the legs"),new SuperCategory("Legs Category"));
        registerProductController.registerProduct(category6,"LEGS123","Legs product","Efficient and practical legs product","Modern legs Product","123456789127","La Roche Posay","LEGS123",null,60.0,70.0,28.0,17.0, photos6, 1L,1L,1L);

    }
}
