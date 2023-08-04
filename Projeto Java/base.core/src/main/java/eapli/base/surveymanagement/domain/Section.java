package eapli.base.surveymanagement.domain;

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
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idBaseDeDados;

    private Long sectionId;

    private Titulo titulo;

    private Message Message;

    private int repetibilidade;

    private Obligatoriness obligatoriness;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "section_id")
    private List<Question> questions = new ArrayList<>();


    public Long sectionId(){
        return this.sectionId;
    }

    public void modifyId(Long identifier) {
        this.sectionId = identifier;
    }

    public void modifyTitle(Titulo titulo) {
        this.titulo = titulo;
    }

    public void modifyMessage(Message Message) {
        this.Message = Message;
    }

    public void modifyObligatoriness(String obligatoriness){
        this.obligatoriness = Obligatoriness.getObligatoriness(obligatoriness);
    }

    public boolean addQuestion(final Question question) {
        return questions.add(question);
    }

    public void modifyRepetibilidade(final int repetibilidade){
        this.repetibilidade=repetibilidade;
    }

    public Titulo getTitulo(){
        return titulo;
    }

    public List<Question> getQuestions(){
        return questions;
    }

    public Obligatoriness getObligatoriness(){
        return obligatoriness;
    }


}
