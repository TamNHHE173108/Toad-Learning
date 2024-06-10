<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Course - EditUser</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>


    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">
            <%@include file ="adminNavbarSidebar.jsp" %>
            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Edit User</h1> 

                <!-- DataTales -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">        
                        <div id="editNewUser">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="edit" method="post">
                                        <div class="modal-header">						
                                            <h4 class="modal-title">Edit User</h4>
                                            <button onclick="window.location.href = 'listuser'" type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label>User_ID</label>
                                                <input value="${detail.user_id}" name="user_id" type="text" class="form-control" readonly required>
                                            </div>
                                            <div class="form-group">
                                                <label>Username</label>
                                                <input value="${detail.username}" name="username" type="text" class="form-control" >
                                            </div>
                                            <div class="form-group">
                                                <label>Password</label>
                                                <input value="${detail.password}" name="password" type="text" class="form-control" >
                                            </div>
                                            <div class="form-group">
                                                <label>Name</label>
                                                <input value="${detail.name}" name="name" type="text" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label>Gender</label>
                                                <select name="gender" class="form-select">                              
                                                    <option value="Male" ${detail.gender == 'Male' ? 'selected' : ''}>Male</option>
                                                    <option value="Fermale" ${detail.gender == 'Fermale' ? 'selected' : ''}>Fermale</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>Role</label>
                                                <select name="role" class="form-select">                              
                                                    <option value="Teacher" ${detail.role == 'Teacher' ? 'selected' : ''}>Teacher</option>
                                                    <option value="Student" ${detail.role == 'Student' ? 'selected' : ''}>Student</option>
                                                    <option value="Admin" ${detail.role == 'Admin' ? 'selected' : ''}>Admin</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input value="${detail.email}" name="email" type="email" class="form-control" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" >
                                            </div>
                                            <div class="form-group">
                                                <label>Mobile</label>
                                               <input value="${detail.mobile}" name="mobile" class="form-control" type="tel" pattern="[0-9]{10,11}"required>
                                            </div>
                                            <div class="form-group">
                                                <label>Address</label>
                                                <textarea  name="address" class="form-control" required>${detail.address}</textarea>
                                            </div>
                                            <div class="form-group">
                                                <label>Status</label>
                                                <select name="status" class="form-select" aria-label="Default select example">                              
                                                    <option value="Active" ${detail.status == 'Active' ? 'selected' : ''}>Active</option>
                                                    <option value="Inactive" ${detail.status == 'Inactive' ? 'selected' : ''}>Inactive</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">        
                                            <input onclick="window.location.href = 'listuser'" type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                            <input type="submit" class="btn btn-success" value="Edit">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- Content Row -->
                        <!-- End of Main Content -->

                        <%@include file = "adminfooter.jsp" %>

                    </div>
                    <!-- End of Content Wrapper -->
                </div>
                <!-- End of Page Wrapper -->

                <!-- Scroll to Top Button-->
                <a class="scroll-to-top rounded" href="#page-top">
                    <i class="fas fa-angle-up"></i>
                </a>

                <!-- Logout Modal-->
                <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                            <div class="modal-footer">
                                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                <a class="btn btn-primary" href="login.html">Logout</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Bootstrap core JavaScript-->
                <script src="vendor/jquery/jquery.min.js"></script>
                <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


                <!-- Custom scripts for all pages-->
                <script src="js/sb-admin-2.min.js"></script>
                </body>

                </html>