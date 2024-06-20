package dao;

import dal.DBContext;
import entity.PasswordResetToken;
import entity.User;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

public class UsersDAO extends MyDAO {

    public User Login(String username, String pass) {
        xSql = "select * from Users where username = ? and password = ?";
        String xUsername, xPass, xRole, xName = null, xUser_id, xGender = null, xEmail = null, xMobile = null, xStatus = null, xAddress = null;

        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                xUser_id = rs.getString("UserID");
                xUsername = rs.getString("Username");
                xPass = rs.getString("Password");
                xRole = rs.getString("Role");
                xName = rs.getString("FullName");
                xGender = rs.getString("Gender");
                xEmail = rs.getString("Email");
                xMobile = rs.getString("Mobile");
                xStatus = rs.getString("Status");
                xAddress = rs.getString("Address");

                x = new User(xUser_id, xUsername, xPass, xName, xGender, xEmail, xMobile, xRole, xStatus, xAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    // hàm tra vê danh sách tat ca nguoi dung
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        xSql = "select * from users";
        String xUsername, xPass, xRole, xName = null, xUser_id, xGender = null, xEmail = null, xMobile = null, xStatus = null, xAddress = null;

        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xUser_id = rs.getString("UserID");
                xUsername = rs.getString("Username");
                xPass = rs.getString("Password");
                xRole = rs.getString("Role");
                xName = rs.getString("FullName");
                xGender = rs.getString("Gender");
                xEmail = rs.getString("Email");
                xMobile = rs.getString("Mobile");
                xStatus = rs.getString("Status");
                xAddress = rs.getString("Address");

                x = new User(xUser_id, xUsername, xPass, xName, xGender, xEmail, xMobile, xRole, xStatus, xAddress);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // hàm dang kí
    public void Register(String username, String password, String name, String gender,
            String email, String mobile, String role, String status, String address) {
        String query = "INSERT INTO [dbo].[Users] \n"
                + "([Username], [Password], [FullName], [Gender], [Email], [Mobile], [Role] , [Status],[Address])\n"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            connection = new DBContext().getConnection();//mo ket noi voi sql
            ps = connection.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, gender);
            ps.setString(5, email);
            ps.setString(6, mobile);
            ps.setString(7, role);
            ps.setString(8, "Active");
            ps.setString(9, address);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Add new methods for forgot password functionality

    // Get user by email
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM Users WHERE Email = ?";
        User user = null;
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getString("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        rs.getString("Mobile"),
                        rs.getString("Role"),
                        rs.getString("Status"),
                        rs.getString("Address")
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Save reset token
    public void saveResetToken(String email, String token, LocalDateTime expiryDate) {
        String query = "INSERT INTO PasswordResetToken (Email, Token, ExpiryDate) VALUES (?, ?, ?)";
        try  {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, token);
            ps.setObject(3, expiryDate);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get user by reset token
    public User getUserByToken(String token) {
        String query = "SELECT * FROM Users WHERE ResetToken = ?";
        User user = null;
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, token);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getString("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        rs.getString("Mobile"),
                        rs.getString("Role"),
                        rs.getString("Status"),
                        rs.getString("Address")
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Update password using reset token
    public boolean updatePassword(String email, String newPassword) {
        String query = "UPDATE Users SET Password = ? WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, email);
            int updated = ps.executeUpdate();
            return updated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy người dùng bằng token reset
    public User getUserByResetToken(String token) {
        String query = "SELECT * FROM Users WHERE ResetToken = ?";
        User user = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, token);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getString("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        rs.getString("Mobile"),
                        rs.getString("Role"),
                        rs.getString("Status"),
                        rs.getString("Address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    // Xóa token reset sau khi mật khẩu đã được cập nhật

    public void clearResetToken(String token) {
        String query = "UPDATE Users SET ResetToken = NULL WHERE ResetToken = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, token);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User checkUserByEmail(String email) {
        String query = "SELECT * FROM Users WHERE Email = ?";
        User user = null;
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getString("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        rs.getString("Mobile"),
                        rs.getString("Role"),
                        rs.getString("Status"),
                        rs.getString("Address")
                );
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public PasswordResetToken getResetToken(String token) {
        String query = "SELECT * FROM PasswordResetToken WHERE Token = ?";
        PasswordResetToken resetToken = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, token);
            rs = ps.executeQuery();
            if (rs.next()) {
                resetToken = new PasswordResetToken(
                        rs.getString("Token"),
                        rs.getString("Email"),
                        rs.getTimestamp("ExpiryDate").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resetToken;
    }

}
