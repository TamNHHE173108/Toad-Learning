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

/**
 *
 * @author My Lap
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/ChangePassword"})
public class ChangePassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/Dangph/ChangePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        UsersDAO dbUser = new UsersDAO();
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {

            if (oldPassword != null && newPassword != null && oldPassword.equals(user.getPassword())) {
                if (newPassword != null && confirmPassword != null && newPassword.equals(confirmPassword)) {
                    dbUser.updatePassword(user.getEmail(), newPassword);
                    request.setAttribute("mess", "Password changed successfully!");
                    request.getRequestDispatcher("/views/Dangph/ChangePassword.jsp").forward(request, response);
                } else {
                    request.setAttribute("mess", "Password confirmation does not match!");
                    request.getRequestDispatcher("/views/Dangph/ChangePassword.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("mess", "Your old does not match!");
                request.getRequestDispatcher("/views/Dangph/ChangePassword.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("mess", "Please login!");
            request.getRequestDispatcher("/views/Dangph/ChangePassword.jsp").forward(request, response);
        }
    }
}
