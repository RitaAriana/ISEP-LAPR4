package eapli.base.persistence.impl.jpa;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.repositories.CategoryRepository;

import javax.persistence.TypedQuery;

public class JpaCategoryRepository extends BasepaRepositoryBase<Category, Long, Long> implements CategoryRepository {

    JpaCategoryRepository() {
        super("categoryId");
    }

    @Override
    public Iterable<Category> findAll(){
        final TypedQuery<Category> query = entityManager().createQuery(
                "SELECT c FROM Category c",
                Category.class);

        return query.getResultList();
    }
}
