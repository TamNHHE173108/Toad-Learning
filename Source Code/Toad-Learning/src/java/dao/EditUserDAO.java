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
public class EditUserDAO {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void editUser(String name, String gender, String role,
            String gmail, String mobile, String address, String status, String uid) {
        String query = "update users\n"
                + "set [name] = ?,\n"
                + "[gender] = ?,\n"
                + "[role] = ?,\n"
                + "[gmail] = ?,\n"
                + "[mobile] = ?,\n"
                + "[address] = ?,\n"
                + "[status] = ?\n"
                + "where user_id = ?";
        try {
            connection = new DBContext().getConnection();//mo ket noi voi sql
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, role);
            ps.setString(4, gmail);
            ps.setString(5, mobile);
            ps.setString(6, address);
            ps.setString(7, status);
            ps.setString(8, uid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}

