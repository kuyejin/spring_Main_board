<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
	function makeList() {
		var htmls="";
		
    	$("#list-table").html(""); // 자식태그 가져와.초기화시킴.

		$("<tr>" , {
			html : "<td>" + "번호" + "</td>"+  // 컬럼명들
					"<td>" + "이름" + "</td>"+
					"<td>" + "제목" + "</td>"+
					"<td>" + "날짜" + "</td>"+				
					"<td>" + "히트" + "</td>"
		}).appendTo("#list-table") // 이것을 테이블에붙임
		
		//jsp 값을 javascript 에서 쓸수 있는 방법(0728메모장에 입력되어있다.)
		
			//javascript 안에 jstl 문법이 들어 갔음
			//html 초기화 시켜놨다. tr생성하고 td  htmls태그로 계속 붙이고 있다. 마지막에 list-table 을 htmls태그에 넣는다.
			<c:forEach var="boardVO" items="${list}" >
					htmls += '<tr>';
	            	htmls += '<td>'+ '${boardVO.bId}' + '</td>';
	            	htmls += '<td>'+ '${boardVO.bName}'+ '</td>';
	            	htmls += '<td>';
	            	<c:forEach begin="1" end="${boardVO.bIndent}">
	            		htmls += '-';
	            	</c:forEach>
	            	htmls += '<a href="${pageContext.request.contextPath}/content_view?bId=' + '${boardVO.bIndent}' + '">' + '${boardVO.bTitle}' + '</a></td>';
		            htmls += '/<td>';
		            htmls += '${boardVO.bDate}';
		            htmls += '${boardVO.bHit}';
	            
	        </c:forEach>    
	        
	        $("#list-table").append(htmls);
	}//end getList()
	
	</script>
		
	<script>
		$(document).ready(function(){
			makeList();
		});
	</script>
</head>
<body>
	<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
	</table>
</body>
</html>