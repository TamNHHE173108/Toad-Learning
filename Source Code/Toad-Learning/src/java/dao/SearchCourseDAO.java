/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.Course;
import entity.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop lenovo
 */
public class SearchCourseDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Course> searchCourseByName(String txtC) {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "WHERE [CourseID] like ? or [Title] like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtC + "%");
            ps.setString(2, "%" + txtC + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
            }
        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
        }
        return list;
    }
    
    public List<Course> searchCourseByTopic(String topicname) {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "WHERE Topics.TopicName = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,topicname);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
            }
        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
        }
        return list;
    }
    
    public List<Course> searchCourseByStatus(String statuss) {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "WHERE Status = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,statuss);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
            }
        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
        }
        return list;
    }
    
    public List<Course> sortByPriceASC() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "ORDER BY Price ASC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
            }
        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
        }
        return list;
    }
    
    public List<Course> sortByPriceDESC() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "ORDER BY Price DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
            }
        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
        }
        return list;
    }
    
    public List<Course> sortBySalePriceASC() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "ORDER BY SalePrice ASC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
            }
        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
        }
        return list;
    }
    public List<Course> sortBySalePriceDESC() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "ORDER BY SalePrice DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
            }
        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
        }
        return list;
    }
    public static void main(String[] args) {
        SearchCourseDAO dao = new SearchCourseDAO();
        List<Course> list = dao.sortByPriceDESC();
        for (Course o : list) {
            System.out.println(o);
        }
    }
}
