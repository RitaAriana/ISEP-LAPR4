package eapli.base.ordermanagement.application;
import eapli.base.AGV.domain.AGVId;
import eapli.base.AGV.dto.AgvDto;
import eapli.base.AGV.application.ConfigureAGVController;
import eapli.base.AGV.domain.AGV;
import eapli.base.AGV.domain.AGVStatus;
import eapli.base.AGV.repositories.AGVRepository;
import eapli.base.ordermanagement.domain.OrderStatus;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repository.OrderRepository;
import eapli.base.ordermanagement.dto.ProductOrderDto;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ForceOrderPrepController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    private final OrderRepository orderRepository= PersistenceContext.repositories().orders();
    private final ConfigureAGVController configureAGVController = new ConfigureAGVController();

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();

    private ProductOrder productOrder;
    private AGV agv;

    public ProductOrder getOrder(Long orderId){
        return orderRepository.getOrderById(orderId);

    }


    public AGV getAGV(AGVId agvId){
        return agvRepository.getAGVById(agvId);
    }

    public AGV getAGVSt(String agvId){
        return agvRepository.getAGVByIdSt(agvId);
    }


    public List<AgvDto> showAvailableAGVs(){
        Iterable<AGV> aux = agvRepository.findAll();
        List<AgvDto> list = new ArrayList<>();
        for(AGV agv : aux ){
            if(agv.getAgvStatus().obtainStatus().equals(AGVStatus.Status.FREE)){
                String id = agv.getAgvId().getAGVId();
                String volume = agv.getMaxVolumeCapacity().toString();
                String weight = agv.getMaxWeightCapacity().toString();
                AgvDto dto = new AgvDto(id,volume,weight);
                list.add(dto);
            }
        }
        return list;
    }

    public List<ProductOrderDto> getOrdersToBePrepared(){
        Iterable<ProductOrder> aux = orderRepository.findAll();
        Iterator<ProductOrder> it = aux.iterator();
        List<ProductOrderDto> list = new ArrayList<>();

        OrderStatus.Status st = OrderStatus.Status.TO_BE_PREPARED;
        while(it.hasNext()){
            ProductOrder productOrder = it.next();

            if(productOrder.getOrderStatus().obtainStatus().equals(st)) {
                Long id = productOrder.getOrderId();
                String date = productOrder.obtainInteractionDate().toString();
                String name = productOrder.obtainClient().obtainName().toString();
                String orderTotal = productOrder.obtainTotalAmountWithTaxes().toString();
                ProductOrderDto productOrderDto = new ProductOrderDto(id, date, name, orderTotal);
                list.add(productOrderDto);
            }
        } return list;
    }


    public ProductOrder forceOrderPrep(String productOrderid, AGVId agvid){

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE, BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.SALES_CLERK);
        txCtx.beginTransaction();

        try{
            OrderStatus.Status st = OrderStatus.Status.BEING_PREPARED_BY_AGV;
            OrderStatus orderStatus = new OrderStatus(st);
            ProductOrder order = getOrder(Long.parseLong(productOrderid));
            order.changeProductOrderStatus(orderStatus);


            AGV agv1 = null;

            try{
                agv1 = getAGVSt(agvid.getAGVId());
                System.out.println();

            } catch(Exception e){
                System.out.println(e.getMessage());
            }

            agv1.changeStatusOfAGVForOccupied();
            order.preparedByAGV(agv1);
            agvRepository.save(agv1);
            orderRepository.save(order);

            txCtx.commit();
        } catch (Exception e){
            txCtx.rollback();
        }
        return this.productOrder;

    }




}
