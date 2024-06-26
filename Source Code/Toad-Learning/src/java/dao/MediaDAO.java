/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.Course;
import entity.Media;
import entity.Topic;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author My Lap
 */
public class MediaDAO extends MyDAO {

    public List<Media> findAll() {
        List<Media> list = new ArrayList<>();
        xSql = "Select * from [Media]";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String MediaID = rs.getString(1);
                String LessonID = rs.getString(2);
                String MediaType = rs.getString(3);
                String MediaPath = rs.getString(4);
                Media media = new Media(MediaID, LessonID, MediaType, MediaPath);
                list.add(media);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
