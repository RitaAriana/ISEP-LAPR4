package eapli.base.surveymanagement.antlr.eapli.base.surveymanagement.antlr;


import eapli.base.surveymanagement.domain.*;

/**
 *
 *
 * Created by Rita Ariana Sobral on 02/06/2022.
 */
public class QuestionnaireVisitor extends SurveyBaseVisitor<Questionnaire> {

    String auxiliar;

    int aux;

    Question question;

    Section section;

    Questionnaire questionnaire = new Questionnaire();

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitStart(SurveyParser.StartContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitQuestionario(SurveyParser.QuestionarioContext ctx) {
        visit(ctx.regraIdQuestionario());
        aux=0;
        visit(ctx.regraTitulo());
        int size = ctx.regraMensagem().size();

        if (size == 2){
            aux=0;
            visit(ctx.regraMensagem(0));
            aux=1;
            visit(ctx.regraMensagem(1));
        } else {
            aux=1;
            visit(ctx.regraMensagem(0));
        }


        size = ctx.seccao().size();

        for (int i=0; i<size; i++){
            visit(ctx.seccao(i));
            questionnaire.addSection(section);
        }

        return questionnaire;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitRegraIdQuestionario(SurveyParser.RegraIdQuestionarioContext ctx) {
        StringBuilder id = new StringBuilder();
        int size = ctx.alfanumerico().size();
        for(int i=0; i<=size; i++){
            if(ctx.getChild(i).equals(ctx.HIFEN())){
                id.append(ctx.HIFEN().getText());
            }else {
                visit(ctx.getChild(i));
                id.append(auxiliar);
            }
        }
        questionnaire.modifyId(new Identifier(id.toString()));
        auxiliar = null;
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitAlfanumerico(SurveyParser.AlfanumericoContext ctx) {
        auxiliar = ctx.getText();
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitRegraTitulo(SurveyParser.RegraTituloContext ctx) {
        visit(ctx.frase());
        if(aux==0){
            questionnaire.modifyTitle(new Titulo(auxiliar));
        } else if(aux==1){
            section.modifyTitle(new Titulo(auxiliar));
        }
        auxiliar = null;
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitFrase(SurveyParser.FraseContext ctx) {
        auxiliar = ctx.getText();
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitRegraMensagem(SurveyParser.RegraMensagemContext ctx) {
        StringBuilder message = new StringBuilder();
        int size = ctx.frase().size();
        for (int i= 0; i<size;i++){
            visit(ctx.frase(i));
            message.append(auxiliar);
            visit(ctx.pontucao(i));
            message.append(auxiliar);
            message.append("\n");
        }
        if(aux==0){
            questionnaire.modifyInitialMessage(new Message(message.toString()));
        } else if (aux == 1){
            questionnaire.modifyFinalMessage(new Message(message.toString()));
        } else if(aux == 2){
            section.modifyMessage(new Message(message.toString()));
        } else if (aux == 3){
            question.modifyInstruction(new Message(message.toString()));
        } else if(aux == 4){
            question.modifyExtraInfo(new Message(message.toString()));
        }
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitPontucao(SurveyParser.PontucaoContext ctx) {
        auxiliar = ctx.getText();
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitSeccao(SurveyParser.SeccaoContext ctx) {
        section = new Section();
        visit(ctx.regraId());
        section.modifyId(Long.parseLong(auxiliar));
        aux=1;
        visit(ctx.regraTitulo());

        aux = 2;
        try{
            visit(ctx.regraMensagem());
        } catch (NullPointerException e){
            System.out.println("Section " + section.sectionId() + " with no section description.");
        }

        aux = 10;
        visit(ctx.obrigatoriedade());

        try{
            visitRepetibilidade(ctx.repetibilidade());
        } catch (NullPointerException e){
            System.out.println("Section " + section.sectionId()+ " with no repeatability.");
        }

        int size = ctx.pergunta().size();

        for (int i=0; i<size; i++){
            visit(ctx.pergunta(i));
            section.addQuestion(question);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitRegraId(SurveyParser.RegraIdContext ctx) {
        auxiliar = ctx.getText();
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitPergunta(SurveyParser.PerguntaContext ctx) {
        question = new Question();
        visit(ctx.regraId());
        question.modifyId(Long.parseLong(auxiliar));
        visit(ctx.regraPergunta());
        question.modifyPergunta(new Message(auxiliar));
        aux = 20;
        visit(ctx.obrigatoriedade());
        visit(ctx.type());
        question.modifyType(auxiliar);
        
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitRegraPergunta(SurveyParser.RegraPerguntaContext ctx) {
        StringBuilder pergunta = new StringBuilder();
        visit(ctx.frase());
        pergunta.append(auxiliar);
        pergunta.append("?");
        auxiliar = pergunta.toString();
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitType(SurveyParser.TypeContext ctx) {
        auxiliar = ctx.getChild(0).getText();
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitObrigatoriedade(SurveyParser.ObrigatoriedadeContext ctx) {
        if (aux == 10){
            if (ctx.OPTIONAL() != null) {
                section.modifyObligatoriness("optional");
            } else if ( ctx.MANDATORY() != null){
                section.modifyObligatoriness("optional");
            } else {
                section.modifyObligatoriness("condition dependent");
            }
        } else if (aux == 20){
            if (ctx.OPTIONAL() != null) {
                question.modifyObligatoriness("optional");
            } else if ( ctx.MANDATORY() != null){
                question.modifyObligatoriness("optional");
            } else {
                question.modifyObligatoriness("condition dependent");
                visit(ctx.regraId(0));
                Long sectionId = Long.parseLong(auxiliar);
                visit(ctx.regraId(1));
                Long questionId = Long.parseLong(auxiliar);
                question.modifyDespendencias(sectionId,questionId);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Questionnaire visitRepetibilidade(SurveyParser.RepetibilidadeContext ctx) {
        section.modifyRepetibilidade(Integer.parseInt(ctx.getText()));
        return null;
    }








}
