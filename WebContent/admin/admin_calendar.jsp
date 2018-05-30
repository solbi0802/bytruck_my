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

    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month'
      },
      defaultDate: '2018-06-01',
      lang:'ko',
      navLinks: true, // can click day/week names to navigate views
      businessHours: true, // display business hours
      editable: true,
      events: function(start, end, timezone, callback) {  
    	//--start, end 는 ui상에 보이는 시작일과 마지막일이다.
    	//-- ui상에 사작일은 현재월의 1일이 아니라 전달의 날짜가 올수도 있다.
    	//-- 마찬가지로 end일은 현재월의 마지막일이 아니라 다음달의 날짜가 올수도 있다.
    	//-- 달력에서 월을 변경하게 되면 변경된 월의 현재 날짜가 오거나
    	//-- 변경된 월의 1일이 온다.
    		$.ajax({
    			url: '<%=root%>/calendar.bt',
    			dataType: 'json',
    			type : 'post', 
    				success: function(result) {
    					var events = [];
    					$.each(result.calendar, function(index,cal){
    						events.push({
    							title:cal.title,
    							start:cal.date,
    							detail:cal.detail,
    							color:'#C2185B'
    						});
    					});
    				},
    				error:function(){
    					 alert('에러발생');
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

</style>
<body>
<div class="aside">
		<jsp:include page="/template/admin_aside.jsp" />
</div>
  <div id='calendar'></div>
</body>
</html>