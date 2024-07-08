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
        <title>Course - List Course</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.css" rel="stylesheet">

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
                                <div class="row">
                                    <div class="col-md-4">
                                        <form action="searchcourse" method="post" class="form-inline">
                                            <div class="input-group">
                                                <input value="${txtC}" name="txtC" type="text" class="form-control bg-light border-2 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                                <div class="input-group-append">
                                                    <button class="btn btn-primary" type="submit">
                                                        <i class="fas fa-search fa-sm"></i>
                                                    </button>
                                                </div>
                                            </div>
                                            <div class="col-md-6 text-right">
                                                <a href="#addNewCourse" class="btn btn-success" data-toggle="modal"><i class="material-icons"></i> <span>Add New Course</span></a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="200%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>
                                            <div class="form-control border-0 font-weight-bold">
                                                User Name
                                            </div>
                                        </th>
                                        <th><div class="form-control border-0 font-weight-bold">course ID</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Total Cost</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Status</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Valid From</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Valid To</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Update By</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Registration Time</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Score ID</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Score</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Quiz Status</div></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listR}" var ="c">
                                        <tr> 
                                            <td>${c.userID.username}</td>
                                            <td>${c.courseID}</td>
                                            <td>${c.totalCost}</td>
                                            <td>${c.status}</td>
                                            <td>${c.validFrom}</td>
                                            <td>${c.validTO}</td>
                                            <td>${c.updateBy}</td>
                                            <td>${c.registrationTime}</td>
                                            <td>${c.scoreID}</td>
                                            <td>${c.score}</td>
                                            <td>${c.quizStatus}</td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>

                    </div>
                </div>            
            </div>


        </div>
        <!-- End of Content Wrapper -->
        <!-- End of Page Wrapper -->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>
        <!-- Scroll to Top Button-->
        <%@include  file ="Logout.jsp" %>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>



    </body>

</html>