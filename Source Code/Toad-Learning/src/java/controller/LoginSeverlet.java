/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UsersDAO;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author lehoa
 */
@WebServlet(name = "LoginSeverlet", urlPatterns = {"/Login"})
public class LoginSeverlet extends HttpServlet {

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
            out.println("<title>Servlet LoginSeverlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginSeverlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("/views/Hoanglh/Login.jsp").forward(request, response);
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
        // lay ra input email, password cua nguoi dung
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // dang nhap
        UsersDAO ud = new UsersDAO();
        User u = ud.Login(username, password);

        // neu tai khoan chua ton tai
        if (u == null) {
            request.setAttribute("mess", "Wrong email or password!");
            request.getRequestDispatcher("views/Hoanglh/Login.jsp").forward(request, response);
        } else if(u.getStatus().equals("InActive")){
            request.setAttribute("mess", "Tai khoan ngung hoat dong!");
            request.getRequestDispatcher("views/Hoanglh/Login.jsp").forward(request, response);
            
        } 
        
        else if (u.getRole().equals("Teacher")) { // neu tai khoan tont tai, tao session -> tra ve home (servlet)
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            response.sendRedirect("dashboardlectures");
        } else if (u.getRole().equals("Admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            response.sendRedirect("Dashboard");
        }
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
