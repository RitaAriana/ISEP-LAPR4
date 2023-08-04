package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.categorymanagement.aplication.CreateCategoryController;
import eapli.base.categorymanagement.domain.AlphanumericCode;
import eapli.base.categorymanagement.domain.Description;
import eapli.base.categorymanagement.domain.SuperCategory;
import eapli.framework.actions.Action;



public class CategoryBootstrapper extends BaseDemoBootstrapper implements Action {

    private final CreateCategoryController createCategoryController = new CreateCategoryController();

    @Override
    public boolean execute() {
        createCategories();
        return true;
    }

    private void createCategories(){
        createCategoryController.createCategory(new AlphanumericCode("123dc"),new Description("Efficient Appliances"),new SuperCategory("Modern and Efficient Appliances"));
        createCategoryController.createCategory(new AlphanumericCode("11hagsb"),new Description("This medicine is for the eyes"),new SuperCategory("Eye Category"));
        createCategoryController.createCategory(new AlphanumericCode("1253dc"),new Description("Efficient Televisions"),new SuperCategory("Modern and Efficient Televisions"));
        createCategoryController.createCategory(new AlphanumericCode("34fghj"),new Description("This medicine is for the hands"),new SuperCategory("Hand Category"));
        createCategoryController.createCategory(new AlphanumericCode("35fghj"),new Description("This medicine is for the foots"),new SuperCategory("Foots Category"));
        createCategoryController.createCategory(new AlphanumericCode("36fghj"),new Description("This medicine is for the mouth"),new SuperCategory("Mouth Category"));
        createCategoryController.createCategory(new AlphanumericCode("37fghj"),new Description("This medicine is for the ear"),new SuperCategory("Ear Category"));
        createCategoryController.createCategory(new AlphanumericCode("38fghj"),new Description("This medicine is for the legs"),new SuperCategory("Legs Category"));

    }

}
