package dao;

import entity.User;
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
    public void Register(String username, String pass) {
        xSql = "INSERT INTO Users (username, Password, role_id) VALUES ( ?, ?, ?)";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setInt(3, 2);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
