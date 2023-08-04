package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;

import static org.junit.Assert.*;

public class PeriodTest {

    @Test
    public void ensureActiveDays() {
        Calendar initialDate = Calendar.getInstance();
        initialDate.set(2021, 6, 12);
        Calendar finalDate = Calendar.getInstance();
        finalDate.set(2021, 6, 14);
        Period period = new Period(initialDate,finalDate);
        long result = period.getActiveDays();
        long expected = 2L;
        Assert.assertEquals(expected,result);
    }

}