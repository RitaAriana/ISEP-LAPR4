package eapli.base.surveymanagement.domain;

public enum Obligatoriness {
    MANDATORY, OPTIONAL, CONDITION_DEPENDENT;


    public static Obligatoriness getObligatoriness(String obligatoriness){

        if (obligatoriness.equals("mandatory")){
            return Obligatoriness.MANDATORY;
        } else if (obligatoriness.equals("optional")){
            return Obligatoriness.OPTIONAL;
        } else if (obligatoriness.equals("condition dependent")){
            return Obligatoriness.CONDITION_DEPENDENT;
        }
        return null;
    }
}
