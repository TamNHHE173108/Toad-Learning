/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.HomeForStudent;

import dao.CourseDAO;
import dao.TopicDAO;
import entity.Course;
import entity.Topic;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author My Lap
 */
@WebServlet(name = "HomeStudent", urlPatterns = {"/homes"})
public class HomeStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO dbCourse = new CourseDAO();
        TopicDAO dbTopic = new TopicDAO();
        List<Course> courses = dbCourse.listTop5Courses();
        List<Topic> topics = dbTopic.findTop4();
        request.setAttribute("topics", topics);
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("views/Dangph//HomePageForStudent/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
