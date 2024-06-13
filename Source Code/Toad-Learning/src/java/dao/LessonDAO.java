package dao;

import dal.DBContext;
import entity.Lesson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDAO {

    
    
    
    private Connection connection;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    
        public List<Lesson> getLessonByCourseID(String courseID) {
        List<Lesson> lessonList = new ArrayList<>();
        String xSql = "SELECT * FROM Lessons WHERE courseID = ?";
        
        try {
            conn = new DBContext().getConnection(); // Mở kết nối với SQL
            ps = conn.prepareStatement(xSql);
            ps.setString(1, courseID);
            rs = ps.executeQuery();

            String id, title, content, status;
            while (rs.next()) {
                id = rs.getString("LessonID");
                title = rs.getString("Title");
                content = rs.getString("Content");
                status = rs.getString("Status");

                Lesson lesson = new Lesson(id, courseID, title, content, status);
                lessonList.add(lesson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lessonList;
    }

    // Thêm một bài học mới vào cơ sở dữ liệu
    public void addLesson(Lesson lesson) throws SQLException {
        String sql = "INSERT INTO lesson (lessonID, courseID, title, content, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lesson.getLessonID());
            statement.setString(2, lesson.getCourseID());
            statement.setString(3, lesson.getTitle());
            statement.setString(4, lesson.getContent());
            statement.setString(5, lesson.getStatus());
            statement.executeUpdate();
        }
    }

    // Sửa thông tin của một bài học trong cơ sở dữ liệu
    public void updateLesson(Lesson lesson) throws SQLException {
        String sql = "UPDATE lesson SET courseID = ?, title = ?, content = ? WHERE lessonID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lesson.getCourseID());
            statement.setString(2, lesson.getTitle());
            statement.setString(3, lesson.getContent());
            statement.setString(4, lesson.getLessonID());
            statement.executeUpdate();
        }
    }

    // Xóa một bài học khỏi cơ sở dữ liệu dựa trên lessonID
    public void deleteLesson(String lessonID) throws SQLException {
        String sql = "DELETE FROM lesson WHERE lessonID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lessonID);
            statement.executeUpdate();
        }
    }

    // Thay đổi trạng thái của một bài học trong cơ sở dữ liệu
    public void changeLessonStatus(String lessonID, String newStatus) throws SQLException {
        String sql = "UPDATE lesson SET status = ? WHERE lessonID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newStatus);
            statement.setString(2, lessonID);
            statement.executeUpdate();
        }
    }
}
