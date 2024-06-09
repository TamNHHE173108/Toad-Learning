<%-- 
    Document   : login
    Created on : Jun 9, 2024, 12:51:49 PM
    Author     : My Lap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Cosmetic Store</title>
    <link rel="stylesheet" href="./css/main.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
          crossorigin="anonymous">
    <style>
        /* CSS for custom styling */
        header {
            background-color: #4caf50; /* Set background color for header to green */
            padding: 20px; /* Add padding to the header */
        }
        
        header img {
            width: 150px; /* Set width for the logo */
            height: auto; /* Ensure aspect ratio is maintained */
        }

        .login {
            padding: 50px; /* Add padding to the login section */
        }
    </style>
</head>
<body>

<header>
    <!-- Logo in the top left corner -->
    <img src="./img/logo/logo.png" alt="Cosmetic Store Logo">
</header>

<section class="login">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header text-dark">
                        Please Sign in
                    </div>
                    <p style="color:green">${requestScope.REGISTERMESSAGE}</p>
                    <div class="card-body">
                        <p id="ErrorTextMsg" class="errortxt">${requestScope.MESSAGE}</p>
                        <form action="LoginServlet" method="post">
                            <div class="form-group">
                                <div class="mb-3">
                                    <input type="text" name="userID" class="form-control" id="exampleInputEmail1"
                                           aria-describedby="emailHelp"
                                           placeholder="Username">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="mb-3">
                                    <input type="password" name="password" class="form-control"
                                           id="exampleInputPassword1"
                                           placeholder="Password">
                                </div>
                            </div>
                            <button style="width: 100%; background-color:#5CB85C" type="submit"
                                    class="btn btn-success">Login
                            </button>
                        </form>
                    </div>
                    <div class="card-footer text-dark">
                        If you don't have an account, please <a href="register.jsp">create an account </a>here
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
        integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"
        crossorigin="anonymous">
</script>
</body>
</html>

