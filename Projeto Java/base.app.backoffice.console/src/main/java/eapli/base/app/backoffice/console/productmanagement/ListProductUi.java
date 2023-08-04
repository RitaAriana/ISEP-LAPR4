package eapli.base.app.backoffice.console.productmanagement;

import eapli.base.app.backoffice.console.categorymanagement.CategoryPrinter;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.BrandName;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.TechnicalDescription;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;


public class ListProductUi extends AbstractUI {

    private ListProductController listProductController = new ListProductController();

    @Override
    protected boolean doShow() {
        Iterable<Product> products = null;
        System.out.println("Choose the method of creating the catalog:");
        System.out.println("1 - Description");
        System.out.println("2 - Brand");
        System.out.println("3 - Category");
        System.out.println("0 - Exit");

        int option = Console.readOption(1, 3, 0);

        switch (option){
            case 1:
                final Iterable<TechnicalDescription> technicalDescriptions = this.listProductController.findAllTechnicalDescriptions();

                final SelectWidget<TechnicalDescription> selector = new SelectWidget<>("Choose the description:", technicalDescriptions,
                        new TechnicalDescriptionPrinter());
                selector.show();

                final TechnicalDescription technicalDescription = selector.selectedElement();

                products = listProductController.getProductByDescription(technicalDescription);
                break;

            case 2:

                final Iterable<BrandName> brandNames = this.listProductController.findAllBrandNames();

                final SelectWidget<BrandName> selector2 = new SelectWidget<>("Choose the brand:", brandNames,
                        new BrandNamePrinter());
                selector2.show();

                final BrandName brandName = selector2.selectedElement();

                products = listProductController.getProductByBrand(brandName);
                break;

            case 3:
                final Iterable<Category> categories = this.listProductController.findAllCategories();

                final SelectWidget<Category> selector3 = new SelectWidget<>("Choose the Category:", categories,
                        new CategoryPrinter());
                selector3.show();

                final Category category = selector3.selectedElement();

                products = listProductController.getProductByCategory(category);

                break;
        }

        for (Product p : products) System.out.println(p);

        return false;
    }

    @Override
    public String headline() {
        return "Product Catalog";
    }
}
