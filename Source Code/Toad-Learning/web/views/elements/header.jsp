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
        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
            <a href="Home" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
                <img style="width:150px" src="img/logo/logo.png" alt="Toad Learning"/>
            </a>
            <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>


            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
                    Categories
                </button>
                <ul class="dropdown-menu p-3" aria-labelledby="dropdownMenu2">
                    <!-- AI Section -->
                    <h5 class="dropdown-header text-info">Artificial Intelligence (AI)</h5>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50 text-black-50">Academic Skills for University Success</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Create and Lead an Ethical Data-Driven Organization</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Ethics of Artificial Intelligence</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Python for Everybody</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Using Databases with Python</button></li>
                    <!-- CS Section -->
                    <h5 class="dropdown-header text-info">Computer Science (CS)</h5>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Academic Skills for University Success</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Computer Communications</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Python for Everybody</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Using Databases with Python</button></li>
                    <!-- IB Section -->
                    <h5 class="dropdown-header text-info">International Business (IB)</h5>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Academic Skills for University Success</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Human Resource Management</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Management Information Systems</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Social Media Marketing</button></li>
                    <!-- SE Section -->
                    <h5 class="dropdown-header text-info">Software Engineering (SE)</h5>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Academic Skills for University Success</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Software Development Lifecycle</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Using Databases with Python</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Using Python to Access Web Data</button></li>
                    <li><button class="dropdown-item btn btn-primary mb-2 text-black-50">Web Design</button></li>
                </ul>
            </div>

            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav col-lg-12">
                    <form class="d-flex col-lg-6 p-4 search-items" role="search">
                        <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                    <div class="d-flex col-lg-4 mx-auto align-items-center">
                        <a href="Home" class="nav-item nav-link active">Home</a>
                        <a href="about.html" class="nav-item nav-link">About</a>
                        <a href="courses.html" class="nav-item nav-link">Courses</a>
                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                    </div>
                    <div class="d-flex align-items-center">
                        <c:if test="${sessionScope.user == null}">
                            <div>
                                <button onclick="location.href = 'Login'" class="btn btn-outline-primary" type="button">Login</button>
                                <button onclick="location.href = 'Register'" class="btn btn-outline-success" type="button">Sign Up</button>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.user != null}">
                            <div>
                                <button onclick="location.href = 'logout'" class="btn btn-outline-primary" type="button">Logout</button>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </nav>
        <!-- Navbar End -->
    </body>
</html>
