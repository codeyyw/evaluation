<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var role = $("#role").html().trim();
		console.log(role);

		if (role == "管理员") {

			//alert(role);
			$('a[name="contributor"]').attr('href', '#');
			$('a[name="judge"]').attr('href', '#');
			$('#adminLogin').attr('href', '#');
			$('#judgeLogin').attr('href', '#');
			$('#contributorLogin').attr('href', '#');
		} else if (role == "申报人") {

			//alert(role);
			$('a[name="judge"]').attr('href', '#');
			$('a[name="admin"]').attr('href', '#');
			$('#adminLogin').attr('href', '#');
			$('#judgeLogin').attr('href', '#');
			$('#contributorLogin').attr('href', '#');
		} else if (role == "评委") {

			//alert(role);
			$('a[name="admin"]').attr('href', '#');
			$('a[name="contributor"]').attr('href', '#');
			$('#adminLogin').attr('href', '#');
			$('#judgeLogin').attr('href', '#');
			$('#contributorLogin').attr('href', '#');
		}

	})
</script>

</head>
<body>

	<%
		String role = (String) request.getSession().getAttribute("ROLE");

		System.out.println("ROLE------------" + role);
		Contributor contributor = (Contributor) request.getSession().getAttribute("contributor");
		Judge judge = (Judge) request.getSession().getAttribute("judge");
		Admin admin = (Admin) request.getSession().getAttribute("admin");

		System.out.println("====indexHeader====");
	%>
	<div class="main-content">
		<div class="popup-bg"></div>
		<div class="header">
			<div class="navbar-notmobile d-none d-md-block">
				<div class="container">
					<h1 class="text-hide">
						<!-- 	<a href="http://www.corerain.com">秃头科技</a> -->
					</h1>
					<ul class="top-menu">

						<li><div id="role"
								style="display: block; width: 120px; color: white">
								<%
									if (role == null) {
										out.print("角色");
									} else {
										switch (role) {
										case "admin":
											out.print("管理员");
											break;
										case "contributor":
											out.print("申报人");
											break;
										case "judge":
											out.print("评委");
											break;
										}

									}
								%>
							</div></li>

						<li><a name="contributor" href="#project/toContributor">项目申报</a>
							<div class="sub-nav">
								<ul>
									<li><a id="refer" name="contributor"
										href="project/toReferPro">上传项目</a></li>
									<li><a name="contributor" href="contributor/toRegister">申报人注册</a></li>
									<li><a name="contributor" id="contributorLogin"
										href="contributor/toLogin">申报人登录</a></li>
								</ul>
							</div></li>
						<li><a href="#judge/toJudge" name="judge">评委评审</a>
							<div class="sub-nav">
								<ul>
									<li><a href="judge/assignPros" name="judge">项目评审</a></li>
									<li><a href="judge/toLogin" id="judgeLogin" name="judge">评委登录</a></li>
								</ul>
							</div></li>

						<li style="width: 120px"><a href="#admin/toAdmin"
							name="admin">项目管理</a>
							<div class="sub-nav">
								<ul>
									<li><a href="admin/toPlayerCondition" name="admin">报名情况</a></li>
									<li><a href="admin/toJudgeManager" name="admin">评委管理</a></li>
									<li><a href="admin/toLgoin" id="adminLogin" name="admin">管理员登录</a></li>
								</ul>
							</div></li>


						<li style="width: 120px"><a href="#"> <%
 	if (role == null) {

 		out.print("未登录");
 	} else {
 		switch (role) {
 		case "admin":
 			out.print(Admin.getAdminName());
 			break;
 		case "contributor":
 			out.print(contributor.getContributor_name());
 			break;
 		case "judge":
 			out.print(judge.getJudge_name());
 			break;
 		}

 	}
 %>
						</a>
							<div class="sub-nav">

								<ul>
									<%
										if (role == null) {

											out.print("<li><a href='admin/toLogin'>管理员登录</a></li>");
											out.print("<li><a href='judge/toLogin'>评委登录</a></li>");
											out.print("<li><a href='contributor/toLogin'>申报人登录</a></li>");
										} else {

											switch (role) {
											case "admin":
												out.print("<li><a href='admin/toPlayerCondition'>报名情况 </a></li>");
												out.print("<li><a href='admin/toJudgeManager'>评委管理 </a></li>");
												break;
											case "contributor":
												out.print("<li><a href='contributor/showInfo'>个人信息 </a></li>");
												break;
											case "judge":
												out.print("<li><a href='judge/showInfo'>个人信息 </a></li>");
												out.print("<li><a href='judge/assignPros'>项目评审 </a></li>");
												break;
											}

											out.print("<li><a href='outLogin'>退出</a></li>");

										}
									%>
								</ul>
							</div></li>
					</ul>

				</div>
			</div>
		</div>
</body>
</html>