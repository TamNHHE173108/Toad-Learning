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

    public void insertUser(String user_id, String username, String password, String name, String gender,
            String email, String mobile,String role, String status, String address) {
        String query = "INSERT [dbo].[Users] \n"
                + "([UserID],[Username], [Password], [FullName], [Gender], [Email], [Mobile], [Role] , [Status],[Address])\n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            connection = new DBContext().getConnection();//mo ket noi voi sql
            ps = connection.prepareStatement(query);
            ps.setString(1, user_id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, name);
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, mobile);
            ps.setString(8, role);
            ps.setString(9, status);
            ps.setString(10, address);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
