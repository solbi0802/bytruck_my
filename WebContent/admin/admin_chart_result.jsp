<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="like" value="${requestScope.good}" />
{
 "like_chart":[
  <c:forEach var="i" items="${like}" varStatus="status">
	<c:if test="${status.index > 0}">,</c:if>
	{
	  "id":"${i.user_id}",
	  "like":"${i.good}"
	}
  </c:forEach>
   ]
}
<c:set var="mem" value="${requestScope.mchart}" />
{
 "mem_chart":[
	<c:if test="${status.index > 0}">,</c:if>
	 {
	  "mcount1":"${mem[0]}",
	  "mcount2":"${mem[1]}"
	 }
   ]
}
