package eapli.base.surveymanagement.domain;

import eapli.base.clientmanagement.domain.Email;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * Created by Rita Ariana Sobral on 18/06/2022.
 */
@Entity
public class Answer implements AggregateRoot<Long>{

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBddad;

    private Email client;

    private Identifier idSurvey;

    private Long idQuestion;

    private Long idSection;

    @Enumerated(EnumType.STRING)
    private Type questionType;

    @ElementCollection
    private List<String> respostas = new ArrayList<>();

    public Answer(){

    }


    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return idBddad;
    }

    public void modifyType(String type){
        this.questionType=Type.getType(type);
    }

    public void addAnswer(String answer){
        this.respostas.add(answer);
    }

    public void modifyClientEmail(Email clientEmail){
        this.client = clientEmail;
    }

    public void modifyIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void modifyIdSurvey(Identifier idSurvey) {
        this.idSurvey = idSurvey;
    }

    public void modifyIdSection(Long idSection) {
        this.idSection = idSection;
    }

    public Identifier getIdSurvey(){
        return idSurvey;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public List<String> getRespostas() {
        return respostas;
    }
}
