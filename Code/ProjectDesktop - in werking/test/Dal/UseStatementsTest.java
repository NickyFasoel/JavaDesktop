package Dal;

import Dal.Helpers.CreateConnection;
import Dal.Helpers.FetchFilmData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

public class UseStatementsTest {
    
    public UseStatementsTest() {}

    @Test
    public void testInsertKlantPrepStatement() {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            PreparedStatement prepStmnt = CreateConnection.INSTANCE.getConnection().prepareStatement("INSERT INTO tbl_klanten (Film,AantalTickets,UurVanAankoop,Datum,Prijs) VALUES (?,?,?,?,?)");
            Klant klant = createKlant();
            prep(klant, prepStmnt);
            
            stmt = CreateConnection.INSTANCE.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM `tbl_klanten` WHERE `UurVanAankoop` LIKE '" + klant.getUurVanAankoop() + "'");
            
            // any successful query that has data, once executed, will produce a ResultSet with isBeforeFirst() returning true.
            // getRow haalt de aantal rijen op uit de resultset
            Assert.assertFalse(!rs.isBeforeFirst() && rs.getRow() == 0);
            
            // Ik wis de net geïnserte waarde
            Statement stmt1 = CreateConnection.INSTANCE.getConnection().createStatement();
            stmt1.executeUpdate("delete FROM tbl_klanten WHERE UurVanAankoop LIKE '" + klant.getUurVanAankoop() + "'");
            
        } catch (SQLException ex) {
            Logger.getLogger(UseStatementsTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.assertTrue(false);
        } finally {
            // Dump all resources
            try {
                if (stmt != null && rs != null) {
                    Connection conn = stmt.getConnection();
                    rs.close();
                    stmt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Test
    public void testInsertKlantStatement()
    {
        try {
            Klant klant = createKlant();
            Statement stmnt = CreateConnection.INSTANCE.getConnection().createStatement();
            stmnt.executeUpdate("INSERT INTO tbl_klanten (Film,AantalTickets,UurVanAankoop,Datum,Prijs) VALUES ('" + klant.getFilm() + "','" + klant.getAantalTickets() + "','" + klant.getUurVanAankoop() + "','" + klant.getDatum() + "','" + klant.getPrijs() + "')");
            
            // query om te kijken of de waarde is geïnsert
            Statement stmt = CreateConnection.INSTANCE.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_klanten WHERE UurVanAankoop LIKE '" + klant.getUurVanAankoop() + "'");
            
            // any successful query that has data, once executed, will produce a ResultSet with isBeforeFirst() returning true.
            // getRow haalt de aantal rijen op uit de resultset
            Assert.assertFalse(!rs.isBeforeFirst() && rs.getRow() == 0);
            
            // Ik wis de net geïnserte waarde
            Statement stmt1 = CreateConnection.INSTANCE.getConnection().createStatement();
            stmt1.executeUpdate("delete FROM tbl_klanten WHERE UurVanAankoop LIKE '" + klant.getUurVanAankoop() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(UseStatementsTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.assertTrue(false);
        }
    }
    
    @Test
    public void getAllFilms() throws SQLException {
        Statement stmnt = CreateConnection.INSTANCE.getConnection().createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT * from tbl_films WHERE Actief = 1");
        if (rs.isBeforeFirst() && rs.getRow() == 0) {
            Assert.assertTrue(true);
        } 
        else {
            Assert.assertTrue(false);
        }
    }
    
    
    // Helper methodes
    private Klant createKlant() {
        Klant klant = new Klant("Batman vs Superman", 3, 10.5);
        return klant;
    }
    
    private PreparedStatement prep(Klant klant, PreparedStatement prep) throws SQLException {
        prep.setString(1, klant.getFilm());
        prep.setInt(2, klant.getAantalTickets());
        prep.setString(3, klant.getUurVanAankoop());
        prep.setString(4, klant.getDatum());
        prep.setDouble(5, klant.getPrijs());
        prep.executeUpdate();
        return prep;
    }

}