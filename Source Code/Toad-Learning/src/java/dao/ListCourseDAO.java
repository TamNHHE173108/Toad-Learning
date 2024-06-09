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

    public List<Course> listCoursesLecture() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, t.TopicName, c.Description, CreatedDate, UpdatedDate, Thumbnail, Price, SalePrice, c.Status\n"
                + "                FROM Courses c\n"
                + "                left JOIN Topics t ON c.TopicID=t.TopicID\n"
                + "                left join Users u on c.UserID = u.UserID\n"
                + "                where c.UserID = 'U5' ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String createDate = rs.getString(5);
                String updateDate = rs.getString(6);
                String thumbnail = rs.getString(7);
                String price = rs.getString(8);
                String salePrice = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, createDate, updateDate, thumbnail, price, salePrice, status);
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
