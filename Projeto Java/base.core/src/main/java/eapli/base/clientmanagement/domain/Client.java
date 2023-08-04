package eapli.base.clientmanagement.domain;

import eapli.base.ordermanagement.domain.Notification;
import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Survey;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import org.hibernate.annotations.Cascade;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 * Entity Root that will represent a Client.
 *
 * Created by Rita Ariana Sobral on 23/04/2022.
 */
@Entity
public class Client implements AggregateRoot<Long>, Serializable {

    public enum Gender {
        FEMININE, MASCULINE, OTHER;
    }

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long clientId;

    private Name name;

    private VAT vat;

    private Email email;

    private PhoneNumber phoneNumber;

    @Temporal(TemporalType.DATE)
    private Calendar birthdate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ElementCollection
    private Set<PostalAddress> postalAddresses;


    @ElementCollection
    private List<Survey> unansweredQuestionnaires = new ArrayList<>();


    /**
     * Constructor for Client with the minimum attributes.
     *
     * @param name the costumer name
     * @param vat the costumer vat
     * @param email the costumer email
     * @param phoneNumber the costumer phone number
     */
    public Client(final Name name, final VAT vat, final Email email, final PhoneNumber phoneNumber, final Set<PostalAddress> postalAddresses) {
        Preconditions.noneNull(name, vat, email, phoneNumber);
        Preconditions.noneNull(postalAddresses, "The Client must have at least one address.");

        this.name= name;
        this.vat = vat;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.postalAddresses = postalAddresses;
    }

    protected Client() {
        //for ORM only
    }

    public void addGender(final Gender gender) {
        this.gender = gender;
    }

    public void insertBirthDate(final Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return this.clientId;
    }

    public Name obtainName() {
        return name;
    }

    public void addUnansweredQuestionnaire(Questionnaire questionnaire){
        this.unansweredQuestionnaires.add(new Survey(questionnaire));
        // new Notification(this.email.toString(),"Questionário por Responder","Gostaríamos que disponibiliza-se 15 minutos do seu tempo para responder ao inquérito que lhe enviamos!\n O inquérito encontra-se na sua página pessoal da aplicação!\nCom os melhores cumprimentos!");
    }

    public void removeUnansweredQuestionnaire(Identifier questionnaire){

    }
    public List<Survey> getUnansweredQuestionnaires(){
        return this.unansweredQuestionnaires;
    }

}
