package eapli.base.persistence.impl.inmemory;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCategoryRepository extends InMemoryDomainRepository<Category, Long> implements CategoryRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Category> findAll(){
        return findAll();
    }

}
