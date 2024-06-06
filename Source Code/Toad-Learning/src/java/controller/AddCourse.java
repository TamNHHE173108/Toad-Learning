/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CourseDAO;
import entity.Course;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author My Lap
 */
@WebServlet(name = "AddCourse", urlPatterns = {"/Addcourses"})
public class AddCourse extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String courseID = request.getParameter("courseID");
        String courseName = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("topicID");
        String createDate = request.getParameter("createDate");
        String updateDate = request.getParameter("updateDate");
        String thumbnail = request.getParameter("thumbnail");
        String price = request.getParameter("price");
        String salePrice = request.getParameter("status");
        String status = request.getParameter("status");

        CourseDAO courseDAO = new CourseDAO();
        courseDAO.addCourse(courseID,courseName,category,description,createDate,updateDate,thumbnail,price,salePrice,status);
        response.sendRedirect("listcourse");
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