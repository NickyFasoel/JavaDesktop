package Dal;

import Dal.Helpers.CreateConnection;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

public class CreateConnectionTest {
            
    public CreateConnectionTest() {}
    
    // Test the singletons for equality
    @Test
    public void testUnique() throws SQLException {
        CreateConnection s = CreateConnection.INSTANCE;
        Assert.assertEquals(true, CreateConnection.INSTANCE == s);
    }
    
    // Test if connection can be made
    @Test
    public void testConnection() throws SQLException {
        Connection c = CreateConnection.INSTANCE.getConnection();
        Assert.assertEquals(false, c.isClosed());
    }
    
}
