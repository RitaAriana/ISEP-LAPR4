package eapli.base.app.backoffice.console.ordermanagement;

import eapli.base.ordermanagement.application.ViewOrdersSentToCustomerController;
import eapli.base.ordermanagement.dto.OrderDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Iterator;

public class ViewOrdersSentToCustomerUI extends AbstractUI {

    private final ViewOrdersSentToCustomerController viewOrdersSentToCustomerController = new ViewOrdersSentToCustomerController();

    @Override
    protected boolean doShow() {

        Iterator<OrderDTO> orders = viewOrdersSentToCustomerController.getOrdersDispatchedForCustomerDelivery().iterator();

        if(!orders.hasNext()){
            System.out.println("De momento não existem encomendas no estado DISPATCHED FOR COSTUMER");
        } else {
            System.out.println("--- Encomendas no estado DISPATCHED FOR COSTUMER ---");

            while (orders.hasNext()) {
                OrderDTO order = orders.next();
                System.out.println(order);
            }
            System.out.println();

            String option = Console.readLine("Deseja alterar o estado de alguma encomenda para DELIVERED BY CARRIER?\n(sim|não)\n");

            boolean invalidOrder;

            while (option.equalsIgnoreCase("sim")){

                do {
                    try {
                        String orderId = Console.readLine("Order ID:");
                        viewOrdersSentToCustomerController.findDispacthedOrderById(orderId);
                        invalidOrder = false;
                        viewOrdersSentToCustomerController.changeStatusToBeingDelivered(orderId);
                    } catch (Exception e) {
                        System.out.println("Invalid Id.");
                        invalidOrder = true;
                    }
                } while (invalidOrder);

                option = Console.readLine("Deseja alterar o estado de mais alguma encomenda?\n(sim|não)\n");
            }

        }


        return true;
    }

    @Override
    public String headline() {
        return "Visualizar Encomendas no estado DISPATCHED FOR COSTUMER";
    }
}
