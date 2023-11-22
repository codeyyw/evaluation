<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>formRefer</title>
</head>
<body>

<%
		Contributor contributor = (Contributor) request.getSession().getAttribute("contributor");
		System.out.println(contributor);
	%>
	<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<br>
	<br>
	<form class="form-horizontal" action="referPro" method="post"
		enctype="multipart/form-data">
		<fieldset>
			<div id="legend" class="">
				<label>申报项目</label>
			</div>
			<div class="control-group">
				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">项目名</label>
					<div class="controls">
						<input type="text" name="project_name"
							value="${contributor.project_name}" readonly="true"
							class="input-xlarge">
					</div>

					<!-- Text input-->
					<label class="control-label" for="input01">项目团队</label>
					<div class="controls">
						<input type="text" name="project_team"
							value="${contributor.team_name}" readonly="true"
							class="input-xlarge">
					</div>
				</div>
			</div>

			<div class="control-group">

				<!-- Select Basic -->
				<label class="control-label">项目类别</label>
				<div class="controls">
					<select class="input-xlarge" name="project_type">
						<option>大数据</option>
						<option>人工智能</option>
						<option>互联网</option>
						<option>物联网</option>
						<option>云技术</option>
						<option>机械制造</option>
						<option>能源</option>
					</select>
				</div>

			</div>

			<div class="control-group">

				<!-- Textarea -->
				<label class="control-label">项目特点</label>
				<div class="controls">
					<div class="textarea">
						<textarea class="" name="project_key"> </textarea>
					</div>
				</div>
			</div>

			<div class="control-group">

				<!-- Text input-->
				<label class="control-label" for="input01">项目专利数</label>
				<div class="controls">
					<input type="text" name="project_patent" class="input-xlarge">
				</div>
			</div>

			<div class="control-group">

				<!-- Text input-->
				<label class="control-label" for="input01">项目实施产品</label>
				<div class="controls">
					<input type="text" name="project_product" class="input-xlarge">
				</div>
			</div>

			<div class="control-group">

				<!-- Text input-->
				<label class="control-label" for="input01">项目实施服务</label>
				<div class="controls">
					<input type="text" name="project_service" class="input-xlarge">
				</div>
			</div>

			<div class="control-group">
				<label class="control-label">项目申报书(推荐PDF格式)</label>

				<!-- File Upload -->
				<div class="controls">
					<input class="input-file" name="file1" type="file"> <input
						class="input-file" name="file2" type="file"> <input
						class="input-file" name="file3" type="file">
				</div>
			</div>



			<div class="control-group">
				<label class="control-label">提交项目</label>

				<!-- Button -->
				<div class="controls">
					<button class="btn btn-success">Button</button>
				</div>
			</div>

		</fieldset>
	</form>







</body>
</html>