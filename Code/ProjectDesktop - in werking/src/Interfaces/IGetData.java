package Interfaces;

import Dal.Film;
import Dal.Vertoning;
import java.util.ArrayList;

public interface IGetData {

    ArrayList<Film> getAllFilms();

    ArrayList<String> getAllGenres();

    ArrayList<Integer> getTicketsPerVertoning(Vertoning voorstelling);
    
    ArrayList<Vertoning> createShows();
    
}
