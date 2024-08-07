<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <script type="text/javascript">
            
            function showSuccess(message) {
                alert(message);
            }
        </script>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="./img/logo/logo2.png" type="image/png">
        <title>Course - MyProfile</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.css" rel="stylesheet">

    </head>
    <body>
    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">
            <c:choose>
                <c:when test="${sessionScope.user.role == 'Admin'}">
                    <%@ include file="adminNavbarSidebar.jsp" %>
                </c:when>
                <c:when test="${sessionScope.user.role == 'Teacher'}">
                    <%@ include file="/views/Havt/HomePageForLectures/SideBar.jsp" %>
                </c:when>
                <c:when test="${sessionScope.user.role == 'Student'}">
                    <%@ include file="/views/Hoanglh/StudentNavbarSidebar.jsp" %>
                </c:when>
            </c:choose>
            <!-- Begin Page Content -->
            <div class="container-fluid">
                <h1 class="h3 mb-2 text-gray-800">My Profile</h1> 

                <!-- DataTales -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <div class="row gutters-sm">
                            <div class="col-md-4 mb-3">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-column align-items-center text-center">
                                            <img src="img/imgwhite.jpg" alt="Admin" class="rounded-circle" width="200">
                                            <div class="mt-3">
                                                <h4>${user.name}</h4>
                                                <p class="text-secondary mb-1">${user.role}</p>
                                                <p class="text-muted font-size-sm">${user.address}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="col-md-8">
                                <div class="card mb-3">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Full Name</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                ${user.name}
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Gender</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                ${user.gender}
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Email</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                ${user.email}
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Phone</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                ${user.mobile}
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Address</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                ${user.address}
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <a class="btn btn-info " href="editprofile">Edit</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- End of Content Wrapper -->
                            </div>
                            <c:if test="${not empty successMessage}">
                                <script type="text/javascript">
                                    showSuccess('${successMessage}');
                                    <c:remove var="successMessage" scope="session"/><!-- Clear message after displaying -->
                                </script>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file = "adminfooter.jsp" %>
    </div>
</div>
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<%@include  file ="Logout.jsp" %>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>
</body>
</html>
