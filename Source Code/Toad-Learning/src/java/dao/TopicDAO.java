/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Topic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class TopicDAO extends MyDAO {
    
    public List<Topic> findTop4() {
        
        try {
            List<Topic> topics = new ArrayList<>();
            xSql = "SELECT TOP 5 * FROM Topics";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                topics.add(toTopic(rs));
            }
            return topics;
        } catch (SQLException ex) {
            Logger.getLogger(TopicDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private Topic toTopic(ResultSet rs) throws SQLException {
        Topic topic = new Topic();
        topic.setTopicID(rs.getString("TopicID"));
        topic.setTopicName(rs.getString("TopicName"));
        topic.setDescription(rs.getString("Description"));
        return topic;
    }
    
}
