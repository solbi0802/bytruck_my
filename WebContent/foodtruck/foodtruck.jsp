<%@page import="vo.Foodtruck_Location"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<title>foodtruck.jsp</title>

<style>
.board {
	padding-top: 10%;
}

.board .page-header {
	margin-top: 0;
}
</style>
</head>
<body>
	<div class="row">
		<div class="container-fluid">
			<div class="col-lg-12">
				<header>
					<%@include file="/template/header.jsp"%>
				</header>
			</div>
		</div>
	</div>
	<div class="board">
		<div class="row">
			<div class="container">
				<ol class="breadcrumb link-accent separator-arrow">
					<li><a href="<%=root%>/index.jsp" title="Home"><i
							class="fa fa-home"></i></a></li>
					<li class="active">푸드트럭 소개</li>
					<li><a href="<%=root %>/foodtruck/foodboard.jsp">푸드트럭 등록</a></li>
				</ol>
				<div class="page-header">
					<div class="row">
						<div class=col-lg-12>
							<h1 align="center">
								<b>FOOD TRUCK</b>
							</h1>
							<p align="center">
								<b>이런 푸드트럭은 어때요?</b>
							</p>
						</div>
					</div>
				</div>
				<!-- Wrapper for slides -->
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img src="<%=root%>/images/foodtruck1.PNG">
							<div class="carousel-caption">
								<a href="<%=root%>/foodtruck/foodtruckdetail.jsp"><h3>덕복희</h3></a>
							</div>
						</div>
						<div class="item">
							<img src="<%=root%>/images/foodtruck2.PNG">
							<div class="carousel-caption">
								<a href="<%=root%>/foodtruck/foodtruckdetail.jsp"><h3>돈까쑤</h3></a>
							</div>
						</div>
						<div class="item">
							<img src="<%=root%>/images/foodtruck3.PNG">
							<div class="carousel-caption">
								<a href="<%=root%>/foodtruck/foodtruckdetail.jsp"><h3>핏짜아</h3></a>
							</div>
						</div>
					</div>
				</div>
				<!-- tab Header -->
				<div class="foodsearch">
					<jsp:include page="foodsearch.jsp"/>
				</div>
<!-- 				<div class="row">
					<div class="container-fluid">
						<div class="foodtype">
							<ul class="nav nav-tabs" role="tablist">
								<li class="active"><a href="#main" role="tab"
									data-toggle="tab">식사류</a></li>
								<li><a href="#desert" role="tab" data-toggle="tab">간식류</a></li>
								<li><a href="#drink" role="tab" data-toggle="tab">음료류</a></li>
								<li class="dropdown"><a href="#" id="myTabDrop1"
									class="dropdown-toggle" data-toggle="dropdown">지역별 보기 <b
										class="caret"></b></a>
									<ul class="dropdown-menu" role="menu"
										aria-labelledby="myTabDrop1">
										<li><a href="#dropdown1" tabindex="-1" data-toggle="tab">서울</a></li>
										<li><a href="#dropdown2" tabindex="-1" data-toggle="tab">경기도</a></li>
										<li><a href="#dropdown3" tabindex="-1" data-toggle="tab">대구</a></li>
										<li><a href="#dropdown4" tabindex="-1" data-toggle="tab">부산</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div> -->
				<!-- end tab Header -->
				<br>
				<div class="foodlist" style="cursor:pointer" 
					 onclick ="window.location.href='<%=root%>/foodtruckdetail.bt?num=2';">
				</div>
			</div>
		</div>
	</div>
	<div class="text-center">
		<ul class="pagination">
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
	</div>
	<div class="foot">
		<div class="row">
			<div class="container-fluid">
				<div class="col-lg-12">
					<footer>
						<%@include file="/template/footer.jsp"%>
					</footer>
				</div>
			</div>
		</div>
	</div>
</body>
</html>