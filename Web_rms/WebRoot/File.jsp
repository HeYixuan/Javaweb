<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'File.jsp' starting page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="BootStarp01/css/bootstrap.min.css" type="text/css"></link></head>

<body>
	<div class="container">
		<div class="rows">
			<div class="col-ls-4">
				<form name="uploadform" action="uploadFile" method="post" enctype="multipart/form-data">
					  <div class="form-group">
					    <label>文件名</label>
					    <input type="text" class="form-control" name="fileName" id="fileName" placeholder="请输入文件名">
					  </div>
					  <!-- <div class="form-group">
					    <label for="exampleInputPassword1">Password</label>
					    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
					  </div> -->
					  <div class="form-group">
					    <label>File input</label>
					    <input type="file" id="file" name="file">
					    <p class="help-block">Example block-level help text here.</p>
					  </div>
					  
					  <div class="form-group">
					    <textarea rows="10" cols="20" name="description"></textarea>
					  </div>
					  <button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
	<script src="BootStarp01/js/jquery.min.js"></script>
	<script src="BootStarp01/js/bootstrap.min.js"></script>
</html>
