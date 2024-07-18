/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.Course;
import entity.Topic;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseDAO extends MyDAO {

    // Phương thức thêm mới khóa học vào cơ sở dữ liệu
    public void addCourse(String title, String topicID, String description,
            String thumbnail, String price, String salePrice, String status, String courseID, String createdDate, String updatedDate, String userID) {
        xSql = "INSERT INTO Courses (CourseID, Title, TopicID, Description, Thumbnail, CreatedDate, UpdatedDate, Price, SalePrice, Status, UserID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, courseID);
            ps.setString(2, title);
            ps.setString(3, topicID);
            ps.setString(4, description);
            ps.setString(5, thumbnail);
            ps.setString(6, createdDate);
            ps.setString(7, updatedDate);
            ps.setString(8, price);
            ps.setString(9, salePrice);
            ps.setString(10, status);
            ps.setString(11, userID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Course> listCourses() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID";
        try {
            ps = con.prepareStatement(sql);
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
    public List<Course> getCourseByUserID(String userID) {

        List<Course> list = new ArrayList<>();
        String query = "SELECT \n"
             + "    [Courses].[CourseID],\n"
             + "    [Courses].[Title],\n"
             + "    t.TopicName,\n"
             + "    [Courses].[Description],\n"
             + "    [Courses].[Thumbnail],\n"
             + "    [Courses].[Price],\n"
             + "    [Courses].[SalePrice],\n"
             + "    [Courses].[CreatedDate],\n"
             + "    [Courses].[UpdatedDate],\n"
             + "    [Courses].[Status]\n"
             + "FROM [SWP391_1].[dbo].[Courses]\n"
             + "JOIN [SWP391_1].[dbo].[Registrations]\n"
             + "    ON [Courses].[CourseID] = [Registrations].[CourseID]\n"
             + "LEFT JOIN [SWP391_1].[dbo].[Topics] t\n"
             + "    ON [Courses].[TopicID] = t.[TopicID]\n"
             + "WHERE [Registrations].[UserID] = ?;";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, userID);
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
        } catch (Exception e) {
            // Xử lý các exception tại đây

        }
        return list;
    }
    public List<Course> getCourseByStatus() {

        List<Course> list = new ArrayList<>();
        String query = "SELECT \n"
                     + "    [Courses].[CourseID],\n"
                     + "    [Courses].[Title],\n"
                     + "    t.TopicName,\n"
                     + "    [Courses].[Description],\n"
                     + "    [Courses].[Thumbnail],\n"
                     + "    [Courses].[Price],\n"
                     + "    [Courses].[SalePrice],\n"
                     + "    [Courses].[CreatedDate],\n"
                     + "    [Courses].[UpdatedDate],\n"
                     + "    [Courses].[Status]\n"
                     + "FROM [SWP391_1].[dbo].[Courses]\n"
                    
                     + "LEFT JOIN [SWP391_1].[dbo].[Topics] t\n"
                     + "    ON [Courses].[TopicID] = t.[TopicID]\n"
                     + "WHERE [Courses].[Status] = 'Active';";

        try {
            ps = con.prepareStatement(query);
            
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
        } catch (Exception e) {
            // Xử lý các exception tại đây

        }
        return list;
    }
    
    


    public void editCourse(String title, String topicID, String description,
            String thumbnail, String price, String salePrice, String status,Date updatedDate, String courseID) {
        String query = "UPDATE Courses\n"
                + "SET [Title] = ?,\n "
                + "[TopicID] = ?,\n"
                + "[Description] = ?,\n"
                + "[Thumbnail] = ?,\n"
                + "[Price] = ?,\n"
                + "[SalePrice] = ?,\n"
                + "[Status] = ?,\n"
                + "[UpdatedDate]= ?\n"
                + "WHERE CourseID = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, topicID);
            ps.setString(3, description);
            ps.setString(4, thumbnail);
            ps.setString(5, price);
            ps.setString(6, salePrice);
            ps.setString(7, status);
            ps.setTimestamp(8, new java.sql.Timestamp(updatedDate.getTime()));
            ps.setString(9, courseID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Course> listTop5Courses() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT TOP 5 CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Courses.Status, Users.UserID, Users.FullName\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID \n "
                + "INNER JOIN Users ON Users.UserID=Courses.UserID"
                + " order by Courses.CreatedDate ASC";
        try {
            ps = con.prepareStatement(sql);
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
                User userID = new User();
                userID.setUser_id(rs.getString("UserID"));
                userID.setName(rs.getString("FullName"));
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                course.setUserID(userID);
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

    public Course getCourseByID(String course_ID) {
        String query = "SELECT CourseID, Title, Topics.TopicName, Courses.Description, Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "WHERE CourseID = ?";
        try {
            ps = con.prepareStatement(query);
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
            ps = con.prepareStatement(query);
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
