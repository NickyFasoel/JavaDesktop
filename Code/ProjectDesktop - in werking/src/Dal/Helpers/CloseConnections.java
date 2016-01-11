package Dal.Helpers;

import Interfaces.ICloseConnections;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CloseConnections implements ICloseConnections {
    
    @Override
    public void closeAll(ResultSet rs) {
        try {
            Statement stmnt = rs.getStatement();
            Connection conn = stmnt.getConnection();
            rs.close();
            stmnt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CloseConnections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
