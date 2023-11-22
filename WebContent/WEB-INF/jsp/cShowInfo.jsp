<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*,java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>申报人个人信息</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#toggleTable").click(function() {
			$("#projectTable").toggle();
		});
	});

	$(document).ready(function() {
		$("#person").click(function() {
			$("#addPersonTr").toggle();
		});
	});
</script>


</head>

<body>
	<%
		Contributor contributor = (Contributor) request.getSession().getAttribute("contributor");
		Project project = (Project) request.getSession().getAttribute("project");

		System.out.println("showInfo----" + contributor + "---" + project);

		if (project != null) {
	%>
	<br>
	<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<br>
	<br>
	<table class="table table-hover">
		<caption>个人信息</caption>
		<thead>
			<tr>
				<th>姓名</th>
				<th>登录密码</th>
				<th>联系方式</th>
				<th>邮箱</th>
				<th>项目名</th>
				<th>项目团队</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>${contributor.contributor_name}</th>
				<th>${contributor.contributor_password}</th>
				<th>${contributor.contributor_phone}</th>
				<th>${contributor.contributor_mail}</th>
				<th>${contributor.project_name}</th>
				<th>${contributor.team_name}</th>
			</tr>

		</tbody>
	</table>


	<button id="toggleTable">展示项目</button>
	<table id="projectTable" class="table table-hover">
		<caption>项目信息</caption>
		<thead>
			<tr>
				<th>项目名</th>
				<th>项目类型</th>
				<th>项目团队</th>
				<th>项目关键字</th>
				<th>专利数</th>
				<th>主要产品</th>
				<th>主要服务</th>
				<th>评委评分</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>${project.project_name}</th>
				<th>${project.project_type}</th>
				<th>${project.project_team}</th>
				<th>${project.project_key}</th>
				<th>${project.project_patent}</th>
				<th>${project.project_product}</th>
				<th>${project.project_service}</th>
				<th>${project.project_level}</th>
			</tr>

		</tbody>
	</table>


	<%
		List<String> fileNames = (List<String>) session.getAttribute("fileNames");
			System.out.println("cShowInfo======" + fileNames);
	%>

	<c:forEach items="${fileNames}" var="file">

		<%-- <div><p name="file">${file}</p></div> --%>
		<a href="${file}"  class="easyui-linkbutton">下载附件</a>

	</c:forEach>






	<br>
	<br>
	<div style=" text-align:center"><a href="/evaluation/person/teamInfo">查看团队成员</a></div>

	<%
		} else {
	%>
	<br>
	<br>
	<div style='text-align:center'><h3>该申报人暂未上传项目，请上传项目后再查看个人信息</h3></div>
	<br>
	<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<br>
	<br>
	<br>
	<div style='text-align:center'><a href='../project/toReferPro'>请前往上传项目</a></div>
	
	<%
		}
	%>
	
	<script>
	$(function() {
		
		var file = $('p[name="file"]');
		var oldName = file.html();
		console.log(oldName)
	
		console.log(oldFile.substring(10,20));
		file.html(newName);
		
	})
	
	</script>
</body>
</html>