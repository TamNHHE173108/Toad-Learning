/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CourseDAO;
import dao.GetUserByID;
import dao.SearchCourseDAO;
import entity.Course;
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
 * @author laptop lenovo
 */
@WebServlet(name = "SearchCourseByTopic", urlPatterns = {"/searchtopic"})
public class SearchCourseByTopic extends HttpServlet {

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
            String id = a.getUser_id();
            String topicName = request.getParameter("topicname");
            List<Course> listC;
            SearchCourseDAO dao = new SearchCourseDAO();
            CourseDAO dal = new CourseDAO();
            if(a.getRole().equals("Admin")){
                if ("All".equals(topicName)) {
                listC = dal.listCourses(); // Implement a method to fetch all users
            } else {

                listC = dao.searchCourseByTopic(topicName); // 
            }
            request.setAttribute("listCourse", listC);
            request.setAttribute("txtTo", topicName);
            request.getRequestDispatcher("/views/Hungpt/ListCourse.jsp").forward(request, response);
            } else if(a.getRole().equals("Teacher")){
                if ("All".equals(topicName)) {
                listC = dal.listCourses(); // Implement a method to fetch all users
            } else {

                listC = dao.searchCourseByTopic(topicName); // 
            }
            request.setAttribute("listC", listC);
            request.setAttribute("txtTo", topicName);
            request.getRequestDispatcher("/views/Havt/HomePageForLectures/MyCourse.jsp").forward(request, response);
            }
            else if(a.getRole().equals("Student")){
                if ("All".equals(topicName)) {
                listC = dal.getCourseByUserID(id); // Implement a method to fetch all users
            } else {

                listC = dao.searchCourseStudentByTopic(topicName,id); // 
            }
            request.setAttribute("listC", listC);
            request.setAttribute("txtTo", topicName);
            request.getRequestDispatcher("/views/Hoanglh/CourseStudent.jsp").forward(request, response);
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
