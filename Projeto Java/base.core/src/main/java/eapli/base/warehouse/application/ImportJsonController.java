package eapli.base.warehouse.application;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehouse.domain.JsonImport;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ImportJsonController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JsonImport jsonImport = new JsonImport();

    public ImportJsonController(){}

    public boolean importWarehouse(final String jsonName){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE, BaseRoles.POWER_USER);

        return jsonImport.importJson(jsonName);
    }
}
