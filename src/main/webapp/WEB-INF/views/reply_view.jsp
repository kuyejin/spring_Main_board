<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  <!-- 유니코드 바꿔주세요.  -->
<title>Insert title here</title>
</head>
<body>
	<!-- .do로 확장자 패턴에 있는거 다 url로 바꿔야 합니다. 수많은 클라이언트한테 보여줄 화면을 웹프로그래밍 하는 것. 미리 심어놓음  -->
	<table width="500" cellpadding="0" cellspacing="0" border="1" style="margin-left: auto; margin-right: auto;">
		<form action="reply" method="GET">  <!-- reply.do로 보낸다.  -->
			
			<!-- hidden으로 하는 이유 알아야 합니다. 알아보기-->
			<input type="hidden" name="bId" value="${reply_view.bId}">   <!-- 원본글  -->
			<input type="hidden" name="bGroup" value="${reply_view.bGroup}">
			<input type="hidden" name="bStep" value="${reply_view.bStep}">
			<input type="hidden" name="bIndent" value="${reply_view.bIndent}"> <!-- 안보이게끔 해서 넘기면 되요.  -->
			<tr>
				<td> 번호 </td>
				<td> ${reply_view.bId} </td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td> ${reply_view.bHit} </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="bName" value="${reply_view.bName}"></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="bTitle" value="${reply_view.bTitle}"></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea rows="10"  name="bContent">${reply_view.bContent}</textarea></td>
			</tr>
			<tr >
				<td colspan="2"><input type="submit" value="답변"> 
				<a href="list" >목록</a></td>  <!--  1.submit 답변을 누르게 되면 해당 form----reply로 넘어간다. -->
			</tr> 
		</form>
	</table>
	
</body>
</html>