/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author laptop lenovo
 */
public class DeleteUserDAO {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void deleteUser(String user_id) {
        String query = "DELETE FROM Scores\n"
                + "WHERE UserID = ?\n"
                + "DELETE FROM Histories\n"
                + "WHERE UserID = ?\n"
                + "DELETE FROM Registrations\n"
                + "WHERE UserID = ?\n"
                + "DELETE FROM Blogs\n"
                + "WHERE UserID = ?\n"
                + "DELETE FROM UserGroups\n"
                + "WHERE UserID = ?\n"
                + "DELETE FROM Questions\n"
                + "WHERE QuizID IN (SELECT QuizID FROM Quizzes WHERE CourseID IN (SELECT CourseID FROM Courses WHERE UserID = ?));\n"
                + "DELETE FROM Quizzes\n"
                + "WHERE CourseID IN (SELECT CourseID FROM Courses WHERE UserID = ?);\n"
                + "DELETE FROM Lessons\n"
                + "WHERE CourseID IN (SELECT CourseID FROM Courses WHERE UserID = ?);\n"
                + "DELETE FROM Media\n"
                + "WHERE LessonID IN (SELECT LessonID FROM Lessons WHERE CourseID IN (SELECT CourseID FROM Courses WHERE UserID = ?));\n"
                + "DELETE FROM Courses\n"
                + "WHERE UserID = ?\n"
                + "DELETE FROM Users\n"
                + "WHERE UserID = ?";
        try {
            connection = new DBContext().getConnection();//mo ket noi voi sql
            ps = connection.prepareStatement(query);
            ps.setString(1, user_id);
            ps.setString(2, user_id);
            ps.setString(3, user_id);
            ps.setString(4, user_id);
            ps.setString(5, user_id);
            ps.setString(6, user_id);
            ps.setString(7, user_id);
            ps.setString(8, user_id);
            ps.setString(9, user_id);
            ps.setString(10, user_id);
            ps.setString(11, user_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
