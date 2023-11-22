<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.yyw.entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>秃头科技｜提供下一代人工智能计算平台</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no,shrink-to-fit=no,"> -->
<meta name="description"
	content="秃头自主研发的定制数据流(CAISA）架构，多层并行计算方式具有高度可拓展性，基于CAISA技术推出的“星空”和“雨人”芯片，相较传统计算方式性能功耗比提升10倍，为物联网前端、边缘端和后端服务器提供真实可靠的计算加速，RainBuilder编译器，依托Rainbuilder端到端自动编译工具链，我们建立免费开放的秃头AI开发平台，支持像用CPU、GPU一样使用CAISA架构，支持多数主流深度学习算法，实现算法到硬件的零门槛应用开发">
<meta name="keywords"
	content="秃头，秃头科技，CAISA RainBuilder，高性能的人工智能芯片和全球首款基于数据流引擎的AI开发平台，高性能架构芯片，高通用性编译器，平台解决方案，下一代人工智能计算平台，秃头高校合作计划，CAISA，陆永青，牛昕宇，蔡权雄，肖梦秋">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/swiper.min.css">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/index.css">

<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/swiper.min.js"></script>
<script src="js/common.js"></script>
<script src="js/index.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/setProLevels",
			success : function(data) {
				console.log("排序后的项目和团队信息请求成功");
			},
			error : function(err) {
				console.log("排序后的项目和团队信息请求失败");
			}
		});
	})
</script>
</head>
<body>
	<div class="main-content">
		<%@include file="header.jsp"%>

		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img src="img/ysu/1.png"
						style="width:inherit">
				</div>
				<div class="swiper-slide">
					<img src="img/ysu/2.png"
						style="width:inherit">
				</div>
				<div class="swiper-slide">
					<img src="img/ysu/3.png"
						style="width:inherit">
				</div>
				<div class="swiper-slide">
					<img src="img/ysu/4.png"
						style="width:inherit">
				</div>
			</div>
			<div class="swiper-pagination"></div>
		</div>
	</div>

	<div class="scene">
		<h3 class="title">项目分类</h3>
			<div><%@include file="rotate3d.jsp"%></div>
		<div class="scene-content">
			<div class="container">
				<div class="row">
					<div class="scene-info col-6 col-md-4 col-xl-3">
						<img src="/evaluation/img/index/scene_title.png" alt="应用场景">
					</div>

					<div class="scene-info col-6 col-md-4 col-xl-3">
						<img src="/evaluation/img/index/scene_2.png" alt="教育">
						<div class="scene-name">互联网</div>
						<div class="scene-intro">
							<a href="/evaluation/getProAndTeam?toUrl=userPros&type=互联网">项目</a>
							<--推荐--> <a
								href="/evaluation/getProAndTeam?toUrl=userTeams&type=互联网">团队</a>
						</div>
					</div>

					<div class="scene-info col-6 col-md-4 col-xl-3">
						<img src="/evaluation/img/index/scene_4.png" alt="航空">
						<div class="scene-name">能源</div>
						<div class="scene-intro">
							<a href="/evaluation/getProAndTeam?toUrl=userPros&type=能源">项目</a>
							<--推荐--> <a
								href="/evaluation/getProAndTeam?toUrl=userTeams&type=能源">团队</a>
						</div>
					</div>
					<div class="scene-info col-6 col-md-4 col-xl-3">
						<img src="/evaluation/img/index/scene_5.png" alt="安防">
						<div class="scene-name">大数据</div>
						<div class="scene-intro">
							<a href="/evaluation/getProAndTeam?toUrl=userPros&type=大数据">项目</a>
							<--推荐--> <a
								href="/evaluation/getProAndTeam?toUrl=userTeams&type=大数据">团队</a>
						</div>
					</div>

					<div class="scene-info col-6 col-md-4 col-xl-3">
						<img src="/evaluation/img/index/scene_7.png" alt="工业">
						<div class="scene-name">机械制造</div>
						<div class="scene-intro">
							<a href="/evaluation/getProAndTeam?toUrl=userPros&type=机械制造">项目</a>
							<--推荐--> <a
								href="/evaluation/getProAndTeam?toUrl=userTeams&type=机械制造">团队</a>
						</div>
					</div>
					<div class="scene-info col-6 col-md-4 col-xl-3">
						<img src="/evaluation/img/index/scene_8.png" alt="金融">
						<div class="scene-name">云技术</div>
						<div class="scene-intro">
							<a href="/evaluation/getProAndTeam?toUrl=userPros&type=云技术">项目</a>
							<--推荐--> <a
								href="/evaluation/getProAndTeam?toUrl=userTeams&type=云技术">团队</a>
						</div>
					</div>
					<div class="scene-info col-6 col-md-4 col-xl-3">
						<img src="/evaluation/img/index/scene_9.png" alt="大数据">
						<div class="scene-name">物联网</div>
						<div class="scene-intro">
							<a href="/evaluation/getProAndTeam?toUrl=userPros&type=物联网">项目</a>
							<--推荐--> <a
								href="/evaluation/getProAndTeam?toUrl=userTeams&type=物联网">团队</a>
						</div>
					</div>
					<div class="scene-info col-6 col-md-4 col-xl-3">
						<img src="/evaluation/img/index/scene_10.png" alt="人工智能">
						<div class="scene-name">人工智能</div>
						<div class="scene-intro">
							<a href="/evaluation/getProAndTeam?toUrl=userPros&type=人工智能">项目</a>
							<--推荐--> <a
								href="/evaluation/getProAndTeam?toUrl=userTeams&type=人工智能">团队</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>


	<div class="core">
		<div class="technology">
			<h3 class="title">优秀获奖项目和团队</h3>
			<h4 class="sub-title">我们提供最专业的评审团队和最优质项目</h4>
		</div>
		<div class="application-container container">
			<div class="application">
				<div class="img-info">
					<img class="before-reverse img-fluid"
						src="/evaluation/img/index/technology_1.png" alt="定制数据流(CAISA)架构">
					<img class="reverse-img img-fluid"
						src="/evaluation/img/index/technology_reversal_1.png"
						alt="定制数据流(CAISA)架构">
				</div>
				<a href="#"><span>了解更多</span><img
					src="/evaluation/img/base/right_arrow.png" alt="查看更多"></a>
			</div>
			<div class="application">
				<div class="img-info">
					<img class="before-reverse img-fluid"
						src="/evaluation/img/index/technology_2.png?2019/3/27"
						alt="RainBuilder编译器"> <img class="reverse-img img-fluid"
						src="/evaluation/img/index/technology_reversal_2.png"
						alt="RainBuilder编译器">
				</div>
				<a href="#"><span>了解更多</span><img
					src="/evaluation/img/base/right_arrow.png" alt="查看更多"></a>
			</div>
		</div>
	</div>

	<footer> <%@include file="footer.jsp"%>
	</footer>
	</div>
	
</body>
</html>