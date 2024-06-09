package dao;

import entity.Lesson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LessonDAO {
    
    private Connection connection;

    public LessonDAO(Connection connection) {
        this.connection = connection;
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
