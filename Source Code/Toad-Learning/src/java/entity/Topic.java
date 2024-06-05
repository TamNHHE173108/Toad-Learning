/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author laptop lenovo
 */
public class Topic {
    private String topicID;
    private String topicName;

    public Topic() {
    }

    public Topic(String topicID, String topicName) {
        this.topicID = topicID;
        this.topicName = topicName;
    }

    public Topic(String topicName) {
        this.topicName = topicName;
    }
    
    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
