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

public class CourseDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void addCourse(String courseID, String courseName, String category, String description, String thumbnail, String createDate, String updateDate, String price, String salePrice, String status) {
        String sql = "INSERT INTO Courses (CourseID, Title, TopicID, Description, Thumbnail, CreatedDate,UpdatedDate,Price,SalePrice, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseID);
            ps.setString(2, courseName);
            ps.setString(3, category);
            ps.setString(4, description);
            ps.setString(5, thumbnail);
            ps.setString(6, createDate);
            ps.setString(7, updateDate);
            ps.setString(8, price);
            ps.setString(9, salePrice);
            ps.setString(10, status);
            ps.executeUpdate();
        } catch (SQLException e) {
//            throw e;
//        } finally {
//            if (ps != null) {
//                ps.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
        }
    }

    public List<Course> listCourses() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID";
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

    public void editCourse(String title, String topicID, String description,
            String thumbnail, String price, String salePrice, String status, String courseID) {
        String query = "UPDATE Courses\n"
                + "SET [Title] = ?,\n "
                + "[TopicID] = ?,\n"
                + "[Description] = ?,\n"
                + "[Thumbnail] = ?,\n"
                + "[Price] = ?,\n"
                + "[SalePrice] = ?,\n"
                + "[Status] = ?\n"
                + "WHERE CourseID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);  
            ps.setString(1, title);
            ps.setString(2, topicID);
            ps.setString(3, description);
            ps.setString(4, thumbnail);
            ps.setString(5, price);
            ps.setString(6, salePrice);
            ps.setString(7, status);
            ps.setString(8, courseID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Course getCourseByID(String course_ID) {
        String query = "SELECT CourseID, Title, Topics.TopicName, Courses.Description, Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "WHERE CourseID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, course_ID);
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
                return course;
            }
        } catch (Exception e) {
            // Xử lý các exception tại đây
           
        }
        return null;
    }

    public static void main(String[] args) {
       CourseDAO dao = new CourseDAO();
       Course course = dao.getCourseByID("ASU103c");
       System.out.println(course);
    }
}
