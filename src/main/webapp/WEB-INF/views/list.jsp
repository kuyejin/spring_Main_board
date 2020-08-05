<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!-- view 부분이다 -->
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv = "Content-Type" content="text/html; charset=EUC-KR">
		<title>Board List</title>
	</head>
	
	<body>
	    <table width="500" cellpadding ="0" cellspacing ="0" border="1" align="center">
	        <tr>
	            <td>번호</td>
	            <td>이름</td>
	            <td>제목</td>
	            <td>날짜</td>
	            <td>히트</td>
	        </tr>
	        
	        <c:forEach items ="${list}" var = "dto"> <!-- dtos --> 
	        
	        <tr>
	            <td>${dto.bId}</td>
	            <td>${dto.bName}</td>
	            
	            <td>
	                <c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
	                <a href= "content_view?bId=${dto.bId}">${dto.bTitle}</a> <!-- GET방식으로 bId를 가져온다. -->
	                 <!-- 제목에 링크달기 - 컨텐트뷰와 연결  -->
	            </td>
	            
	            <td>${dto.bDate}</td>
	            <td>${dto.bHit}</td>    
	        </tr>
	        
	        </c:forEach>    
	        
	        <tr>
	            <td colspan = "5"><a href ="write_view">글작성</a></td>
	 
	    </table>
	
	</body>
</html>