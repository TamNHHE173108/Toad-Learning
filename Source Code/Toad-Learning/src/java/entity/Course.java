/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class Course {
    private String courseID;
    private String title;
    private Topic topicID;
    private String description;
    private String createDate;
    private String updateDate;
    private String thumbnail;
    private String price;
    private String salePrice;
    private String status;

    public Course() {
    }

    public Course(String courseID, String title, Topic topicID, String description, String thumbnail,String price,String salePrice, String createDate, String updateDate, String status) {
        this.courseID = courseID;
        this.title = title;
        this.topicID = topicID;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.salePrice = salePrice;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Topic getTopicID() {
        return topicID;
    }

    public void setTopicID(Topic topicID) {
        this.topicID = topicID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", title=" + title + ", topicID=" + topicID + ", description=" + description + ", createDate=" + createDate + ", updateDate=" + updateDate + ", thumbnail=" + thumbnail + ", price=" + price + ", salePrice=" + salePrice + ", status=" + status + '}';
    }
    
    
    
}

