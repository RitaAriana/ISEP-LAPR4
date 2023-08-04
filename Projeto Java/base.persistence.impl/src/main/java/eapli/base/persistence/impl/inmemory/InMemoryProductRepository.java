package eapli.base.persistence.impl.inmemory;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.TechnicalDescription;
import eapli.base.productmanagement.domain.UniqueInternalCode;
import eapli.base.productmanagement.repository.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductRepository extends InMemoryDomainRepository<Product, Long> implements ProductRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Product findByUniqueInternalCode(UniqueInternalCode uniqueInternalCode) {
        Optional<Product> product = matchOne(e -> e.uniqueInternalCode().equals(uniqueInternalCode));
        Product product1 = product.get();
        return product1;
    }

    @Override
    public Iterable<Product> findProductsByCategory(Category category) {
        return match(e -> e.category().equals(category));
    }

    @Override
    public Iterable<Product> findProductsByBrand(BrandName brandName) {
        return match(e -> e.brandName().equals(brandName));
    }

    @Override
    public Iterable<Product> findProductsByDescription(TechnicalDescription technicalDescription) {
        return match(e->e.technicalDescription().equals(technicalDescription));
    }

    @Override
    public Iterable<TechnicalDescription> findAlltechnicalDescription() {
        return null;
    }

    @Override
    public Iterable<BrandName> findAllbrandName() {
        return null;
    }


}
