/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Course;
import entity.History;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author My Lap
 */
public class HistoryDAO extends MyDAO {

    public ArrayList<History> findAllHistoryByUserID(String userID) {
        try {
            xSql = "SELECT * FROM [Histories] where UserID = ?";
            ps = con.prepareStatement(xSql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            
            ArrayList<History> historys = new ArrayList<>();
            
            while (rs.next()) {                
                History history = new History();
                history.setHistoryID(rs.getInt("HistoryID"));
                CourseDAO dbCourse = new CourseDAO();
                Course course = dbCourse.getCourseByID(rs.getString("CourseID"));
                history.setCourseID(course);
                history.setAction(rs.getString("Action"));
                history.setActionDate(rs.getDate("ActionDate"));
                history.setStatus(rs.getString("Status"));
                historys.add(history);
            }
            return historys;
        } catch (SQLException ex) {
            Logger.getLogger(HistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
