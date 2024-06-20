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
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }

        .container {
            width: 100vw;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f2f2f2;
        }

        .form-container {
            width: 100%;
            max-width: 800px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            display: grid;
            grid-template-columns: 1fr 1fr;
            grid-gap: 10px;
        }

        label {
            align-self: center;
            color: #555;
        }

        input[type="text"],
        input[type="file"],
        textarea,
        input[type="number"],
        input[type="datetime-local"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .buttons {
            display: flex;
            justify-content: space-between;
            grid-column: span 2;
            margin-top: 20px;
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
            text-align: center;
        }

        input[type="submit"]:hover,
        .back-button:hover {
            background-color: #45a049;
        }

        .error, .success {
            margin-bottom: 20px;
            font-size: 16px;
            text-align: center;
            grid-column: span 2;
        }

        .error {
            color: red;
            display: none;
        }

        .success {
            color: green;
            display: none;
        }

        @media (max-width: 800px) {
            form {
                grid-template-columns: 1fr;
            }

            .buttons {
                flex-direction: column;
            }

            .buttons a,
            .buttons input {
                width: 100%;
                margin-bottom: 10px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h1>Add Courses</h1>
            <div class="success" id="success">Add new course successful</div>
            <div class="error" id="error">Please fill out all required fields.</div>
            <form id="newCourseForm" action="AddNewCourse" method="post">
                <label for="courseID">Course ID:</label>
                <input type="text" id="courseID" name="courseID" required>

                <label for="courseName">Course Name:</label>
                <input type="text" id="courseName" name="courseName" required>

                <label for="topicID">Topic ID:</label>
                <select id="topicID" name="topicID" class="form-control" required>
                    <option value="AI">AI - Artificial Intelligence</option>
                    <option value="IB">IB - International Business</option>
                    <option value="SE">SE - Software Engineering</option>
                    <option value="CS">CS - Computer Science</option>
                </select>

                <label for="description">Description:</label>
                <textarea id="description" name="description" rows="4" required></textarea>

                <label for="thumbnail">Thumbnail:</label>
                <input type="text" id="thumbnail" name="thumbnail" required>

                <label for="price">Price:</label>
                <input type="number" id="price" name="price" required>

                <label for="salePrice">Sale Price:</label>
                <input type="number" id="salePrice" name="salePrice">

                <label for="createdDate">Created Date:</label>
                <input type="date" id="createdDate" name="createdDate" required>

                <label for="updatedDate">Updated Date:</label>
                <input type="date" id="updatedDate" name="updatedDate" required>

                <label for="status">Status:</label>
                <select id="status" name="status" class="form-control" required>
                    <option value="Active">Active</option>
                    <option value="Inactive">Inactive</option>
                </select>

                <div class="buttons">
                    <input type="submit" value="Add Course" class="btn btn-primary">
                    <a href="/Toad-Learning/mycourse" class="back-button btn btn-secondary">Return to My Course</a>
                </div>
            </form>
        </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for all pages -->
    <script src="js/sb-admin-2.min.js"></script>

    <script>
//        document.getElementById('newCourseForm').addEventListener('submit', function(event) {
//            event.preventDefault();
//            var isValid = true;
//            var requiredFields = document.querySelectorAll('#newCourseForm [required]');
//            requiredFields.forEach(function(field) {
//                if (!field.value) {
//                    isValid = false;
//                }
//            });
//
//            if (isValid) {
//                document.getElementById('error').style.display = 'none';
//                document.getElementById('success').style.display = 'block';
//                // Uncomment the following line to submit the form after validation
//                // this.submit();
//            } else {
//                document.getElementById('success').style.display = 'none';
//                document.getElementById('error').style.display = 'block';
//            }
//        });
    </script>
</body>
</html>
