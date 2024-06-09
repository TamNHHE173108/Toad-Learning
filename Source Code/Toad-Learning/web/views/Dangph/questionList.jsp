<%-- 
    Document   : questionList
    Created on : Jun 6, 2024, 11:06:36 AM
    Author     : My Lap
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions List</title>
</head>
<body>
    <h1>Questions List</h1>
    
    <form action="questionlist" method="GET">
        Subject: <input type="text" name="subject" value="${subject}"> 
        Lesson: <input type="text" name="lesson" value="${lesson}">
        <!-- Các trường lọc khác -->
        <input type="submit" value="Filter">
    </form>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Content</th>
            <th>Subject / Dimension / Lesson</th>
            <th>Level</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        
        <!-- Lặp qua danh sách câu hỏi và hiển thị thông tin -->
        <c:forEach items="${questions}" var="question">
            <tr>
                <td>${question.id}</td>
                <td>${question.content}</td>
                <td>${question.subject} / ${question.dimension} / ${question.lesson}</td>
                <td>${question.level}</td>
                <td>${question.status}</td>
                <td>
                    <a href="#">Show</a>
                    <a href="#">Hide</a>
                    <a href="#">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="question_import.jsp">Import Question</a>
</body>
</html>
