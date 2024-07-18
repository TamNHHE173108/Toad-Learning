///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package controller;
//
//import dao.UsersDAO;
//import entity.User;
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import utils.EmailUtils;
//
///**
// *
// * @author My Lap
// */
//@WebServlet(name = "ForgetPassword", urlPatterns = {"/ForgetPassword"})
//public class ForgetPassword extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.getRequestDispatcher("/views/Dangph/ForgetPassword.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        UsersDAO dbUser = new UsersDAO();
//
//        String email = request.getParameter("email");
//        User user = dbUser.checkUserByEmail(email);
//        if (user == null) {
//            request.setAttribute("error", "Your email is not found");
//            request.getRequestDispatcher("/views/Dangph/ForgetPassword.jsp").forward(request, response);
//        } else {
//            String otp = EmailUtils.generateOTP();
//            EmailUtils.sendEmail(email, EmailUtils.SUBJECT, "Your verifitication code is " + otp);
//            dbUser.updateOTP(email, otp);
//            request.setAttribute("email", email);
//            request.getRequestDispatcher("/views/Dangph/EnterOTP.jsp").forward(request, response);
//        }
//    }
//
//}
