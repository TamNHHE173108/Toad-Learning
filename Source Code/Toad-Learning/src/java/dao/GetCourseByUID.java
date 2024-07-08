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

/**
 *
 * @author Admin
 */
public class GetCourseByUID {

    public Course getCourseByID(String course_ID) {
        String query = "SELECT CourseID, Title, Topics.TopicName, Courses.Description, Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status "
                + "FROM Courses "
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID "
                + "WHERE CourseID = ?";
        try {
            
            
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, course_ID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }
}
