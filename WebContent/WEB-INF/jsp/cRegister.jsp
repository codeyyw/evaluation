<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申报人register</title>

<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<br>
	<br>
	<div style='text-align:center'><a href='/evaluation/index.jsp'>点击返回首页</a></div>
	<br>
	<h1>用户注册</h1>
	<span>请认真注册个人信息，正确填写项目和团队名称</span>
	<hr />
	<form name="myForm" action="registerCommit" method="get"
		onsubmit="return validateForm()">
		<p>
			用户名：<input id="contributor_name" name="contributor_name" type="text" />
		</p>
		<!-- <p class="msg" style="color:red"></p> -->
		<p>
			密码：<input id="contributor_password" name="contributor_password"
				type="password" />
		</p>
		<p>
			确认密码：<input id="rcontributor_password" name="rcontributor_password"
				type="password" />
		</p>
		<p>
			电话：<input id="contributor_phone" name="contributor_phone" type="text" />
		</p>
		<p>
			邮箱：<input id="contributor_mail" name="contributor_mail" type="text" />
		</p>
		<p>
			提交项目名：<input id="project_name" name="project_name" type="text" />
		</p>
		<p>
			所属团队名：<input id="team_name" name="team_name" type="text" />
		</p>
		<p>
			<input type="submit" value="提交">
		</p>
	</form>

	<a href="toLogin">前往登录</a>


	<script>
		$("#contributor_name").focus(function() {

			$("#f").remove()

		})

		$("#contributor_name").blur(
				function() {

					var contributor_name = $.trim($(this).val());
					//alert(contributor_name)

					$.ajax({
						url : "/evaluation/cRegisterCheck",
						type : "post",
						data : {
							"contributor_name" : contributor_name
						},
						dataType : "html",

						success : function(data, textStatus) {
							console.log(data)

							//after的用法：将元素插到指定元素的后面，记住不是包含在里面。这里就是<td></td><span></span>的意思
							$("#contributor_name").after(
									"<span id='f'><font fontsize='5' color='red'>"
											+ data + "</font></span>");

						},
					})
				})

		$("#rcontributor_password").focus(function() {

			$("#r").remove()

		})
			
		$("#rcontributor_password").blur(
				function() {
					var rcontributor_password = $.trim($(this).val());
					var contributor_password = $
							.trim($("#contributor_password").val());
					//alert(rcontributor_password)
					if (contributor_password != rcontributor_password) {

						$(this).after(
								"<span id='r'><font fontsize='5' color='red'>"
										+ "密码错误" + "</font></span>");

					}
				})
				
				
				
	</script>
	<script  type="text/javascript" src="../js/check.js"></script>
</body>
</html>
