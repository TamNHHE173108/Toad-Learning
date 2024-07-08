<!-- course-register.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Registration</title>
    <script>
        function filterCourses() {
            var selectedCategory = document.getElementById("category").value;
            var courses = document.getElementsByClassName("course-option");

            for (var i = 0; i < courses.length; i++) {
                if (courses[i].dataset.categoryId === selectedCategory) {
                    courses[i].style.display = "block";
                } else {
                    courses[i].style.display = "none";
                }
            }

            // Trigger change event to update price
            document.getElementById("courseId").dispatchEvent(new Event('change'));
        }

        function updatePrice() {
            var selectedCourse = document.getElementById("courseId");
            var selectedOption = selectedCourse.options[selectedCourse.selectedIndex];
            var price = selectedOption.dataset.price;
            document.getElementById("coursePrice").innerText = "Price: $" + price;
        }
    </script>
</head>
<body>
    <h2>Course Registration</h2>
    <form action="course-register" method="post">
        <label for="category">Choose Category:</label>
        <select name="category" id="category" onchange="filterCourses()">
            <c:forEach var="category" items="${listCategories}">
                <option value="${category.categoryID}">${category.name} - ${category.description}</option>
            </c:forEach>
        </select><br>

        <label for="courseId">Choose Course:</label>
        <select name="courseId" id="courseId" onchange="updatePrice()">
            <c:forEach var="course" items="${listCourses}">
                <option class="course-option" value="${course.courseId}" data-category-id="${course.topicID}" data-price="${course.salePrice}">
                    ${course.title}
                </option>
            </c:forEach>
        </select><br>

        <p id="coursePrice">Price: </p>

        <c:if test="${empty loggedInUser}">
            <label for="fullName">Full Name:</label>
            <input type="text" name="fullName" id="fullName" required><br>

            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required><br>

            <label for="mobile">Mobile:</label>
            <input type="text" name="mobile" id="mobile" required><br>

            <label for="gender">Gender:</label>
            <select name="gender" id="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select><br>
        </c:if>

        <button type="submit">Register</button>
    </form>
</body>
</html>
