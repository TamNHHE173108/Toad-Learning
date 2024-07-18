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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop lenovo
 */
public class ListUserDAO {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<User> getUserList() {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try {
            connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }
        
    public static void main(String[] args) {
        ListUserDAO dao = new ListUserDAO();
        List<User> list = dao.getUserList();
        for (User o : list) {
            System.out.println(o);
        }
    }
}
