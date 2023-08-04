package eapli.base.surveymanagement.dto;

import java.io.Serializable;
import java.util.List;

public class SurveyDTO implements Serializable {

    public String id;

    public String titulo;

    public List<SectionDTO> sections;

    public SurveyDTO(final String id, final String titulo, List<SectionDTO> sections){
        this.id=id;
        this.titulo=titulo;
        this.sections = sections;
    }

}
