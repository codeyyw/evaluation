<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*,java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>评委管理</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#judge").click(function() {
			$("#addJudgeTr").toggle();
		});
	});
</script>


<script type="text/javascript">
	$(function() {

		var args = {
			judge_name : $("input[name='judge_name']").val(),
			judge_password : $("input[name='judge_password']").val(),
			judge_profession : $("input[name='judge_profession']").val(),
			judge_star : $("input[name='judge_star']").val(),

		};
		$('#judge').submit(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/admin/addJudge",
				data : args,
				type : "POST",
				dataType : "json",
				error : function(data) {
					console.log(data, "111");
					alert(data, "111");
				},
				success : function(data) {
					console.log(data.result)
					alert(data.result);
				}
			});
		});
	})
</script>
</head>
<body>
	<%
		List<Judge> judges = (List<Judge>) request.getSession().getAttribute("judges");

		System.out.println("judges评委列表----" + judges);
	%>


	<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<br>
	<button>评委列表</button>



<form id="judgeForm" method="post"
			action="${pageContext.request.contextPath}/admin/addJudge">

	<table id="judgeTable" class="table table-hover">
		<caption>评委信息</caption>
		<thead>
			<tr>
				<th>姓名</th>
				<th>密码</th>
				<th>专业</th>
				<th>等级</th>
				<th></th>
			</tr>
		</thead>

		<c:forEach items="${judges}" var="judge">

			<tbody>
				<tr>
					<td>${judge.judge_name}</td>
					<td>${judge.judge_password}</td>
					<td>${judge.judge_profession}</td>
					<td>${judge.judge_star}</td>
					<td></td>
				</tr>
			</tbody>
		</c:forEach>
		
		<tbody>
			<tr id="addJudgeTr">
				<td><input type="text" name="judge_name" class="input-xlarge"></td>
				<td><input type="text" name="judge_password"
					class="input-xlarge"></td>
					<td><select class="input-xlarge" name="judge_profession">
						<option>大数据</option>
						<option>人工智能</option>
						<option>互联网</option>
						<option>物联网</option>
						<option>云技术</option>
						<option>机械制造</option>
						<option>能源</option>
					</select></td>
				<td><select class="input-xlarge" name="judge_star">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select></td>
				<td><button id="addJudge" class="btn btn-success">确定</button></td>
			</tr>


		</tbody>
	</table>
	</form>
	<button id="judge">增加评委</button>


</body>
</html>