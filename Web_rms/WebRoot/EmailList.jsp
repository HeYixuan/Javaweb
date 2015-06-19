<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="en">
<head>
<title>Unicorn Admin</title>
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
</head>
<body>


	<div id="header">
		<h1>
			<!-- <a href="#">Unicorn Admin</a> -->
		</h1>
	</div>

	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-user"></i> <span class="text">用户</span> </a></li>
			<li class="btn btn-inverse dropdown" id="menu-messages"><a
				href="#" data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"><i class="icon icon-envelope"></i> <span
					class="text">Messages</span> <span class="label label-important">5</span>
					<b class="caret"></b> </a> <!-- <ul class="dropdown-menu">
                        <li><a class="sAdd" title="" href="#">new message</a></li>
                        <li><a class="sInbox" title="" href="#">inbox</a></li>
                        <li><a class="sOutbox" title="" href="#"></a></li>
                        <li><a class="sTrash" title="" href="#">trash</a></li>
                    </ul> -->
			</li>
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-cog"></i> <span class="text">设置</span> </a></li>
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-share-alt"></i> <span class="text">退出</span> </a></li>
		</ul>
	</div>

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-th-list"></i>
			Validation</a>
		<ul>

			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>个人信息</span> <span class="label">2</span> </a>
				<ul>
					<li><a href="findbyId?id=<s:property value="id"/>">完善个人信息</a></li>
					<li><a href="FixPass.jsp">修改密码</a></li>
				</ul>
			</li>
			<li class="submenu"><a href="#"><i
					class="icon icon-pencil"></i> <span>设备管理</span> <span class="label">1</span>
			</a>
				<ul>
					<li class="active"><a href="list">查看设备信息</a>
					</li>
				</ul>
			</li>
			<li class="active submenu open"><a href="#"><i
					class="icon icon-envelope"></i> <span>邮件管理</span> <span
					class="label">2</span> </a>
				<ul>
					<li><a href="EmailList.jsp">查看邮件</a></li>
					<li><a href="#">垃圾箱</a></li>
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
			<h1>Tables</h1>
			<%-- <div class="btn-group">
				<a class="btn btn-large tip-bottom" title="Manage Files"><i
					class="icon-file"></i> </a> <a class="btn btn-large tip-bottom"
					title="Manage Users"><i class="icon-user"></i> </a> <a
					class="btn btn-large tip-bottom" title="Manage Comments"><i
					class="icon-comment"></i><span class="label label-important">5</span>
				</a> <a class="btn btn-large tip-bottom" title="Manage Orders"><i
					class="icon-shopping-cart"></i> </a>
			</div> --%>
		</div>
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i
				class="icon-home"></i>Home</a> <a href="#" class="tip-bottom">用户管理</a> <a
				href="#" class="current">查看用户信息</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">

						<div class="widget-title">

							<h5>用户信息列表</h5>
						</div>
						<div class="widget-content nopadding" id="Mydiv">
							<table class="table table-bordered data-table table-hover">
								<thead>
									<tr>
										<th style="width: 200px;">ID</th>
										<th style="width: 200px;">Login Name</th>
										<th style="width: 200px;">Pass Word</th>
										<th style="width: 200px;">Email</th>
										<th>Date</th>
									</tr>
								</thead>

								<tbody class="tbody">
									<c:forEach items="${pageList.list}" var="o">
										<tr>
											<td>${o.id}</td>
											<td id="${o.id}">${o.loginName}</td>
											<td>${o.password}</td>
											<td>${o.email}</td>
											<td class="center">${o.CDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<div
							class="fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix">
							<div id="DataTables_Table_0_filter" class="dataTables_filter">

								<%-- <div id="Page"
									class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers">
									<c:if test="${pageList.pageIndex > 1 }">
									<a href="list?pageIndex=1" id="" class="first ui-corner-tl ui-corner-bl fg-button ui-button">首页</a>
									<a href="list?pageIndex=${pageList.pageIndex-1 }" id="" class="previous fg-button ui-button">上一页</a>
									</c:if>
									<c:if test="${pageList.pageIndex < pageList.pageCount}">
									<a href="list?pageIndex=${pageList.pageIndex+1 }" id="" class="next fg-button ui-button">下一页</a>
									<a href="list?pageIndex=${pageList.pageCount }" id="" class="last ui-corner-tr ui-corner-br fg-button ui-button">末页</a>
									</c:if>
								</div> --%>
								<!-- End Page -->

								<div id="Page"
									class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers">
									<a href="javascript:AjaxFlashPage(1)" id="first"
										class="first ui-corner-tl ui-corner-bl fg-button ui-button">首页</a>
									<a onclick="Previous()"
										id="previous" class="previous fg-button ui-button">上一页</a> 
									<input type="hidden" id="pageCount" value="${pageList.pageCount}">
									<a onclick="Next()"
										id="next" class="next fg-button ui-button">下一页</a> 
										<a href="javascript:AjaxFlashPage(${pageList.pageCount})"
										id="last"
										class="last ui-corner-tr ui-corner-br fg-button ui-button">末页</a>
								</div>
							</div>
						</div>
					</div>
					<!-- End widget-box -->
				</div>

				<div class="row-fluid">
					<div id="footer" class="span12" style="padding-top: 10px;">
						2014-2022 壹圆工作室 <a href="#">OGNC.Net © 版权所有</a>
						<!-- 2012 &copy; Unicorn Admin. Brought to you by <a href="https://wrapbootstrap.com/user/diablo9983">diablo9983</a> -->
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="BootStarp01/js/jquery.min.js"></script>
	<script src="BootStarp01/js/jquery.ui.custom.js"></script>
	<script src="BootStarp01/js/bootstrap.min.js"></script>
	<script src="BootStarp01/js/jquery.uniform.js"></script>
	<script src="BootStarp01/js/select2.min.js"></script>
	<%-- <script src="BootStarp01/js/jquery.dataTables.min.js"></script> --%>
	<script src="BootStarp01/js/unicorn.js"></script>
	<%-- <script src="BootStarp01/js/unicorn.tables.js"></script> --%>
	<script type="text/javascript" src="MyJS/MyJS.js"></script>
	<script type="text/javascript">
		function AjaxFlashPage(parms) {
				$.ajax({
						type : "Post",
						dataType : "json",
						url : "list.action?format=json&pageIndex=" + parms,
						success : function(data) {
							var list=data.list;
							alert(parms);
							var strtable = "<table class='table table-bordered data-table table-hover'>";
							strtable += "<thead><tr><th>ID</th><th style='width: 200px;'>Login Name</th><th style='width: 200px;'>Pass Word</th><th style='width: 200px;'>Email</th><th>Date</th></tr></thead>";
							strtable+="<tbody class='tbody'>";
							for(var i=0;i<list.length;i++){
								
								strtable+="<tr>";
								strtable+="<td>"+list[i].id+"</td>";
								strtable+="<td id="+list[i].id+">"+list[i].loginName+"</td>";
								strtable+="<td>"+list[i].password+"</td>";
								strtable+="<td>"+list[i].email+"</td>";
								strtable+="<td>"+list[i].CDate+"</td>";
								strtable+="</tr>";
							}
							strtable+="</tbody>";
							strtable+="</table>";
							$("#Mydiv").html(strtable);
							onLoad();
						},
						error : function() {
							alert("通讯有问题,请稍候刷新...");
						}
					});
		}
		
		var pageIndex=1;
		var pageCount=$("#pageCount").val();
		
		function Next(){
			if(pageCount>+pageIndex){
				pageIndex++;
				AjaxFlashPage(pageIndex);
			}
			
			
		}
		
		function Previous(){
			pageIndex--;
			AjaxFlashPage(pageIndex);
			if((pageIndex--)<=1){
				pageIndex=1;
			}
		}
	</script>
</body>
</html>
