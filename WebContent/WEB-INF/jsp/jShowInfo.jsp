<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*,java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>评委个人信息</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
	<%
		Judge judge = (Judge) request.getSession().getAttribute("judge");

		System.out.println("showInfo----" + judge);
	%>
	<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<table class="table table-hover">
		<caption>个人信息</caption>
		<thead>
			<tr>
				<th>姓名</th>
				<th>登录密码</th>
				<th>专业领域</th>
				<th>级别</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<th>${judge.judge_name}</th>
				<th>${judge.judge_password}</th>
				<th>${judge.judge_profession}</th>
				<th>${judge.judge_star}</th>

			</tr>

		</tbody>
	</table>


</body>
</html>