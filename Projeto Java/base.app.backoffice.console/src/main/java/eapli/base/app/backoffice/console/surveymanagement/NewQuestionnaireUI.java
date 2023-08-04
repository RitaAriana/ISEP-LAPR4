package eapli.base.app.backoffice.console.surveymanagement;

import eapli.base.surveymanagement.application.CreateNewQuestionnaireController;
import eapli.base.surveymanagement.domain.Criterio;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 *
 *
 * Created by 1201382@isep.ipp.pt & 1201239@isep.ipp.pt & 1201386@isep.ipp.pt
 */
public class NewQuestionnaireUI extends AbstractUI {

    private final CreateNewQuestionnaireController createNewQuestionnaireController = new CreateNewQuestionnaireController();

    private Boolean operationError=false;


    @Override
    protected boolean doShow() {

        do{
            try {
                Calendar finalDate = Console.readCalendar("Please enter until what date it is possible to answer the questionnaire that will import (yyyy/MM/dd):","yyyy/MM/dd");

                List<Criterio> criterios = obterRestricoes();

                String fileName = Console.readLine("Please insert the file path:");
                createNewQuestionnaireController.createQuestionnaire(fileName,finalDate,criterios);

            } catch(Exception e){
                System.out.println(e.getMessage());
                operationError=true;
            }

        } while(operationError);

        return true;

    }

    private List<Criterio> obterRestricoes(){
        List<Criterio> criterios = new ArrayList<>();

        int i = 1;

        System.out.println("- Restrictions to apply in relation to who answers the questionnaire -");

        for (Criterio options : Criterio.values()) {
            System.out.printf("%d. %s%n", i ,options.toString());
            i++;
        }

        String aux;
        int temp = 0;

        List<Integer> options = new ArrayList<>();

        boolean invalidData;

        do {
            try {
                do {

                    int option = Console.readInteger("Select the option:") - 1;

                    if (option >= i ||  option < 0 || options.contains(option)) {
                        throw new UnsupportedOperationException("Invalid Option");
                    } else if (temp == 1 && option == 3){
                        throw new UnsupportedOperationException("Invalid Option");
                    }

                    invalidData = false;

                    options.add(option);

                    criterios.add(Criterio.values()[option]);

                    if (option == 3){
                        aux = "no";
                    } else if (options.size() == 3) {
                        aux = "no";
                    }else {
                        aux = Console.readLine("Do you want to add one more context? (yes | no)");
                        temp = 1;
                    }

                } while (aux.equalsIgnoreCase("yes"));
            } catch (UnsupportedOperationException e){
                System.out.println(e.getMessage());
                invalidData = true;
            }
        } while (invalidData);




        return  criterios;
    }

    @Override
    public String headline() {
        return "Create New Questionnaire";
    }

}
