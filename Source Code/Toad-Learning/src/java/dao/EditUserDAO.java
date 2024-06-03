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

    public void editUser(String username, String password,String name, String gender,
            String email, String mobile,String role, String address, String status, String uid) {
        String query = "update Users\n"
                + "set [Username] = ?,\n"
                + "[Password] = ?,\n "
                + "[FullName] = ?,\n"
                + "[Gender] = ?,\n"
                + "[Email] = ?,\n"
                + "[Mobile] = ?,\n"
                + "[Role] = ?,\n"
                + "[Address] = ?,\n"
                + "[Status] = ?\n"
                + "where UserID = ?";
        try {
            connection = new DBContext().getConnection();//mo ket noi voi sql
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, gender);
            ps.setString(5, email);
            ps.setString(6, mobile);
            ps.setString(7, role);
            ps.setString(8, address);
            ps.setString(9, status);
            ps.setString(10, uid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
