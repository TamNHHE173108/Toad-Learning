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
            <%@include file ="adminNavbarSidebar.jsp" %>
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
                                        <th>Price</th>
                                        <th>SalePrice</th>
                                        <th>Status</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listCourse}" var ="c">
                                        <tr> 
                                            <td>${c.courseID}</td>
                                            <td><img src="${c.thumbnail}" alt="Description of the image" width="100px"></td>
                                            <td>${c.title}</td>
                                            <td>${c.topicID.topicName}</td>
                                            <td>${c.description}</td>
                                            <td>${c.price}$</td>
                                            <td>${c.salePrice}$</td>
                                            <td>${c.status}</td>
                                            <td>
                                                <a href="loadcourse?course_ID=${c.courseID}"><i class="fas fa-edit" data-toggle="tooltip" title="Edit"></i></a>
                                            </td>
                                            <td>
                                                <a href=""><i class="fas fa-trash" data-toggle="tooltip" title="Delete"></i></a>
                                            </td>                                          
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>


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