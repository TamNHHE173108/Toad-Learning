/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class Subject {
    private String subjectID;
    private String subjectName;
    private String description;
    private String categoryID;

    public Subject() {}

    public Subject(String subjectID, String subjectName, String description, String categoryID) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.description = description;
        this.categoryID = categoryID;
    }

    // Getters and setters...
    public String getSubjectID() { return subjectID; }
    public void setSubjectID(String subjectID) { this.subjectID = subjectID; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategoryID() { return categoryID; }
    public void setCategoryID(String categoryID) { this.categoryID = categoryID; }
}

