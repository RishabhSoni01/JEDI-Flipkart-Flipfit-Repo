package com.flipkart.dao;
import com.flipkart.bean.*;
import com.flipkart.business.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.flipkart.utils.dbutils;
public class FlipFitUserDAOImplement {
        public boolean addRole(FlipFitRole role) {
            String sql = "INSERT INTO role (role_name) VALUES (?)"; // Assuming role ID is auto-generated
            try (Connection connection = dbutils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, role.getRoleType());

                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0; // Return true if the insert was successful
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false; // Return false if an exception occurs or no rows were inserted
        }
    }