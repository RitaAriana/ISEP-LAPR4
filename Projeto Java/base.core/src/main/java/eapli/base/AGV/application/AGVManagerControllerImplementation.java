package eapli.base.AGV.application;

import eapli.base.AGV.domain.AGV;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


public class AGVManagerControllerImplementation implements AGVManagerController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public AGVManagerControllerImplementation(){}

    @Override
    public boolean assignTasks() {
        //authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE, BaseRoles.ADMIN);
        return new TaskManagement().assignTasks();
    }
}
