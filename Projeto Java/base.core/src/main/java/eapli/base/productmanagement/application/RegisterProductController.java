package eapli.base.productmanagement.application;


import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.clientmanagement.domain.*;
import eapli.base.clientmanagement.repositories.ClientRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.*;
import eapli.base.productmanagement.repository.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Controller responsible for registering a product in the application.
 *
 * Created by Rita Ariana Sobral on 27/04/2022.
 */
public class RegisterProductController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();
    private final CategoryRepository categoryRepository = PersistenceContext.repositories().category();

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Product registerProduct(final Category category,final String uniqueInternalCode, final String shortDescription, final String extendedDescription, final String technicalDescription,final String barcode,final String brandName,final String reference, final String productionCode,final double priceWithoutTaxes, final double priceWithTaxes, final Double weight, final Double volume, final Set<String> photos, final Long aisleId, final Long rowId, final Long shelfId) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        Set<Photo> photoSet = new HashSet<>();

        for (String path: photos){
            photoSet.add(new Photo(path));
        }

        Product newProduct = new Product(category,new UniqueInternalCode(uniqueInternalCode), new ShortDescription(shortDescription),new ExtendedDescription(extendedDescription),new TechnicalDescription(technicalDescription),new Barcode(barcode), new BrandName(brandName),new Reference(reference),Money.euros(priceWithoutTaxes), Money.euros(priceWithTaxes), weight, volume,photoSet,rowId,shelfId,aisleId);

        if(productionCode != null){
            newProduct.addProductionCode(new ProductionCode(productionCode));
        }
        return productRepository.save(newProduct);
    }


}
