package Dal.Helpers;

// <editor-fold defaultstate="collapsed" desc="Imports">

import Interfaces.IGetData;
import CONSTANTS.IntConstants;
import CONSTANTS.StringConstants;
import Dal.Film;
import Dal.Vertoning;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// </editor-fold>

public class FetchFilmData implements IGetData {

    // <editor-fold defaultstate="collapsed" desc="Private Member Variables">
    
    private ResultSet _rs;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
   
    private Statement createAStatement() throws SQLException {
        Statement stmnt = CreateConnection.INSTANCE.getConnection().createStatement();
        return stmnt;
    }
    
    private void closeStatement(Statement stmnt) throws SQLException {
        Connection conn = stmnt.getConnection();
        stmnt.close();
        conn.close();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public FetchFilmData() {}

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Public Methods">

    @Override
    public ArrayList<Film> getAllFilms() {
        ArrayList<Film> lst = new ArrayList<>();
        Statement stmnt = null;
        try {
            stmnt = createAStatement();
            _rs = stmnt.executeQuery(StringConstants.QRY_GET_ALL_FILMS.getValue());
            while(_rs.next())
            {
                long id = _rs.getLong("ID");
                String naam = _rs.getString(StringConstants.NAAM_COLUMN.getValue());
                String speelUren = _rs.getString(StringConstants.SPEELUUR_COLUMN.getValue());
                String speelDagen = _rs.getString(StringConstants.SPEELDAGEN_COLUMN.getValue());
                double prijs = _rs.getDouble(StringConstants.PRIJS_COLUMN.getValue());
                String genre = _rs.getString(StringConstants.GENRE_COLUMN.getValue());
                boolean actief = _rs.getBoolean(StringConstants.ACTIEF_COLUMN.getValue());
                String description = _rs.getString(StringConstants.DESCRIPTION_COLUMN.getValue());
                String foto = _rs.getString(StringConstants.FOTO_COLUMN.getValue());
                // TODO: constante invoere
                String showBG = _rs.getString("ShowInfoBackgroundImage");
                int imgCorr = _rs.getInt("bgImageCorrection");
                Film film = new Film(id, naam, speelUren, speelDagen, prijs,
                            genre, actief, description, foto, showBG, imgCorr);
                lst.add(film);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeStatement(stmnt);
            } catch (SQLException ex) {
                Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lst;
    }
    
    @Override
    public ArrayList<Integer> getTicketsPerVertoning(Vertoning voorstelling) {
        ArrayList<Integer> lst = new ArrayList<>();
        Statement stmnt = null;
        try {
            stmnt = createAStatement();
            _rs = stmnt.executeQuery("SELECT `Aantal` FROM `tbl_tickets` WHERE  (`Voorstelling_ID` IN ('" + voorstelling.getId() + "'))");
            while(_rs.next())
            {
                lst.add(_rs.getInt(IntConstants.ONE.getValue()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeStatement(stmnt);
            } catch (SQLException ex) {
                Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lst;
    }
    
    @Override
    public ArrayList<String> getAllGenres() {
        ArrayList<String> lst = new ArrayList<>();
        Statement stmnt = null;
        try {
            stmnt = createAStatement();
            _rs = stmnt.executeQuery(StringConstants.QRY_GET_ALL_GENRES.getValue());
            while(_rs.next())
            {
                lst.add(_rs.getString(IntConstants.ONE.getValue()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeStatement(stmnt);
            } catch (SQLException ex) {
                Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lst;
    }
    
    @Override
    public ArrayList<Vertoning> createShows() {
        ArrayList<Vertoning> lstVert = new ArrayList<>();
        ResultSet rs = null;
        try {
            //rs = CreateConnection.INSTANCE.getConnection().createStatement().executeQuery("SELECT tbl_zaal.ID FROM `tbl_zaal` WHERE NOT EXISTS(Select 1 from tbl_vertoning WHERE (tbl_vertoning.Zaal_ID = tbl_zaal.ID) AND (tbl_vertoning.SpeelDag = '" + dagTrim + "') AND (tbl_vertoning.SpeelUur = '" + urenTrim + "'))");
            rs = CreateConnection.INSTANCE.getConnection().createStatement().executeQuery("SELECT tbl_vertoning.ID, a.naam, tbl_vertoning.SpeelDag, tbl_vertoning.SpeelUur, a.prijs, tbl_zaal.Nummer, tbl_zaal.Plaatsen FROM tbl_film AS a INNER JOIN tbl_vertoning ON a.ID = tbl_vertoning.Film_ID INNER JOIN tbl_zaal ON tbl_zaal.ID = tbl_vertoning.Zaal_ID");
        } catch (SQLException e) {
            Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // TODO: close connections when moved to dal
        }
        
        return lstVert;
    }
    
    // </editor-fold>
  
}
