package eapli.base.app.backoffice.console.productmanagement;

import eapli.base.productmanagement.domain.TechnicalDescription;
import eapli.framework.visitor.Visitor;

public class TechnicalDescriptionPrinter implements Visitor<TechnicalDescription> {

    @Override
    public void visit(TechnicalDescription visitee) {
        System.out.printf("%s", visitee);
    }
}
