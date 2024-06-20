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
     Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
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

<<<<<<< HEAD
                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                return course;
=======
                    // Create Topic object from retrieved data
//                    Topic topic = new Topic(topicID, topicName);
//
//                    // Create Course object with retrieved data
//                    Course course = new Course(courseId, title, description, thumbnail, price, salePrice, createDate, updateDate, status);
//                    course.setTopicID(topic); // Set Topic object

//                    return course;
                }
>>>>>>> 4c04bc2156f5d53855bbcadf9d9396b16666e12d
            }
        } catch (Exception e) {
            // Xử lý các exception tại đây

        }
        return null;
    }
}
