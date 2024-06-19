<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="./img/logo/logo2.png" type="image/png">
        <title>Course - EditProfile</title>

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
            <%@include file ="adminNavbarSidebar.jsp" %>
            <!-- Begin Page Content -->
            <div class="container-fluid">
                <h1 class="h3 mb-2 text-gray-800">Edit Profile</h1> 

                <!-- DataTales -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <div class="row gutters-sm">
                            <div class="col-md-4 mb-3">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-column align-items-center text-center">
                                            <img src="img/admin.jpg" alt="Admin" class="rounded-circle" width="200">
                                            <div class="mt-3">
                                                <h4>${user.name}</h4>
                                                <p class="text-secondary mb-1">${user.role}</p>
                                                <p class="text-muted font-size-sm">${user.address}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <div class="col-lg-8">
                                <div class="card">
                                    <div class="card-body">
                                        <form action="editprofile" method="post">
                                            <div class="row mb-3">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Full Name</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <input value="${user.name}" name="name" type="text" class="form-control" >
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Email</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <input value="${user.email}" name="email" type="text" class="form-control" >
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Gender</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <select name="gender" class="form-select">                              
                                                        <option value="Male" ${user.gender == 'Male' ? 'selected' : ''}>Male</option>
                                                        <option value="Female" ${user.gender == 'Female' ? 'selected' : ''}>Female</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Mobile</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <input value="${user.mobile}" name="mobile" type="text" class="form-control" >
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Address</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <input value="${user.address}" name="address" type="text" class="form-control" >
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-3"></div>
                                                <div class="col-sm-9 text-secondary">
                                                    <input type="submit" class="btn btn-primary px-4" value="Save Changes">
                                                </div>
                                            </div>
                                            <input value="${user.role}" name="role" type="text" class="form-control" hidden>
                                            <input value="${user.status}" name="status" type="text" class="form-control" hidden>
                                        </form>
                                    </div>
                                </div>
                                <!-- End of Content Wrapper -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <%@include file = "adminfooter.jsp" %>

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
