package eapli.base.AGV.application;

import eapli.base.AGV.domain.AGV;
import eapli.base.AGV.domain.AGVId;
import eapli.base.AGV.domain.AGVTask;
import eapli.base.AGV.repositories.AGVRepository;
import eapli.base.AGV.dto.AgvDto;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.dto.ProductOrderDto;
import eapli.base.ordermanagement.repository.OrderRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


import java.util.ArrayList;
import java.util.List;


public class ListOrderBeingPreparedByAGVController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TransactionalContext context = PersistenceContext.repositories().newTransactionalContext();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv(context);
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders(context);

    private AGV agv;

    public ListOrderBeingPreparedByAGVController() {
        this.agv = null;
    }

    public List<AgvDto> getAGVsAvaiable(){

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.WAREHOUSE_EMPLOYEE);
        List<AgvDto> agvsAvaiable = new ArrayList<>();

        Iterable<AGV> agvsIterable = agvRepository.getAGVsAvaiable();

        for (AGV agv : agvsIterable){

            agvsAvaiable.add(new AgvDto(agv.getAgvId().getAGVId()));

        }

        return agvsAvaiable;

    }

    public List<ProductOrderDto> getOrdersWhoNeedToBePreparedByAGV(String idAgv){

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.WAREHOUSE_EMPLOYEE);

        agv = agvRepository.getAGVById(new AGVId(idAgv));

        List<ProductOrderDto> orderDtos = new ArrayList<>();

        Iterable<ProductOrder> orders = orderRepository.getOrdersWhoNeedToBePrepared();

        for (ProductOrder po : orders){
            orderDtos.add(new ProductOrderDto(agv.getAgvId().getAGVId(), po.getOrderId(), po.getStatus().obtainStatus().name()));
        }

        return orderDtos;

    }

    public List<ProductOrderDto> changeStatusOfOrdersSelectToBeingPreparedByAGV(String taskDescription, List<ProductOrderDto> productsOrderSelected) throws Exception {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.WAREHOUSE_EMPLOYEE);
        int count = 0;

        List<ProductOrderDto> orderDtos = new ArrayList<>();
        List<ProductOrder> productOrders = new ArrayList<>();

        for (ProductOrderDto dto : productsOrderSelected){
            productOrders.add(orderRepository.getOrderById(dto.orderId));
        }
        context.beginTransaction();

        agv.assignATaskForAGV(new AGVTask(taskDescription));
        agv.changeStatusOfAGVForOccupied();

        String taskDescriptionAux = taskDescription;

        for (ProductOrder p : productOrders){

            p.changeStatusOfOrderToBeingPreparedByAnAGV();

            boolean flag = agv.addOrdersToATask(taskDescriptionAux, p);

            if (!flag){
                taskDescriptionAux = taskDescription + " " + count;
                agv.assignATaskForAGV(new AGVTask(taskDescriptionAux));
                agv.addOrdersToATask(taskDescriptionAux, p);
            }

            orderDtos.add(new ProductOrderDto(agv.getAgvId().getAGVId(), p.getOrderId(), taskDescriptionAux, p.getStatus().obtainStatus().name()));
            agvRepository.save(agv);
            orderRepository.save(p);

        }

        context.commit();

        return orderDtos;

    }

    public List<ProductOrderDto> changeTheStatusOfOrdersForDispatchedToCustomer(List<ProductOrderDto> listOfOrdersSelected){

        List<ProductOrderDto> productOrderDtoList = new ArrayList<>();
        ProductOrder order;

        context.beginTransaction();
        for (ProductOrderDto dto : listOfOrdersSelected){
            order = orderRepository.getOrderById(dto.orderId);
            order.changeStatusOfOrderToBeingDispatchedToCustomer();

            orderRepository.save(order);
            productOrderDtoList.add(new ProductOrderDto(agv.getAgvId().getAGVId(), order.getOrderId(), order.getOrderStatus().obtainStatus().name()));

        }
        agv.changeStatusOfAGVForFree();
        agvRepository.save(agv);

        context.commit();
        return productOrderDtoList;
    }


}
