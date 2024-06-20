package dao;

import dal.DBContext;
import entity.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Categories> getAllCourses() {
        try {
            String query = "SELECT DISTINCT Title, TopicID FROM Courses";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Categories> list = new ArrayList<>();
            while (rs.next()) {
                Categories c = new Categories(rs.getString(2), rs.getString(1));
                list.add(c);
            }

            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
