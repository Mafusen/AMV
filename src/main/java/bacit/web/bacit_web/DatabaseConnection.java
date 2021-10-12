package bacit.web.bacit_web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{
    protected static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "\torg.mariadb.jdbc.Driver";
        String dbURL = "http://localhost:8081/bacit-web-1.0-SNAPSHOT/";
        // Database name to access
        String dbName = "AMVDB";
        String dbUsername = "root";
        String dbPassword = "12345";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return con;
    }
}
