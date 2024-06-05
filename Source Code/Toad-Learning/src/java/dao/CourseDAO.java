/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.Course;

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
        String sql = "INSERT INTO Courses (CourseID, Title, TopicID, Description, Thumbnail, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, course.getCourseID());
            ps.setString(2, course.getTitle());
            ps.setString(3, course.getTopicID());
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
        String sql = "SELECT CourseID, Title, TopicName, Courses.Description, CreatedDate,UpdatedDate, Thumbnail, Status, Price, SalePrice\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getString("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setTopicID(rs.getString("TopicID"));
                course.setDescription(rs.getString("Description"));
                course.setCreateDate(rs.getString("CreatedDate"));
                course.setUpdateDate(rs.getString("UpdatedDate"));
                course.setThumbnail(rs.getString("Thumbnail"));
                course.setStatus(rs.getString("Status"));
                course.setPrice(rs.getString("Price"));
                course.setSalePrice(rs.getString("SalePrice"));
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
                course.setTopicID(rs.getString("TopicID"));
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
