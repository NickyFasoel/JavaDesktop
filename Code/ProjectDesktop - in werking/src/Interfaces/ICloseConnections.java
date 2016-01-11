package Interfaces;

import java.sql.ResultSet;

public interface ICloseConnections {

    void closeAll(ResultSet rs);
    
}
