<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*,java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>user查看项目</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<%
		String type = (String) request.getSession().getAttribute("type");
		List<Project> pros = (List<Project>) request.getSession().getAttribute("pros");

		if (pros != null) {
	%>
	<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<br>
	<button>${type}类项目列表排行榜</button>
	<table id="projectTable" class="table table-hover">
		<caption>项目推荐信息</caption>
		<thead>
			<tr>
				<th>项目名</th>
				<th>项目类型</th>
				<th>项目团队</th>
				<th>项目评分
				<th>
			</tr>
		</thead>

		<c:forEach items="${pagePros.list}" var="project">
			<tbody>
				<tr>
					<th>${project.project_name}</th>
					<th>${project.project_type}</th>
					<th>${project.project_team}</th>
					<th>${project.project_level}
					<th>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<div style="text-align: center">
		<a href="getProAndTeam?pn=1&toUrl=userPros&type=${type}">首页</a>
		<c:if test="${pagePros.hasPreviousPage}">
			<a href="getProAndTeam?pn=${pagePros.pageNum-1}&toUrl=userPros&type=${type}">上一页</a>
		</c:if>
		当前第${pagePros.pageNum}页 / 总${pagePros.pages}页 | 共${pagePros.total}个${type}类项目 
		<c:if test="${pagePros.hasNextPage}">
			<a href="getProAndTeam?pn=${pagePros.pageNum+1}&toUrl=userPros&type=${type}">下一页</a>
		</c:if>
		<a href="getProAndTeam?pn=${pagePros.pages}&toUrl=userPros&type=${type}">尾页</a>
	</div>
	<%
		} else {
	%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<button>暂时没有${type}类项目的推荐</button>
	<a href="/evaluation/index.jsp">回到首页</a>
	<%
		}
	%>
</body>
</html>