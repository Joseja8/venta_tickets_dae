package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by joseja on 11/2/16.
 */
public class DBConnection {

    Connection connection;

    public DBConnection() {}

    public DBConnection(String url, String name, String password) throws SQLException {
        connection = DriverManager.getConnection(url, name, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            }
            catch(SQLException e) {
            }
        }
    }
}
