/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UsersDAO;
import entity.User;
import jakarta.servlet.RequestDispatcher;
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
 * @author My Lap
 */
@WebServlet(name = "ValidateOtp", urlPatterns = {"/ValidateOtp"})
public class ValidateOtp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersDAO dbUser = new UsersDAO();
        String value = request.getParameter("otp");
        String email = request.getParameter("email");
        User user = dbUser.checkUserByEmail(email);

        if (user != null) {
            if (user.getOtp().equals(value)) {
                request.setAttribute("email", email);
                request.getRequestDispatcher("views/Dangph/resetPassword.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Wrong OTP");
                request.setAttribute("email", email);
                request.getRequestDispatcher("views/Dangph/EnterOtp.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Please send forget password again");
            request.getRequestDispatcher("views/Dangph/EnterOtp.jsp").forward(request, response);
        }
    }

}
