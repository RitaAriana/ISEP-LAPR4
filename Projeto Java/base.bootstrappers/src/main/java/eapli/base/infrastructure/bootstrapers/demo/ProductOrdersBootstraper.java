package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.ordermanagement.application.RegisterClientOrderController;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.domain.Shipment;
import eapli.framework.actions.Action;
import eapli.framework.time.util.Calendars;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductOrdersBootstraper extends BaseDemoBootstrapper implements Action {

    private final RegisterClientOrderController registerClientOrderController = new RegisterClientOrderController();


    @Override
    public boolean execute() {
        try {
            createOrders();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void createOrders() throws ParseException {

        List<List<String>> addresses = new ArrayList<>();
        List<String> address = new ArrayList<>();
        address.add("Rua 10 do Cerrado");
        address.add("25");
        address.add("4535-334");
        address.add("Aveiro");
        address.add("Portugal");
        addresses.add(address);
        List<String> address1 = new ArrayList<>();
        address1.add("Rua 15 do Cerrado");
        address1.add("37");
        address1.add("4535-334");
        address1.add("Aveiro");
        address1.add("Portugal");
        addresses.add(address1);

        String strDate = "2022/05/28";
        SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
        Calendar orderDate = Calendars.fromDate(df.parse(strDate));

        Map<String, Integer> itens = new HashMap<>();
        itens.put("FRIG123", 2);
        itens.put("EYES123", 1);
        itens.put("HAND123", 5);


        registerClientOrderController.registerOrder(3L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(4L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(5L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(6L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(7L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(8L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(9L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(10L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(11L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(12L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(13L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);

        registerClientOrderController.registerOrder(14L, addresses, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, orderDate, itens);


    }
}
