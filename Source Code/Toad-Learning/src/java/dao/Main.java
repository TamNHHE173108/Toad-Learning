/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Categories;
import java.util.List;

/**
 *
 * @author Andrew
 */
public class Main {

    public static void main(String[] args) {
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        List<Categories> list = categoriesDAO.getAllCourses();
        for (Categories c : list) {
            System.out.println("TopicID: " +c.getTopicID() + ", CategoryName: "+c.getCategoryName());
        }
    }
}
