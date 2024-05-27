<%-- 
    Document   : header
    Created on : May 23, 2024, 1:52:19 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Navbar Start -->
        <nav class=" navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
            <a href="Home" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
                <img style="width:  150px" src="img/logo/logo.png" alt="Toad Learning"/>
            </a>
            <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav col-lg-12">
                    <form class="d-flex col-lg-6 p-4 search-items" role="search">
                        <input  class="form-control " type="search" placeholder="Search" aria-label="Search">
                        <button  class="btn btn-outline-success  " type="submit">Search</button>
                    </form>
                    <div class="d-flex col-lg-4 mx-auto align-items-center">
                        <a href="Home" class="nav-item nav-link active">Home</a>
                        <a href="about.html" class="nav-item nav-link">About</a>
                        <a href="courses.html" class="nav-item nav-link">Courses</a>
                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                    </div>
                    <div class="d-flex align-items-center">
                        <button  class="btn btn-outline-primary  " type="submit">Login</button>
                        <button  class="btn btn-outline-success  " type="submit">Sign Up</button>
                    </div>
                </div>
            </div>
        </nav>
        <!-- Navbar End -->
    </body>
</html>
