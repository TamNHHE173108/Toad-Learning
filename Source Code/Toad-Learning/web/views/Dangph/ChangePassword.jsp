<%-- 
    Document   : ChangePassword
    Created on : Jun 23, 2024, 1:24:26 PM
    Author     : My Lap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-primary">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-6">
            <div class="card shadow-lg my-5">
                <div class="card-body p-0">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Change Password</h1>
                        </div>
                        <h3 style="color: red">${requestScope.mess}</h3>
                        <form class="user" action="ChangePassword" method="post">

                            </c:if>

                            <div class="form-group">
                                <input type="password" class="form-control form-control-user"
                                       id="oldPassword" name="oldPassword" placeholder="Enter Old Password" required>
                                <input type="hidden" name ="user" value="${sessionScope.User.username}">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control form-control-user"
                                       id="newPassword" name="newPassword" placeholder="Enter New Password" required>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control form-control-user"
                                       id="confirmPassword" name="confirmPassword" placeholder="Confirm New Password" required>
                            </div>
                            <input type="submit" value="Change Password" class="btn btn-primary btn-user btn-block">
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="homes">Home</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>       

</body>
</html>


