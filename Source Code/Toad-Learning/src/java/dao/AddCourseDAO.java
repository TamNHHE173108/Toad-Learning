package dao;

import dal.DBContext;
import entity.Course;
import entity.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            ps.setTimestamp(8, new java.sql.Timestamp(course.getCreateDate().getTime()));
            ps.setTimestamp(9, new java.sql.Timestamp(course.getCreateDate().getTime()));
            ps.setString(10, course.getStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex; // Propagate exception for handling in servlet
        }
    }

    public Course getCourseByID(String course_ID) {
        String query = "SELECT CourseID, Title, Topics.TopicName, Courses.Description, Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status "
                + "FROM Courses "
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID "
                + "WHERE CourseID = ?";
        try {
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
                java.sql.Timestamp createDate = rs.getTimestamp(8);
                java.sql.Timestamp updateDate = rs.getTimestamp(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                return course;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
