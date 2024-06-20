/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AddCourseDAO;
import dao.CourseDAO;
import entity.Course;
import entity.Topic;
import entity.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;

@WebServlet(name = "AddNewCourse", urlPatterns = {"/AddNewCourse"})
public class AddNewCourse extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddLesson</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddLesson at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("views/Dangph/addCourses.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null && user.getRole().equals("Teacher")) {
            // Retrieve form data
            String courseID = request.getParameter("courseID");
            String courseName = request.getParameter("courseName");
            String topicID = request.getParameter("topicID");
            String description = request.getParameter("description");
            String priceStr = request.getParameter("price");
            String salePriceStr = request.getParameter("salePrice");
            String createdDateStr = request.getParameter("createdDate");
            String updatedDateStr = request.getParameter("updatedDate");
            String status = request.getParameter("status");
            String thumbnailStr = request.getParameter("thumbnail");

            CourseDAO dbCourse = new CourseDAO();
            dbCourse.addCourse(courseName, topicID, description, thumbnailStr, priceStr, salePriceStr,
                    status, courseID, createdDateStr, updatedDateStr, user.getUser_id());
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                // Convert necessary fields
                double price = Double.parseDouble(priceStr);
                double salePrice = (salePriceStr != null && !salePriceStr.isEmpty()) ? Double.parseDouble(salePriceStr) : 0.0;

                // Perform any necessary business logic (e.g., database operations)
                // For demonstration purposes, we will just print the received data
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Course Added</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Course Added Successfully</h1>");
                out.println("<p>Course ID: " + courseID + "</p>");
                out.println("<p>Course Name: " + courseName + "</p>");
                out.println("<p>Topic ID: " + topicID + "</p>");
                out.println("<p>Description: " + description + "</p>");
                out.println("<p>Price: " + price + "</p>");
                out.println("<p>Sale Price: " + salePrice + "</p>");
                out.println("<p>Created Date: " + createdDateStr + "</p>");
                out.println("<p>Updated Date: " + updatedDateStr + "</p>");
                out.println("<p>Status: " + status + "</p>");
                out.println("<a href='/Toad-Learning/mycourse'>Return to My Course</a>");
                out.println("</body>");
                out.println("<script>");
                out.println("alert('Add sucessfully!')");
                out.println("</script>");
                out.println("</html>");

            } catch (NumberFormatException e) {
                out.println("<html><body><h2>Error parsing number input</h2></body></html>");
                e.printStackTrace(out);
            } finally {
                out.close();
            }
        } else {
            response.sendRedirect("login");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
