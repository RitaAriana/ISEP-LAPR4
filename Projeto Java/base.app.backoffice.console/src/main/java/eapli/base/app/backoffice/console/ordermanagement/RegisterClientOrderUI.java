package eapli.base.app.backoffice.console.ordermanagement;

import eapli.base.app.backoffice.console.clientmanagement.RegisterClientUI;
import eapli.base.app.backoffice.console.productmanagement.ListProductUi;
import eapli.base.ordermanagement.application.RegisterClientOrderController;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.domain.Shipment;
import eapli.base.productmanagement.domain.UniqueInternalCode;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

/**
 * UI for register a client order to the application.
 *
 * Created by Rita Ariana Sobral on 28/04/2022.
 */
public class RegisterClientOrderUI extends AbstractUI {

    private final RegisterClientOrderController theController = new RegisterClientOrderController();

    @Override
    protected boolean doShow() {

        Map<String, Integer> items = new HashMap<>();

        System.out.println(">> PRODUCTS OF THE ORDER");

        String moreProducts = "yes";

        while(moreProducts.equalsIgnoreCase("yes")) {
            String answer = Console.readLine("Do you want to view the Products Catalog?\n (yes|no)\n");

            if (answer.equalsIgnoreCase("yes")) {
                new ListProductUi().show();
            }
            final String productCode = Console.readLine("Product Unique Internal Code: ");

            boolean productExist = this.theController.verifyProductById(UniqueInternalCode.valueOf(productCode));
            if (!productExist) {
                System.out.println("There has not been matches in our Catalog for that Product Code.");
            } else {
                Integer quantity = Console.readInteger("How many units of this product do you want?");

                if(items.get(productCode) != null) {
                    System.out.println("You have already chosen that Product.");
                } else {
                    items.put(productCode, quantity);
                }
                moreProducts = Console.readLine("Product added successfully. Do you want to add more Products?");
            }
        }

        final Long clientId = Console.readLong("Client ID: ");

        boolean clientExist = this.theController.verifyClientById(clientId);

        if(!clientExist) {
            new RegisterClientUI().show();
        }

        List<List<String>> addresses = new ArrayList<>();

        for(int i=0;i<2;i++){

            if (i == 0){
                System.out.println("- Billing Address -");
            } else {
                System.out.println("- Shipping Address -");
            }

            List<String> address = new ArrayList<>();

            String streetName = Console.readLine("Street Name:");
            address.add(streetName);
            String doorNumber = Console.readLine("Door Number:");
            address.add(doorNumber);
            String postalCode = Console.readLine("Postal Code:");
            address.add(postalCode);
            String city = Console.readLine("City:");
            address.add(city);
            String country = Console.readLine("Country:");
            address.add(country);

            addresses.add(address);
        }

        int i = 1;

        System.out.println("- Shipment -");
        for (Shipment options : Shipment.values()) {
            System.out.printf("%d. %s | Cost: %s%n", i , options.name(),options.cost());
            i++;
        }

        int optionShipment = Console.readInteger("Select the option:") - 1;

        if (optionShipment >= i ||  optionShipment < 0) {
            throw new UnsupportedOperationException("Invalid Option");
        }

        Shipment shipment = Shipment.values()[optionShipment];

        i = 1;

        System.out.println("- Payment -");
        for (ProductOrder.Payment options : ProductOrder.Payment.values()) {
            System.out.printf("%d. %s%n", i , options.name());
            i++;
        }

        int optionPayment = Console.readInteger("Select the option:") - 1;

        if (optionPayment >= i || optionPayment < 0) {
            throw new UnsupportedOperationException("Invalid Option");
        }

        ProductOrder.Payment payment = ProductOrder.Payment.values()[optionPayment];



        i = 1;

        System.out.println("- Source Channel -");
        for (ProductOrder.SourceChannel options : ProductOrder.SourceChannel.values()) {
            System.out.printf("%d. %s%n", i , options.name());
            i++;
        }

        int optionSourceChannel = Console.readInteger("Select the option:") - 1;

        if (optionSourceChannel >= i || optionSourceChannel < 0) {
            throw new UnsupportedOperationException("Invalid Option");
        }

        ProductOrder.SourceChannel sourceChannel = ProductOrder.SourceChannel.values()[optionSourceChannel];

        Calendar interactionDate = Console.readCalendar("Interaction Date:","yyyy/MM/dd");

        String option = Console.readLine("Do you want to enter any additional comments?\n (yes|no)\n");

        if(option.equalsIgnoreCase("yes")){
            String additionalComment = Console.readLine("Additional Comments:");
            theController.registerOrder(addresses,shipment,payment,sourceChannel,interactionDate,additionalComment,items);
        } else {
            theController.registerOrder(addresses,shipment,payment,sourceChannel,interactionDate,items);

        }

        return false;
    }

    @Override
    public String headline() {
        return "Register Client Order";
    }

}
