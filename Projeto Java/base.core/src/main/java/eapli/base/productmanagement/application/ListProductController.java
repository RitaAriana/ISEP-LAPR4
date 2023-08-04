package eapli.base.productmanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.domain.*;
import eapli.base.usermanagement.domain.BaseRoles;


public class ListProductController {

    private final ListProductService service = new ListProductService();

    public Iterable<Product> getProductByBrand(BrandName brandName) {
        return service.findProductByBrand(brandName);
    }

    public Iterable<Product> getProductByDescription(TechnicalDescription technicalDescription) {
        return service.findProductByTechnicalDescription(technicalDescription);
    }

    public Iterable<Product> getProductByCategory(Category category) {
        return service.findProductByCategory(category);
    }

    public Iterable<Category> findAllCategories(){
        return service.findAllCategories();
    }

    public Iterable<TechnicalDescription> findAllTechnicalDescriptions(){
        return service.findAllTechnicalDescriptions();
    }

    public Iterable<BrandName> findAllBrandNames(){
        return service.findAllBrandNames();
    }
}
