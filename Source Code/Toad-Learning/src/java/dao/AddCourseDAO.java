/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AddCourseDAO {

    Connection connection = null;
    PreparedStatement ps = null;

    public void addCourse(String courseID, String title, String topicID, String description,
            String thumbnail, String price, String salePrice, LocalDateTime createdDate,
            LocalDateTime updatedDate, String status) {

        String query = "		   INSERT INTO [dbo].[Courses]\n"
                + "           ([CourseID]\n"
                + "           ,[Title]\n"
                + "           ,[TopicID]\n"
                + "           ,[Description]\n"
                + "           ,[Thumbnail]\n"
                + "           ,[Price]\n"
                + "           ,[SalePrice]\n"
                + "           ,[CreatedDate]\n"
                + "           ,[UpdatedDate]\n"
                + "           ,[Status])\n"
                + "     VALUES\n"
                + "           (?,\n"
                + "           ?,\n"
                + "?, ?,?,?,\n"
                + "          ?,\n"
                + "           ?,\n"
                + "           ?,\n"
                + "           ?)";

        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, courseID);
            ps.setString(2, title);
            ps.setString(3, topicID);
            ps.setString(4, description);
            ps.setString(5, thumbnail);
            ps.setString(6, price);
            ps.setString(7, salePrice);
            ps.setObject(8, createdDate);
            ps.setObject(9, updatedDate);
            ps.setString(10, status);

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exceptions as per your application's requirements
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
