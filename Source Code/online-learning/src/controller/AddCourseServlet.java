/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


package controller;

import dao.CategoryDAO;
import dao.CourseDAO;
import entity.Category;
import entity.Subject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> categoryList = categoryDAO.listCategories();
            req.setAttribute("categories", categoryList);
            req.getRequestDispatcher("addCourse.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String subjectId = req.getParameter("subjectId");
            String subjectName = req.getParameter("subjectName");
            String description = req.getParameter("description");
            String categoryId = req.getParameter("categoryId");

            Subject course = new Subject(subjectId, subjectName, description, categoryId);
            CourseDAO courseDAO = new CourseDAO();
            courseDAO.addCourse(course);
            resp.sendRedirect("listCourses");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
