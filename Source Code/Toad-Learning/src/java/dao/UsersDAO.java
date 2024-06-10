package dao;

import dal.DBContext;
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
    public void Register( String username, String password, String name, String gender,
            String email, String mobile,String role, String status, String address) {
        String query = "INSERT [dbo].[Users] \n"
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

}
