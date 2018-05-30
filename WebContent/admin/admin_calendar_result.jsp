<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<!-- json 형식으로 데이터를 받아옴  -->
<c:set var = "calendar" value = "${requestScope.calendar}"/>
{
<c:if test="${!empty calendar}">
"calendar":[
	<c:forEach var="i" items="${calendar}" varStatus="status">
	  <c:if test="${status.index != 0}">,</c:if>
	{"no":"${i.no}", 
 	"user_id":"${i.user_id}",
 	"title":"${i.title}",
 	"detail":"${i.detail}",
 	"date":"${i.event_date}"
	}
   </c:forEach>
	]
</c:if>
}
</head>
</html>