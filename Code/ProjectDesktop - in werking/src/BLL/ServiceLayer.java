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
    
    
    
    
    
    
    public ArrayList<Vertoning> createShows() {
        ArrayList<Vertoning> lstVert = new ArrayList<>();
        ResultSet rs = null;
        try {
            //rs = CreateConnection.INSTANCE.getConnection().createStatement().executeQuery("SELECT tbl_zaal.ID FROM `tbl_zaal` WHERE NOT EXISTS(Select 1 from tbl_vertoning WHERE (tbl_vertoning.Zaal_ID = tbl_zaal.ID) AND (tbl_vertoning.SpeelDag = '" + dagTrim + "') AND (tbl_vertoning.SpeelUur = '" + urenTrim + "'))");
            rs = CreateConnection.INSTANCE.getConnection().createStatement().executeQuery("SELECT tbl_vertoning.ID, a.naam, tbl_vertoning.SpeelDag, tbl_vertoning.SpeelUur, a.prijs, tbl_zaal.Nummer, tbl_zaal.Plaatsen FROM tbl_film AS a INNER JOIN tbl_vertoning ON a.ID = tbl_vertoning.Film_ID INNER JOIN tbl_zaal ON tbl_zaal.ID = tbl_vertoning.Zaal_ID");
        } catch (SQLException e) {
            Logger.getLogger(ServiceLayer.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            if (rs != null) {
                while (rs.next()){
                    long id = rs.getLong("ID");
                    String naam = rs.getString("Naam");
                    String speelDag = rs.getString("SpeelDag"); 
                    String speelUur = rs.getString("SpeelUur");
                    double prijs = rs.getDouble("Prijs");
                    int zaalNummer = rs.getInt("Nummer");
                    int plaatsen = rs.getInt("Plaatsen");

                    lstVert.add(new Vertoning(id, naam, speelDag, speelUur, prijs, zaalNummer, plaatsen));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // TODO: close connections when moved to dal
        }
        
        return lstVert;
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
