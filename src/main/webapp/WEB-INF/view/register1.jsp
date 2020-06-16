<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]><html class="ie8 no-js" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9 no-js" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
    <title>Ahmedabad City Police- Traffic Police</title>
    <link rel="shortcut icon" href="favicon.ico" />
    <!-- start: META -->
    <meta charset="utf-8" />
    <!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="Responsive Admin Template build with Twitter Bootstrap and jQuery" name="description" />
    <meta content="ClipTheme" name="author" />
    <!-- end: META -->
    <!-- start: MAIN CSS -->
    <link type="text/css" rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Raleway:400,100,200,300,500,600,700,800,900/" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/font-awesome.min.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/clip-font.min.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/skins/all.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/perfect-scrollbar.min.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/sweetalert.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/main.min.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/main-responsive.min.css" />
    <link type="text/css" rel="stylesheet" media="print" href="adminResources/css/print.min.css" />
    <link type="text/css" rel="stylesheet" id="skin_color" href="adminResources/css/light.min.css" />
    <!-- end: MAIN CSS -->
    <!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->

</head>

<body class="login example1">

    <div class="main-login col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
        <div class="logo">
            CLIP<i class="clip-clip"></i>ONE
        </div>
        <!-- start: LOGIN BOX -->
        <div class="box-login">
        
            <h3>Sign in to your account</h3>
            <p>
                Please enter your name and password to log in.
            </p>
               <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
            <form class="form-register">
            
              	<f:form id="registration" class="form-inline" action="/insertRegister" modelAttribute="registerdata" method="POST">
                                    
                <div class="errorHandler alert alert-danger no-display">
                    <i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
                </div>
                <fieldset>
                     <div class="form-group">
                                                <label class="control-label">
                                                    First Name <span class="symbol required"></span>
                                                </label>
                                                <f:input id="firstname" type="text" placeholder="Insert your First Name" class="form-control" path="firstname" />
                                                
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label">
                                                    Last Name <span class="symbol required"></span>
                                                </label>
                                                
                                                <f:input id="lastname" type="text" placeholder="Insert your Last Name" class="form-control" path="lastname" />
                                        	 </div>
                     <div class="form-group">
                                                        <label class="control-label">
                                                            AGE <span class="symbol required"></span>
                                                        </label>
                                                        <f:input id="age" type="text" placeholder="Enter Your Age" class="form-control" path="age" />

                                                    </div>
                     <div class="form-group">
                                            
                                            
                                                <label for="signupInputName" class="control-label">Gender</label><br>
                                    <f:select id="gender" type="text"  class="form-control" path="gender">
                                    	<option value="" disabled selected>Select gender</option>
                                    	<f:option value="Male"></f:option>
                                    	<f:option value="Female"></f:option>
                                    	<f:option value="Others"></f:option>
                                    </f:select>
                                    
                                    
                                          	</div>
                      <div class="form-group">
                                               
                                               
                                                 <label for="signupInputName" class="control-label">Gender</label><br>
                                    
                                    
                                    <f:select id="area" type="text"  class="form-control" path="area">
                                    	<option value="" disabled selected>Select gender</option>
                                    	<f:option value="Ghatlodiya"></f:option>
                                    	<f:option value="Ranna park"></f:option>
                                    	<f:option value="Prabhatchowk"></f:option>
                                    </f:select>
                                    
                                    
                                            </div>
					<div class="form-group">
                                                        <label class="control-label">
                                                            Zip Code <span class="symbol required"></span>
                                                        </label>
                                                        <f:input id="zipcode" type="text" placeholder="Enter Zip Code" class="form-control" path="zipcode" />
                                                    </div>
                    <p>
                        Enter your account details below:
                    </p>
                    <div class="form-group">
                                                <label class="control-label">
                                                    Email Address/Username <span class="symbol required"></span>
                                                </label>
                                                
                                                  <f:input id="email" type="email" placeholder="Text Field" class="form-control" path="loginModel.username" />
                                            </div>
                                              
                                            <div class="form-group">
                                                <label class="control-label">
                                                    Password <span class="symbol required"></span>
                                                </label>
                                 			 	 <f:input id="password" type="password" placeholder="Password" class="form-control lock-input" path="loginModel.password" />
                 	                           
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label">
                                                    Confirm Password <span class="symbol required"></span>
                                                </label>
                                                <input id="password" type="password" placeholder="Retype Password" class="form-control lock-input" name="confirmPassword" />
                                                                                                 
                                            </div>
                    <div class="form-group">
                        <div>
                            <label for="agree" class="checkbox-inline">
                                <input type="checkbox" class="grey agree" id="agree" name="agree">
                                I agree to the Terms of Service and Privacy Policy
                            </label>
                        </div>
                    </div>
                    <div class="form-actions">
                        <a href="?box=login" class="btn btn-light-grey go-back">
                            <i class="fa fa-circle-arrow-left"></i> Back
                        </a>
                        <button class="btn btn-yellow btn-block" type="submit">
                                                Register <i class="fa fa-arrow-circle-right"></i>
                                            </button>
                                            </f:form>                                                                         
                    </div>
                </fieldset>
            </form>
        </div>
        <!-- end: LOGIN BOX -->
        <div class="copyright">
            <script>
                document.write(new Date().getFullYear())
            </script> &copy; clip-one by cliptheme.
        </div>
        <!-- end: COPYRIGHT -->
    </div>

    <!-- start: MAIN JAVASCRIPTS -->
    <!--[if lt IE 9]>
            <script src="adminResources/js/respond.min.js"></script>
            <script src="adminResources/js/excanvas.min.js"></script>
            <script src="adminResources/js/jquery.min.js"></script>
            <![endif]-->
    <!--[if gte IE 9]><!-->
    <script type="text/javascript" src="adminResources/js/jquery.min.js"></script>
    <!--<![endif]-->
    <script type="text/javascript" src="adminResources/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="adminResources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="adminResources/js/bootstrap-hover-dropdown.min.js"></script>
    <script type="text/javascript" src="adminResources/js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="adminResources/js/icheck.min.js"></script>
    <script type="text/javascript" src="adminResources/js/perfect-scrollbar.jquery.min.js"></script>
    <script type="text/javascript" src="adminResources/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="adminResources/js/sweetalert.min.js"></script>
    <script type="text/javascript" src="adminResources/js/main.min.js"></script>
    <!-- end: MAIN JAVASCRIPTS -->
    <!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
    <script src="adminResources/js/jquery.validate.min.js"></script>
    <script src="adminResources/js/login.min.js"></script>
    <!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->

    <script>
        jQuery(document).ready(function() {
            Main.init();
            Login.init();
        });
    </script>

</body>

</html>