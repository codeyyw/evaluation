<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*,java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>申报人信息 - 管理员</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>




</head>
<body>
	<%
		List<Contributor> players = (List<Contributor>) request.getSession().getAttribute("players");


		System.out.println("Contributors申报人列表----" + players);
	%>


	<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<br>
	<button>申报人列表</button>



		<table id="contributorTable" class="table table-hover">
			<caption>评委信息</caption>
			<thead>
				<tr>
					<th>申报人姓名</th>
					<th>密码</th>
					<th>联系方式</th>
					<th>邮箱地址</th>
					<th>项目名称</th>
					<th>团队名称</th>
					<th>是否上传项目</th>
					<th></th>
				</tr>
			</thead>

			<c:forEach items="${players}" var="contributor">

				<tbody>
					<tr>
						<td>${contributor.contributor_name}</td>
						<td>${contributor.contributor_password}</td>
						<td>${contributor.contributor_phone}</td>
						<td>${contributor.contributor_mail}</td>
						<td>${contributor.project_name}</td>
						<td>${contributor.team_name}</td>
						<td>${contributor.contributor_isUpload}</td>	
						<td></td>
					</tr>
				</tbody>
			</c:forEach>


		</table>



</body>
</html>