<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>regite</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="BootStarp01/css/pages/bootstrap.min.css" rel="stylesheet" />
    <link href="BootStarp01/css/bootstrap-responsive.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="BootStarp01/css/css.css" type="text/css"></link>
    <!-- <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet" /> -->
    <link href="BootStarp01/css/font-awesome.css" rel="stylesheet" />
    <link href="BootStarp01/css/adminia.css" rel="stylesheet" /> 
    <link href="BootStarp01/css/adminia-responsive.css" rel="stylesheet" /> 
    <link href="BootStarp01/css/pages/login.css" rel="stylesheet" />


	<style type="text/css">
	#login-container {
	width: 600px;
	}
	</style>
  </head>
  
  <body>
  
  	<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 				
			</a>
			
			<a class="brand" href="#">Adminia Admin</a>
			
			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					
					<li class="">
						
						<a href="#"><i class="icon-chevron-left"></i> Back to Homepage</a>
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->


<div id="login-container">
	
	
	<div id="login-header">
		
		<h3>Register</h3>
		
	</div> <!-- /login-header -->
	
	<div id="login-content" class="clearfix">
	
	<form action="" id="RegiteForm" name="RegiteForm" method="post">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="username">Username</label>
						<div class="controls">
							<input type="text" name="user.loginName" id="loginName"onblur="Onblur()"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<input type="password" name="user.password" id="password" onblur="Onblur()"/>
							<!-- <div id="message"></div> -->
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="password">Sure_Password</label>
						<div class="controls">
							<input type="password" name="sure_password" id="sure_password" onblur="Onblur()"/>
							<!-- <div id="message"></div> -->
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="password">Email</label>
						<div class="controls">
							<input type="text" name="user.email" id="email" onblur="Onblur()"/>
							<!-- <div id="message"></div> -->
						</div>
						<span style="color: red" id="message"></span>
					</div>
				</fieldset>
				
				<!-- <div id="remember-me" class="pull-left">
					<input type="checkbox" name="remember" id="remember" />
					<label id="remember-label" for="remember">Remember Me</label>
				</div> -->
				
				<div class="pull-right">
					<button type="button" class="btn btn-warning btn-large" onclick="Login()">
						Register
					</button>
				</div>
			</form>
			
		</div> <!-- /login-content -->
		
		
		 <div id="login-extra">
			
			<p>Have an account <a href="Login.jsp"> Login</a></p>
			
			<!-- <p>Remind Password? <a href="#">Retrieve.</a></p> -->
			
		</div> <!--/login-extra -->
	
</div> <!-- /login-wrapper -->
  </body>
  
  <!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="BootStarp01/js/js/jquery-1.7.2.min.js"></script>
<script src="BootStarp01/js/js/bootstrap.js"></script>
<script type="text/javascript" src="MyJS/Regite.js"></script>
</html>
