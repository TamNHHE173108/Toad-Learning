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
<<<<<<< HEAD
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
=======

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
//                Topic topic = courseDAO.getTopicByID(topicID); // Implement this method in DAO
//
//                // Create a new Course object and set its properties
//                Course newCourse = new Course(courseID, courseName, description, thumbnail, String.valueOf(price), String.valueOf(salePrice), createdDate.toString(), updatedDate.toString(), status);
//                newCourse.setTopicID(topic); // Set the retrieved Topic object
//
//                courseDAO.addCourse(newCourse); // Pass the Course object to the DAO

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
>>>>>>> 4c04bc2156f5d53855bbcadf9d9396b16666e12d
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
