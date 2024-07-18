/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.DBContext;
import entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lehoa
 */
public class FilterCourseStudent {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Course> searchCourseStudentByTopic(String topicname) {
    List<Course> list = new ArrayList<>();
    String sql = "SELECT \n"
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
               + "WHERE t.TopicName = ?\n" // Corrected WHERE clause
               + "    AND [Courses].[Status] = 'Active';"; // Added AND for second condition

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(sql);
         // Set second parameter for UserID
         ps.setString(1, topicname);
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
            entity.Topic topic = new entity.Topic(topicName);

            Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
            list.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception
    } finally {
        // Close resources in finally block
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
    }
    return list;
}
    
}
