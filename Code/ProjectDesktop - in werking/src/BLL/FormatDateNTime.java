package BLL;

import Interfaces.IFormatDate;
import CONSTANTS.StringConstants;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateNTime implements IFormatDate {
    
    private final Date _date;
    private SimpleDateFormat _timeFormat;
    
    public FormatDateNTime() {
        _date = new Date();
    }
    
    public String getFormattedTimeOfDay() {
        _timeFormat = new SimpleDateFormat(StringConstants.TIME_FORMAT_HHMMSS.getValue());
        return _timeFormat.format(_date);
    }
    
    public String getFormattedTimeOfDayNoSeconds() {
        _timeFormat = new SimpleDateFormat(StringConstants.TIME_FORMAT_HHMM.getValue());
        return _timeFormat.format(_date);
    }
    
    @Override
    public String getFormattedDate() {
        _timeFormat = new SimpleDateFormat(StringConstants.DATE_FORMAT.getValue());
        return _timeFormat.format(_date);
    }
    
}
