<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Course - List Course</title>

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
            <%@include file ="SideBar.jsp" %>
            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">List Course</h1> 

                <!-- DataTales -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3"> 
                        <div class="box">
                            <div class="container-2">
                                <span class="icon"><i class="fa fa-search"></i></span>
                                <input type="search" id="search" style = "margin-bottom: 5px" placeholder="Search..." />
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addNewCourse"  class="btn btn-success" data-toggle="modal"><i class="material-icons"></i> <span>Add New Course</span></a>					
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>LessonID</th>
                                        <th>Title</th>
                                        <th>Content</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listP}" var="p">
                                        <tr>
                                            <td>${p.lessonID}</td>
                                            <td>${p.title}</td>
                                            <td>${p.content}</td>
                                            <td>${p.status}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>


                        </div>
                    </div>
                </div>
            </div>
            <div id="addNewCourse" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/Addcourses" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Add Course</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">	
                                <div class="form-group">
                                    <label>UserID</label>
                                    <input name="user_id" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Username</label>
                                    <input name="username" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input name="password" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>FullName</label>
                                    <input name="name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Gender</label>
                                    <select name="gender" class="form-select" aria-label="Default select example">                              
                                        <option value="Male">Male</option>
                                        <option value="Fermale">Fermale</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Role</label>
                                    <select name="role" class="form-select" aria-label="Default select example">                              
                                        <option value="Teacher">Teacher</option>
                                        <option value="Student">Student</option>
                                        <option value="Admin">Admin</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <textarea name="email" class="form-control" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Mobile</label>
                                    <textarea name="mobile" class="form-control" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <textarea name="address" class="form-control" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Status</label>
                                    <select name="status" class="form-select" aria-label="Default select example">                              
                                        <option value="Active">Active</option>
                                        <option value="Inactive">Inactive</option>
                                    </select>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Content Row -->
            <!-- End of Main Content -->

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