<%-- 
    Document   : ForgotPasswaord
    Created on : Jun 19, 2024, 4:25:28 PM
    Author     : My Lap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body oncontextmenu='return false' class='snippet-body'>
    <div class="container padding-bottom-3x mb-2 mt-5">
        <div class="row justify-content-center">
            <div class="col-lg-8 col-md-10">
                <div class="forgot">
                    <h2>Forgot your password?</h2>
                    <p>Change your password in three easy steps. This will help you to secure your password!</p>
                    <ol class="list-unstyled">
                        <li><span class="text-primary text-medium">1. </span>Enter your email address below.</li>
                        <li><span class="text-primary text-medium">2. </span>Our system will send you an OTP to your email</li>
                        <li><span class="text-primary text-medium">3. </span>Enter the OTP on the next page</li>
                    </ol>
                </div>
                <form class="card mt-4" action="forgotPassword" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="email-for-pass">Enter your email address</label> 
                            <input class="form-control" type="text" name="email" id="email-for-pass" required="">
                            <small class="form-text text-muted">Enter the registered email address. Then we'll email an OTP to this address.</small>
                        </div>
                        <div class="form-group">
                            <c:if test="${not empty error}">
                                <div class="alert alert-danger">${error}</div>
                            </c:if>
                            <c:if test="${not empty message}">
                                <div class="alert alert-success">${message}</div>
                            </c:if>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button href='ValidateOtp' class="btn btn-success" type="submit">Get New Password</button>
                        <a href="Login" class="btn btn-danger">Back to Login</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
</body>
</html>
