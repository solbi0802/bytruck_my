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
<script>
$(function() {
	$.ajax({
        url: '<%=root%>/grank.bt',
        dataType: 'json',
        success: function(data) {
      	var like = []; var label = [];
        for(var i = 0; i < data.like_chart.length; i++) {
        	label.push("아이디: " + data.like_chart[i].id);
        	like.push(data.like_chart[i].like);
        	}
       var lct = document.getElementById("likeChart");
	   var myChart = new Chart(lct, {
    		type: 'bar',
    		label:'test',
    		data:{
    			  labels:label,
    			  datasets:[{
    				  label:"좋아요",
    				  data:like,
    				  backgroundColor: [
    					  	'rgba(255, 206, 86, 0.2)',
    		                'rgba(54, 162, 235, 0.2)',
    		                'rgba(255, 25, 255, 0.2)',
    		                'rgba(75, 192, 192, 0.2)',
    		                'rgba(255, 99, 132, 0.2)'
    		            ],
    		         borderColor: [
    		        	 'rgba(255, 206, 86, 1)',
 		                 'rgba(54, 162, 235, 1)',
 		                 'rgba(255, 25, 255, 1)',
 		                 'rgba(75, 192, 192, 1)',
 		                 'rgba(255, 99, 132, 1)'
    		        	 ],
    		        borderWidth: 1
    			  }]
    		},
    options: {
    	animation: {
    		animateScale: true
    	},
    	responsive: false,
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                	}
              	}]
              }
    		}
		 });
	  }
	});
});
</script>
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
					<canvas id="likeChart" width="400" height="400"></canvas>
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