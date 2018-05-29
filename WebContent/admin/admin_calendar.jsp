<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
      defaultDate: '2018-03-12',
      lang:'ko',
      navLinks: true, // can click day/week names to navigate views
      businessHours: true, // display business hours
      editable: true,
      events: {
          url: '<%=root%>/eventlist.bt',
          type: 'POST',
          error: function() {
              alert('There was an error while fetching events.');
          }
  		}
    });
});
</script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #calendar {
    width: 60%;
	float: center; 
    margin: 0 auto;
  }

</style>
</head>
<body>
<div class="aside">
		<jsp:include page="/template/admin_aside.jsp" />
</div>
  <div id='calendar'></div>
</body>
</html>