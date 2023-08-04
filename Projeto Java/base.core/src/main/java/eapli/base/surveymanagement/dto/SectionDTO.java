package eapli.base.surveymanagement.dto;

import eapli.base.surveymanagement.domain.Obligatoriness;
import eapli.base.surveymanagement.domain.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SectionDTO implements Serializable {

    public Long sectionId;

    public String titulo;

    public Obligatoriness obligatoriness;

    public List<QuestionDTO> questions;

    public SectionDTO(final Long sectionId, final String titulo, final Obligatoriness obligatoriness, List<QuestionDTO> questions){
        this.sectionId = sectionId;
        this.titulo = titulo;
        this.obligatoriness = obligatoriness;
        this.questions = questions;
    }
}
