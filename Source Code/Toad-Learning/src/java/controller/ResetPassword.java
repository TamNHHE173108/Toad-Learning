/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UsersDAO;
import entity.PasswordResetToken;
import entity.User;
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
@WebServlet(name = "ResetPassword", urlPatterns = {"/ResetPassword"})
public class ResetPassword extends HttpServlet {

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
            out.println("<title>Servlet ResetPassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPassword at " + request.getContextPath() + "</h1>");
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
    private UsersDAO userDAO;

    @Override
    public void init() {
        userDAO = new UsersDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = request.getParameter("token");
        if (token != null && !token.isEmpty()) {
            PasswordResetToken resetToken = userDAO.getResetToken(token);
            if (resetToken != null && !resetToken.isExpired()) {
                request.setAttribute("token", token);
                request.getRequestDispatcher("/reset-password.jsp").forward(request, response);
                return;
            }
        }
        response.sendRedirect("forgot-password.jsp?error=Invalid or expired token");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (password != null && password.equals(confirmPassword)) {
            PasswordResetToken resetToken = userDAO.getResetToken(token);
            if (resetToken != null && !resetToken.isExpired()) {
                boolean isUpdated = userDAO.updatePassword(resetToken.getEmail(), password);
                if (isUpdated) {
                    userDAO.clearResetToken(token);
                    request.setAttribute("message", "Password reset successfully");
                    request.getRequestDispatcher("Login").forward(request, response);
                } else {
                    request.setAttribute("error", "Failed to reset password");
                    request.getRequestDispatcher("ResetPassword").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Invalid or expired token");
                request.getRequestDispatcher("ResetPassword").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Passwords do not match");
            request.getRequestDispatcher("ResetPassword").forward(request, response);
        }
    }


    @Override
    public String getServletInfo() {
        return "Handles resetting password based on token";
    }
}
