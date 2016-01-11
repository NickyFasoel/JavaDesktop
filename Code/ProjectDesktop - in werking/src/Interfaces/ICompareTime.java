package Interfaces;

import Dal.Film;
import Dal.Vertoning;
import java.text.ParseException;

public interface ICompareTime {

    int compareTime(String tijd) throws ParseException;
    
}
