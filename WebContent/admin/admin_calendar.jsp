<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css" href="<%=root%>/css/fullcalendar.css" />
<link rel="stylesheet" type="text/css" href="<%=root%>/css/fullcalendar.min.css" />
<script type="text/javascript" src="<c:url value='<%=root%>/js/fullcalendar.min.js'/>"></script>
<title>일정관리</title>
</head>
<body>
	<div class="aside">
		<jsp:include page ="/template/admin_aside.jsp"/>
	</div>
	<div id="calender">
	</div>
	
</body>
</html>