/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AddUserDAO;
import dao.GetUserByID;
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
 * @author laptop lenovo
 */
@WebServlet(name = "AddUser", urlPatterns = {"/add"})
public class AddUser extends HttpServlet {

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
        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("user");
        if (a != null) {
            String username = request.getParameter("username");
            AddUserDAO dao = new AddUserDAO();
            if (!dao.doesUsernameExist(username)) {
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String gender = request.getParameter("gender");
                String role = request.getParameter("role");
                String email = request.getParameter("email");
                String mobile = request.getParameter("mobile");
                String address = request.getParameter("address");
                String status = request.getParameter("status");
                dao.insertUser(username, password, name, gender, email, mobile, role, status, address);
                session.setAttribute("successMessage", "User added successfully.");
                response.sendRedirect("listuser"); // Redirect to listuser page
            } else {
                // Handle the case where the username already exists
                session.setAttribute("errorMessage", "Username already exists. Please choose a different username.");
                response.sendRedirect("listuser");
            }
        } else {
            // Xử lý trường hợp không có đối tượng User trong session
            // Ví dụ: chuyển hướng hoặc hiển thị thông báo lỗi
            response.sendRedirect("Login"); // Ví dụ chuyển hướng đến trang đăng nhập
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
