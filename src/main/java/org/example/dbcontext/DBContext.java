package org.example.dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private static String url = "jdbc:sqlserver://ADMIN-PC\\\\SQLEXPRESS:1433;databaseName=AP;encrypt=false";
    private static String user = "sa";
    private static String password = "sa";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
