package eapli.base.productmanagement.application;


import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.TechnicalDescription;
import eapli.base.productmanagement.domain.UniqueInternalCode;

import eapli.base.productmanagement.repository.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


@ApplicationService
public class ListProductService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();
    private final CategoryRepository categoryRepository = PersistenceContext.repositories().category();

    /**
     *
     * @return
     */
    public Product findProductByUniqueInternalCode(UniqueInternalCode code) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);
        return productRepository.findByUniqueInternalCode(code);
    }

    public Iterable<Product> findProductByCategory(Category category){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);
        return productRepository.findProductsByCategory(category);
    }

    public Iterable<Product> findProductByTechnicalDescription(TechnicalDescription technicalDescription){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);
        return productRepository.findProductsByDescription(technicalDescription);
    }

    public Iterable<Product> findProductByBrand(BrandName brandName){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);
        return productRepository.findProductsByBrand(brandName);
    }

    public Iterable<Category> findAllCategories(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);
        return categoryRepository.findAll();
    }

    public Iterable<TechnicalDescription> findAllTechnicalDescriptions(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);
        return productRepository.findAlltechnicalDescription();
    }

    public Iterable<BrandName> findAllBrandNames(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);
        return productRepository.findAllbrandName();
    }

}
