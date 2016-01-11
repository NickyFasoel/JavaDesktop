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
        this._queryInsertKlant = "INSERT INTO tbl_klanten (Film, AantalTickets, UurVanAankoop, Datum, Prijs) VALUES ('" + _klant.getFilm() + "','" + _klant.getAantalTickets() + "','" + _klant.getUurVanAankoop() + "','" + _klant.getDatum() + "','" + _klant.getPrijs() + "')";
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
            stmnt.setString(1, klant.getFilm());
            stmnt.setInt(2, klant.getAantalTickets());
            stmnt.setString(3, klant.getUurVanAankoop());
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
