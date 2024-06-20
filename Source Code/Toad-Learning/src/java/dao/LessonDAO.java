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
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lessonList;
    }

    // Thêm một bài học mới vào cơ sở dữ liệu
    public void addLesson(Lesson lesson) {
        String sql = "INSERT INTO [dbo].[Lessons] ([LessonID], [CourseID], [Title], [Content], [Status]) VALUES (?, ?, ?, ?, ?)";

        try {
            // Kiểm tra xem kết nối đã được khởi tạo chưa
            if (connection == null || connection.isClosed()) {
                // Khởi tạo kết nối nếu chưa tồn tại
                connection = new DBContext().getConnection(); // Thay thế DBContext() bằng class chứa kết nối đến cơ sở dữ liệu của bạn
            }

            ps = connection.prepareStatement(sql);

            // Đặt các tham số cho câu lệnh SQL
            ps.setString(1, lesson.getLessonID());
            ps.setString(2, lesson.getCourseID());
            ps.setString(3, lesson.getTitle());
            ps.setString(4, lesson.getContent());
            ps.setString(5, lesson.getStatus());

            // Thực thi câu lệnh SQL
            ps.executeUpdate();

        } catch (SQLException e) {
            // Xử lý các ngoại lệ SQL
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên (ResultSet không cần đóng vì chưa sử dụng)
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Sửa thông tin của một bài học trong cơ sở dữ liệu
    public void editLesson(String lessonID, String courseID, String title, String content, String status) {
        String query = "UPDATE Lessons\n"
                + "SET Title = ?,\n"
                + "    Content = ?,\n"
                + "    Status = ?\n"
                + "WHERE LessonID = ? AND CourseID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, status);
            ps.setString(4, lessonID);
            ps.setString(5, courseID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa một bài học khỏi cơ sở dữ liệu dựa trên lessonID
    public void deleteLesson(String lessonID) {
        String sql = "DELETE FROM Media WHERE LessonID IN (SELECT LessonID FROM Lessons WHERE LessonID = ?);\n"
                + "\n"
                
                + "DELETE FROM Questions WHERE QuizID IN (SELECT QuizID FROM Quizzes WHERE CourseID IN (SELECT CourseID FROM Courses WHERE CourseID = (SELECT CourseID FROM Lessons WHERE LessonID = ?)));\n"
                + "\n"
                
                + "DELETE FROM Quizzes WHERE CourseID IN (SELECT CourseID FROM Courses WHERE CourseID = (SELECT CourseID FROM Lessons WHERE LessonID = ?));\n"
                + "\n"
                
                + "DELETE FROM Scores WHERE QuizID IN (SELECT QuizID FROM Quizzes WHERE CourseID IN (SELECT CourseID FROM Courses WHERE CourseID = (SELECT CourseID FROM Lessons WHERE LessonID =?)));\n"
                + "\n"
                
                + "DELETE FROM Histories WHERE CourseID IN (SELECT CourseID FROM Courses WHERE CourseID = (SELECT CourseID FROM Lessons WHERE LessonID = ?));\n"
                + "\n"
                
                + "DELETE FROM Registrations WHERE CourseID = (SELECT CourseID FROM Lessons WHERE LessonID = ?);\n"
                + "\n"
               
                + "DELETE FROM Lessons WHERE LessonID =?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, lessonID);
            ps.setString(2, lessonID);
            ps.setString(3, lessonID);
            ps.setString(4, lessonID);
            ps.setString(5, lessonID);
            ps.setString(6, lessonID);
            ps.setString(7, lessonID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
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

    public List<Lesson> getAllLesson() {
        List<Lesson> lessonList = new ArrayList<>();
        String xSql = "SELECT * FROM Products";
        try {

            String lessonID, courseID, title, content, status;

            ps = conn.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lessonID = rs.getString("LessonID");
                courseID = rs.getString("CourseID");
                title = rs.getString("Title");
                content = rs.getString("Content");
                status = rs.getString("Status");
                Lesson l = new Lesson(lessonID, courseID, title, content, status);
                lessonList.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lessonList;
    }

    public Lesson getLessonByLessonID(String lessonID) {
        Lesson lesson = null;
        String query = "SELECT LessonID, CourseID, Title, Content, Status "
                + "FROM dbo.Lessons "
                + "WHERE LessonID = ?";

        try {
            conn = new DBContext().getConnection(); // Mở kết nối với SQL
            ps = conn.prepareStatement(query);
            ps.setString(1, lessonID);
            rs = ps.executeQuery();
            if (rs.next()) {
                lesson = new Lesson();
                lesson.setLessonID(rs.getString("LessonID"));
                lesson.setCourseID(rs.getString("CourseID"));
                lesson.setTitle(rs.getString("Title"));
                lesson.setContent(rs.getString("Content"));
                lesson.setStatus(rs.getString("Status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng các kết nối
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lesson;
    }
}
