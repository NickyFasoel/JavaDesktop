package Dal;

import CONSTANTS.StringConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class FormatDataTest {
    
    public FormatDataTest() {
    }
    
     @Test
     public void getFormattedDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat _timeFormat = new SimpleDateFormat(StringConstants.DATE_FORMAT.getValue());
        String time = _timeFormat.format(date);
        /**
         * de string moet de datum van nu zijn
         */
        Assert.assertEquals(true, time.matches("\\d{2}/\\d{2}/\\d{4}"));
     }
     
     @Test
     public void getFormattedTimeOfDay() {
        Date date = new Date();
        SimpleDateFormat _timeFormat = new SimpleDateFormat(StringConstants.TIME_FORMAT_HHMMSS.getValue());
        String time = _timeFormat.format(date);
        if (time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]")) {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
     }
     
     @Test
     public void getFormattedTimeOfDayNoSeconds() {
        Date date = new Date();
        SimpleDateFormat _timeFormat = new SimpleDateFormat(StringConstants.TIME_FORMAT_HHMM.getValue());
        String time = _timeFormat.format(date);
        if (time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }
}
