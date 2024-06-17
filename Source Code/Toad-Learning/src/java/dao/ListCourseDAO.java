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
 * @author Admin
 */
public class ListCourseDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Course> listCoursesLecture(String UiD) {
    List<Course> list = new ArrayList<>();
    String sql = "SELECT CourseID, Title, t.TopicName, c.Description, Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, c.Status\n"
                + "FROM Courses c\n"
                + "LEFT JOIN Topics t ON c.TopicID = t.TopicID\n"
                + "LEFT JOIN Users u ON c.UserID = u.UserID\n"
                + "WHERE c.UserID = ?";
    try {
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1, UiD);  // Thiết lập giá trị tham số UiD
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
        e.printStackTrace();  // In lỗi ra console để dễ dàng theo dõi
    } finally {
        // Đóng các tài nguyên
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return list;
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
}
