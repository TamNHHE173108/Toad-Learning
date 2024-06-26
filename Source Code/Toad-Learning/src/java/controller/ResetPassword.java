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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        User user = userDAO.checkUserByEmail(email);
        if (user != null) {
            if (password != null && password.equals(confirmPassword)) {
                boolean isUpdated = userDAO.updatePassword(email, password);
                userDAO.updateOTP(email, "");
                if (isUpdated) {
                    request.setAttribute("message", "Password reset successfully");
                    request.getRequestDispatcher("views/Dangph/resetPassword.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "Failed to reset password");
                    request.getRequestDispatcher("views/Dangph/resetPassword.jsp").forward(request, response);

                }
            } else {
                request.setAttribute("error", "Passwords do not match");
                request.getRequestDispatcher("views/Dangph/resetPassword.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Please forget password again");
            request.getRequestDispatcher("views/Dangph/resetPassword.jsp").forward(request, response);
        }
    }
}
