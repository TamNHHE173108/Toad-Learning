<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="./img/logo/logo2.png" type="image/png">
        <title>Course - List Course</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.css" rel="stylesheet">

    </head>


    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">
            <%@include file ="StudentNavbarSidebar.jsp" %>
            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">List Course</h1> 

                <!-- DataTales -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3"> 
                        <div class="box">
                            <div class="container-2">
                                <div class="row">
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
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="200%" cellspacing="0">
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
                                                    <option value="International Business" >International Business</option>
                                                    <option value="Software Engineering" >Software Engineering</option>
                                                    <option value="Computer Science" >Computer Science</option>
                                                    <option value="Artificial Intelligence">Artificial Intelligence</option>
                                                </select>

                                            </form>
                                        </th>
                                        <th><div class="form-control border-0 font-weight-bold">Description</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">CreateDate</div></th>
                                        <th><div class="form-control border-0 font-weight-bold">UpdateDate</div></th>
                                        <th>
                                            <form action="sortcourse" method="post" class="form-inline">
                                                <div class="form-group">
                                                    <select name="sortPrice" id="sortPrice" class="form-control border-0 font-weight-bold" onchange="this.form.submit()">
                                                        <option value="All">Price</option>
                                                        <option value="PriceASC">ASC</option>
                                                        <option value="PriceDESC">DESC</option>
                                                    </select>
                                                </div>      
                                            </form>
                                        </th>
                                        <th>
                                            <form action="sortsaleprice" method="post" class="form-inline">
                                                <div class="form-group">
                                                    <select name="sortSalePrice" id="sortSalePrice" class="form-control border-0 font-weight-bold" onchange="this.form.submit()">
                                                        <option value="All">Sale Price</option>
                                                        <option value="SalePriceASC">ASC</option>
                                                        <option value="SalePriceDESC">DESC</option>
                                                    </select>
                                                </div>      
                                            </form>
                                        </th>
                                        <th><form action="searchcoursebystatus" method="post" class="form-inline">
                                                <div class="form-group">
                                                    <select name="statuss" id="statuss" class="form-control border-0 font-weight-bold" onchange="this.form.submit()">
                                                        <option value="All">Status</option>
                                                        <option value="Active">Active</option>
                                                        <option value="Inactive">Inactive</option>
                                                    </select>
                                                </div>
                                            </form></th>
                                        <th><div class="form-control border-0 font-weight-bold">Delete</div></th>
                                    </tr>
                                    
                                </thead>
                                <tbody>
                                    <c:forEach items="${listC}" var ="c">
                                        <tr> 
                                            <td>${c.courseID}</td>
                                            <td><img src="${c.thumbnail}" alt="Description of the image" width="100px"></td>
                                            <td>${c.title}</td>
                                            <td>${c.topicID.topicName}</td>
                                            <td>${c.description}</td>
                                            <td>${c.formattedCreateDate}</td>
                                            <td>${c.formattedUpdateDate}</td>
                                            <td>${c.price}$</td>
                                            <td>${c.salePrice}$</td>
                                            <td>${c.status}</td>
                                            <td>
                                                <a href="deleteRegistration?courseID=${c.courseID}" onclick="return confirm('Are you sure you want to delete ${c.courseID}?');">
                                                    <i class="fas fa-trash" data-toggle="tooltip" title="Delete"></i></a>
                                            </td>
                                                                                    
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>

                    </div>
                </div>
                <div id="addNewCourse" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="addcourse" method="post">
                                <div class="modal-header">						
                                    <h4 class="modal-title">Add Course</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">	
                                    <div class="form-group">
                                        <label>Course ID</label>
                                        <input name=id type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Course Name</label>
                                        <input name="name" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Thumbnail</label>
                                        <input name="thumb" type="text" class="form-control" value="url: ..." required>
                                    </div>
                                    <div class="form-group">
                                        <label>Topic Name</label>
                                        <select name="topic name" class="form-select" aria-label="Default select example">                              
                                            <option value="IB">International Business</option>
                                            <option value="SE">Software Engineering</option>
                                            <option value="CS">Computer Science</option>
                                            <option value="AI">Artificial Intelligence</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <input name="description" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Date Create</label>
                                        <input name="create" class="form-control" type="text" pattern="[a-zA-Z0-9._%+-]"required>
                                    </div>
                                    <div class="form-group">
                                        <label>Update Date</label>
                                        <input name="update" class="form-control" type="text" pattern="[a-zA-Z0-9._%+-]"required>
                                    </div>
                                    <div class="form-group">
                                        <label>Price</label>
                                        <textarea name="price" class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Sale Price</label>
                                        <textarea name="sale price" class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Status</label>
                                        <select name="status" class="form-select" aria-label="Default select example">                              
                                            <option value="Active">Active</option>
                                            <option value="Inactive">Inactive</option>
                                        </select>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-success" value="Add">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <!-- End of Content Wrapper -->
        <!-- End of Page Wrapper -->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>
        <!-- Scroll to Top Button-->
       

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>



    </body>

</html>