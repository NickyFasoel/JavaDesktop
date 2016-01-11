//package BLL;
//
//import CONSTANTS.IntConstants;
//import CONSTANTS.StringConstants;
//import Dal.Film;
//import Dal.Helpers.CreateConnection;
//import Dal.Helpers.FormatData;
//import Interfaces.IGetFormattedTimeOfDayNoSeconds;
//import Dal.Helpers.FetchFilmData;
//import Dal.Klant;
//import Interfaces.IUseStatements;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.DefaultListModel;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class ServiceLayerTest {
//    
//    public ServiceLayerTest() {}
//
//    @Test
//    public void testGetFilms() throws ParseException, SQLException {
//        IUseStatements iUs = new FetchFilmData();
//        DefaultListModel _dlm = new DefaultListModel();
//        ResultSet rs = iUs.getAllFilms();
//        try {
//            if (rs.isBeforeFirst() && rs.getRow() == IntConstants.ZERO.getValue()) {
//                SimpleDateFormat format = new SimpleDateFormat("hh:mm");
//                IGetFormattedTimeOfDayNoSeconds iGFTODNS = new FormatData();
//                String temp2 = iGFTODNS.getFormattedTimeOfDayNoSeconds();
//                java.util.Date d2 =(java.util.Date)format.parse(temp2);
//                while (rs.next()){
//                    String temp = rs.getString(StringConstants.SPEELUUR_COLUMN.getValue());
//                    java.util.Date d1 =(java.util.Date)format.parse(temp);
//                    if (d1.compareTo(d2) >= 0) {
//                        String naam = rs.getString(StringConstants.NAAM_COLUMN.getValue());
//                        String zaal = rs.getString(StringConstants.ZAAL_COLUMN.getValue()); 
//                        String speelUur = rs.getString(StringConstants.SPEELUUR_COLUMN.getValue());
//                        String speelDagen = rs.getString(StringConstants.SPEELDAGEN_COLUMN.getValue());
//                        double prijs = rs.getDouble(StringConstants.PRIJS_COLUMN.getValue());
//                        String genre = rs.getString(StringConstants.GENRE_COLUMN.getValue());
//                        int minimumLeeftijd = rs.getInt(StringConstants.MINIMUMLEEFTIJD_COLUMN.getValue());
//                        boolean actief = rs.getBoolean(StringConstants.ACTIEF_COLUMN.getValue());
//                        String description = rs.getString(StringConstants.DESCRIPTION_COLUMN.getValue());
//                        String foto = rs.getString(StringConstants.FOTO_COLUMN.getValue());
//                        Film film = new Film(naam, zaal, speelUur, speelDagen, prijs,
//                                genre, minimumLeeftijd, actief, description, foto);
//                        _dlm.addElement(film);
//                    }
//                }
//            }
//            // JList.setModel(_dlm);
//        } catch (SQLException ex) {
//            Logger.getLogger(ServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            // Dump all resources
//            try {
//                // closes all connections and releases resources
//                Connection conn = closeAll(rs);                
//                Assert.assertEquals(true, _dlm.getSize() > 0 && conn.isClosed());
//            } catch (SQLException ex) {
//                Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    private Connection closeAll(ResultSet rs) throws SQLException {
//        Statement stmnt = rs.getStatement();
//        Connection conn = stmnt.getConnection();
//        rs.close();
//        stmnt.close();
//        conn.close();
//        return conn;
//    }
//    
////    @Test
////    public void insertKlantTest() throws SQLException {
////        Klant klant = new Klant("Batman vs Superman", 3, 10.5);
////        IUseStatements iStmnt = new FetchFilmData(klant);
////        iStmnt.insertKlantStatement();
////
////        checkStatementsNDelete(klant);
////    }
//    
//    @Test
//    public void insertKlantPrepTest() throws SQLException {
//        Klant klant = new Klant("Batman vs Superman", 3, 10.5);
//        IUseStatements iStmnt = new FetchFilmData();
//        iStmnt.insertKlantPrepStatement(klant);
//        
//        checkStatementsNDelete(klant);
//    }
//
//    private void checkStatementsNDelete(Klant klant) throws SQLException {
//        Statement stmt = CreateConnection.INSTANCE.getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_klanten WHERE UurVanAankoop LIKE '" + klant.getUurVanAankoop() + "'");
//
//        // any successful query that has data, once executed, will produce a ResultSet with isBeforeFirst() returning true.
//        // getRow haalt de aantal rijen op uit de resultset
//        Assert.assertFalse(!rs.isBeforeFirst() && rs.getRow() == 0);
//
//        // Ik wis de net geïnserte waarde
//        Statement stmt1 = CreateConnection.INSTANCE.getConnection().createStatement();
//        stmt1.executeUpdate("delete FROM tbl_klanten WHERE UurVanAankoop LIKE '" + klant.getUurVanAankoop() + "'");
//    }
//    
//    // Vul de UI Combobox met alle genres
//    @Test
//    public void fillDDLGenresTest() {
//        DefaultComboBoxModel model = new DefaultComboBoxModel();
//        ArrayList<String> lijst = getGenres();
//        if (!lijst.contains("All")) {
//            model.addElement("All");
//        }
//        lijst.stream().forEach((item) -> {
//            model.addElement(item);
//        });
//        
//        // If index is -1 it means it doesn't exist
//        if (model.getIndexOf("All") != -1 && model.getIndexOf("Actie") != -1 && model.getIndexOf("Komedie") != -1) {
//            Assert.assertTrue(true);
//        } else {
//            Assert.assertTrue(false);
//        }
//    }
//    
//    private ArrayList<String> getGenres() {
//        DefaultListModel _dlm = createTempDLM();
//        
//        ArrayList<String> lijst = new ArrayList<>();
//        Object[] films = _dlm.toArray();
//        for (Object item : films) {
//            Film film = (Film)item;
//            String genre = film.getGenre();
//            if (!lijst.contains(genre)) {
//                lijst.add(genre);
//            }
//        }
//        return lijst;
//    }
//
//    private DefaultListModel createTempDLM() {
//        Film f = new Film("Superman", "A-10", "10.00", "maandag, dinsdag en zondag",
//                10.5, "Actie", 12, true, "Goede film", "url");
//        Film f2 = new Film("Superman", "A-10", "10.00", "maandag, dinsdag en zondag",
//                10.5, "Komedie", 12, true, "Goede film", "url");
//        DefaultListModel _dlm = new DefaultListModel();
//        _dlm.addElement(f);
//        _dlm.addElement(f2);
//        return _dlm;
//    }
//    
//    @Test
//    public void createWorkableDLMTest() {
//        ArrayList<Film> lijst = getSpecificFilmsTest("Actie");
//        DefaultListModel _dlmWorkable = new DefaultListModel();
//        lijst.stream().forEach((item) -> {
//            _dlmWorkable.addElement(item);
//        });
//        
//        Assert.assertEquals(true, "Superman".equals(_dlmWorkable.elementAt(0).toString()));
//    }
//    
//    private ArrayList<Film> getSpecificFilmsTest(String selectedGenre) {
//        ArrayList<Film> lijst = new ArrayList<>();
//        DefaultListModel _dlm = createTempDLM();
//        Object[] toArray = _dlm.toArray();
//        
//        if ("All".equals(selectedGenre)) {
//            for (Object item : toArray) {
//                Film film = (Film)item;
//                lijst.add(film);
//            }
//        }
//        else {
//            for (Object item : toArray) {
//                Film film = (Film)item;
//                if (selectedGenre.equals(film.getGenre())) {
//                    lijst.add(film);
//                }
//            }
//        }
//        return lijst;
//    }
//
//    // Niet alles getest omwille combinatie van al interne geteste methodes
//    
//}
