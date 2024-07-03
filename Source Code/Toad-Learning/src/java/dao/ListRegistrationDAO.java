/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.Course;
import entity.Registrations;
import entity.Topic;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class ListRegistrationDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Registrations> ListRegistration(String UID) {
        List<Registrations> list = new ArrayList<>();
        String sql = "select u.Username, h.CourseID, r.TotalCost, r.Status, r.ValidFrom, r. ValidTo, r.LastUpdatedBy, r.RegistrationTime, r.ScoreID, r.Score, r.QuizStatus  \n"
                + "from Registrations r\n"
                + "left join Histories h on r.CourseID = h.CourseID\n"
                + "left join Courses c on r.CourseID = c.CourseID\n"
                + "left join Users u on r.UserID = u.UserID\n"
                + "where c.UserID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, UID);  // Thiết lập giá trị tham số UiD
            rs = ps.executeQuery();
            while (rs.next()) {
                String userName = rs.getString(1);
                String courseID = rs.getString(2);
                String totalCost = rs.getString(3);
                String status = rs.getString(4);
                String validFrom = rs.getString(5);
                String validTO = rs.getString(6);
                String updateBy = rs.getString(7);
                String registrationTime = rs.getString(8);
                String scoreID = rs.getString(9);
                String score = rs.getString(10);
                String quizStatus = rs.getString(11);
                User user = new User(userName);

                Registrations register = new Registrations(user, courseID, totalCost, status, validFrom, validTO, updateBy, registrationTime, scoreID, score, quizStatus);
                list.add(register);
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

    public static void main(String[] args) {
        ListRegistrationDAO dao = new ListRegistrationDAO();
        List<Registrations> course = dao.ListRegistration("2");
        //dao.addCourse("ASU103c", "Academic Skills for University Success", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkU37bC3aUEAg0qYSGMVI6OJoxVxy2r-KrSw&s", "SE", "Enhance your academic capabilities to thrive in university-level software courses with a specialization by The University of Sydney.", "2024-01-01 00:00:00.000", "2024-06-01 00:00:00.000", "199.00", "149.00", "Active", "2");
        for (Registrations course1 : course) {
            System.out.println(course1);
        }
    }
}
