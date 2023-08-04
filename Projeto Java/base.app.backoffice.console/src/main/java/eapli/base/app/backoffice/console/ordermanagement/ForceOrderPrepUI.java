package eapli.base.app.backoffice.console.ordermanagement;

import eapli.base.AGV.domain.AGVId;
import eapli.base.AGV.dto.AgvDto;
import eapli.base.AGV.modules.WarehouseMovement;
import eapli.base.ordermanagement.application.ForceOrderPrepController;
import eapli.base.ordermanagement.dto.ProductOrderDto;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

/**
 * UI for register a client order to the application.
 *
 * Created by 1201382@isep.ipp.pt
 */
public class ForceOrderPrepUI extends AbstractUI {

    private final ForceOrderPrepController forceOrderController = new ForceOrderPrepController();

    private Boolean operationError=false;


    @Override
    protected boolean doShow() {

        do{
            try {

                /*WarehouseMovement wh = new WarehouseMovement();
                wh.findById("1");*/


                // escolher order

                System.out.println("Select the order you want to force:");
                List<ProductOrderDto> ordersToBePreparedList = forceOrderController.getOrdersToBePrepared();
                if(ordersToBePreparedList.isEmpty()){
                    System.out.println("\nThere are no orders needing preparation.");
                    operationError=true;
                }
                int index = 1;
                for(ProductOrderDto po: ordersToBePreparedList) {
                    System.out.println(index + " - " + po.orderId + " - " + po.customerName + " - " + po.date + " - " + po.total);
                    index++;
                }
                int order = Integer.parseInt(Console.readLine("Choose an Order"));
                ProductOrderDto productOrder = ordersToBePreparedList.get(order-1);



                // escolher agv
                List<AgvDto> availableAGVList = forceOrderController.showAvailableAGVs();

                int index1 = 1;
                for(AgvDto agv: availableAGVList) {
                    System.out.println(index1 + " - id:" + agv.getId() + " - volume:" + agv.getVolume() + " - weight:" + agv.getWeight());
                    index1++;
                }
                int a = Integer.parseInt(Console.readLine("Choose an agv"));
                AgvDto agv = availableAGVList.get(a-1);

                // force order prep
                forceOrderController.forceOrderPrep(Long.toString(productOrder.orderId), new AGVId(agv.id));
                

            } catch(Exception e){
                System.out.println(e.getMessage());
                operationError=true;
            }

        } while(operationError);

        System.out.println("Order Forced Successfuly");
        return true;

    }

    @Override
    public String headline() {
        return "Force Order Prep";
    }

}
