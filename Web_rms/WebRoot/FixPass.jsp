<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="en">
<head>
<title>FixPass</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="BootStarp01/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="BootStarp01/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="BootStarp01/css/uniform.css" />
<link rel="stylesheet" href="BootStarp01/css/select2.css" />
<link rel="stylesheet" href="BootStarp01/css/unicorn.main.css" />
<link rel="stylesheet" href="BootStarp01/css/unicorn.grey.css"
	class="skin-color" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
.form-horizontal input {
	height: 36px;
}

.form-horizontal .form-actions {
	margin-left: 0px;
	margin-top: 200px;
}

input#btn {
	margin-left: 245px;
}

.control-group {
	padding: 25px;
}
</style>
</head>

<body>


	<div id="header">
		<h1>
			<!-- <a href="#"></a> -->
		</h1>
	</div>

	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-user"></i> <span class="text">用户</span>
			</a>
			</li>
			<li class="btn btn-inverse dropdown" id="menu-messages"><a
				href="#" data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"><i class="icon icon-envelope"></i> <span
					class="text">Messages</span> <span class="label label-important">5</span>
					<b class="caret"></b>
			</a> <!-- <ul class="dropdown-menu">
                        <li><a class="sAdd" title="" href="#">new message</a></li>
                        <li><a class="sInbox" title="" href="#">inbox</a></li>
                        <li><a class="sOutbox" title="" href="#"></a></li>
                        <li><a class="sTrash" title="" href="#">trash</a></li>
                    </ul> --></li>
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-cog"></i> <span class="text">设置</span>
			</a>
			</li>
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-share-alt"></i> <span class="text">退出</span>
			</a>
			</li>
		</ul>
	</div>

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-th-list"></i>
			Validation</a>
		<ul>

			<li class="submenu active open"><a href="#"><i
					class="icon icon-th-list"></i> <span>个人信息</span> <span
					class="label">2</span>
			</a>
				<ul>

					<!-- <li><a href="#">查看个人信息</a></li> -->
					<li><a
						href="findbyId?id=<s:property value="id"/>">完善个人信息</a>
					</li>
					<li class="active"><a href="FixPass.jsp">修改密码</a></li>
				</ul></li>
			<li class="submenu"><a href="#"><i class="icon icon-pencil"></i><span>设备管理</span>
					<span class="label">1</span>
			</a>
				<ul>
					<li><a href="list">查看设备信息</a>
					</li>
				</ul>
			</li>

			<li class="submenu"><a href="#"><i
					class="icon icon-envelope"></i> <span>邮件管理</span> <span
					class="label">2</span>
			</a>
				<ul>
					<li><a href="EmailList.jsp">查看邮件</a>
					</li>
					<li><a href="#">垃圾箱</a>
					</li>
				</ul>
			</li>
			
			<li class="submenu"><a href="#"><i
					class="icon icon-envelope"></i> <span>文件管理</span> <span
					class="label">2</span>
			</a>
				<ul>
					<li><a href="File_List.jsp">查看文件</a>
					</li>
					<li><a href="File_Upload.jsp">上传文件</a>
					</li>
				</ul>
			</li>
		</ul>

	</div>

	<div id="content">
		<div id="content-header">
			<h1>Form validation</h1>
		</div>
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i
				class="icon-home"></i> Home</a> <a href="#">个人信息</a> <a href="#"
				class="current">修改密码</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i> </span>
							<h5>修改个人密码</h5>
							<span class="label label-important">48 notices</span>
						</div>
						<div class="widget-content nopadding">

							<form class="form-horizontal" method="post" action="#"
								name="basic_validate" id="basic_validate"
								novalidate="novalidate">
											
								<div class="control-group">
									<label class="control-label">原密码</label>
									<div class="controls">
										<input type="password" name="Password" id="Password" onblur="Onblur()"/> <span
											style="color: #b94a48" id="PasswordMessage"
											class="help-inline"></span>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">新密码</label>
									<div class="controls">
										<input type="password" name="new_pass" id="new_pass" onblur="Onblur()"/> <span
											style="color: #b94a48" id="NewPassMessage"
											class="help-inline"></span>
									</div>
								</div>
								
								
								<div class="control-group">
									<label class="control-label">确认密码</label>
									<div class="controls">
										<input type="password" name="sure_password" id="sure_password" onblur="Onblur()" /> <span
											style="color: #b94a48" id="SurePassMessage" class="help-inline"></span>
									</div>
								</div>
								<div class="form-actions">
									<input type="button" id="btn" onclick="UpdatePass()" value="修改密码"
										class="btn btn-primary" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div id="footer" class="span12" style="padding-top: 10px;">
					2014-2022 壹圆工作室 <a href="#">OGNC.Net © 版权所有</a>
					<!-- 2012 &copy; Unicorn Admin. Brought to you by <a href="https://wrapbootstrap.com/user/diablo9983">diablo9983</a> -->
				</div>
			</div>
		</div>
	</div>



	<script src="BootStarp01/js/jquery.min.js"></script>
	<!-- <script src="BootStarp01/js/jquery.ui.custom.js"></script> -->
	<script src="BootStarp01/js/bootstrap.min.js"></script>
	<!-- <script src="BootStarp01/js/jquery.uniform.js"></script> -->
	<%-- <script src="BootStarp01/js/select2.min.js"></script> --%>
	<!-- <script src="BootStarp01/js/jquery.validate.js"></script> -->
	<script src="BootStarp01/js/unicorn.js"></script>
	<!-- <script src="BootStarp01/js/unicorn.form_validation.js"></script> -->
	<script type="text/javascript" src="MyJS/FixPass.js"></script>

</body>

</html>



