package eapli.base.ordermanagement.application;

import eapli.base.clientmanagement.domain.Client;
import eapli.base.clientmanagement.repositories.ClientRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;

import eapli.base.productmanagement.application.ListProductService;

import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.UniqueInternalCode;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


import java.util.*;

public class RegisterClientOrderController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListProductService svcProducts = new ListProductService();
    private final ClientRepository clientRepository = PersistenceContext.repositories().client();

    private Client client;
    private Product product;

    public ProductOrder registerOrder(List<List<String>> addresses, Shipment shipment, ProductOrder.Payment payment, ProductOrder.SourceChannel sourceChannel, Calendar interactionDate, String additionalCommentText, Map<String, Integer> items) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        Address billingAddress = new Address(addresses.get(0).get(0), addresses.get(0).get(1),addresses.get(0).get(2),
                addresses.get(0).get(3), addresses.get(0).get(4));

        Address deliveryAddress = new Address(addresses.get(1).get(0), addresses.get(1).get(1),addresses.get(1).get(2),
                addresses.get(1).get(3), addresses.get(1).get(4));

        AdditionalComment additionalComment = new AdditionalComment(additionalCommentText);

        List<OrderItem> orderItems = new ArrayList<>();
        fillOrderItems(items, orderItems);

        ProductOrder order = new ProductOrder(client, billingAddress, deliveryAddress, shipment, payment, sourceChannel, interactionDate, additionalComment, authz.session().get().authenticatedUser(), orderItems);

        return PersistenceContext.repositories().orders().save(order);
    }

    public ProductOrder registerOrder(List<List<String>> addresses, Shipment shipment, ProductOrder.Payment payment, ProductOrder.SourceChannel sourceChannel, Calendar interactionDate, Map<String, Integer> items) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        Address billingAddress = new Address(addresses.get(0).get(0), addresses.get(0).get(1),addresses.get(0).get(2),
                addresses.get(0).get(3), addresses.get(0).get(4));

        Address deliveryAddress = new Address(addresses.get(1).get(0), addresses.get(1).get(1),addresses.get(1).get(2),
                addresses.get(1).get(3), addresses.get(1).get(4));

        List<OrderItem> orderItems = new ArrayList<>();
        fillOrderItems(items, orderItems);

        ProductOrder order = new ProductOrder(client, billingAddress, deliveryAddress, shipment, payment, sourceChannel, interactionDate, authz.session().get().authenticatedUser(), orderItems);

        return PersistenceContext.repositories().orders().save(order);
    }

    public ProductOrder registerOrder(Long clientId, List<List<String>> addresses, Shipment shipment, ProductOrder.Payment payment, ProductOrder.SourceChannel sourceChannel, Calendar interactionDate, Map<String, Integer> items) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);
        verifyClientById(clientId);

        Address billingAddress = new Address(addresses.get(0).get(0), addresses.get(0).get(1),addresses.get(0).get(2),
                addresses.get(0).get(3), addresses.get(0).get(4));

        Address deliveryAddress = new Address(addresses.get(1).get(0), addresses.get(1).get(1),addresses.get(1).get(2),
                addresses.get(1).get(3), addresses.get(1).get(4));

        List<OrderItem> orderItems = new ArrayList<>();
        fillOrderItems(items, orderItems);

        ProductOrder order = new ProductOrder(client, billingAddress, deliveryAddress, shipment, payment, sourceChannel, interactionDate, authz.session().get().authenticatedUser(), orderItems);

        return PersistenceContext.repositories().orders().save(order);
    }


    public boolean verifyClientById(Long clientId) {
        Optional<Client> chosenClient = clientRepository.ofIdentity(clientId);
        if(chosenClient.isPresent())
            client = chosenClient.get();
        return client != null;
    }

    public boolean verifyProductById(UniqueInternalCode code) {
        Product chosenProduct = svcProducts.findProductByUniqueInternalCode(code);

        return chosenProduct != null;
    }

    private void fillOrderItems(Map<String, Integer> items, List<OrderItem> setItems) {

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String code = entry.getKey();
            Integer quantity = entry.getValue();
            Product product = svcProducts.findProductByUniqueInternalCode(UniqueInternalCode.valueOf(code));
            OrderItem orderItem = new OrderItem(quantity, product);
            setItems.add(orderItem);
        }
    }
}
