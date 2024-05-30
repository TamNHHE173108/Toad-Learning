/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class Course {
    private String courseID;
    private String courseName;
    private String description;
    private String categoryID;
    private String thumbnail;
    private boolean featured;
    private String owner;
    private String status;
    private String category;

    // Constructors
    public Course() {
    }

    public Course(String courseID, String courseName, String description, String categoryID, String thumbnail, boolean featured, String owner, String status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.description = description;
        this.categoryID = categoryID;
        this.thumbnail = thumbnail;
        this.featured = featured;
        this.owner = owner;
        this.status = status;
    }

    // Getters and Setters
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        String category = null;
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
