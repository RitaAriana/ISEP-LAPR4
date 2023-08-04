package eapli.base.shoppingcarmanagement.domain;

import eapli.base.clientmanagement.domain.Client;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCar implements AggregateRoot<Long>, Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long shoppingCarId;

    @OneToOne
    private Client client;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "shopping_car_id")
    private List<ShopCarItem> items;

    public ShoppingCar(final Client client) {
        Preconditions.noneNull(client);
        this.client = client;
        this.items = new ArrayList<>();
    }

    protected ShoppingCar() {
        //for ORM purposes
    }

    public List<ShopCarItem> getItems(){
        return items;
    }
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
        return this.shoppingCarId;
    }

    public boolean addProductToShoppingCar(ShopCarItem shopCarItem) {
        for (ShopCarItem item : items){
            if(item.product().uniqueInternalCode().equals(shopCarItem.product().uniqueInternalCode())){
                int quant = item.quantity() + shopCarItem.quantity();
                item.setQuantity(quant);
                return true;
            }
        }
        return items.add(shopCarItem);
    }
}
