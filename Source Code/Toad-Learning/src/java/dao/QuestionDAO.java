package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Question;

public class QuestionDAO {

    private Connection connection;

    public QuestionDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Question> getFilteredQuestions(String subject, String lesson) throws SQLException {
        List<Question> questions = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Tạo truy vấn SQL dựa trên các thông số lọc
            String query = "SELECT * FROM Questions WHERE 1=1";
            if (subject != null && !subject.isEmpty()) {
                query += " AND Subject = ?";
            }
            if (lesson != null && !lesson.isEmpty()) {
                query += " AND Lesson = ?";
            }

            // Tạo PreparedStatement và thiết lập các tham số
            ps = connection.prepareStatement(query);
            int parameterIndex = 1;
            if (subject != null && !subject.isEmpty()) {
                ps.setString(parameterIndex++, subject);
            }
            if (lesson != null && !lesson.isEmpty()) {
                ps.setString(parameterIndex++, lesson);
            }

            // Thực thi truy vấn
            rs = ps.executeQuery();

            // Xử lý kết quả và thêm câu hỏi vào danh sách
            while (rs.next()) {
                Question question = new Question();
                // Thiết lập thông tin cho câu hỏi từ kết quả ResultSet
                question.setQuestionID(rs.getString("QuestionID"));
                question.setQuizID(rs.getString("QuizID"));
                question.setContent(rs.getString("Content"));
                question.setMedia(rs.getString("Media"));
                question.setAnswerOptions(rs.getString("AnswerOptions"));
                question.setCorrectAnswer(rs.getString("CorrectAnswer"));
                question.setExplanation(rs.getString("Explanation"));
                question.setStatus(rs.getString("Status"));
                // Thêm câu hỏi vào danh sách
                questions.add(question);
            }
        } finally {
            // Đóng các đối tượng ResultSet và PreparedStatement sau khi sử dụng
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return questions;
    }

    public void addQuestion(Question question) throws SQLException {
        String sql = "INSERT INTO Questions (QuestionID, QuizID, Content, Media, AnswerOptions, CorrectAnswer, Explanation, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, question.getQuestionID());
            ps.setString(2, question.getQuizID());
            ps.setString(3, question.getContent());
            ps.setString(4, question.getMedia());
            ps.setString(5, question.getAnswerOptions());
            ps.setString(6, question.getCorrectAnswer());
            ps.setString(7, question.getExplanation());
            ps.setString(8, question.getStatus());

            // Thực thi truy vấn
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            // Đóng PreparedStatement
            if (ps != null) {
                ps.close();
            }
        }
    }
}
