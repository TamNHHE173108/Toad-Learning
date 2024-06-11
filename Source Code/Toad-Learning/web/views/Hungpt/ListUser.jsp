<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Course - ListUser</title>

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
                <h1 class="h3 mb-2 text-gray-800">List User</h1> 

                <!-- DataTales -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3"> 
                        <div class="box">
                            <div class="container-2">
                                <div class="container">
                                    <div class="row align-items-center">
                                        <div class="col-md-6">
                                            <form action="search" method="post" class="form-inline">
                                                <div class="input-group">
                                                    <input value="${txtU}" name="txt" type="text" class="form-control bg-light border-2 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                                    <div class="input-group-append">
                                                        <button class="btn btn-primary" type="submit">
                                                            <i class="fas fa-search fa-sm"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>         
                                        <div class="col-md-6 text-right">
                                            <a href="#addNewUser" class="btn btn-success" data-toggle="modal"><i class="material-icons"></i> <span>Add New User</span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>                
                                        <th>
                                            <div class="form-control border-0 font-weight-bold">
                                                FullName
                                            </div>
                                        </th>
                                        <th>
                                            <form id="filterForm" action="searchgender" method="post" class="form-inline">
                                                <div class="form-group">
                                                    <select name="gender" id="gender" class="form-control border-0 font-weight-bold" onchange="this.form.submit()">
                                                        <option value="All">Gender</option>
                                                        <option value="Male" ${txtG == 'Male' ? 'selected' : ''}>Male</option>
                                                        <option value="Female" ${txtG == 'Female' ? 'selected' : ''}>Female</option>
                                                    </select>
                                                </div>
                                            </form>
                                        </th>
                                        <th> 
                                            <form id="filterForm" action="searchrole" method="post" class="form-inline">
                                                <div class="form-group">
                                                    <select name="role" id="role" class="form-control border-0 font-weight-bold" onchange="this.form.submit()">
                                                        <option value="All">Role</option>
                                                        <option value="Teacher" ${txtR == 'Teacher' ? 'selected' : ''}>Teacher</option>
                                                        <option value="Student" ${txtR == 'Student' ? 'selected' : ''}>Student</option>
                                                        <option value="Admin" ${txtR == 'Admin' ? 'selected' : ''}>Admin</option>
                                                    </select>
                                                </div>
                                            </form>
                                        </th>
                                        <th>
                                            <div class="form-control border-0 font-weight-bold">
                                                Email
                                            </div>
                                        </th>
                                        <th>
                                            <div class="form-control border-0 font-weight-bold">
                                                Mobile
                                            </div>
                                        </th>
                                        <th>
                                            <div class="form-control border-0 font-weight-bold">
                                                Address
                                            </div>
                                        </th>
                                        <th>
                                            <form id="filterForm" action="searchstatus" method="post" class="form-inline">
                                                <div class="form-group">
                                                    <select name="status" id="status" class="form-control border-0 font-weight-bold" onchange="this.form.submit()">
                                                        <option value="All">Status</option>
                                                        <option value="Active" ${txtS == 'Active' ? 'selected' : ''}>Active</option>
                                                        <option value="Inactive" ${txtS == 'Inactive' ? 'selected' : ''}>Inactive</option>
                                                    </select>
                                                </div>
                                            </form>
                                        </th>
                                        <th>
                                            <div class="form-control border-0 font-weight-bold">
                                                Edit
                                            </div>
                                        </th>
                                        <th>
                                            <div class="form-control border-0 font-weight-bold">
                                                Delete
                                            </div>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listU}" var ="o">
                                        <tr> 
                                            <td>${o.name}</td>
                                            <td>${o.gender}</td>
                                            <td>${o.role}</td>
                                            <td>${o.email}</td>
                                            <td>${o.mobile}</td>
                                            <td>${o.address}</td>
                                            <td>${o.status}</td>
                                            <td>
                                                <a href="load?uid=${o.user_id}""><i class="fas fa-edit" data-toggle="tooltip" title="Edit"></i></a>
                                            </td>
                                            <td>
                                                <a href="delete?uid=${o.user_id}" onclick="return confirm('Are you sure you want to delete ${o.name}');">
                                                    <i class="fas fa-trash" data-toggle="tooltip" title="Delete"></i>
                                                </a>
                                            </td>                                         
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
            <div id="addNewUser" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="add" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Add User</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">	
                                <div class="form-group">
                                    <label>Username</label>
                                    <input name="username" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input name="password" type="password" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>FullName</label>
                                    <input name="name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Gender</label>
                                    <select name="gender" class="form-select" aria-label="Default select example">                              
                                        <option value="Male">Male</option>
                                        <option value="Female">Female</option>
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
                                    <input name="email" class="form-control" type="email" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"required>
                                </div>
                                <div class="form-group">
                                    <label>Mobile</label>
                                    <input name="mobile" class="form-control" type="tel" pattern="[0-9]{10,11}"required>
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

            <%@include file = "adminfooter.jsp" %>

        </div>
        <!-- End of Content Wrapper -->
    </div>
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