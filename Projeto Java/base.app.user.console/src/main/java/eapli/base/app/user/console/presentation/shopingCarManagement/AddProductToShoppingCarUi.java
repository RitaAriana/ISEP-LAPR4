package eapli.base.app.user.console.presentation.shopingCarManagement;

import eapli.base.shoppingcarmanagement.application.AddProductToShoppingCarController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddProductToShoppingCarUi extends AbstractUI {

    private final AddProductToShoppingCarController controller = new AddProductToShoppingCarController();

    private boolean produtoValido;


    @Override
    protected boolean doShow() {

        controller.allProducts();

        String productUniqueInternalCode = null;
        do {
            productUniqueInternalCode = Console.readLine("Product Unique Internal Code");
            produtoValido =controller.findByUniqueInternalCode(productUniqueInternalCode);
            if (!produtoValido) {
                System.out.println("Não existe nenhum produto com esse Unique Internal Code!");
            }
        }while (!produtoValido);
        final int quantity = Integer.parseInt(Console.readLine("Quantity"));
        try {
            controller.addProductShoppingCart(quantity,productUniqueInternalCode);
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong!");
        }

        return false;

    }

    @Override
    public String headline() {
        return "Add Product to Shopping Car";
    }
}
