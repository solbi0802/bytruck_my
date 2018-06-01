<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<script src="<%=root%>/js/Chart.min.js"></script>
</head>
<style>
body {
	padding-top: 5%;
}

#bo-container.container {
	padding-left: 90px;
	width: 60%;
	float: center; 
}

h2, .mem, .likes, .profit {
	margin-bottom: 5%;
}
</style>
	<div class="aside">
		<jsp:include page="/template/admin_aside.jsp" />
	</div>
	<div class="container" id="bo-container">
		<div class="row">
			<h2>CHART</h2>
			<div class="mem">
				<div class="card-block" >
					<h4 class="card-title">MEMBER</h4>
					<canvas id="memChart"></canvas>
					<%-- <img src="<%=root%>/images/mem_money_chart.PNG" alt="member chart"> --%>
				</div>
			</div>
			<div class="likes">
				<div class="card-block">
					<h4 class="card-title">좋아요 순위</h4>
					<jsp:include page="/admin/likeChart.jsp"/>
				</div>
			</div>
			<div class="profit">
				<div class="card-block">
					<h4 class="card-title">PROFIT</h4>
					<%-- <img src="<%=root%>/images/mem_money_chart.PNG" alt="profit chart"> --%>
				</div>
			</div>
		</div>
	</div>
</html>