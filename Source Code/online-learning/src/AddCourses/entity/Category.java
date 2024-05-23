/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class Category {
    private String categoryID;
    private String name;
    private String description;

    public Category() {}

    public Category(String categoryID, String name, String description) {
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
    }

    // Getters and setters...
    public String getCategoryID() { return categoryID; }
    public void setCategoryID(String categoryID) { this.categoryID = categoryID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

