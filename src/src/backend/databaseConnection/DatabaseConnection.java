package src.backend.databaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DatabaseConnection {

    //information that allow accessing the database
    static protected final String url = "jdbc:mysql://localhost:3306/bank_app_database";
    static protected final String username = "SkyBank";
    static protected final String password = "dtbs@anson-1001";

    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }


}