package eapli.base.app.backoffice.console.productmanagement;

import eapli.base.app.backoffice.console.categorymanagement.CategoryPrinter;
import eapli.base.categorymanagement.domain.Category;

import eapli.base.productmanagement.application.RegisterProductController;

import eapli.base.productmanagement.domain.Photo;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;


/**
 * UI for register a product to the application.
 *
 * Created by Rita Ariana Sobral on 27/04/2022.
 */
public class RegisterProductUI extends AbstractUI {

    private final RegisterProductController registerProductController = new RegisterProductController();


    @Override
    protected boolean doShow() {
        final Iterable<Category> categories = this.registerProductController.getCategories();

        final SelectWidget<Category> selector = new SelectWidget<>("Categories:", categories,
                new CategoryPrinter());
        selector.show();


        String productionCode = null;

        final Category theCategory = selector.selectedElement();

        final String uniqueInternalCode= Console.readLine("Unique Internal Code:");
        final String shortDescription= Console.readLine("Short Description:");
        final String extendedDescription= Console.readLine("Extended Description:");
        final String technicalDescription= Console.readLine("Technical Description:");
        final String barcode = Console.readLine("Barcode");
        final double priceWithoutTaxes= Console.readDouble("Price Without Taxes:");
        final double priceWithTaxes= Console.readDouble("Price With Taxes:");
        final String brandName= Console.readLine("Brand Name:");
        final String reference = Console.readLine("Reference:");
        final Double weight = Console.readDouble("Weight:");
        final Double volume = Console.readDouble("Volume:");

        final Set<String> photoPaths = new HashSet<>();
        String option;

        do {
            String photoPath = Console.readLine("Photo Path:");
            File file = new File(photoPath);
            while (!file.exists()){
                photoPath = Console.readLine("Invalid Photo Path! Insert a new one:");
                file = new File(photoPath);
            }
            if (Files.exists(Paths.get(photoPath)) && !photoPaths.contains(photoPath)){
                photoPaths.add(photoPath);

/*
                try {
                    Runtime rt = Runtime.getRuntime();
                    rt.exec(String.format("open %s",photoPath));
                } catch (IOException e) {
                    Runtime runtime = Runtime.getRuntime();
                    try {
                        runtime.exec(String.format("open %s",photoPath));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }



 */




            } else if (!Files.exists(Paths.get(photoPath))){
                System.out.println("Wrong Path Inserted");
            } else {
                System.out.println("This photo was already added");
            }
            option = Console.readLine("Do you want to add another phot? (yes|no)");

        }while (option.equalsIgnoreCase("yes"));

        System.out.println("- Product Location -\n");

        final Long aisleId= Console.readLong("Aisle Id:");
        final Long rowId= Console.readLong("Row Id:");
        final Long shelfId= Console.readLong("Shelf Id:");

        option = Console.readLine("Do you want to insert the production Code?\n (yes|no)\n");

        if(option.equalsIgnoreCase("yes")){
            productionCode = Console.readLine("Production Code:");
        }

        try {
            this.registerProductController.registerProduct(theCategory,uniqueInternalCode,shortDescription,extendedDescription,technicalDescription,barcode,brandName,reference,productionCode,priceWithoutTaxes,priceWithTaxes,weight,volume,photoPaths,aisleId,rowId,shelfId);
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("You tried to enter a product which already exists in the database..");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Register a Product";
    }
}
