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
import java.util.List;

/**
 *
 * @author lehoa
 */
@WebServlet(name="RegisterServlet", urlPatterns={"/Register"})
public class RegisterServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet RegisterServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         request.getRequestDispatcher("/views/Hoanglh/newAccount.jsp").forward(request, response);
        
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      String  username,  password, name, gender,
             email, mobile,role, address;

        // lay ra thong tin nguoi dung input o form signup
        username = request.getParameter("username");
        password = request.getParameter("password");
        name = request.getParameter("fullname");
        gender = request.getParameter("gender");
        role = request.getParameter("role");
        email = request.getParameter("email");
        mobile = request.getParameter("phone");
        address = request.getParameter("address");

        // lay ra tat ca nhung tai khoan da ton tai trong he thong
        UsersDAO ud = new UsersDAO();
        List<User> listU = ud.getAllUser();


        if (checkUserExist(username, listU)) {
            request.setAttribute("mess", "Username already exists");
            request.getRequestDispatcher("views/Hoanglh/newAccount.jsp").forward(request, response);
        }else {
            // neu khong co van de gì -> dang ky tai khoan thành công

            ud.Register(username, password, name, gender, email, mobile, role, email, address);
            response.sendRedirect("Home");

//            ud.Register(username, pass);
            

        }
    }
     public static boolean checkUserExist(String username, List<User> listU) {
        for (User u : listU) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
