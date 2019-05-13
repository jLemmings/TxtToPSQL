package TxtToPostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PsqlConnector {

    Connection connection = null;

    public Connection psqlConnector(String url, String user, String password) {

        if (connection == null) {
            System.out.println("Connecting to Datbase!");
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
