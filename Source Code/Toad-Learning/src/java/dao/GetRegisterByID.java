/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.Registrations;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GetRegisterByID {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public User GetRegisterByID(String user_id) {
        String sql = "select UserID, u.Username, u.Password, u.FullName, u.Gender, u.Email, u.Mobile, u.Role, u.Status, u.Address\n"
                + "from Users u\n"
                + "where u.Username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String user_ID = rs.getString(1);
                String userName = rs.getString(2);
                String password = rs.getString(3);
                String name = rs.getString(4);
                String gender = rs.getString(5);
                String email = rs.getString(6);
                String mobile = rs.getString(7);
                String role = rs.getString(8);
                String status = rs.getString(9);
                String address = rs.getString(10);

                User user = new User(user_ID, userName, password, name, gender, email, mobile, role, status, address);
                return user;
            }
        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
        }
        return null;
    }

    public static void main(String[] args) {
        GetRegisterByID dao = new GetRegisterByID();
        User user = dao.GetRegisterByID("student1");
        System.out.println(user);
    }
}
