package eapli.base.surveymanagement.domain;

import com.ibm.icu.impl.Pair;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * Created by Rita Ariana Sobral on 02/06/2022.
 */
@Entity
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idBaseDeDados;

    private Long questionId;

    @AttributeOverrides({
            @AttributeOverride(name = "message", column = @Column(name = "pergunta"))
    })
    private Message pergunta;

    private Obligatoriness obligatoriness;

    @AttributeOverrides({
            @AttributeOverride(name = "message", column = @Column(name = "instruction"))
    })
    private Message instruction;

    @AttributeOverrides({
            @AttributeOverride(name = "message", column = @Column(name = "extraInfo"))
    })
    private Message extraInfo;

    private Type type;

    private Long questaoDependente;

    private Long seccaoDependente;

    @ElementCollection
    private List<String> escala = new ArrayList<>();

    @ElementCollection
    @MapKeyColumn(name = "id")
    @Column(name = "option")
    private Map<Long,String> options =new HashMap<>();

    public void modifyId(Long identifier) {
        this.questionId = identifier;
    }

    public void modifyPergunta(Message pergunta) {
        this.pergunta = pergunta;
    }

    public void modifyInstruction(Message instruction) {
        this.instruction = instruction;
    }

    public void modifyExtraInfo(Message extraInfo) {
        this.extraInfo = extraInfo;
    }

    public void modifyType(String type){
        this.type = Type.getType(type);
    }

    public void modifyObligatoriness(String obligatoriness){
        this.obligatoriness = Obligatoriness.getObligatoriness(obligatoriness);
    }

    public void addOption(Long id, String opcao){
        options.put(id,opcao);
    }

    public void addEscala(String escala){
        this.escala.add(escala);
    }

    public List<String> getEscala() {
        return this.escala;
    }

    public void modifyDespendencias(Long sectionId, Long questionId){
        this.seccaoDependente=sectionId;
        this.questaoDependente=questionId;
    }

    public Long getQuestionId(){
        return questionId;
    }

    public Message getPergunta(){
        return pergunta;
    }

    public Obligatoriness getObligatoriness(){
        return obligatoriness;
    }

    public Message getExtraInfo(){
        return extraInfo;
    }

    public Type getType(){
        return type;
    }

    public Map<Long,String> getOptions(){
        return options;
    }

    public Long getQuestaoDependente(){
        return questaoDependente;
    }

    public Long getSeccaoDependente(){
        return seccaoDependente;
    }


}
