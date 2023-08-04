package eapli.base.surveymanagement.dto;

import eapli.base.surveymanagement.domain.Obligatoriness;
import eapli.base.surveymanagement.domain.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDTO implements Serializable {

    public Long questionId;

    public String pergunta;

    public Obligatoriness obligatoriness;

    public String extraInfo;

    public Type type;

    public Long questaoDependente;

    public Long seccaoDependente;

    public List<String> options= new ArrayList<>();

    public List<String> escala = new ArrayList<>();

    public QuestionDTO(final Long questionId,final String pergunta,final Obligatoriness obligatoriness,final String extraInfo,final Type type,Map<Long,String> options,Long seccaoDependente,Long questaoDependente,List<String> escala){
        this.questionId=questionId;
        this.pergunta=pergunta;
        this.obligatoriness=obligatoriness;
        this.extraInfo=extraInfo;
        this.type=type;
        for (Map.Entry<Long, String> entry : options.entrySet()){
            this.options.add(entry.getValue());
        }
        this.questaoDependente=questaoDependente;
        this.seccaoDependente=seccaoDependente;
        for (String esc: escala){
            this.escala.add(esc);
        }
    }



}
