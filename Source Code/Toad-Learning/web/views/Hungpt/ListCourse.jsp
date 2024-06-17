<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Course - List Course</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>


    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">
            <%@include file ="adminNavbarSidebar.jsp" %>
            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">List Course</h1> 

                <!-- DataTales -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3"> 
                        <div class="box">
                            <div class="container-2">
                                <div class="container">
                                    <div class="row align-items-center">
                                        <div class="col-md-4">
                                            <form action="searchcourse" method="post" class="form-inline">
                                                <div class="input-group">
                                                    <input value="${txtC}" name="txtC" type="text" class="form-control bg-light border-2 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                                    <div class="input-group-append">
                                                        <button class="btn btn-primary" type="submit">
                                                            <i class="fas fa-search fa-sm"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>
                                            <div class="form-control border-0 font-weight-bold">
                                                CourseID
                                            </div>
                                        </th>
                                        <th><div class="form-control border-0 font-weight-bold">Thumbnail</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Title</div></th>
                                        <th>
                                            <form action="searchtopic" method="post" class="form-inline">

                                                <select name="topicname" id="topicname" class="form-control border-0 font-weight-bold" onchange="this.form.submit()">
                                                    <option value="All">Topic Name</option>
                                                    <option value="International Business" ${txtTo == 'International Business' ? 'selected' : ''}>International Business</option>
                                                    <option value="Software Engineering" ${txtTo == 'Software Engineering' ? 'selected' : ''}>Software Engineering</option>
                                                    <option value="Computer Science" ${txtTo == 'Computer Science' ? 'selected' : ''}>Computer Science</option>
                                                    <option value="Artificial Intelligence" ${txtTo == 'Artificial Intelligence' ? 'selected' : ''}>Artificial Intelligence</option>
                                                </select>

                                            </form>
                                        </th>                
                                        <th>
                                            <form action="sortcourse" method="post" class="form-inline">
                                                <div class="form-group">
                                                    <select name="sortPrice" id="sortPrice" class="form-control border-0 font-weight-bold" onchange="this.form.submit()">
                                                        <option value="All">Price</option>
                                                        <option value="PriceASC"${txtSort == 'PriceASC' ? 'selected' : ''}>ASC</option>
                                                        <option value="PriceDESC"${txtSort == 'PriceDESC' ? 'selected' : ''}>DESC</option>
                                                    </select>
                                                </div>      
                                            </form>
                                        </th>
                                        <th>
                                            <form action="sortsaleprice" method="post" class="form-inline">
                                                <div class="form-group">
                                                    <select name="sortSalePrice" id="sortSalePrice" class="form-control border-0 font-weight-bold" onchange="this.form.submit()">
                                                        <option value="All">Sale Price</option>
                                                        <option value="SalePriceASC"${txtSale == 'SalePriceASC' ? 'selected' : ''}>ASC</option>
                                                        <option value="SalePriceDESC"${txtSale == 'SalePriceDESC' ? 'selected' : ''}>DESC</option>
                                                    </select>
                                                </div>      
                                            </form>
                                        </th>
                                        <th><form action="searchcoursebystatus" method="post" class="form-inline">
                                                <div class="form-group">
                                                    <select name="statuss" id="statuss" class="form-control border-0 font-weight-bold" onchange="this.form.submit()">
                                                        <option value="All">Status</option>
                                                        <option value="Active" ${txtSta == 'Active' ? 'selected' : ''}>Active</option>
                                                        <option value="Inactive" ${txtSta == 'Inactive' ? 'selected' : ''}>Inactive</option>
                                                    </select>
                                                </div>
                                            </form></th>
                                        <th><div class="form-control border-0 font-weight-bold">Edit</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">Delete</div></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listCourse}" var ="c">
                                        <tr> 
                                            <td>${c.courseID}</td>
                                            <td><img src="${c.thumbnail}" alt="Description of the image" width="100px"></td>
                                            <td><<a href="ListLesson?courseID=${c.courseID}">${c.title}</a></td>
                                            <td>${c.topicID.topicName}</td>
                                            <td>${c.price}$</td>
                                            <td>${c.salePrice}$</td>
                                            <td>${c.status}</td>
                                            <td>
                                                <a href="loadcourse?course_ID=${c.courseID}"><i class="fas fa-edit" data-toggle="tooltip" title="Edit"></i></a>
                                            </td>
                                            <td>
                                                <a href="deletecourse?course_ID=${c.courseID}" onclick="return confirm('Are you sure you want to delete ${c.courseID}?');">
                                                    <i class="fas fa-trash" data-toggle="tooltip" title="Delete"></i></a>
                                            </td>                                          
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>


            <%@include file = "adminfooter.jsp" %>
        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
    <!-- Scroll to Top Button-->
    <%@include  file ="Logout.jsp" %>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>



</body>

</html>