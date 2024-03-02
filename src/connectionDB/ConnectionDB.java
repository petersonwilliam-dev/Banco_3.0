package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection conn;
    private static final String url =  "jdbc:mysql://localhost:3306/exemplodb";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnectionDB() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } else {
            return conn;
        }
    }
}
