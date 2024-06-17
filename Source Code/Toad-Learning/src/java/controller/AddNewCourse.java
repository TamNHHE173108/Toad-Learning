/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AddCourseDAO;
import dao.CourseDAO;
import entity.Course;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 *
 * @author My Lap
 */
@WebServlet(name = "AddNewCourse", urlPatterns = {"/AddNewCourse"})
public class AddNewCourse extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Lấy dữ liệu từ form
        String courseID = request.getParameter("courseID");
        String courseName = request.getParameter("courseName");
        String description = request.getParameter("description");
        String topicID = request.getParameter("topicID");
        String createDate = request.getParameter("createdDate");
        String updateDate = request.getParameter("updatedDate");
        String thumbnail = ""; // Assuming you handle file upload separately
        String price = request.getParameter("price");
        String salePrice = request.getParameter("salePrice");
        String status = request.getParameter("status");
        AddCourseDAO c = new AddCourseDAO();
        try {
            Course a = c.getCourseByID(courseID);
            if (a == null) {
                c.addCourse(courseID, status, topicID, description, thumbnail, price, salePrice, LocalDateTime.MAX, LocalDateTime.MAX, status);
                response.sendRedirect("listcourse");
            } else {
                request.setAttribute("error", courseID + "exitsed");
            }
            
        } catch (NumberFormatException e) {
            System.out.println(e);
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
