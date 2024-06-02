/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author laptop lenovo
 */
public class DeleteUserDAO {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void deleteUser(String user_id) {
        String query = "DELETE FROM Users WHERE UserID = ?";
        try {
            connection = new DBContext().getConnection();//mo ket noi voi sql
            ps = connection.prepareStatement(query);
            ps.setString(1, user_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
