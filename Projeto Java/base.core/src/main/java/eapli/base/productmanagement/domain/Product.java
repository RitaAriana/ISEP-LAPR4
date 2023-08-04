package eapli.base.productmanagement.domain;

import eapli.base.categorymanagement.domain.Category;

import eapli.base.productmanagement.dto.ProductDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Money;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product implements AggregateRoot<Long>, Serializable, DTOable<ProductDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long productId;

    @Column(unique = true,nullable = false)
    private UniqueInternalCode uniqueInternalCode;

    @ManyToOne
    private Category category;

    private ShortDescription shortDescription;

    private TechnicalDescription technicalDescription;

    private ExtendedDescription extendedDescription;

    private Double weight;

    private Double volume;

    private Reference reference;

    @Column(unique = true,nullable = false)
    private Barcode barcode;

    private BrandName brandName;

    @ElementCollection
    private Set<Photo> photos = new HashSet<>();

    private ProductionCode productionCode;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "no_taxes_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "no_taxes_currency"))
    })
    private Money priceWithoutTaxes;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "taxes_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "taxes_currency"))
    })
    private Money priceWithTaxes;

    private Long rowId;

    private Long shelfId;

    private Long aisleId;

    private boolean isActive;



    public Product(final Category category,final UniqueInternalCode uniqueInternalCode, final ShortDescription shortDescription,final ExtendedDescription extendedDescription,final TechnicalDescription technicalDescription,final Barcode barcode,final BrandName brandName, final Reference reference,final Money priceWithoutTaxes, final Money priceWithTaxes, final Double weight, final  Double volume, final Set<Photo> photos, final Long rowId, final Long shelfId, final Long aisleId){
        this.category=category;
        this.uniqueInternalCode=uniqueInternalCode;
        this.shortDescription=shortDescription;
        this.extendedDescription=extendedDescription;
        this.technicalDescription=technicalDescription;
        this.priceWithoutTaxes=priceWithoutTaxes;
        this.priceWithTaxes=priceWithTaxes;
        this.weight=weight;
        this.volume=volume;
        this.barcode=barcode;
        this.brandName=brandName;
        this.reference=reference;
        this.photos = photos;
        this.aisleId = aisleId;
        this.rowId = rowId;
        this.shelfId = shelfId;
        this.isActive = true;
    }

    protected Product() {
        //for ORM only
    }


    public void addProductionCode(final ProductionCode productionCode) {
        this.productionCode = productionCode;
    }


    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return this.productId;
    }

    public UniqueInternalCode uniqueInternalCode() {
        return this.uniqueInternalCode;
    }

    public void deactivateOrActivateProduct (boolean isActive){
        this.isActive=isActive;
    }

    public Money getPriceWithoutTaxes() {
        return priceWithoutTaxes;
    }

    public Money getPriceWithTaxes() {
        return priceWithTaxes;
    }


    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {

        return "------* Product *------\n" +
                "Product Id - " + productId + "\n" +
                "Unique Internal Code - " + uniqueInternalCode + "\n" +
                "Technical Description - " + technicalDescription + "\n" +
                "Brand Name - " + brandName + "\n";
    }

    public Category category(){
        return this.category;
    }

    public BrandName brandName(){
        return this.brandName;
    }

    public TechnicalDescription technicalDescription(){
        return  this.technicalDescription;

    }


    @Override
    public ProductDTO toDTO() {
        return new ProductDTO(uniqueInternalCode.toString(),shortDescription.toString(),priceWithoutTaxes.amount());
    }
}
