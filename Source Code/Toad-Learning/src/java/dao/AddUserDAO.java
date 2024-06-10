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

    public void insertUser( String username, String password, String name, String gender,
            String email, String mobile,String role, String status, String address) {
        String query = "INSERT [dbo].[Users] \n"
                + "([Username], [Password], [FullName], [Gender], [Email], [Mobile], [Role] , [Status],[Address])\n"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
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
            ps.setString(8, status);
            ps.setString(9, address);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
