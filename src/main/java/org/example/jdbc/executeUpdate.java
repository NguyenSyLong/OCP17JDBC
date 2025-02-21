package org.example.jdbc;

import org.example.dbcontext.DBContext;

import java.sql.Connection;
import java.sql.SQLException;

public class executeUpdate {

    public static void main(String[] args) throws SQLException {
        Connection conn = DBContext.getConnection();
        var insertSql = "INSERT INTO CAMPUSES VALUES(5, 'BSE-HN', '3', 'abc')";
        var updateSql = "UPDATE CAMPUSES SET Description = '' " + "WHERE CampusId = 6";
        var deleteSql = "DELETE  CAMPUSES  WHERE CampusId = 5";
//        try(var ps = conn.prepareStatement(insertSql)){
//            int result = ps.executeUpdate();
//            System.out.println(result);
//        }

        try(var ps = conn.prepareStatement(updateSql)){
            int result = ps.executeUpdate();
            System.out.println(result);
        }

        try(var ps = conn.prepareStatement(deleteSql)){
            int result = ps.executeUpdate();
            System.out.println(result);
        }
    }
}
