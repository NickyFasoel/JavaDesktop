package Dal.Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum CreateConnection {
    
    /** 
     * The singleton pattern restricts the instantiation of a class to one object
     * In Java to enforce this, the best approach is to use an enum
     * Thread safe, wordt maar 1 keer geïnitialiseerd (waarde aan toegekend)
     */
    INSTANCE;
    
    private static final String _connString = "jdbc:mysql://localhost:3307/db_kinepolis";
    private static final String _username = "root";
    private static final String _password = "usbw";
    
    private CreateConnection() {}
    
    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(_connString, _username, _password);
        return conn;
    }    
    
}
