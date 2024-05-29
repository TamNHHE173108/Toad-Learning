<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lesson List</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .action-buttons button {
                margin-right: 5px;
            }
            .table th, .table td {
                vertical-align: middle;
            }
            .page-header {
                margin-bottom: 30px;
            }
        </style>
    </head>
    <body>
        <%-- Include header --%>
        <jsp:include page="../elements/header.jsp" flush="true" ></jsp:include>

            <div class="container mt-5">
                <div class="page-header">
                    <h1>Lesson List for Selected Package</h1>
                    <p class="lead">Manage lessons by activating/deactivating or editing details.</p>
                    <button class="btn btn-success" onclick="addLesson()">Add New Lesson</button>
                </div>
                <table class="table table-striped table-hover mt-3">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Lesson Name</th>
                            <th>Content</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%-- Your lesson list content goes here --%>
                </tbody>
            </table>
        </div>

        <script>
            function editLesson(lessonName) {
                alert('Edit Lesson: ' + lessonName);
                // Redirect to lesson details page for editing
                window.location.href = 'lessonDetails.jsp?lesson=' + encodeURIComponent(lessonName);
            }

            function addLesson() {
                alert('Add New Lesson');
                // Redirect to lesson details page for adding a new lesson
                  window.location.href = '/Toad-Learning/views/Hoanglh/lessonDetails.jsp';
            }
            function toggleStatus(lessonId) {
                var statusCell = document.getElementById('status-' + lessonId);
                if (statusCell.innerText === 'Active') {
                    statusCell.innerHTML = '<span class="badge badge-secondary">Inactive</span>';
                    alert('Lesson Deactivated');
                } else {
                    statusCell.innerHTML = '<span class="badge badge-success">Active</span>';
                    alert('Lesson Activated');
                }
            }


        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
