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
public class AddUserDAO {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertUser(String name, String gender, String role,
            String gmail, String mobile, String address, String status) {
        String query = "INSERT [dbo].[users] \n"
                + "([name], [gender], [role], [gmail], [mobile], [address], [status])\n"
                + "VALUES(?,?,?,?,?,?,?)";
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
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
