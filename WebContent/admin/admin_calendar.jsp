<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<c:url value='<%=root%>/js/jquery.min.js'/>">	
</script>
<script type="text/javascript"
	src="<c:url value='<%=root%>/js/jquery-ui.min.js'/>">	
</script>
<script type="text/javascript"
	src="<c:url value='<%=root%>/js/fullcalendar.min.js'/>">	
</script>
<script type="text/javascript"
	src="<c:url value='<%=root%>/js/moment.min.js'/>">	
</script>
<link rel="stylesheet" type="text/css"
	href="<%=root%>/css/fullcalendar.css" />
<link rel="stylesheet" type="text/css"
	href="<%=root%>/css/fullcalendar.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=root%>/css/fullcalendar.print.min.css"/>
<title>일정관리</title>
</head>
<style>
body {
	padding-top: 5%;
}
#calendar { 
max-width: 900px; 
margin: 0 auto;
float:center;} 

</style>
<body>
	<div class="aside">
		<jsp:include page="/template/admin_aside.jsp" />
	</div>
	<div id="calender"></div>
<script>
$(document).ready(function() {
    var lang_cd = 'ko';
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,listMonth'
        },
        defaultDate: moment().format('YYYY-MM-DD'),
        locale: initialLocaleCode,
        editable: true,
        navLinks: true,
        eventLimit: true,
        events: function(start, end, timezone, callback) {
            $.ajax({
                url: '/test/eventAll.do',
                type : 'post',
                data : {EVENT_CODE : '11', LANG : lang_cd, startDate : start.format(), endDate : end.format() },
                dataType: 'json',
                success: function(data) {
                    var events = [];
                    $(data).each(function() {
                        events.push({
                            title: $(this).attr('title'),
                            start: $(this).attr('start'),
                            end: $(this).attr('end'),
                            url: "/test/eventDetail.do?id="+$(this).attr('id')+"&amp;lang="+$(this).attr('lang')+"&amp;start="+$(this).attr('start')+"&amp;end="+$(this).attr('end'),
                            lang : $(this).attr('lang')
                        });
                    });
                    callback(events);
                }
            });
 
        },
        loading: function(bool) {
            $('#loading').toggle(bool);
        }
    });
    
/*     $('#calendar').fullCalendar({
        eventSources: [
            '/eventSource1.json',
            '/eventSource2.json'
        ]
    }); */
});
</script>
</body>
</html>