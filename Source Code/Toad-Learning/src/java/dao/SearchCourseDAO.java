/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.Course;
import entity.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop lenovo
 */
public class SearchCourseDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Course> searchCourseByName(String txtC) {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "WHERE [CourseID] like ? or [Title] like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtC + "%");
            ps.setString(2, "%" + txtC + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
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

    public List<Course> searchCourseByTopic(String topicname) {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "WHERE Topics.TopicName = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, topicname);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
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
    public List<Course> searchCourseStudentByTopic(String topicname, String UserID) {
    List<Course> list = new ArrayList<>();
    String sql = "SELECT \n"
               + "    [Courses].[CourseID],\n"
               + "    [Courses].[Title],\n"
               + "    t.TopicName,\n"
               + "    [Courses].[Description],\n"
               + "    [Courses].[Thumbnail],\n"
               + "    [Courses].[Price],\n"
               + "    [Courses].[SalePrice],\n"
               + "    [Courses].[CreatedDate],\n"
               + "    [Courses].[UpdatedDate],\n"
               + "    [Courses].[Status]\n"
               + "FROM [SWP391_1].[dbo].[Courses]\n"
               + "JOIN [SWP391_1].[dbo].[Registrations]\n"
               + "    ON [Courses].[CourseID] = [Registrations].[CourseID]\n"
               + "LEFT JOIN [SWP391_1].[dbo].[Topics] t\n"
               + "    ON [Courses].[TopicID] = t.[TopicID]\n"
               + "WHERE t.TopicName = ?\n" // Corrected WHERE clause
               + "    AND [Registrations].[UserID] = ?;"; // Added AND for second condition

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1, topicname);
        ps.setString(2, UserID); // Set second parameter for UserID
        rs = ps.executeQuery();
        while (rs.next()) {
            String courseID = rs.getString(1);
            String title = rs.getString(2);
            String topicName = rs.getString(3);
            String description = rs.getString(4);
            String thumbnail = rs.getString(5);
            String price = rs.getString(6);
            String salePrice = rs.getString(7);
            String createDate = rs.getString(8);
            String updateDate = rs.getString(9);
            String status = rs.getString(10);
            Topic topic = new Topic(topicName);

            Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
            list.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception
    } finally {
        // Close resources in finally block
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
    }
    return list;
}
    public List<Course> searchCourseStudentByStatus(String status, String UserID) {
    List<Course> list = new ArrayList<>();
    String sql = "SELECT \n"
               + "    [Courses].[CourseID],\n"
               + "    [Courses].[Title],\n"
               + "    t.TopicName,\n"
               + "    [Courses].[Description],\n"
               + "    [Courses].[Thumbnail],\n"
               + "    [Courses].[Price],\n"
               + "    [Courses].[SalePrice],\n"
               + "    [Courses].[CreatedDate],\n"
               + "    [Courses].[UpdatedDate],\n"
               + "    [Courses].[Status]\n"
               + "FROM [SWP391_1].[dbo].[Courses]\n"
               + "JOIN [SWP391_1].[dbo].[Registrations]\n"
               + "    ON [Courses].[CourseID] = [Registrations].[CourseID]\n"
               + "LEFT JOIN [SWP391_1].[dbo].[Topics] t\n"
               + "    ON [Courses].[TopicID] = t.[TopicID]\n"
               + "WHERE [Courses].[Status] = ?\n" // Corrected WHERE clause
               + "    AND [Registrations].[UserID] = ?;"; // Added AND for second condition

    

    try {
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1, status);
        ps.setString(2, UserID); // Set second parameter for UserID
        rs = ps.executeQuery();
        while (rs.next()) {
            String courseID = rs.getString(1);
            String title = rs.getString(2);
            String topicName = rs.getString(3);
            String description = rs.getString(4);
            String thumbnail = rs.getString(5);
            String price = rs.getString(6);
            String salePrice = rs.getString(7);
            String createDate = rs.getString(8);
            String updateDate = rs.getString(9);
            String status1 = rs.getString(10);
            Topic topic = new Topic(topicName);

            Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status1);
            list.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception
    } finally {
        // Close resources in finally block
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
    }
    return list;
}


    public List<Course> searchCourseByStatus(String statuss) {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "WHERE Status = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, statuss);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
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

    public List<Course> sortByPriceASC() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "ORDER BY Price ASC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
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

    public List<Course> sortByPriceDESC() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "ORDER BY Price DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
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

    public List<Course> sortBySalePriceASC() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "ORDER BY SalePrice ASC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
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
   public List<Course> sortStudentCourseBySalePriceASC(String userID) {
    List<Course> list = new ArrayList<>();
    String sql = "SELECT \n"
               + "    [Courses].[CourseID],\n"
               + "    [Courses].[Title],\n"
               + "    t.TopicName,\n"
               + "    [Courses].[Description],\n"
               + "    [Courses].[Thumbnail],\n"
               + "    [Courses].[Price],\n"
               + "    [Courses].[SalePrice],\n"
               + "    [Courses].[CreatedDate],\n"
               + "    [Courses].[UpdatedDate],\n"
               + "    [Courses].[Status]\n"
               + "FROM [SWP391_1].[dbo].[Courses]\n"
               + "JOIN [SWP391_1].[dbo].[Registrations]\n"
               + "    ON [Courses].[CourseID] = [Registrations].[CourseID]\n"
               + "LEFT JOIN [SWP391_1].[dbo].[Topics] t\n"
               + "    ON [Courses].[TopicID] = t.[TopicID]\n"
               + "WHERE [Registrations].[UserID] = ?\n"
               + "ORDER BY [Courses].[SalePrice] ASC;";

    
    try {
        conn = new DBContext().getConnection(); // Kết nối tới cơ sở dữ liệu
        ps = conn.prepareStatement(sql);
        ps.setString(1, userID); // Thiết lập giá trị tham số `userID`
        rs = ps.executeQuery();

        while (rs.next()) {
            String courseID = rs.getString(1);
            String title = rs.getString(2);
            String topicName = rs.getString(3);
            String description = rs.getString(4);
            String thumbnail = rs.getString(5);
            String price = rs.getString(6);
            String salePrice = rs.getString(7);
            String createDate = rs.getString(8);
            String updateDate = rs.getString(9);
            String status = rs.getString(10);
            Topic topic = new Topic(topicName);

            Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
            list.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // In ra lỗi nếu có
    } finally {
        // Đóng các tài nguyên
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return list;
}
  
    public List<Course> sortListStudentCourseByPriceASC() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT \n"
                     + "    [Courses].[CourseID],\n"
                     + "    [Courses].[Title],\n"
                     + "    t.[TopicName],\n"
                     + "    [Courses].[Description],\n"
                     + "    [Courses].[Thumbnail],\n"
                     + "    [Courses].[Price],\n"
                     + "    [Courses].[SalePrice],\n"
                     + "    [Courses].[CreatedDate],\n"
                     + "    [Courses].[UpdatedDate],\n"
                     + "    [Courses].[Status]\n"
                     + "FROM [SWP391_1].[dbo].[Courses]\n"
                     + "LEFT JOIN [SWP391_1].[dbo].[Topics] t\n"
                     + "    ON [Courses].[TopicID] = t.[TopicID]\n"
                     + "WHERE [Courses].[Status] = 'Active'\n"
                     + "ORDER BY [Courses].[Price] ASC;";

        try {
            conn = new DBContext().getConnection(); // Kết nối tới cơ sở dữ liệu
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        } finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    

}
   public List<Course> sortListStudentCourseByPriceDESC() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT \n"
                     + "    [Courses].[CourseID],\n"
                     + "    [Courses].[Title],\n"
                     + "    t.[TopicName],\n"
                     + "    [Courses].[Description],\n"
                     + "    [Courses].[Thumbnail],\n"
                     + "    [Courses].[Price],\n"
                     + "    [Courses].[SalePrice],\n"
                     + "    [Courses].[CreatedDate],\n"
                     + "    [Courses].[UpdatedDate],\n"
                     + "    [Courses].[Status]\n"
                     + "FROM [SWP391_1].[dbo].[Courses]\n"
                     + "LEFT JOIN [SWP391_1].[dbo].[Topics] t\n"
                     + "    ON [Courses].[TopicID] = t.[TopicID]\n"
                     + "WHERE [Courses].[Status] = 'Active'\n"
                     + "ORDER BY [Courses].[Price] DESC;";

        try {
            conn = new DBContext().getConnection(); // Kết nối tới cơ sở dữ liệu
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        } finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    

}
    public List<Course> sortStudentCourseByPriceDESC(String userID) {
    List<Course> list = new ArrayList<>();
    String sql = "SELECT \n"
               + "    [Courses].[CourseID],\n"
               + "    [Courses].[Title],\n"
               + "    t.TopicName,\n"
               + "    [Courses].[Description],\n"
               + "    [Courses].[Thumbnail],\n"
               + "    [Courses].[Price],\n"
               + "    [Courses].[SalePrice],\n"
               + "    [Courses].[CreatedDate],\n"
               + "    [Courses].[UpdatedDate],\n"
               + "    [Courses].[Status]\n"
               + "FROM [SWP391_1].[dbo].[Courses]\n"
               + "JOIN [SWP391_1].[dbo].[Registrations]\n"
               + "    ON [Courses].[CourseID] = [Registrations].[CourseID]\n"
               + "LEFT JOIN [SWP391_1].[dbo].[Topics] t\n"
               + "    ON [Courses].[TopicID] = t.[TopicID]\n"
               + "WHERE [Registrations].[UserID] = ?\n"
               + "ORDER BY [Courses].[Price] DESC;";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = new DBContext().getConnection(); // Kết nối tới cơ sở dữ liệu
        ps = conn.prepareStatement(sql);
        ps.setString(1, userID); // Thiết lập giá trị tham số `userID`
        rs = ps.executeQuery();

        while (rs.next()) {
            String courseID = rs.getString(1);
            String title = rs.getString(2);
            String topicName = rs.getString(3);
            String description = rs.getString(4);
            String thumbnail = rs.getString(5);
            String price = rs.getString(6);
            String salePrice = rs.getString(7);
            String createDate = rs.getString(8);
            String updateDate = rs.getString(9);
            String status = rs.getString(10);
            Topic topic = new Topic(topicName);

            Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
            list.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // In ra lỗi nếu có
    } finally {
        // Đóng các tài nguyên
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return list;
}
    public List<Course> sortStudentCourseByPriceASC(String userID) {
    List<Course> list = new ArrayList<>();
    String sql = "SELECT \n"
               + "    [Courses].[CourseID],\n"
               + "    [Courses].[Title],\n"
               + "    t.TopicName,\n"
               + "    [Courses].[Description],\n"
               + "    [Courses].[Thumbnail],\n"
               + "    [Courses].[Price],\n"
               + "    [Courses].[SalePrice],\n"
               + "    [Courses].[CreatedDate],\n"
               + "    [Courses].[UpdatedDate],\n"
               + "    [Courses].[Status]\n"
               + "FROM [SWP391_1].[dbo].[Courses]\n"
               + "JOIN [SWP391_1].[dbo].[Registrations]\n"
               + "    ON [Courses].[CourseID] = [Registrations].[CourseID]\n"
               + "LEFT JOIN [SWP391_1].[dbo].[Topics] t\n"
               + "    ON [Courses].[TopicID] = t.[TopicID]\n"
               + "WHERE [Registrations].[UserID] = ?\n"
               + "ORDER BY [Courses].[Price] ASC;";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = new DBContext().getConnection(); // Kết nối tới cơ sở dữ liệu
        ps = conn.prepareStatement(sql);
        ps.setString(1, userID); // Thiết lập giá trị tham số `userID`
        rs = ps.executeQuery();

        while (rs.next()) {
            String courseID = rs.getString(1);
            String title = rs.getString(2);
            String topicName = rs.getString(3);
            String description = rs.getString(4);
            String thumbnail = rs.getString(5);
            String price = rs.getString(6);
            String salePrice = rs.getString(7);
            String createDate = rs.getString(8);
            String updateDate = rs.getString(9);
            String status = rs.getString(10);
            Topic topic = new Topic(topicName);

            Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
            list.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // In ra lỗi nếu có
    } finally {
        // Đóng các tài nguyên
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return list;
}




     public List<Course> sortStudentCourseBySalePriceDESC(String userID) {
    List<Course> list = new ArrayList<>();
    String sql = "SELECT \n"
               + "    [Courses].[CourseID],\n"
               + "    [Courses].[Title],\n"
               + "    t.TopicName,\n"
               + "    [Courses].[Description],\n"
               + "    [Courses].[Thumbnail],\n"
               + "    [Courses].[Price],\n"
               + "    [Courses].[SalePrice],\n"
               + "    [Courses].[CreatedDate],\n"
               + "    [Courses].[UpdatedDate],\n"
               + "    [Courses].[Status]\n"
               + "FROM [SWP391_1].[dbo].[Courses]\n"
               + "JOIN [SWP391_1].[dbo].[Registrations]\n"
               + "    ON [Courses].[CourseID] = [Registrations].[CourseID]\n"
               + "LEFT JOIN [SWP391_1].[dbo].[Topics] t\n"
               + "    ON [Courses].[TopicID] = t.[TopicID]\n"
               + "WHERE [Registrations].[UserID] = ?\n"
               + "ORDER BY [Courses].[SalePrice] DESC;";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = new DBContext().getConnection(); // Kết nối tới cơ sở dữ liệu
        ps = conn.prepareStatement(sql);
        ps.setString(1, userID); // Thiết lập giá trị tham số `userID`
        rs = ps.executeQuery();

        while (rs.next()) {
            String courseID = rs.getString(1);
            String title = rs.getString(2);
            String topicName = rs.getString(3);
            String description = rs.getString(4);
            String thumbnail = rs.getString(5);
            String price = rs.getString(6);
            String salePrice = rs.getString(7);
            String createDate = rs.getString(8);
            String updateDate = rs.getString(9);
            String status = rs.getString(10);
            Topic topic = new Topic(topicName);

            Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
            list.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // In ra lỗi nếu có
    } finally {
        // Đóng các tài nguyên
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return list;
}


    public List<Course> sortBySalePriceDESC() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "ORDER BY SalePrice DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
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

    public List<Course> searchCourseLecByStatus(String statuss, String userID) {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "FROM Courses\n"
                + "INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "WHERE Status = ? AND UserID= ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, statuss);
            ps.setString(2, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
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

    public List<Course> searchCourseLecByName(String txtC, String userid) {
        List<Course> list = new ArrayList<>();
        String sql = "  SELECT CourseID, Title, Topics.TopicName, Courses.Description,Thumbnail, Price, SalePrice, CreatedDate, UpdatedDate, Status\n"
                + "                FROM Courses\n"
                + "                INNER JOIN Topics ON Courses.TopicID=Topics.TopicID\n"
                + "                WHERE ([CourseID] like ? or [Title] like ?)\n"
                + "				AND [UserID] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtC + "%");
            ps.setString(2, "%" + txtC + "%");
            ps.setString(3, userid);
            rs = ps.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String title = rs.getString(2);
                String topicName = rs.getString(3);
                String description = rs.getString(4);
                String thumbnail = rs.getString(5);
                String price = rs.getString(6);
                String salePrice = rs.getString(7);
                String createDate = rs.getString(8);
                String updateDate = rs.getString(9);
                String status = rs.getString(10);
                Topic topic = new Topic(topicName);

                Course course = new Course(courseID, title, topic, description, thumbnail, price, salePrice, createDate, updateDate, status);
                list.add(course);
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
        SearchCourseDAO dao = new SearchCourseDAO();
        List<Course> list = dao.searchCourseLecByName("ASU", "2");
        for (Course o : list) {
            System.out.println(o);
        }
    }
}
