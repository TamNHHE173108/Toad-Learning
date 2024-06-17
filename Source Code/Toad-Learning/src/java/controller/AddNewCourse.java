/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AddCourseDAO;
import entity.Course;
import entity.Topic;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddNewCourse", urlPatterns = {"/AddNewCourse"})
public class AddNewCourse extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Retrieve data from the form
        String courseID = request.getParameter("courseID");
        String courseName = request.getParameter("courseName");
        String description = request.getParameter("description");
        String topicID = request.getParameter("topicID");
        String createDateStr = request.getParameter("createdDate");
        String updateDateStr = request.getParameter("updatedDate");
        String thumbnail = ""; // Assuming you handle file upload separately
        float price = Float.parseFloat(request.getParameter("price"));
        float salePrice = request.getParameter("salePrice").isEmpty() ? 0 : Float.parseFloat(request.getParameter("salePrice"));
        String status = request.getParameter("status");

        // Parse dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime createdDate = LocalDateTime.parse(createDateStr, formatter);
        LocalDateTime updatedDate = LocalDateTime.parse(updateDateStr, formatter);

        AddCourseDAO courseDAO = new AddCourseDAO();
        try {
            Course existingCourse = courseDAO.getCourseByID(courseID);
            if (existingCourse == null) {
                // Fetch the Topic object corresponding to topicID
                Topic topic = courseDAO.getTopicByID(topicID); // Implement this method in DAO

                // Create a new Course object and set its properties
                Course newCourse = new Course(courseID, courseName, description, thumbnail, String.valueOf(price), String.valueOf(salePrice), createdDate.toString(), updatedDate.toString(), status);
                newCourse.setTopicID(topic); // Set the retrieved Topic object

                courseDAO.addCourse(newCourse); // Pass the Course object to the DAO

                response.sendRedirect(request.getContextPath() + "/listcourse");
            } else {
                request.setAttribute("error", "Course ID " + courseID + " already exists.");
                request.getRequestDispatcher("/Toad-Learning/views/Dangph/addCourses.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("error", "Invalid number format.");
            request.getRequestDispatcher("/Toad-Learning/views/Dangph/addCourses.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while adding the course.");
            request.getRequestDispatcher("/Toad-Learning/views/Dangph/addCourses.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
