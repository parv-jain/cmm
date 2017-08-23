package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";    
    private static String driverName = "oracle.jdbc.driver.OracleDriver";   
    private static String username = "SYSTEM";   
    private static String password = "system";
    private static Connection con;
    
    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                
            	System.out.println(ex); 
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex); 
        }
        return con;
    }
}