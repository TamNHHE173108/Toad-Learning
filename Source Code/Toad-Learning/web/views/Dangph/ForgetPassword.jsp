<%-- 
    Document   : ForgotPassword
    Created on : Jun 18, 2024, 9:37:00 PM
    Author     : My Lap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forget Password</title>
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
                            <h1 class="h4 text-gray-900 mb-4">Forgot Your Password?</h1>
                        </div>
                        <form class="user" action="ForgetPassword" method="post">
                            <%-- Display message or error --%>
                            <c:if test="${not empty requestScope.message}">
                                <div class="alert alert-success" role="alert">
                                    ${requestScope.message}
                                </div>
                            </c:if>
                            <c:if test="${not empty requestScope.error}">
                                <div class="alert alert-danger" role="alert">
                                    ${requestScope.error}
                                </div>
                            </c:if>

                            <div class="form-group">
                                <input type="email" class="form-control form-control-user"
                                       id="email" name="email" placeholder="Enter Email Address" required>
                            </div>
                            <input type="submit" value="Reset Password" class="btn btn-primary btn-user btn-block">
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="Login">Back to Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>       

</body>
</html>

