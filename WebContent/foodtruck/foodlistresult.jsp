<%@page import="vo.Foodtruck_Location"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String root = request.getContextPath(); %>
<%
String result = (String)request.getAttribute("result");
if(result != null){
%><%=result %>
<%
  return;
}
List<Foodtruck_Location>list = (List)request.getAttribute("list");
%>
<div class="list">
<%
for(int i=0; i<list.size(); i++){
	Foodtruck_Location fc =  list.get(i);
	String imgpath = fc.getImgpath();
	String title = fc.getTitle();
	
    if(imgpath != null){
         int lastIndex = imgpath.lastIndexOf("\\");
         imgpath = imgpath.substring(lastIndex+1);
    }
%>	
 <div class="col-lg-3">
  <div class="product-item">
  	<img src="<%=root%>/upload/<%=imgpath%>" class="img-rounded"
				alt="NO IMAGE" height="220" width="250"></img>
	<div class="info">
  		<h3 class="title"><%=title%></h3>
  	</div>
  </div>
 </div> 		
<%
}
 %>
 </div>