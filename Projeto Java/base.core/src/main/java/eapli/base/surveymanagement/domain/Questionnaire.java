package eapli.base.surveymanagement.domain;

import eapli.base.productmanagement.dto.ProductDTO;
import eapli.base.surveymanagement.dto.QuestionDTO;
import eapli.base.surveymanagement.dto.QuestionnaireDTO;
import eapli.base.surveymanagement.dto.SectionDTO;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Created by Rita Ariana Sobral on 02/06/2022.
 */
@Entity
public class Questionnaire implements AggregateRoot<Long>, Serializable, DTOable {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idBaseDeDados;


    private Identifier surveyId;

    private Titulo titulo;

    private int quantityInquiredCustomers;

    private int amountAnswered;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "message", column = @Column(name = "initial_message"))
    })
    private Message initialMessage;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "message", column = @Column(name = "final_message"))
    })
    private Message finalMessage;

    private Period period;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "survey_id")
    private List<Section> sections = new ArrayList<>();

    @Column(length = 2000)
    @ElementCollection
    private List<Restricao> restricao = new ArrayList<>();

    public Questionnaire(){}



    @Override
    public boolean equals(final Object o){
        return DomainEntities.areEqual(this,o);
    }

    @Override
    public int hashCode(){
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Questionnaire)) {
            return false;
        }

        final var that = (Questionnaire) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }


    @Override
    public Long identity() {
        return this.idBaseDeDados;
    }

    public void modifyId(Identifier surveyIdentifier) {
        this.surveyId = surveyIdentifier;
    }

    public void modifyTitle(Titulo titulo) {
        this.titulo = titulo;
    }

    public void modifyInitialMessage(Message initialMessage) {
        this.initialMessage = initialMessage;
    }

    public void modifyFinalMessage(Message finalMessage) {
        this.finalMessage = finalMessage;
    }

    public boolean addSection(final Section section) {
        return sections.add(section);
    }

    public void modifyPeriod(final Period period){
        this.period = period;
    }

    public void modifyRestricao(Restricao restricao){
        this.restricao.add(restricao);
    }

    public List<Restricao> restricoes(){
        return this.restricao;
    }

    public void addQuantityInquiredCustomers(int aux){
        this.quantityInquiredCustomers = this.quantityInquiredCustomers + aux;
    }

    public void addAmountAnswered(){
        this.amountAnswered++;
    }

    public Identifier getSurveyId(){
        return this.surveyId;
    }

    @Override
    public QuestionnaireDTO toDTO() {
        return new QuestionnaireDTO(surveyId.toString(),titulo.toString());
    }

    public SurveyDTO toDto(){
        List<SectionDTO> sectionDTOS = new ArrayList<>();
        for (Section section: sections){
            List<QuestionDTO> questionDTOS = new ArrayList<>();
            for (Question question: section.getQuestions()){
                QuestionDTO questionDTO = new QuestionDTO(question.getQuestionId(),question.getPergunta().toString(),question.getObligatoriness(),question.getExtraInfo().toString(),question.getType(),question.getOptions(),question.getSeccaoDependente(),question.getQuestaoDependente(),question.getEscala());
                questionDTOS.add(questionDTO);
            }
            SectionDTO sectionDTO = new SectionDTO(section.sectionId(),section.getTitulo().toString(),section.getObligatoriness(),questionDTOS);
            sectionDTOS.add(sectionDTO);
        }
        return new SurveyDTO(surveyId.toString(),titulo.toString(),sectionDTOS);
    }

    public int getAmountAnswered() {
        return amountAnswered;
    }

    public int getQuantityInquiredCustomers() {
        return quantityInquiredCustomers;
    }

    public List<Section> getSections() {
        return sections;
    }
}
