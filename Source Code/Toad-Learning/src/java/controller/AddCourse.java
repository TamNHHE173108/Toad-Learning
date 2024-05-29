/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CourseDAO;
import entity.Course;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author My Lap
 */
@WebServlet(name="AddCourse", urlPatterns={"/addCourse"})
public class AddCourse extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String courseID = request.getParameter("courseID");
        String courseName = request.getParameter("courseName");
        String description = request.getParameter("description");
        String categoryID = request.getParameter("categoryID");
        String thumbnail = request.getParameter("thumbnail");
        boolean featured = request.getParameter("featured") != null;
        String owner = request.getParameter("owner");
        String status = request.getParameter("status");

        Course course = new Course();
        course.setCourseID(courseID);
        course.setCourseName(courseName);
        course.setDescription(description);
        course.setCategoryID(categoryID);
        course.setThumbnail(thumbnail);
        course.setFeatured(featured);
        course.setOwner(owner);
        course.setStatus(status);

        CourseDAO courseDAO = new CourseDAO();
        try {
            courseDAO.addCourse(course);
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
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
        return "AddCourseServlet";
    }
}