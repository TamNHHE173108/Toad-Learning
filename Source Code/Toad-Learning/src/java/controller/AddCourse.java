/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;



import dao.AddCourseDAO;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddCourse", urlPatterns = {"/Addcourses"})
public class AddCourse extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String courseID = request.getParameter("courseID");
        String courseName = request.getParameter("courseName");
        String description = request.getParameter("description");
        String category = request.getParameter("topicID");
        String createDate = request.getParameter("createdDate");
        String updateDate = request.getParameter("updatedDate");
        String thumbnail = ""; // Assuming you handle file upload separately
        String price = request.getParameter("price");
        String salePrice = request.getParameter("salePrice");
        String status = request.getParameter("status");

        try {
            // Format the dates appropriately
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime createdDateTime = LocalDateTime.parse(createDate, formatter);
            LocalDateTime updatedDateTime = LocalDateTime.parse(updateDate, formatter);

            // Call DAO to add course to database
            AddCourseDAO courseDAO = new AddCourseDAO();
            courseDAO.addCourse(courseID, courseName, category, description, thumbnail,
                    price, salePrice, createdDateTime, updatedDateTime, status);

            // Redirect to a success page or send JSON response
            response.sendRedirect("listcourse"); // Assuming listcourse is a servlet or JSP to display list of courses
        } catch (IOException ex) {
// Handle exceptions appropriately
                        response.sendRedirect("errorpage.html"); // Redirect to an error page
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/Dangph/addCourses.jsp").forward(request, response);
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