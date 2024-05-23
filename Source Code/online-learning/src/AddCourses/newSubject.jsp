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
    <title>New Subject</title>
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
            max-width: 600px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input[type="text"],
        input[type="file"],
        textarea,
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="checkbox"] {
            margin-right: 10px;
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
    <h1>New Subject</h1>
    <form id="newSubjectForm" action="/addSubject" method="post" enctype="multipart/form-data">
        <div class="error" id="error"></div>
        <label for="subjectName">Subject Name:</label>
        <input type="text" id="subjectName" name="subjectName">
        
        <label for="thumbnail">Thumbnail Image:</label>
        <input type="file" id="thumbnail" name="thumbnail">
        
        <label for="category">Category:</label>
        <select id="category" name="category">
            <option value="">Select Category</option>
            <option value="SW">Software</option>
            <option value="AI">Artificial Intelligence</option>
            <option value="CS">Computer Science</option>
            <option value="IB">International Business</option>
        </select>
        
        
        
        <label for="owner">Owner:</label>
        <input type="text" id="owner" name="owner">
        
        <label for="status">Status:</label>
        <select id="status" name="status">
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
        </select>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description"></textarea>
        
        <input type="submit" value="Add Subject">
    </form>

    <script>
        document.getElementById('newSubjectForm').addEventListener('submit', function(event) {
            let errorElement = document.getElementById('error');
            let subjectName = document.getElementById('subjectName').value.trim();
            let category = document.getElementById('category').value;
            let owner = document.getElementById('owner').value.trim();
            let status = document.getElementById('status').value;
            let description = document.getElementById('description').value.trim();

            if (subjectName === "" || category === "" || owner === "" || status === "" || description === "") {
                errorElement.textContent = "All fields except thumbnail and featured flag are required.";
                errorElement.style.display = "block";
                event.preventDefault();
            } else {
                errorElement.style.display = "none";
            }
        });
    </script>
</body>
</html>


