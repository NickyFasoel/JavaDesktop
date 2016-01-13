package Dal.Helpers;

import CONSTANTS.StringConstants;
import Dal.Klant;
import Interfaces.IInsertKlant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertKlant implements IInsertKlant {
    
    private Klant _klant;
    private final String _queryInsertKlant;
    
    /* Used for prepared statments and counting tickets */
    public InsertKlant() {
        _queryInsertKlant = StringConstants.EMPTY.getValue();
    }
    
    /* Used for regular statements */
    public InsertKlant(Klant klant) {
        this._klant = klant;
        this._queryInsertKlant = "INSERT INTO tbl_klant (Vertoning_ID, Aantal, Zaal_Nummer, Datum, Prijs) VALUES ('" + _klant.getVertoning() + "','" + _klant.getAantalTickets() + "','" + _klant.getZaalNummer()+ "','" + _klant.getDatum() + "','" + _klant.getPrijs() + "')";
    }
    
    @Override
    public void insertKlantStatement() {
        Statement stmnt = null;
        try {
            stmnt = CreateConnection.INSTANCE.getConnection().createStatement();
            stmnt.executeUpdate(_queryInsertKlant);
        } catch (SQLException ex) {
            Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /* Dump all resources */
            try {
                if (stmnt != null) {
                    Connection conn = stmnt.getConnection();
                    stmnt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void insertKlantPrepStatement(Klant klant) {
        PreparedStatement stmnt = null;
        try {
            stmnt = CreateConnection.INSTANCE.getConnection().prepareStatement(StringConstants.PREP_QRY_INSERT_KLANT.getValue());
            stmnt.setLong(1, klant.getVertoning());
            stmnt.setInt(2, klant.getAantalTickets());
            stmnt.setInt(3, klant.getZaalNummer());
            stmnt.setString(4, klant.getDatum());
            stmnt.setDouble(5, klant.getPrijs());
            stmnt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /* Dump all resources */
            try {
                if (stmnt != null) {
                    Connection conn = stmnt.getConnection();
                    stmnt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FetchFilmData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
