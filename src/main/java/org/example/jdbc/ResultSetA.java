package org.example.jdbc;

import org.example.dbcontext.DBContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ResultSetA {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBContext.getConnection();
        String sql = "SELECT CampusId, CampusCode FROM CAMPUSES";
        var idToNameMap = new HashMap<Integer, String>();
        try (var ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("CampusId");
                String name = rs.getString("CampusCode");
                idToNameMap.put(id, name);

            }
        }
        System.out.println(idToNameMap);
    }
}
