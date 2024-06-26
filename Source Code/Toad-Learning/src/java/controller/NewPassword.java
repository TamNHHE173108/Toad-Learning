package controller;

import dao.UsersDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet(name = "NewPassword", urlPatterns = {"/newPassword"})
public class NewPassword extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        String email = (String) session.getAttribute("email");
        UsersDAO dbUser = new UsersDAO();
        if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
            dbUser.updatePassword(email, newPassword);
            response.sendRedirect("/Toad-Learning/Login");
        } else {
            request.setAttribute("status", "passwordMismatch");
            request.getRequestDispatcher("views/Dangph/newPassword.jsp").forward(request, response);
        }
    }

}
