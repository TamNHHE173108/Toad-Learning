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
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;

    }

    public void addCourse(String id, String name, String thumb, String topic_name, String description, String create,
            String update, String price, String sale_price, String status, String userID) {
        String sql = "INSERT INTO Courses (CourseID, Title, Thumbnail, TopicID, Description, CreatedDate, UpdatedDate, Price, SalePrice, Status, UserID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, thumb);
            ps.setString(4, topic_name);
            ps.setString(5, description);
            ps.setString(6, create);
            ps.setString(7, update);
            ps.setString(8, price);
            ps.setString(9, sale_price);
            ps.setString(10, status);
            ps.setString(11, userID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }
    public static void main(String[] args) {
        ListCourseDAO dao = new ListCourseDAO();
        List<Course> course = dao.listCoursesLecture("2");
        //dao.addCourse("ASU103c", "Academic Skills for University Success", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkU37bC3aUEAg0qYSGMVI6OJoxVxy2r-KrSw&s", "SE", "Enhance your academic capabilities to thrive in university-level software courses with a specialization by The University of Sydney.", "2024-01-01 00:00:00.000", "2024-06-01 00:00:00.000", "199.00", "149.00", "Active", "2");
        for(Course course1 : course){
            System.out.println(course1);
        }
    }

}
