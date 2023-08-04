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
public class Message implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    private final String message;

    public Message(final String message) {
        this.message = message;
    }

    protected Message() {
        this.message = "";
    }

    public static Message valueOf(final String titulo) {
        return new Message(titulo);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Message)) {
            return false;
        } else {
            Message obj = (Message)o;
            return this.message.equals(obj.message);
        }
    }

    public int hashCode() {
        HashCoder coder = (new HashCoder()).with(this.message);
        return coder.code();
    }

    public String toString() {
        return this.message;
    }
}
