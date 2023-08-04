package eapli.base.persistence.impl.jpa;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.TechnicalDescription;
import eapli.base.productmanagement.domain.UniqueInternalCode;
import eapli.base.productmanagement.repository.ProductRepository;
import org.springframework.security.core.parameters.P;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JpaProductRepository extends BasepaRepositoryBase<Product, Long, Long> implements ProductRepository {

    JpaProductRepository() {
        super("productId");
    }



    @Override
    public Product findByUniqueInternalCode(UniqueInternalCode uniqueInternalCode) {
        try {
        Query query = super.entityManager().createQuery("SELECT e FROM Product e WHERE e.uniqueInternalCode=:uniqueInternalCode");
        query.setParameter("uniqueInternalCode", uniqueInternalCode);
            Product product = (Product) query.getSingleResult();
            return product;
        } catch (NoResultException e){
            return null;
        }

    }

    @Override
    public Iterable<Product> findProductsByCategory(Category category) {
        final TypedQuery<Product> query = entityManager().createQuery(
                "SELECT p FROM Product p WHERE p.category = :category",
                Product.class);
        query.setParameter("category", category);

        return query.getResultList();
    }

    @Override
    public Iterable<Product> findProductsByBrand(BrandName brandName) {
        final TypedQuery<Product> query = entityManager().createQuery(
                "SELECT p FROM Product p WHERE p.brandName = :brandName",
                Product.class);
        query.setParameter("brandName", brandName);

        return query.getResultList();
    }

    @Override
    public Iterable<Product> findProductsByDescription(TechnicalDescription technicalDescription) {
        final TypedQuery<Product> query = entityManager().createQuery(
                "SELECT p FROM Product p WHERE p.technicalDescription = :technicalDescription",
                Product.class);
        query.setParameter("technicalDescription", technicalDescription);

        return query.getResultList();
    }

    @Override
    public Iterable<TechnicalDescription> findAlltechnicalDescription() {
        final TypedQuery<Product> query = entityManager().createQuery(
                "SELECT p FROM Product p",
                Product.class);

        Iterable<Product> products = query.getResultList();
        List<TechnicalDescription> technicalDescriptions = new ArrayList<>();

        for (Product p : products){
            if (!technicalDescriptions.contains(p.technicalDescription())) technicalDescriptions.add(p.technicalDescription());
        }
        return technicalDescriptions;
    }

    @Override
    public Iterable<BrandName> findAllbrandName() {
        final TypedQuery<Product> query = entityManager().createQuery(
                "SELECT p FROM Product p",
                Product.class);

        Iterable<Product> products = query.getResultList();
        List<BrandName> brandNameArrayList = new ArrayList<>();

        for (Product p : products){
            if (!brandNameArrayList.contains(p.brandName())) brandNameArrayList.add(p.brandName());


        }
        return brandNameArrayList;

    }


}
