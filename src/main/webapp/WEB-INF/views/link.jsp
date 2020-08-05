<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>link</title>
</head>
<body>
	<%
	   String path = request.getContextPath();
	%>
	
	<a href="<%=path%>/list">게시판 리스트</a><br>
	<a href="<%=path%>/area">넓이구하기</a>
	


</body>
</html>
