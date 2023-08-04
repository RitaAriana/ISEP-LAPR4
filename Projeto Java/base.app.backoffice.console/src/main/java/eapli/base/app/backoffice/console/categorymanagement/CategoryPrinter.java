package eapli.base.app.backoffice.console.categorymanagement;

import eapli.base.categorymanagement.domain.Category;
import eapli.framework.visitor.Visitor;

public class CategoryPrinter implements Visitor<Category> {

    @Override
    public void visit(Category visitee) {
        System.out.printf("%s", visitee.identity());
    }
}
