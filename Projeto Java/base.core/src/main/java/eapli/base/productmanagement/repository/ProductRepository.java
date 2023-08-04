package eapli.base.productmanagement.repository;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.Product;

import eapli.base.productmanagement.domain.TechnicalDescription;
import eapli.base.productmanagement.domain.UniqueInternalCode;
import eapli.framework.domain.repositories.DomainRepository;

public interface ProductRepository extends DomainRepository<Long, Product> {

    Product findByUniqueInternalCode(UniqueInternalCode uniqueInternalCode);

    Iterable<Product> findProductsByCategory(Category category);

    Iterable<Product> findProductsByBrand(BrandName brandName);

    Iterable<Product> findProductsByDescription(TechnicalDescription technicalDescription);

    Iterable<TechnicalDescription> findAlltechnicalDescription();

    Iterable<BrandName> findAllbrandName();
}
