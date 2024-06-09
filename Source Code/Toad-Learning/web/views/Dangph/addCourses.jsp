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
            select,
            input[type="number"],
            input[type="datetime-local"] {
                width: 100%;
                padding: 10px;
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
                font-size: 16px;
                text-align: center;
            }

<<<<<<< HEAD
            .success {
                color: green;
                margin-bottom: 20px;
                display: none;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <h1>Add Courses</h1>
            <div class="success" id="success">Add new course successful</div>
            <form id="newCourseForm" action="/Addcourses" method="post" enctype="multipart/form-data">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title">

                <label for="topicID">Topic ID:</label>
                <select id="topicID" name="topicID">
                    <option value="AI">AI - Artificial Intelligence</option>
                    <option value="IB">IB - International Business</option>
                    <option value="SE">SE - Software Engineering</option>
                    <option value="CS">CS - Computer Science</option>
                </select>
=======
        .success {
            color: green;
            margin-bottom: 20px;
            display: none;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <h1>Add Courses</h1>
        <div class="success" id="success">Add new course successful</div>
        <form id="newCourseForm" action="/Addcourses" method="post" enctype="multipart/form-data">
            <label for="title">CourseID</label>
            <input type="text" id="courseID" name="courseID">
            
            <label for="title">Title:</label>
            <input type="text" id="courseName" name="courseName">

            <label for="topicID">Topic ID:</label>
            <input type="text" id="category" name="category">
>>>>>>> f14fc94b9e965d2b4e57eb5048c95e1ebc3a8c2c

                <label for="description">Description:</label>
                <textarea id="description" name="description"></textarea>

                <label for="thumbnail">Thumbnail:</label>
                <input type="file" id="thumbnail" name="thumbnail" accept="image/*">

                <label for="price">Price:</label>
                <input type="number" id="price" name="price">

                <label for="salePrice">Sale Price:</label>
                <input type="number" id="salePrice" name="salePrice">

                <label for="createdDate">Created Date:</label>
                <input type="datetime-local" id="createdDate" name="createdDate">

                <label for="updatedDate">Updated Date:</label>
                <input type="datetime-local" id="updatedDate" name="updatedDate">

                <label for="status">Status:</label>
                <input type="text" id="status" name="status">

                <div class="buttons">
                    <input type="submit" value="Add Course">
                    <a href="/Toad-Learning/Dashboard" class="back-button">Return to Dash Board</a>
                </div>
            </form>
        </div>
    </body>
</html>