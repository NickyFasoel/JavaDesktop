//package Dal.Helpers;
//
//// <editor-fold defaultstate="collapsed" desc="Imports">
//
//import Interfaces.IGetData;
//import BLL.FormatDateNTime;
//import CONSTANTS.IntConstants;
//import CONSTANTS.StringConstants;
//import Dal.Film;
//import Dal.Klant;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//// </editor-fold>
//
//public class UseStatements implements IGetData {
//
//    // <editor-fold defaultstate="collapsed" desc="Private Member Variables">
//    
//    /* Data nodig van klant daarom geen constante */
//    private final String _queryInsertKlant;
//    private Klant _klant;
//    private ResultSet _rs;
//    
//    // </editor-fold>
//    
//    // <editor-fold defaultstate="collapsed" desc="Private Methods">
//   
//    private Statement createAStatement() throws SQLException {
//        Statement stmnt = CreateConnection.INSTANCE.getConnection().createStatement();
//        return stmnt;
//    }
//    
//    private void closeAllStmnts(Statement stmnt) throws SQLException {
//        Connection conn = stmnt.getConnection();
//        stmnt.close();
//        conn.close();
//    }
//    
//    // </editor-fold>
//    
//    // <editor-fold defaultstate="collapsed" desc="Constructors">
//
//    /* Used for prepared statments and counting tickets */
//    public UseStatements() {
//        _queryInsertKlant = StringConstants.EMPTY.getValue();
//    }
//
//    /* Used for regular statements */
//    public UseStatements(Klant klant) {
//        this._klant = klant;
//        this._queryInsertKlant = "INSERT INTO tbl_klanten (Film,AantalTickets,UurVanAankoop,Datum,Prijs) VALUES ('" + _klant.getFilm() + "','" + _klant.getAantalTickets() + "','" + _klant.getUurVanAankoop() + "','" + _klant.getDatum() + "','" + _klant.getPrijs() + "')";
//    }
//
//    // </editor-fold>
//    
//    // <editor-fold defaultstate="collapsed" desc="Public Methods">
//
//    @Override
//    public ArrayList<Film> getAllFilms() {
//        ArrayList<Film> lst = new ArrayList<>();
//        Statement stmnt = null;
//        try {
//            stmnt = createAStatement();
//            _rs = stmnt.executeQuery(StringConstants.QRY_GET_ALL_FILMS.getValue());
//            while(_rs.next())
//            {
//                String naam = _rs.getString(StringConstants.NAAM_COLUMN.getValue());
//                String speelUur = _rs.getString(StringConstants.SPEELUUR_COLUMN.getValue());
//                String speelDagen = _rs.getString(StringConstants.SPEELDAGEN_COLUMN.getValue());
//                double prijs = _rs.getDouble(StringConstants.PRIJS_COLUMN.getValue());
//                String genre = _rs.getString(StringConstants.GENRE_COLUMN.getValue());
//                boolean actief = _rs.getBoolean(StringConstants.ACTIEF_COLUMN.getValue());
//                String description = _rs.getString(StringConstants.DESCRIPTION_COLUMN.getValue());
//                String foto = _rs.getString(StringConstants.FOTO_COLUMN.getValue());
//                Film film = new Film(naam, speelUur, speelDagen, prijs,
//                            genre, actief, description, foto);
//                lst.add(film);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UseStatements.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                closeAllStmnts(stmnt);
//            } catch (SQLException ex) {
//                Logger.getLogger(UseStatements.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return lst;
//    }
//    
//    @Override
//    public ArrayList<Integer> getTicketsPerFilm(String filmName) {
//        ArrayList<Integer> lst = new ArrayList<>();
//        Statement stmnt = null;
//        try {
//            stmnt = createAStatement();
//            _rs = stmnt.executeQuery("SELECT `AantalTickets` FROM `tbl_klanten` WHERE  (`Film` IN ( '" + filmName + "')) AND (`Datum` IN ( '" + new FormatDateNTime().getFormattedDate() + "' ))");
//            while(_rs.next())
//            {
//                lst.add(_rs.getInt(IntConstants.ONE.getValue()));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UseStatements.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                closeAllStmnts(stmnt);
//            } catch (SQLException ex) {
//                Logger.getLogger(UseStatements.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return lst;
//    }
//    
//    @Override
//    public ArrayList<String> getAllGenres() {
//        ArrayList<String> lst = null;
//        Statement stmnt = null;
//        try {
//            stmnt = createAStatement();
//            _rs = stmnt.executeQuery(StringConstants.QRY_GET_ALL_GENRES.getValue());
//            while(_rs.next())
//            {
//                if (lst != null) {
//                    lst.add(_rs.getString(IntConstants.ONE.getValue()));
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UseStatements.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                closeAllStmnts(stmnt);
//            } catch (SQLException ex) {
//                Logger.getLogger(UseStatements.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return lst;
//    }
//    
//    // </editor-fold>
//  
//}
