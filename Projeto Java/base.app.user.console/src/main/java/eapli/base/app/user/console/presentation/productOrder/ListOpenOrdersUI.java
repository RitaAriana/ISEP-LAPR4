package eapli.base.app.user.console.presentation.productOrder;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.ordermanagement.application.ListOpenOrdersController;
import eapli.base.ordermanagement.dto.ProductOrderDto;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public class ListOpenOrdersUI extends AbstractUI {

    private final ListOpenOrdersController controller = new ListOpenOrdersController();
    private boolean endOp = false;


    @Override
    protected boolean doShow() {
        

       do{
           // get orders
           List<ProductOrderDto> list = controller.getOpenOrdersOfAClient(controller.getClientLogged());

           if(list.size()==0){
               System.out.println("Orders list is empty.");
               endOp = true;
           }

           for(ProductOrderDto po: list){
               System.out.println("==========================================");
               System.out.println("Order ID: " + po.orderId);
               System.out.println(po.clientName);
               System.out.println("Order Status: " + po.status);
           }
           endOp=true;
       } while(!endOp);

       return true;

    }

    @Override
    public String headline() {
        return "Client's Open Orders";
    }

}
