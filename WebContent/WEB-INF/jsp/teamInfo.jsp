<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*,java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>团队成员信息</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#person").click(function() {
			$("#addPersonTr").toggle();
		});
	});
</script>


<script type="text/javascript">

$(function(){
	var args = {
			person_name : $("input[name='person_name']").val(),
			person_sex : $("input[name='person_sex']").val(),
			person_old : $("input[name='person_old']").val(),
			person_college : $("input[name='person_college']").val(),
			person_degree : $("input[name='person_degree']").val(),
			person_position : $("input[name='person_position']").val(),
			person_profession : $("input[name='person_profession']").val(),
			person_jobYear : $("input[name='person_jobYear']").val(),
			person_team : $("input[name='person_team']").val(),
		};
    $('#personForm').submit(function(){
        $.ajax({
            data:args,
            dataType:"json",
            error:function(data){
               // alert(data.result+"111");
            },
            success:function(data){
               // alert(data.result);
            }
        });
    });        
}) 

</script>

</head>
<body>
	<%
		Project project = (Project) request.getSession().getAttribute("project");

		Object obj = request.getSession().getAttribute("teamList");

		List<Person> teamList = (List<Person>) obj;

		System.out.println("showInfo----" + project + "---" + teamList);
	%>


	<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<br>
	<button>项目名---${project.project_name}</button>




	<form action="${pageContext.request.contextPath}/person/addPerson"
		id="personForm" method="post">
		<table id="personTable" class="table table-hover">
			<caption>成员信息</caption>
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
					<th></th>
				</tr>
			</thead>

			<c:forEach items="${teamList}" var="person">

				<tbody>
					<tr>
						<td>${person.person_name}</td>
						<td>${person.person_sex}</td>
						<td>${person.person_old}</td>
						<td>${person.person_college}</td>
						<td>${person.person_degree}</td>
						<td>${person.person_position}</td>
						<td>${person.person_profession}</td>
						<td>${person.person_jobYear}</td>
						<td>${person.person_team}</td>
						<td></td>
					</tr>
				</tbody>
			</c:forEach>

			<tbody>
				<tr id="addPersonTr">
					<td><input type="text" name="person_name" class="input-xlarge"></td>
					<td><input type="text" name="person_sex" class="input-xlarge"></td>
					<td><input type="text" name="person_old" class="input-xlarge"></td>
					<td><input type="text" name="person_college"
						class="input-xlarge"></td>
					<td><input type="text" name="person_degree"
						class="input-xlarge"></td>
					<td><input type="text" name="person_position"
						class="input-xlarge"></td>
					<td><input type="text" name="person_profession"
						class="input-xlarge"></td>
					<td><input type="text" name="person_jobYear"
						class="input-xlarge"></td>
					<td><input type="text" name="person_team"
						value="${sessionScope.project.project_team}" readonly="true"
						class="input-xlarge"></td>
					<td><button id="addPerson" class="btn btn-success">添加成员</button></td>
				</tr>


			</tbody>
		</table>
	</form>

	<button id="person">添加项目成员</button>


</body>
</html>