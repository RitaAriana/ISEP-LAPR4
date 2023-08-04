package eapli.base.app.backoffice.console.ordermanagement;

import eapli.base.ordermanagement.dto.ProductOrderDto;
import eapli.framework.visitor.Visitor;

public class ProductOrderDtoPrinter implements Visitor {

    @Override
    public void visit(Object visitee) {
        ProductOrderDto productOrderDto = (ProductOrderDto) visitee;
        System.out.printf("Order number -> %d \n", productOrderDto.orderId);
        System.out.printf("AGV ID assigned to this order -> %s\n", productOrderDto.agvId);
        System.out.printf("Order Status -> %s\n", productOrderDto.status);
        System.out.println("--------------------------------------------------------");
    }
}
