package eapli.base.app.backoffice.console.surveymanagement;

import eapli.base.surveymanagement.application.ObterRelatorioEstatisticoController;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Type;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;
import java.util.spi.LocaleNameProvider;

/**
 *
 *
 * Created by 1201382@isep.ipp.pt & 1201239@isep.ipp.pt & 1201386@isep.ipp.pt
 */
public class ObterRelatorioEstatisticoUI extends AbstractUI {

    ObterRelatorioEstatisticoController obterRelatorioEstatisticoController= new ObterRelatorioEstatisticoController();
    @Override
    protected boolean doShow() {
        Iterator<QuestionnaireDTO> questionnaires = obterRelatorioEstatisticoController.findAllQuestionnaires().iterator();

        if(!questionnaires.hasNext()){
            System.out.println("De momento não existem questionários!");
        } else {
            System.out.println("\nQuestionários para analisar\n");
            while (questionnaires.hasNext()) {
                QuestionnaireDTO questionnaire = questionnaires.next();
                System.out.println(questionnaire);
            }
            System.out.println();

            System.out.println("Deseja obter um relatório estatístico de que questionário?\n");

            String id = Console.readLine("Identifier:");
            System.out.println();
            System.out.println("--- Relatório Estatístico ---");
            int clientesInquiridos = obterRelatorioEstatisticoController.obterQuantidadeClientesInquiridos(id);
            System.out.printf("Clientes Inquiridos: %d\n",clientesInquiridos);
            int numRespostas = obterRelatorioEstatisticoController.obterQuantidadeRespostas(id);
            System.out.printf("Quantidade de Respostas: %d\n",numRespostas);
            if (numRespostas>0){
                double percentagemRespostas =((double)numRespostas/(double) clientesInquiridos) * 100;
                System.out.printf("Percentagem de Respostas Obtidas: %.2f\n",percentagemRespostas);
                List<Question> questions = obterRelatorioEstatisticoController.obterQuestoes(id);
                System.out.println("- Perguntas -");
                for (Question question: questions){
                        System.out.println();
                        System.out.printf("Id: %d\n",question.getQuestionId());
                        System.out.printf("Tipo: ");
                        System.out.println(question.getType());
                        System.out.println();
                        Map<Long,String> ops = question.getOptions();
                        if (question.getType().equals(Type.SINGLE_CHOICE) || question.getType().equals(Type.MULTIPLE_CHOICE)){
                            if (question.getType().equals(Type.MULTIPLE_CHOICE)){
                                System.out.println("Para cada alternativa:");
                                System.out.println();
                            }
                            for (Long op : ops.keySet()){
                                int num = obterRelatorioEstatisticoController.obterQuantidadeRespostasOpcao(question.getQuestionId(), op,id);
                                percentagemRespostas = ((double) num/(double) numRespostas) * 100;
                                System.out.println("Opção " + op);
                                System.out.printf("Percentagem: %.2f\n",percentagemRespostas);
                            }
                        }
                        if (question.getType().equals(Type.SINGLE_CHOICE1)|| question.getType().equals(Type.MULTIPLE_CHOICE1)){
                            if (question.getType().equals(Type.MULTIPLE_CHOICE1)){
                                System.out.println("Para cada alternativa:");
                                System.out.println();
                            }
                            int aux = 1;
                            int num;
                            for (Long op : ops.keySet()){
                                if (aux==ops.keySet().size()){
                                    num = obterRelatorioEstatisticoController.obterQuantidadeRespostasOutra(question.getQuestionId(), op,id);

                                } else {
                                    num = obterRelatorioEstatisticoController.obterQuantidadeRespostasOpcao(question.getQuestionId(), op,id);
                                    aux++;
                                }
                                percentagemRespostas = ((double) num/(double) numRespostas) * 100;
                                System.out.println("Opção " + op);
                                System.out.printf("Percentagem: %.2f\n",percentagemRespostas);
                            }
                        }
                        if (question.getType().equals(Type.FREE_TEXT)){
                            int quantiRespostas = obterRelatorioEstatisticoController.obterQuantClientesRespondeuPergunta(question.getQuestionId(),id);
                            System.out.println("Quantidade de clientes que respondeu: " + quantiRespostas);
                        } else if (question.getType().equals(Type.NUMERIC)){
                            double media = obterRelatorioEstatisticoController.obterRespostaMedia(question.getQuestionId(),id);
                            System.out.printf("Média: %.2f\n",media);
                        } else if (question.getType().equals(Type.SORTING_OPTIONS)){
                            for (int lugar = 0; lugar < question.getOptions().size(); lugar++){
                                int num = lugar + 1;
                                System.out.println("--- Lugar " + num + " ---");
                                for (Long op : question.getOptions().keySet()){
                                    num = obterRelatorioEstatisticoController.obterPercentagemPorLugar(lugar, question.getQuestionId(), op,id);
                                    double perc = ((double) num/(long)numRespostas)*100;
                                    System.out.println("Opção: "+op);
                                    System.out.printf("Percentagem: %.2f\n",perc);
                                }
                            }
                        }else if (question.getType().equals(Type.SCALING_OPTIONS)){
                            int index = 0;
                            for (Long op : question.getOptions().keySet()){
                                System.out.println("--- " + op + " ---");
                                for (String scale : question.getEscala()){
                                    int num =  obterRelatorioEstatisticoController.obterNumeroEscalaOpcao(question.getQuestionId(), scale, index,id);
                                    System.out.println("Escala " + scale + ": " + num);
                                }
                                index++;
                            }
                        }

                }


            }else{
                System.out.println();
                System.out.println("De momento não é possível obter nenhum relatório estatístico para este questionário!");
            }

        }

        return true;
    }

    @Override
    public String headline() {
        return "Get a statistical report";
    }
}
