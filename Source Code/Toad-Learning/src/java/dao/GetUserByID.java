/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author laptop lenovo
 */
public class GetUserByID {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public User getUserByID(String user_id) {
        String query = "select * from Users\n"
                + "where UserID = ?";
        try {
            connection = new DBContext().getConnection();//mo ket noi voi sql
            ps = connection.prepareStatement(query);
            ps.setString(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        GetUserByID dao = new GetUserByID();
        User u = dao.getUserByID("U1");
        System.out.println(u);
    }
}
