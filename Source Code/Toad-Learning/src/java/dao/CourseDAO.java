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

    public void addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO Courses (CourseID, Title, TopicID, Description, Thumbnail, CreatedDate,UpdatedDate,Price,SalePrice, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, course.getCourseID());
            ps.setString(2, course.getTitle());
            ps.setObject(3, course.getTopicID());
            ps.setString(4, course.getDescription());
            ps.setString(5, course.getThumbnail());
            ps.setString(6, course.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public List<Course> listCourses() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, TopicName, Courses.Description, CreatedDate, UpdatedDate, Thumbnail, Status, Price, SalePrice\n"
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
                String createDate = rs.getString(5);
                String updateDate = rs.getString(6);
                String thumbnail = rs.getString(7);
                String price = rs.getString(8);
                String salePrice = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);
                
                Course course = new Course(courseID,title,topic,description,createDate,updateDate,thumbnail,price,salePrice,status);
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

    public Course getCourseById(String courseID) throws SQLException {
        String sql = "SELECT * FROM Courses WHERE CourseID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseID);
            rs = ps.executeQuery();
            if (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getString("CourseID"));
                course.setTitle(rs.getString("Title"));
//                course.setTopicID(rs.getString("TopicID"));
                course.setDescription(rs.getString("Description"));
                course.setThumbnail(rs.getString("Thumbnail"));
                course.setStatus(rs.getString("Status"));
                return course;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
}
