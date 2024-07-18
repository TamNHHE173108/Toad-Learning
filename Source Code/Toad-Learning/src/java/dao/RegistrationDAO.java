/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.Registrations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lehoa
 */
public class RegistrationDAO {
    private Connection connection;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
     public void addRegistration(Registrations registration) {
        String sql = "INSERT INTO [dbo].[Registrations]\n" +
"           ([UserID]\n" +
"           ,[CourseID])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?)";

        try {
            // Kiểm tra xem kết nối đã được khởi tạo chưa
            if (connection == null || connection.isClosed()) {
                // Khởi tạo kết nối nếu chưa tồn tại
                connection = new DBContext().getConnection(); // Thay thế DBContext() bằng class chứa kết nối đến cơ sở dữ liệu của bạn
            }

            ps = connection.prepareStatement(sql);

            // Đặt các tham số cho câu lệnh SQL
            ps.setString(1, registration.getUserID());
            ps.setString(2, registration.getCourseID());
            

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

    
}
