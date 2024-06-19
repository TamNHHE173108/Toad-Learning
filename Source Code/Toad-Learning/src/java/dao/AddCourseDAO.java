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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AddCourseDAO {
    private final Connection conn;

    public AddCourseDAO() {
        conn = new DBContext().getConnection();
    }

    public void addCourse(Course course) throws SQLException {
        String query = "INSERT INTO Courses (CourseID, Title, TopicID, Description, Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, course.getCourseID());
            ps.setString(2, course.getTitle());
            ps.setString(3, course.getTopicID().getTopicID()); // Get TopicID from Topic object
            ps.setString(4, course.getDescription());
            ps.setString(5, course.getThumbnail());
            ps.setFloat(6, Float.parseFloat(course.getPrice()));
            ps.setFloat(7, Float.parseFloat(course.getSalePrice()));
            ps.setString(8, course.getCreateDate());
            ps.setString(9, course.getUpdateDate());
            ps.setString(10, course.getStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex; // Propagate exception for handling in servlet
        }
    }

    public Course getCourseByID(String courseID) {
        String query = "SELECT CourseID, Title, Description, Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status, TopicID, TopicName "
                + "FROM Courses "
                + "INNER JOIN Topics ON Courses.TopicID = Topics.TopicID "
                + "WHERE CourseID = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, courseID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String courseId = rs.getString("CourseID");
                    String title = rs.getString("Title");
                    String description = rs.getString("Description");
                    String thumbnail = rs.getString("Thumbnail");
                    String price = rs.getString("Price");
                    String salePrice = rs.getString("SalePrice");
                    String createDate = rs.getString("CreatedDate");
                    String updateDate = rs.getString("UpdatedDate");
                    String status = rs.getString("Status");
                    String topicID = rs.getString("TopicID");
                    String topicName = rs.getString("TopicName");

                    // Create Topic object from retrieved data
//                    Topic topic = new Topic(topicID, topicName);
//
//                    // Create Course object with retrieved data
//                    Course course = new Course(courseId, title, description, thumbnail, price, salePrice, createDate, updateDate, status);
//                    course.setTopicID(topic); // Set Topic object

//                    return course;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
