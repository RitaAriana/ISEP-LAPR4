package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Embeddable
public class Period implements ValueObject, Serializable {

    @Temporal(TemporalType.DATE)
    private Calendar initialDate;

    @Temporal(TemporalType.DATE)
    private Calendar finalDate;

    private Long activeDays;

    public Period(final Calendar finalDate){
        this.initialDate = Calendar.getInstance();
        this.finalDate = finalDate;
        this.activeDays = determineActiveDays();
    }

    /*
    Por motivos de testes.
     */
    public Period(final Calendar initialDate,final Calendar finalDate){
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.activeDays = determineActiveDays();
    }

    public Period() {
    }

    private Long determineActiveDays(){

        long diff = finalDate.getTime().getTime() - initialDate.getTime().getTime();

        TimeUnit time = TimeUnit.DAYS;

        return time.convert(diff, TimeUnit.MILLISECONDS);
    }

    public Long getActiveDays(){
        return activeDays;
    }

    public Calendar getInitialDate(){
        return initialDate;
    }

    public Calendar getFinalDate(){
        return finalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Period)) return false;
        Period that = (Period) o;
        return initialDate.equals(that.initialDate) && activeDays.equals(that.activeDays);
    }

}
