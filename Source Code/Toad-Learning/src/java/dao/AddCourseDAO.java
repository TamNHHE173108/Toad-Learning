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
import java.time.LocalDateTime;

public class AddCourseDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void addCourse(String courseID, String title, String topicID, String description, String thumbnail, String price, String salePrice, LocalDateTime createdDate, LocalDateTime updatedDate, String status) {

        String query = "INSERT INTO Courses (CourseID, Title, TopicID, Description, Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, courseID);
            ps.setString(2, title);
            ps.setString(3, topicID);
            ps.setString(4, description);
            ps.setString(5, thumbnail);
            ps.setString(6, price);
            ps.setString(7, salePrice);
            ps.setObject(8, createdDate);
            ps.setObject(9, updatedDate);
            ps.setString(10, status);

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exceptions as per your application's requirements
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public Course getCourseByID(String course_ID) {
        String query = "SELECT CourseID, Title, Topics.TopicName, Courses.Description, Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status "
                + "FROM Courses "
                + "INNER JOIN Topics ON Courses.TopicID = Topics.TopicID "
                + "WHERE CourseID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, course_ID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                LocalDateTime createDate = rs.getTimestamp(8).toLocalDateTime();
                LocalDateTime updateDate = rs.getTimestamp(9).toLocalDateTime();
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, description, thumbnail, price, salePrice, createDate.toString(), updateDate.toString(), status);
                return course;
            }
        } catch (SQLException e) {
            // Handle exceptions as per your application's requirements
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
