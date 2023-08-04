package eapli.base.surveymanagement.domain;

public enum Type {
    FREE_TEXT, NUMERIC, SINGLE_CHOICE, SINGLE_CHOICE1,
    MULTIPLE_CHOICE, MULTIPLE_CHOICE1, SORTING_OPTIONS, SCALING_OPTIONS;


    public static Type getType(String type){

        if (type.equals("Free-Text")){
            return Type.FREE_TEXT;
        } else if (type.equals("Numeric")){
            return Type.NUMERIC;
        } else if (type.equals("Single-Choice")){
            return Type.SINGLE_CHOICE;
        } else if (type.equals("Single-Choice with input value")){
            return Type.SINGLE_CHOICE1;
        } else if (type.equals("Multiple-Choice")){
            return Type.MULTIPLE_CHOICE;
        } else if (type.equals("Multiple-Choice with input value")){
            return Type.MULTIPLE_CHOICE1;
        } else if (type.equals("Sorting Options")){
           return SORTING_OPTIONS;
        } else if (type.equals("Scaling Options")){
            return Type.SCALING_OPTIONS;
        }
        return null;
    }
}
