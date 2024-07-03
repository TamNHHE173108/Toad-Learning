/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.HomeForStudent;

import dao.HistoryDAO;
import entity.History;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author My Lap
 */
@WebServlet(name = "MyCourseStudentController", urlPatterns = {"/myCourseStudent"})
public class MyCourseStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getRole().equals("Student")) {
            HistoryDAO dbHistory = new HistoryDAO();
            ArrayList<History> historys = dbHistory.findAllHistoryByUserID(user.getUser_id());
            req.setAttribute("historys", historys);
            req.getRequestDispatcher("views/Dangph/HomePageForStudent/MyCourse.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
