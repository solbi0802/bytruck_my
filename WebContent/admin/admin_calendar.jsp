<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<%
String root = request.getContextPath();
%>
<html lang="ko">
<head>
<meta charset='utf-8' />
<link href='<%=root%>/css/fullcalendar.css' rel='stylesheet' />
<link href='<%=root%>/css/fullcalendar.min.css' rel='stylesheet' />
<link href='<%=root%>/css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<script src='<%=root%>/js/jquery.min.js'></script>
<script src='<%=root%>/js/jquery-ui.min.js'></script>
<script src='<%=root%>/js/moment.min.js'></script>
<script src='<%=root%>/js/fullcalendar.min.js'></script>
<script src='<%=root%>/js/locale-all.js'></script>

<script>
$(document).ready(function() {
	var events = [];
    $('#calendar').fullCalendar({
	      header: {
	        left: 'prev,next today',
	        center: 'title',
	        right: 'month'
	      },
	      allDa: true,
	      defaultDate: '2018-06-01',
	      lang:'ko',
	      navLinks: true, // can click day/week names to navigate views
	      businessHours: true, // display business hours
	      editable: true,
	      events:function(start, end, timezone, callback) {
	    	  		$.ajax({
	  				type : 'post',
					url: '<%=root%>/calendar.bt',
					dataType:'json',
					success: function(result) {
					var events = [];
					console.log("성공!");
					$.each(result.calendar, function(index, cal) {
						events.push({
							title:cal.title,
							start:cal.start,
							color:'#C2185B',
						});
					});
				}, error:function(request,status,error){
			       		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	   }
	});
}); 
</script>
</head>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #calendar {
    width: 65%;
	float: center; 
    margin: 0 auto;
  }
   
  #teat {
   padding-top:30dp;
   float: center;
   display: none;
  }

</style>
<body>
<div class="aside">
		<jsp:include page="/template/admin_aside.jsp" /> 
</div>
  <div id='test'></div>
  <div id='calendar' ></div>
</body>
</html>