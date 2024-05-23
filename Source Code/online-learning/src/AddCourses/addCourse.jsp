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
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input[type="text"],
        textarea,
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error {
            color: red;
            margin-bottom: 20px;
            display: none;
        }
    </style>
</head>
<body>
    <h1>Add Course</h1>
    <form id="addCourseForm" action="/addCourse" method="post">
        <div class="error" id="error"></div>
        <label for="courseName">Course ID:</label><br>
        <input type="text" id="courseID" name="courseID"><br>
        <label for="courseName">Course Name:</label><br>
        <input type="text" id="courseName" name="courseName"><br>
        <label for="description">Description:</label><br>
        <textarea id="description" name="description"></textarea><br>
        <label for="category">Category:</label><br>
        <select id="category" name="category">
            <option value="">Select Category</option>
            <option value="SW">Software</option>
            <option value="AI">Artificial Intelligence</option>
            <option value="CS">Computer Science</option>
            <option value="IB">International Business</option>
        </select><br>
        <input type="submit" value="Add Course">
    </form>

    <script>
        document.getElementById('addCourseForm').addEventListener('submit', function(event) {
            let errorElement = document.getElementById('error');
            let courseName = document.getElementById('courseName').value.trim();
            let description = document.getElementById('description').value.trim();
            let category = document.getElementById('category').value;

            if (courseName === "" || description === "" || category === "") {
                errorElement.textContent = "All fields are required.";
                errorElement.style.display = "block";
                event.preventDefault();
            } else {
                errorElement.style.display = "none";
            }
        });
    </script>
</body>
</html>

