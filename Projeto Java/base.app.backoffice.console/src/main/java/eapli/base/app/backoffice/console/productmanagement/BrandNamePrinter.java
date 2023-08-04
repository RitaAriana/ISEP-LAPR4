package eapli.base.app.backoffice.console.productmanagement;

import eapli.base.productmanagement.domain.BrandName;
import eapli.framework.visitor.Visitor;

public class BrandNamePrinter implements Visitor<BrandName> {

    @Override
    public void visit(BrandName visitee) {
        System.out.printf("%s", visitee);
    }
}
