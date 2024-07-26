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
        <title>Course - EditCourse</title>

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
            <%@include file ="adminNavbarSidebar.jsp" %>
            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Edit Course</h1> 

                <!-- DataTales -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">        
                        <div id="editNewCourse">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="editcourse" method="post">
                                        <div class="modal-header">						
                                            <h4 class="modal-title">Edit Course</h4>
                                            <button onclick="window.location.href = 'listcourse'" type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label>Course_ID</label>
                                                <input value="${detailcourse.courseID}" name="courseID" type="text" class="form-control" readonly required>
                                            </div>
                                            <div class="form-group">
                                                <label for="thumbnail" >Thumbnail</label>                                         
                                                <img src="${detailcourse.thumbnail}" id="thumbnail-preview"class="img-thumbnail" style="max-width: 150px;">
                                                <input value="${detailcourse.thumbnail}" name="thumbnail" type="text" class="form-control" hidden>

                                            </div>
                                            <div class="form-group">
                                                <label>Title</label>
                                                <input value="${detailcourse.title}" name="title" type="text" class="form-control" required>
                                            </div>
                                            <label>Topip Name</label>
                                            <select name="topicID" class="form-select" aria-label="Default select example">                              
                                                <option value="IB" ${detailcourse.topicID.topicName == 'International Business' ? 'selected' : ''}>International Business</option>
                                                <option value="SE" ${detailcourse.topicID.topicName == 'Software Engineering' ? 'selected' : ''}>Software Engineering</option>
                                                <option value="CS" ${detailcourse.topicID.topicName == 'Computer Science' ? 'selected' : ''}>Computer Science</option>
                                                <option value="AI" ${detailcourse.topicID.topicName == 'Artificial Intelligence' ? 'selected' : ''}>Artificial Intelligence</option>
                                            </select>
                                            <div class="form-group">
                                                <label>	Description</label>
                                                <input value="${detailcourse.description}" name="description" type="text" class="form-control" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Price ($)</label>
                                                <input value="${detailcourse.price}" name="price" type="text" class="form-control" required>
                                            </div>
                                            <div class="form-group">
                                                <label>SalePrice ($)</label>
                                                <input value="${detailcourse.salePrice}" name="salePrice" type="text" class="form-control" required>
                                            </div>
                                            <div class="form-group">
                                                <input value="${detailcourse.updateDate}" name="updateDate" type="date" class="form-control" hidden>
                                            </div>
                                            <label>Status</label>
                                            <select name="status" class="form-select" aria-label="Default select example">                              
                                                <option value="Active" ${detailcourse.status == 'Active' ? 'selected' : ''}>Active</option>
                                                <option value="Inactive" ${detailcourse.status == 'Inactive' ? 'selected' : ''}>Inactive</option>
                                            </select>

                                        </div>
                                        <div class="modal-footer">        
                                            <input onclick="window.location.href = 'listcourse'" type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                            <input type="submit" class="btn btn-success" value="Edit">
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
                <%@include file = "adminfooter.jsp" %>

            </div>
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