package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://ADMIN-PC\\\\SQLEXPRESS:1433;databaseName=AP;encrypt=false";
        String user = "sa";
        String password = "sa";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM COURSES");
             ResultSet rs = ps.executeQuery()) {
             while (rs.next())
                System.out.println(rs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
