package eapli.base.categorymanagement.aplication;

import eapli.base.categorymanagement.domain.*;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.stereotype.Component;


/**
 * Controller responsible for creating a new category in the application.
 *
 * Created by Manuela Leite on 27/04/20022
 */

@Component
@UseCaseController
public class CreateCategoryController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CategoryRepository categoryRepository = PersistenceContext.repositories().category();


    public Category createCategory(AlphanumericCode alphanumericCode, Description description, SuperCategory superCategory){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        final var newCategory = new CategoryFactory()
                .withAlphanumericaCode(alphanumericCode)
                .withSuperCategory(superCategory)
                .withDescription(description)
                .build();

        return categoryRepository.save(newCategory);

    }
}
