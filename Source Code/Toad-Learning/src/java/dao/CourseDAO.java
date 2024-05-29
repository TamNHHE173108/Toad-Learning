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
        String sql = "INSERT INTO Course (CourseID, CourseName, Description, CategoryID, Thumbnail, Featured, Owner, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, course.getCourseID());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getDescription());
            ps.setString(4, course.getCategoryID());
            ps.setString(5, course.getThumbnail());
            ps.setBoolean(6, course.isFeatured());
            ps.setString(7, course.getOwner());
            ps.setString(8, course.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    public List<Course> listCourses() throws SQLException {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM Course";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getString("CourseID"));
                course.setCourseName(rs.getString("CourseName"));
                course.setDescription(rs.getString("Description"));
                course.setCategoryID(rs.getString("CategoryID"));
                course.setThumbnail(rs.getString("Thumbnail"));
                course.setFeatured(rs.getBoolean("Featured"));
                course.setOwner(rs.getString("Owner"));
                course.setStatus(rs.getString("Status"));
                list.add(course);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return list;
    }

    public Course getCourseById(String courseID) throws SQLException {
        String sql = "SELECT * FROM Course WHERE CourseID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseID);
            rs = ps.executeQuery();
            if (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getString("CourseID"));
                course.setCourseName(rs.getString("CourseName"));
                course.setDescription(rs.getString("Description"));
                course.setCategoryID(rs.getString("CategoryID"));
                course.setThumbnail(rs.getString("Thumbnail"));
                course.setFeatured(rs.getBoolean("Featured"));
                course.setOwner(rs.getString("Owner"));
                course.setStatus(rs.getString("Status"));
                return course;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return null;
    }
}


