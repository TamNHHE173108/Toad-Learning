<%-- 
    Document   : newjsp
    Created on : May 20, 2024, 10:27:07 AM
    Author     : My Lap
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Courses</title>
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
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

        .buttons {
            display: flex;
            justify-content: space-between;
        }

        input[type="submit"],
        .back-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            text-align: center;
        }

        input[type="submit"]:hover,
        .back-button:hover {
            background-color: #45a049;
        }

        .error {
            color: red;
            margin-bottom: 20px;
            display: none;
        }

        .success {
            color: green;
            margin-bottom: 20px;
            display: none;
            text-align: center;
        }
    </style>
</head>
<body>
    <!-- Begin Page Content -->
    <div class="container-fluid">
        <h1>Add Courses</h1>
        <div class="success" id="success">Add new courses successful</div>
        <form id="newCourseForm" action="/addCourse" method="post" enctype="multipart/form-data">
            <div class="error" id="error"></div>
            <label for="courseName">Course Name:</label>
            <input type="text" id="courseName" name="courseName">
            
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
            
            <label for="featured">Featured:</label>
            <input type="checkbox" id="featured" name="featured">
            
            <label for="owner">Owner:</label>
            <input type="text" id="owner" name="owner">
            
            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="Active">Active</option>
                <option value="Inactive">Inactive</option>
            </select>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description"></textarea>
            
            <div class="buttons">
                <a href="/Toad-Learning/Dashboard" class="back-button">Back</a>
                <input type="submit" value="Add Course">
            </div>
        </form>
    </div>
    <!-- End of Main Content -->

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <script>
        document.getElementById('newCourseForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission

            let errorElement = document.getElementById('error');
            let successElement = document.getElementById('success');
            let courseName = document.getElementById('courseName').value.trim();
            let category = document.getElementById('category').value;
            let owner = document.getElementById('owner').value.trim();
            let status = document.getElementById('status').value;
            let description = document.getElementById('description').value.trim();

            if (courseName === "" || category === "" || owner === "" || status === "" || description === "") {
                errorElement.textContent = "All fields except thumbnail and featured flag are required.";
                errorElement.style.display = "block";
                successElement.style.display = "none";
            } else {
                errorElement.style.display = "none";

                // Simulate a successful form submission (replace with actual AJAX call if needed)
                setTimeout(function() {
                    document.getElementById('newCourseForm').reset();
                    successElement.style.display = "block";
                }, 500);
            }
        });
    </script>

</body>
</html>
