package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    
     public Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://"+PropertiesManager.serverName+":"+PropertiesManager.portNumber +";databaseName="+PropertiesManager.dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, PropertiesManager.userID, PropertiesManager.password);
    }
    
  
}
