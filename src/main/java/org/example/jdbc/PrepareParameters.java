package org.example.jdbc;

import org.example.dbcontext.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class PrepareParameters {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBContext.getConnection();

        var sql = "INSERT INTO CAMPUSES VALUES(?, ?, ?, ?)";
        register(conn, 8, "abc",  "Elias", "Ester");
//        try(PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setInt(1, 6);
//            ps.setString(3, "abc");
//            ps.setString(2, "abc");
//            ps.setString(4, "abc");
//            ps.executeUpdate();
//            ps.setInt(1, 7);
//            ps.setString(3, "abc");
//            ps.setString(4, "abc");
//            ps.executeUpdate();
//        }
    }

    public static void register(Connection conn, int firstKey,
                                String type, String... names) {
        var sql = "INSERT INTO CAMPUSES VALUES(?, ?, ?, ?)";
        var nextIndex = firstKey;

        try (var ps = conn.prepareStatement(sql)) {
            ps.setString(2, type);

            for(var name: names) {
                ps.setInt(1, nextIndex);
                ps.setString(3, name);
                ps.setString(4, name);
                ps.addBatch();

                nextIndex++;
            }
            int[] result = ps.executeBatch();
            System.out.println(Arrays.toString(result));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
