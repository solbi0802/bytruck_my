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
	        left: 'month',
	        center: 'title',
	        right: 'prev,next today'
	      },
	      defaultDate: '2018-06-01',
	      lang:'ko',
	      navLinks: true, // can click day/week names to navigate views
	      businessHours: true, // display business hours
	      editable: false,
	      events: 
              function(start, end, timezone, callback) {
                  $.ajax({
                    url: '${pageContext.request.contextPath}/calendar.bt',
                    dataType: 'json',
                    data: {
                      start: start.unix(),
                      end: end.unix()
                    },
                    success: function(data) {
                      var events = [];
                      $.each(data.calendar, function(index,cal){
                    events.push({
                                title: cal.title,
                                start: cal.start,
                                description: 'This is a cool event',
                                /* description: "[일정상세] "+contents, */
                                contents: cal.detail,
                                color : "#f49542"
                              });
                    });
                 callback(events);
                       
                    }
                  });
           },
          eventRender : function(event, element) {
 	   $(element).tooltip({title: event.title});
 	  /*  element[0].title = event.title; */
 	  /*  element[1].detail = event.detail; */
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

  #calendar{
    width: 60%;
	float: center; 
    margin: 0 auto;
  }
</style>
<body>
<div class="aside">
		<jsp:include page="/template/admin_aside.jsp" /> 
</div>
<div id='calendar' ></div>
</body>
</html>