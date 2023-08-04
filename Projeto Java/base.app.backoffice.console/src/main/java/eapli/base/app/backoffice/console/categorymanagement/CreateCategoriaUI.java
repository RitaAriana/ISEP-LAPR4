package eapli.base.app.backoffice.console.categorymanagement;

import eapli.base.categorymanagement.aplication.CreateCategoryController;
import eapli.base.categorymanagement.domain.AlphanumericCode;
import eapli.base.categorymanagement.domain.Description;
import eapli.base.categorymanagement.domain.SuperCategory;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class CreateCategoriaUI extends AbstractUI {

    private final CreateCategoryController createCategoryController = new CreateCategoryController();

    @Override
    protected boolean doShow() {

        String alphaNumericCodeInput;
        String descriptionInput;
        String superCategoryInput;
        AlphanumericCode alphanumericCode = null;
        Description description = null;
        SuperCategory superCategory = null;

        do {
            alphaNumericCodeInput = Console.readLine("Alphanumeric code describing the category - ");
            try {
                alphanumericCode = new AlphanumericCode(alphaNumericCodeInput);
            }catch (Exception e){
              e.printStackTrace();
            }
        }while (alphanumericCode == null);

        do {
            descriptionInput = Console.readLine("Description that characterizes a category - ");
            try {
                description = new Description(descriptionInput);
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (description == null);

        do {
            superCategoryInput = Console.readLine("Super category to which the category belongs - ");
            try {
                superCategory = new SuperCategory(superCategoryInput);
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (superCategory == null);


        try {
            this.createCategoryController.createCategory(alphanumericCode, description, superCategory);

        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("You tried to enter a category that already exists in the system.");
        }
        return false;
    }

    @Override
    public String headline() {
        return " Create a Category ";
    }
}
