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
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

// Phương thức thêm mới khóa học vào cơ sở dữ liệu
public boolean insertCourse(Course course) {
    String query = "INSERT INTO Courses (CourseID, Title, TopicID, Description, Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = new DBContext().getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {

        ps.setString(1, course.getCourseID());
        ps.setString(2, course.getTitle());
        ps.setString(3, course.getTopicID().getTopicID());
        ps.setString(4, course.getDescription());
        ps.setString(5, course.getThumbnail());
        ps.setString(6, course.getPrice());
        ps.setString(7, course.getSalePrice());
        ps.setObject(8, LocalDateTime.parse(course.getCreateDate()));
        ps.setObject(9, LocalDateTime.parse(course.getUpdateDate()));
        ps.setString(10, course.getStatus());

        return ps.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Xử lý các ngoại lệ theo logic của ứng dụng
    }
    return false;
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

                Course course = new Course(courseID, title, description, thumbnail, price, salePrice, createDate, updateDate, status);
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

                Course course = new Course(courseID, title, description, thumbnail, price, salePrice, createDate, updateDate, status);
                return course;
            }
        } catch (Exception e) {
            // Xử lý các exception tại đây

        }
        return null;
    }

    public void deleteCourse(String course_ID) {
        String query = "DELETE FROM Media\n"
                + "WHERE LessonID IN (SELECT LessonID FROM Lessons WHERE CourseID = ?);\n"
                + "DELETE FROM Questions\n"
                + "WHERE QuizID IN (SELECT QuizID FROM Quizzes WHERE CourseID = ?);\n"
                + "DELETE FROM Quizzes\n"
                + "WHERE CourseID = ?\n"
                + "SELECT LessonID\n"
                + "FROM Lessons\n"
                + "WHERE CourseID = ?\n"
                + "DELETE FROM Lessons\n"
                + "WHERE CourseID = ?\n"
                + "DELETE FROM Courses\n"
                + "WHERE CourseID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, course_ID);
            ps.setString(2, course_ID);
            ps.setString(3, course_ID);
            ps.setString(4, course_ID);
            ps.setString(5, course_ID);
            ps.setString(6, course_ID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        Course course = dao.getCourseByID("ASU103c");
        System.out.println(course);
    }
}
