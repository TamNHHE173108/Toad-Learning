/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.LessonDAO;
import entity.Lesson;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author lehoa
 */
@WebServlet(name = "ListLesson", urlPatterns = {"/ListLesson"})
public class ListLesson extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListLesson</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListLesson at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String stringcourseID = request.getParameter("courseID");
        HttpSession session = request.getSession();
        User a = (User)session.getAttribute("user");
                // Check if the user is null
        if (a == null) {
            // Redirect to login page or show an error message
            response.sendRedirect("Login"); // Assuming login.jsp is the login page
            return;
        }
         
        LessonDAO ls = new LessonDAO();

        List<Lesson> listP;

        listP = ls.getLessonByCourseID(stringcourseID);
        request.setAttribute("listP", listP);
        request.setAttribute("courseID", stringcourseID);
        String role = a.getRole();
        if(role.equals("Admin")){
             request.getRequestDispatcher("/views/Hoanglh/LessonListForAdmin.jsp").forward(request, response);
            
        } else if(role.equals("Teacher")){
             request.getRequestDispatcher("/views/Hoanglh/lessonList.jsp").forward(request, response);
            
        }else if(role.equals("Student")){
             request.getRequestDispatcher("/views/Dangph/lessonList.jsp").forward(request, response);
            
        }

       
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
