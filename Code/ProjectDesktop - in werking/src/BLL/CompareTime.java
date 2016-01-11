package BLL;

import CONSTANTS.StringConstants;
import Dal.Film;
import Dal.Vertoning;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Interfaces.ICompareTime;

public class CompareTime implements ICompareTime {
    
    @Override
    public int compareTime(String tijd) throws ParseException {
       Date currentFilmStartTime = null;
       SimpleDateFormat sdf = new SimpleDateFormat(StringConstants.TIME_FORMAT_HHMM.getValue());
       currentFilmStartTime = sdf.parse(tijd);
       Date test = sdf.parse(sdf.format(new Date()));
       
       return currentFilmStartTime.compareTo(test);
   } 
    
}
