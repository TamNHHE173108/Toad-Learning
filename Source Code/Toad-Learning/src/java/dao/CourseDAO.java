/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class CourseDAO {
    Connection conn = null;
    PreparedStatement ps = null;

    public void addCourse(Subject subject) throws Exception {
        String sql = "INSERT INTO Subject (SubjectID, SubjectName, Description, CategoryID) VALUES (?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, subject.getSubjectID());
            ps.setString(2, subject.getSubjectName());
            ps.setString(3, subject.getDescription());
            ps.setString(4, subject.getCategoryID());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    // Các phương thức khác như lấy danh sách khóa học có thể được thêm vào đây...
}

