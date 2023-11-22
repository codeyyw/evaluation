<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*,java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>user查看团队</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<%
		String type = (String) request.getSession().getAttribute("type");
		//Map<List<Person>, Integer> teams = (Map<List<Person>, Integer>) request.getSession().getAttribute("teams");
		List<List<Person>> teams = (List<List<Person>>)request.getSession().getAttribute("teams");
		if (teams != null) {
	%>
	<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<br>
	<button>${type}类项目列表排行榜</button>
	<table id="teamTable" class="table table-hover">
		<caption>团队推荐信息</caption>
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>毕业院校</th>
				<th>学位</th>
				<th>公司职位</th>
				<th>从事行业</th>
				<th>从业年限</th>
				<th>团队名</th>
			</tr>
		</thead>

		<c:forEach items="${teams}" var="team">

			<c:forEach items="${team}" var="person">
				<tbody>
					<tr>
						<th>${person.person_name}</th>
						<th>${person.person_sex}</th>
						<th>${person.person_old}</th>
						<th>${person.person_college}</th>
						<th>${person.person_degree}</th>
						<th>${person.person_position}</th>
						<th>${person.person_profession}</th>
						<th>${person.person_jobYear}</th>
						<th>${person.person_team}</th>
					</tr>
				</tbody>
			</c:forEach>
			<tbody>
				<tr>
					<th colspan="9" style="text-align: center">======</th>

				</tr>
			</tbody>
		</c:forEach>
	</table>
	<%
		} else {
	%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<button>暂时没有${type}类团队的推荐</button>
	<a href="/evaluation/index.jsp">回到首页</a>

	<%
		}
	%>
</body>
</html>