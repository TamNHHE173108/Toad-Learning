<%-- 
    Document   : newjsp
    Created on : May 20, 2024, 10:27:07 AM
    Author     : My Lap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Course</title>
</head>
<body>
    <h1>Add Course</h1>
    <form action="/addCourse" method="post">
        <label for="courseName">Course Name:</label><br>
        <input type="text" id="courseName" name="courseName"><br>
        <label for="description">Description:</label><br>
        <textarea id="description" name="description"></textarea><br>
        <label for="category">Category:</label><br>
        <select id="category" name="category">
            <option value="SW">Software</option>
            <option value="AI">Artificial Intelligence</option>
            <option value="CS">Computer Science</option>
            <option value="IB">International Business</option>
        </select><br>
        <input type="submit" value="Add Course">
    </form>
</body>
</html>
