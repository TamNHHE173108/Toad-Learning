<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Categories</title>
    </head>
    <body>
        <h1>Course Categories</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Topic ID</th>
                    <th>Category Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="topic" items="${listC}">
                    <tr>
                        <td>${topic.topicName}</td>
                       
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
