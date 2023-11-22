<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员login</title>
<link rel="stylesheet" href="/evaluation/css/login.css" />
</head>

<body>

	<div class="top">秃头科技&nbsp;·&nbsp;管理员登录界面</div>

	<div class="content">
		<form action="${pageContext.request.contextPath}/admin/loginCommit" method="post" onsubmit="true">

			<div class="login">
				<div class="title">秃头科技&nbsp;·&nbsp;管理员登录</div>
				<div class="line">
					<img class="smallImg" src="/evaluation/img/login/icon-4.png" /> <input
						placeholder="请输入账号" name="loginName" type="text" />
				</div>
				<div class="line">
					<img class="smallImg" src="/evaluation/img/login/icon-5.png" /> <input
						placeholder="请输入密码" name="loginPassword" type="password" />
				</div>
				<button type="submit" class="logBut">登&nbsp;&nbsp;录</button>
			</div>
		</form>
		
		
	</div>

</body>
</html>