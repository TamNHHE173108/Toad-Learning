<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Register</title>

        <!-- Custom fonts for this template-->
        <link href="css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body class="bg-gradient-primary">
        <input type="hidden" id="mess" value=" <%= request.getAttribute("mess") %> ">

        <div class="container">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <img class="col-lg-5 d-none d-lg-block bg-register-image" src="img/haandhai.jpg " alt="alt"/>
                        <div class="col-lg-7">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>

                                </div>
                                <p style="color: red">${mess}</p>
                                <form action="Register" method="post" class="user">
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="text" class="form-control form-control-user" id="exampleFirstName"
                                                   placeholder="User Name" name="username" required>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="Password" class="form-control form-control-user" id="exampleLastName"
                                                   placeholder="Password" name="password" required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="text" class="form-control form-control-user"
                                                   id="exampleInputPassword" name="fullname" placeholder="Fullname" required>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control form-control-user"
                                                   id="exampleRepeatPassword" name="address" placeholder="Address" required>
                                        </div>
                                    </div>
                                    <div class="form-group row text-right">
                                        <div class="row">
                                            <div class="col-sm-8 mb-3 mb-sm-0">
                                                <div class="form-group">
                                                    <label for="genderSelect1">Gender</label>
                                                    <select name="gender" id="genderSelect1" class="form-select">
                                                        <option value="Male">Male</option>
                                                        <option value="Female">Female</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group d-flex align-items-center">
                                                    <label for="genderSelect2" class="mr-2">Role</label>
                                                    <select name="role" id="genderSelect2" class="form-select">
                                                        <option value="Teacher">Teacher</option>
                                                        <option value="Student">Student</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>






                                    </div>
                                    <div class="form-group">
                                        <input type="email" name="email" class="form-control form-control-user" id="exampleInputEmail"
                                               placeholder="Email Address" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="number" name="phone" class="form-control form-control-user" id="phonenumber"
                                               placeholder="Phone number" required>
                                    </div>


                                    <input type="submit"  value="Register Account" class="btn btn-primary btn-user btn-block"/>


                                </form>
                                <hr>
                                <a href="index.html" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>

                                <hr>
                                <div class="text-center">
                                    <a class="small" href="forgot-password.html">Forgot Password?</a>
                                </div>
                                <div class="text-center">
                                    <a class="small" href="Login">Already have an account? Login!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

    </body>

</html>