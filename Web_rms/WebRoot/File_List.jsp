<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="en">
<head>
<title>File_List</title>
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
.span12{
	height: 500px;
}

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

.panel{
	width: 1000px;
	height: 400px;
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

			<li class="submenu"><a href="#"><i
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
				</ul></li>
				
			<li class="submenu active open"><a href="#"><i
					class="icon icon-envelope"></i> <span>文件管理</span> <span
					class="label">2</span>
			</a>
				<ul>
					<li class="active"><a href="File_List.jsp">查看文件</a>
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
				class="icon-home"></i> Home</a> <a href="#">文件管理</a> <a href="#"
				class="current">查看文件</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i> </span>
							<h5>查看文件</h5>
							<span class="label label-important">48 notices</span>
							
						</div>
						
					<div class="rows" style="margin-top: 10px;">
						<div class="col-sm-10">
      						<select class="form-control" id="Format" name="Format">
							  <option value="app">APP</option>
							  <option value="firmware">固件</option>
							</select>
    					</div>
						<div class="widget-content nopadding" id="Mydiv">
							<!-- <table class="table table-bordered data-table table-hover">
								<tbody class="tbody">
										<tr>
											<td>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone。<a href="#">下载</a></td>
										</tr>
								</tbody>
							</table> -->
						</div>
    					<div
							class="fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix">
							<div id="DataTables_Table_0_filter" class="dataTables_filter">

								<div id="Page"
									class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers">
									<%-- <a href="javascript:Flash(1)" id="first"
										class="first ui-corner-tl ui-corner-bl fg-button ui-button">首页</a>
									<a onclick="Previous()"
										id="previous" class="previous fg-button ui-button">上一页</a> 
									<input type="hidden" id="pageCount" value="${pageList.pageCount}">
									<a onclick="Next()"
										id="next" class="next fg-button ui-button">下一页</a> 
										<a href="javascript:Flash(${pageList.pageCount})"
										id="last"
										class="last ui-corner-tr ui-corner-br fg-button ui-button">末页</a> --%>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			<div class="row-fluid" style="margin-top: 100px;">
				<div id="footer" style="padding-top: 10px;">
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
	<script src="MyJS/File_List.js"></script>
</body>

</html>



