package eapli.base.surveymanagement.domain;


public enum Criterio  {

    ORDER(Info.ORDER),
    PRODUCT(Info.PRODUCT),
    AGE(Info.AGE),
    NONE(Info.NONE);

    private static class Info {
        private static String ORDER = "After placing an order";
        private static String PRODUCT = "Customer buys a certain product";
        private static String AGE = "Customer belongs to a certain age group";
        private static String NONE = "No restrictions";
    }

    Criterio(final String info) {
        this.info = info;
    }

    private final String info;

    @Override
    public String toString() {
        return info;
    }

}


