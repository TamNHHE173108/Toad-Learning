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
public class SearchUserDAO {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<User> searchUserByName(String txtSearch) {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM Users\n"
                + "WHERE [FullName] like ?\n"
                + "or [Email] like ?\n"
                + "or [Address] like ?";
        try {
            connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,"%" + txtSearch + "%");
            ps.setString(2,"%" + txtSearch + "%");
            ps.setString(3,"%" + txtSearch + "%");
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
    public List<User> searchUserByGender(String gender) {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM Users\n"
                + "WHERE [Gender] = ?";
        try {
            connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,gender);

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
    public List<User> searchUserByRole(String role) {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM Users\n"
                + "WHERE [Role] = ?";
        try {
            connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,role);
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
    public List<User> searchUserByStatus(String status) {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM Users\n"
                + "WHERE [Status] = ?";
        try {
            connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,status);
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
}
