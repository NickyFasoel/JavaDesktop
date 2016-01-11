package BLL;

import Interfaces.ICountTickets;
import Dal.Film;
import Dal.Helpers.CreateConnection;
import Dal.Helpers.FetchFilmData;
import Dal.Vertoning;
import Interfaces.ICompareTime;
import Interfaces.IGetData;
import Interfaces.ISetFavicon;
import Interfaces.ISetFilmFoto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class ServiceLayer {
    
    // TODO: Interfaces gebruiken in de ui ipv servicelayer
    
    private final IGetData _iGD;
    private ArrayList<Film> _lstFilms;
    
    public ServiceLayer() {
        _iGD = new FetchFilmData();
    }
    
    public ArrayList<Film> getAllFilms() {
        _lstFilms = _iGD.getAllFilms();
        return _lstFilms;
    }
    
    public ArrayList<String> getAllGenres() {
        return _iGD.getAllGenres();
    }
    
    public ArrayList<Integer> getTicketsPerVertoning(Vertoning vertoning) {
        return _iGD.getTicketsPerVertoning(vertoning);
    }
    
    public int countTickets(Vertoning vertoning) {
        ICountTickets iCT = new CountTickets();
        return iCT.countTickets(vertoning);
    }
    
    public boolean isRoom(Vertoning vertoning) {
        ICountTickets iCT = new CountTickets();
        return iCT.isRoom(vertoning);
    }
    
    public ImageIcon setFoto(String path) {
        ISetFilmFoto iSFF = new FetchImages();
        return iSFF.setFoto(path);
    }
    
    public int compareTime(String tijd) throws ParseException {
        ICompareTime iCTi = new CompareTime();
        return iCTi.compareTime(tijd);
    }
    
    public ImageIcon setFavicon() {
        ISetFavicon iSF = new FetchImages();
        return iSF.setFavicon();
    }
    
//    public String getFilmSpeelUren(String filmNaam) {
//        String[] speelUren = null;
//        String lol = "";
//        for (Film film : _lstFilms) {
//            String naam = film.getNaam();
//            if (naam.equals(filmNaam)) {
//                speelUren = film.getSpeelUren().split(",");
//            }
//        }
//        for (String string : speelUren) {
//            lol +=  " " + string;
//        }
//        return lol;
//    }
}
