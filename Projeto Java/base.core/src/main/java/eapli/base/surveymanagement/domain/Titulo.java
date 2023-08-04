package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 *
 * Created by Rita Ariana Sobral on 02/06/2022.
 */
@Embeddable
public class Titulo implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    private final String titulo;

    public Titulo(final String titulo) {
        this.titulo= titulo;
    }

    protected Titulo() {
        this.titulo = "";
    }

    public static Titulo valueOf(final String titulo) {
        return new Titulo(titulo);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Titulo)) {
            return false;
        } else {
            Titulo obj = (Titulo)o;
            return this.titulo.equals(obj.titulo);
        }
    }

    public int hashCode() {
        HashCoder coder = (new HashCoder()).with(this.titulo);
        return coder.code();
    }

    public String toString() {
        return this.titulo;
    }
}
