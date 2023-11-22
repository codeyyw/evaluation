<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*,java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>评委评审项目</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>
	<%
		Judge judge = (Judge) request.getSession().getAttribute("judge");
		List<Project> projects = (List<Project>) request.getSession().getAttribute("projects");

		System.out.println("projectJudge.jsp====" + projects);
		if (projects != null) {
			System.out.println(judge.getJudge_profession() + "类项目列表----" + projects);
		} else {
			System.out.println("目前还没有" + judge.getJudge_profession() + "类项目");
		}
	%>


	<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<br>
	<button>${judge.judge_profession}类项目列表</button>




	<form action="${pageContext.request.contextPath}/judge/judgeProject"
		id="judgeForm" method="post">
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
					<th>评分</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<c:forEach items="${projects}" var="project">

				<tbody>
					<tr>
						<th>${project.project_name}</th>
						<th>${project.project_type}</th>
						<th>${project.project_team}</th>
						<th>${project.project_key}</th>
						<th>${project.project_patent}</th>
						<th>${project.project_product}</th>
						<th>${project.project_service}</th>
						<th><select name="project_level" class="input-xlarge">
						<option>0</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
					</select></th>
					<c:forEach items="${project.fileNames}" var="fileName">
						<td><a href="${fileName}">下载附件</a></td>
						<%-- <td><a href="${fileName.fileNames[0]}">下载附件</a></td>
						<td><a href="${fileName.fileNames[1]}">下载附件</a></td>
						<td><a href="${fileName.fileNames[2]}">下载附件</a></td> --%>
					</c:forEach>
					</tr>
				</tbody>

			</c:forEach>
		</table>
		<button id="set" class="btn btn-success">确定</button>
	</form>
	<%
		if(projects.size()==0){
			out.println("<div style='text-align:center'><b>该专业项目已经全部评审完毕</b></div>");
			out.println("<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>");
		}
	%>


</body>
</html>