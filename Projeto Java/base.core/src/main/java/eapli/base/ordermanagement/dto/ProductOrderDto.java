package eapli.base.ordermanagement.dto;

import eapli.framework.representations.dto.DTO;

import java.lang.annotation.Annotation;

public class ProductOrderDto implements DTO {

    public long orderId;

    public String date;

    public String customerName;

    public String total;

    public String agvId;

    public String taskDescription;

    public String status;

    public String clientName;

    public ProductOrderDto(String agvId, Long orderId, String taskDescription, String status) {
        this.orderId = orderId;
        this.agvId = agvId;
        this.taskDescription = taskDescription;
        this.status = status;
    }


    public ProductOrderDto(String agvId, Long orderId, String status) {
        this.orderId = orderId;
        this.agvId = agvId;

        this.status = status;
    }

    public ProductOrderDto(long id, String client, String total, String status){
        this.orderId = id;
        this.clientName = client;
        this.total = total;
        this.status = status;
    }

    public ProductOrderDto(long id, String client,String status){
        this.orderId = id;
        this.clientName = client;
        this.status = status;
    }


    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
