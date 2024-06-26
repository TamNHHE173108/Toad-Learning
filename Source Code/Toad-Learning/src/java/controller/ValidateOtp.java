/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("otp");
        HttpSession session = request.getSession();
        String otp = (String) session.getAttribute("otp");

        RequestDispatcher dispatcher = null;

        if (value.equals(otp)) {
            request.setAttribute("status", "success");
            dispatcher = request.getRequestDispatcher("views/Dangph/newPassword.jsp");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("message", "wrong otp");

            dispatcher = request.getRequestDispatcher("views/Dangph/EnterOtp.jsp");
            dispatcher.forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
