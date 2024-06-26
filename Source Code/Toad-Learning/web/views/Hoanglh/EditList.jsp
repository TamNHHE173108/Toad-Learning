<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Lesson - EditLesson</title>

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
                <h1 class="h3 mb-2 text-gray-800">Edit Lesson</h1> 

                <!-- DataTales -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">        
                        <div id="editNewCourse">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="EditLesson1" method="get">
    <div class="modal-header">						
        <h4 class="modal-title">Edit Lesson</h4>
        <button onclick="window.location.href = 'ListLesson?courseID=${detaillesson.courseID}'" type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    </div>
    <div class="modal-body">
        <div class="form-group">
            <label>LessonID</label>
            <input value="${detaillesson.lessonID}" name="lessonID" type="text" class="form-control" readonly>
        </div>
        <div class="form-group">
            <label>CourseID</label>
            <input value="${detaillesson.courseID}" name="courseID" type="text" class="form-control" readonly>
        </div>
        <div class="form-group">
            <label>Title</label>
            <input value="${detaillesson.title}" name="title" type="text" class="form-control">
        </div>
        <div class="form-group">
            <label>Content</label>
            <textarea name="content" class="form-control">${detaillesson.content}</textarea>
        </div>
        <div class="form-group">
            <label>Status</label>
            <select name="status" class="form-select" aria-label="Default select example">
                <option value="Active" ${detaillesson.status == 'Active' ? 'selected' : ''}>Active</option>
                <option value="Inactive" ${detaillesson.status == 'Inactive' ? 'selected' : ''}>Inactive</option>
            </select>
        </div>
    </div>
    <div class="modal-footer">
        <input onclick="window.location.href = 'ListLesson?courseID=${detaillesson.courseID}'" type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
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
                <!-- End of Page Wrapper -->

                <!-- Scroll to Top Button-->
               

                <!-- Bootstrap core JavaScript-->
                <script src="vendor/jquery/jquery.min.js"></script>
                <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


                <!-- Custom scripts for all pages-->
                <script src="js/sb-admin-2.min.js"></script>
                </body>

                </html>