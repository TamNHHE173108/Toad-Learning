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
public class SearchRegisterDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Registrations> sortByPriceASC(String UID) {
        List<Registrations> list = new ArrayList<>();
        String sql = "select u.Username, h.CourseID, r.TotalCost, r.Status, r.ValidFrom, r. ValidTo, r.LastUpdatedBy, r.RegistrationTime, r.ScoreID, r.Score, r.QuizStatus  \n"
                + "from Registrations r\n"
                + "left join Histories h on r.CourseID = h.CourseID\n"
                + "left join Courses c on r.CourseID = c.CourseID\n"
                + "left join Users u on r.UserID = u.UserID\n"
                + "where c.UserID = ?\n"
                + "ORDER BY Price ASC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, UID);
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
        }
        return list;
    }

    public List<Registrations> sortByPriceDESC(String UID) {
        List<Registrations> list = new ArrayList<>();
        String sql = "select u.Username, h.CourseID, r.TotalCost, r.Status, r.ValidFrom, r. ValidTo, r.LastUpdatedBy, r.RegistrationTime, r.ScoreID, r.Score, r.QuizStatus  \n"
                + "from Registrations r\n"
                + "left join Histories h on r.CourseID = h.CourseID\n"
                + "left join Courses c on r.CourseID = c.CourseID\n"
                + "left join Users u on r.UserID = u.UserID\n"
                + "where c.UserID = ?\n"
                + "ORDER BY Price DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, UID);
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
        }
        return list;
    }

    
    public List<Registrations> sortByScoreASC(String UID) {
        List<Registrations> list = new ArrayList<>();
        String sql = "select u.Username, h.CourseID, r.TotalCost, r.Status, r.ValidFrom, r. ValidTo, r.LastUpdatedBy, r.RegistrationTime, r.ScoreID, r.Score, r.QuizStatus  \n"
                + "from Registrations r\n"
                + "left join Histories h on r.CourseID = h.CourseID\n"
                + "left join Courses c on r.CourseID = c.CourseID\n"
                + "left join Users u on r.UserID = u.UserID\n"
                + "where c.UserID = ?\n"
                + "ORDER BY Score ASC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, UID);
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
        }
        return list;
    }

    public List<Registrations> sortByScoreDESC(String UID) {
        List<Registrations> list = new ArrayList<>();
        String sql = "select u.Username, h.CourseID, r.TotalCost, r.Status, r.ValidFrom, r. ValidTo, r.LastUpdatedBy, r.RegistrationTime, r.ScoreID, r.Score, r.QuizStatus  \n"
                + "from Registrations r\n"
                + "left join Histories h on r.CourseID = h.CourseID\n"
                + "left join Courses c on r.CourseID = c.CourseID\n"
                + "left join Users u on r.UserID = u.UserID\n"
                + "where c.UserID = ?\n"
                + "ORDER BY Score DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, UID);
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
        }
        return list;
    }
    

    public List<Registrations> searchRegisterByStatus(String UID, String statuss) {
        List<Registrations> list = new ArrayList<>();
        String sql = "select u.Username, h.CourseID, r.TotalCost, r.Status, r.ValidFrom, r. ValidTo, r.LastUpdatedBy, r.RegistrationTime, r.ScoreID, r.Score, r.QuizStatus  \n"
                + "from Registrations r\n"
                + "left join Histories h on r.CourseID = h.CourseID\n"
                + "left join Courses c on r.CourseID = c.CourseID\n"
                + "left join Users u on r.UserID = u.UserID\n"
                + "where c.UserID = ?\n"
                + "AND r.Status = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, UID);
            ps.setString(2, statuss);
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
//            throw e;
//        } finally {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
        }
        return list;
    }
    
    
    public List<Registrations> searchRegisterByQuizStatus(String UID, String quizStatuss) {
        List<Registrations> list = new ArrayList<>();
        String sql = "select u.Username, h.CourseID, r.TotalCost, r.Status, r.ValidFrom, r. ValidTo, r.LastUpdatedBy, r.RegistrationTime, r.ScoreID, r.Score, r.QuizStatus  \n"
                + "from Registrations r\n"
                + "left join Histories h on r.CourseID = h.CourseID\n"
                + "left join Courses c on r.CourseID = c.CourseID\n"
                + "left join Users u on r.UserID = u.UserID\n"
                + "where c.UserID = ?\n"
                + "AND r.QuizStatus = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, UID);
            ps.setString(2, quizStatuss);
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
//            throw e;
//        } finally {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
        }
        return list;
    }

    
    public static void main(String[] args) {
        SearchRegisterDAO dao = new SearchRegisterDAO();
        List<Registrations> list = dao.searchRegisterByQuizStatus("2", "Passed");
        for (Registrations o : list) {
            System.out.println(o);
        }
    }
}
