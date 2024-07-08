<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Lesson - My Lesson</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>


    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">
            <%@include file ="../SideBarStudent.jsp" %>
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
                                <div class="input-group">
                                    <input id="searchInput" name="txtC" type="text" class="form-control bg-light border-2 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" onkeyup="searchTable()">
                                    <a href="/Toad-Learning/homes" class="back-button btn btn-secondary">Return to Home</a>
                                    <div class="input-group-append"></div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>CourseID</th>
                                                <th>Thumbnail</th>
                                                <th>Title</th>
                                                <th>TopicName</th>
                                                <th>Description</th>

                                                <th>CreateDate</th>
                                                <th>UpdateDate</th>
                                                <th>Price</th>
                                                <th>SalePrice</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody id="courseTableBody">
                                            <c:forEach items="${historys}" var ="h">
                                                <tr> 
                                                    <td><a href="coursedetail?course_ID=${h.courseID.courseID}">${h.courseID.courseID}</a></td>
                                                    <td><img src="${h.courseID.thumbnail}" alt="Description of the image" width="100px"></td>
                                                    <td>${h.courseID.title}</td>
                                                    <td>${h.courseID.topicID.topicName}</td>
                                                    <td>${h.courseID.description}</td>

                                                    <td>${h.courseID.createDate}</td>
                                                    <td>${h.courseID.updateDate}</td>
                                                    <td>${h.courseID.price}$</td>
                                                    <td>${h.courseID.salePrice}$</td>
                                                    <td>${h.status}</td>
                                                    <td><a class="btn btn-primary" style="margin-bottom: 10px;" href="ListLesson?courseID=${h.courseID.courseID}">List Lesson</a>

                                                    </td>
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
                            <a class="btn btn-primary" href="Login">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

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

            <!-- Script for search functionality -->
            <script>
                                        function searchTable() {
                                            var input, filter, table, tr, td, i, txtValue;
                                            input = document.getElementById("searchInput");
                                            filter = input.value.toLowerCase();
                                            table = document.getElementById("dataTable");
                                            tr = table.getElementsByTagName("tr");

                                            for (i = 1; i < tr.length; i++) {
                                                tr[i].style.display = "none";
                                                td = tr[i].getElementsByTagName("td");
                                                for (var j = 0; j < td.length; j++) {
                                                    if (td[j]) {
                                                        txtValue = td[j].textContent || td[j].innerText;
                                                        if (txtValue.toLowerCase().indexOf(filter) > -1) {
                                                            tr[i].style.display = "";
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
            </script>
    </body>

</html>
