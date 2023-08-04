package eapli.base.ordermanagement.domain;

import eapli.base.AGV.domain.AGV;
import eapli.base.clientmanagement.domain.Client;
import eapli.base.ordermanagement.dto.OrderDTO;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.dto.ProductDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.time.util.Calendars;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class ProductOrder implements AggregateRoot<Long>, Serializable, DTOable<OrderDTO> {
    private static final long serialVersionUID = 1L;

    public enum SourceChannel {
        CALL, EMAIL, MEETING;
    }

    public enum Payment {
        PAYPAL,APPLE_PAY;
    }

    @Version
    private Long version;

    @Id
    @GeneratedValue
    private Long orderId;

    @ManyToOne
    private Client client;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    @Embedded
    private OrderStatus status;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "billing_streetName")),
            @AttributeOverride(name = "doorNumber", column = @Column(name = "billing_doorNumber")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "billing_postalCode")),
            @AttributeOverride(name = "city", column = @Column(name = "billing_city")),
            @AttributeOverride(name = "country", column = @Column(name = "billing_country"))
    })
    private Address billingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "shipping_streetName")),
            @AttributeOverride(name = "doorNumber", column = @Column(name = "shipping_doorNumber")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "shipping_postalCode")),
            @AttributeOverride(name = "city", column = @Column(name = "shipping_city")),
            @AttributeOverride(name = "country", column = @Column(name = "shipping_country"))
    })
    private Address shippingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "no_taxes_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "no_taxes_currency"))
    })
    private Money totalAmountWithoutTaxes;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "taxes_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "taxes_currency"))
    })
    private Money totalAmountWithTaxes;

    @Enumerated(EnumType.STRING)
    private Shipment shipment;

    @Enumerated(EnumType.STRING)
    private Payment payment;

    private OrderVolume orderVolume;

    private OrderWeight orderWeight;

    @Enumerated(EnumType.STRING)
    private SourceChannel sourceChannel;

    @Temporal(TemporalType.DATE)
    private Calendar interactionDate;

    private AdditionalComment additionalComment;

    @ManyToOne
    private SystemUser salesClerk;

    @OneToMany(cascade = CascadeType.ALL,
                orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> newOrderItems;

    @OneToOne
    private AGV agv;

    public OrderStatus getStatus() {
        return status;
    }


    public ProductOrder(final Client client, final Address billingAddress, final Address shippingAddress, final Shipment shipment, final Payment payment, final SourceChannel sourceChannel, final Calendar interactionDate, final AdditionalComment additionalComment, final SystemUser salesClerk, final List<OrderItem> newOrderItems) {
        this.createdOn = Calendars.now();
        this.client = client;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.shipment = shipment;
        this.payment = payment;
        this.sourceChannel = sourceChannel;
        this.interactionDate = interactionDate;
        this.additionalComment = additionalComment;
        this.salesClerk = salesClerk;
        this.newOrderItems = newOrderItems;
        this.totalAmountWithoutTaxes = obtainTotalAmountWithoutTaxes();
        this.totalAmountWithTaxes = obtainTotalAmountWithTaxes();
        this.orderWeight = obtainTotalOrderWeight();
        this.orderVolume = obtainTotalOrderVolume();
        this.status = new OrderStatus(OrderStatus.Status.TO_BE_PREPARED);
        /*
        if(this.client != null) {
            new Notification(this.client.getEmail().toString(),"Encomenda Efetuada!","A sua encomenda já foi registada no sistema e encontra-se a ser preparada!\n Obrigada pela preferência!");
        }

         */
    }

    public ProductOrder(final Client client, final Address billingAddress, final Address shippingAddress, final Shipment shipment, final Payment payment, final SourceChannel sourceChannel, final Calendar interactionDate, final SystemUser salesClerk, final List<OrderItem> newOrderItems) {
        this.createdOn = Calendars.now();
        this.client = client;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.shipment = shipment;
        this.payment = payment;
        this.sourceChannel = sourceChannel;
        this.interactionDate = interactionDate;
        this.salesClerk = salesClerk;
        this.newOrderItems = newOrderItems;
        this.totalAmountWithoutTaxes = obtainTotalAmountWithoutTaxes();
        this.totalAmountWithTaxes = obtainTotalAmountWithTaxes();
        this.orderWeight = obtainTotalOrderWeight();
        this.orderVolume = obtainTotalOrderVolume();
        this.status = new OrderStatus(OrderStatus.Status.TO_BE_PREPARED);
        /*
        if(this.client != null) {
            new Notification(this.client.getEmail().toString(),"Encomenda Efetuada!","A sua encomenda já foi registada no sistema e encontra-se a ser preparada!\n Obrigada pela preferência!");
        }

         */
    }
    public ProductOrder(final Client client, final Address billingAddress, final Address shippingAddress, final Shipment shipment, final Payment payment, final SourceChannel sourceChannel, final Calendar interactionDate, final List<OrderItem> newOrderItems) {
        this.createdOn = Calendars.now();
        this.client = client;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.shipment = shipment;
        this.payment = payment;
        this.sourceChannel = sourceChannel;
        this.interactionDate = interactionDate;
        this.newOrderItems = newOrderItems;
        this.totalAmountWithoutTaxes = obtainTotalAmountWithoutTaxes();
        this.totalAmountWithTaxes = obtainTotalAmountWithTaxes();
        this.orderWeight = obtainTotalOrderWeight();
        this.orderVolume = obtainTotalOrderVolume();
        this.status = new OrderStatus(OrderStatus.Status.TO_BE_PREPARED);
        /*
        if(this.client != null) {
            new Notification(this.client.getEmail().toString(),"Encomenda Efetuada!","A sua encomenda já foi registada no sistema e encontra-se a ser preparada!\n Obrigada pela preferência!");
        }

         */
    }

    protected ProductOrder() {
        //for ORM purposes
    }

    public Money obtainTotalAmountWithoutTaxes() {
        double totalAmountWithoutTaxes = 0;

        for (OrderItem orderItem : newOrderItems) {
            Product product = orderItem.product();
            totalAmountWithoutTaxes += (orderItem.quantity() * product.getPriceWithoutTaxes().amountAsDouble());
        }
        return this.totalAmountWithoutTaxes = Money.euros(totalAmountWithoutTaxes);
    }

    public Money obtainTotalAmountWithTaxes() {
        double totalAmountWithTaxes = 0;

        for (OrderItem orderItem : newOrderItems) {
            Product product = orderItem.product();
            totalAmountWithTaxes += (orderItem.quantity() * product.getPriceWithTaxes().amountAsDouble());
        }
        return this.totalAmountWithTaxes = Money.euros(totalAmountWithTaxes + this.shipment.cost());
    }

    public OrderWeight obtainTotalOrderWeight() {
        long totalWeight = 0;

        for (OrderItem orderItem : newOrderItems) {
            Product product = orderItem.product();
            totalWeight += (orderItem.quantity() * product.getWeight());
        }
        return this.orderWeight = new OrderWeight(totalWeight);
    }

    public OrderVolume obtainTotalOrderVolume() {
        long totalVolume = 0;

        for (OrderItem orderItem : newOrderItems) {
            Product product = orderItem.product();
            totalVolume += (orderItem.quantity() * product.getVolume());
        }
        return this.orderVolume = new OrderVolume(totalVolume);
    }

    public OrderStatus getOrderStatus(){
        return this.status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void changeProductOrderStatus(OrderStatus status) {
        this.status = status;
    }

    public void preparedByAGV(AGV agv){this.agv = agv;}

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return this.orderId;
    }


    @Override
    public String toString() {
        return "ProductOrder{" +
                "version=" + version +
                ", orderId=" + orderId +
                ", client=" + client +
                ", createdOn=" + createdOn +
                ", status=" + status +
                ", billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +
                ", totalAmountWithoutTaxes=" + totalAmountWithoutTaxes +
                ", totalAmountWithTaxes=" + totalAmountWithTaxes +
                ", shipment=" + shipment +
                ", payment=" + payment +
                ", orderVolume=" + orderVolume +
                ", orderWeight=" + orderWeight +
                ", sourceChannel=" + sourceChannel +
                ", interactionDate=" + interactionDate +
                ", additionalComment=" + additionalComment +
                ", salesClerk=" + salesClerk +
                ", newOrderItems=" + newOrderItems +
                ", agv=" + agv +
                '}';
    }

    public Calendar obtainInteractionDate(){return this.interactionDate;}

    public Client obtainClient(){return this.client;}

    public void changeStatusOfOrderToBeingPreparedByAnAGV(){
        status.changeStatusForBeingPreparedByAGV();
    }

    public void changeStatusOfOrderToBeingDispatchedToCustomer(){
        status.changeStatusForBeingDispatchedForCostumer();
    }

    public OrderVolume getOrderVolume() {
        return orderVolume;
    }

    public OrderWeight getOrderWeight() {
        return orderWeight;
    }

    public Client getClient(){return client;}

    @Override
    public OrderDTO toDTO() {
        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(createdOn.getTime());
        return new OrderDTO(orderId,date,status.toString());
    }


}
