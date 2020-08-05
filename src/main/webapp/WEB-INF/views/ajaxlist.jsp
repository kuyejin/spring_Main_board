 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

   function getAjaxList() {
      
      //url 받아오는 주소
      //${pageContext.request.contextPath}
      var url= "${pageContext.request.contextPath}/restful/after.json";
      
         
      //ajax 기본 문법
      $.ajax({
          url: url,
          type: 'GET', //무조건 대문자 넣어줘야 한다. 
          cache: false,//이걸 안쓰거나 ture하면 수정해도 값반영이 잘 안될때가 있음.
          dataType: 'json', //통신에서 내가 데이터를 받을꺼, 받는 타입이 들어감
          //data: "id:"abcd"", // 현재는 넘길 데이터가 없기 떄문에 삭제
          success: function(result){
        	  //alert("성공");
             console.log(result); //배열로 올라간상태
             
             var htmls="";
				
	        	$("#list-table").html("");	

				$("<tr>" , {
					html : "<td>" + "번호" + "</td>"+  // 컬럼명들
							"<td>" + "이름" + "</td>"+
							"<td>" + "제목" + "</td>"+
							"<td>" + "날짜" + "</td>"+				
							"<td>" + "히트" + "</td>"
				}).appendTo("#list-table") // 이것을 테이블에붙임

				if(result.length < 1){
					htmls.push("등록된 댓글이 없습니다.");
				} else {

	                    $(result).each(function(){			                    			                    
		                    htmls += '<tr>';
		                    htmls += '<td>'+ this.bId + '</td>';
		                    htmls += '<td>'+ this.bName + '</td>';
		                    htmls += '<td>'
		         			for(var i=0; i < this.bIndent; i++) { //for 문은 시작하는 숫자와 종료되는 숫자를 적고 증가되는 값을 적어요. i++ 은 1씩 증가 i+2 는 2씩 증가^^
		         				htmls += '-'	
		        			}
		                    htmls += '<a href="${pageContext.request.contextPath}/content_view?bId=' + this.bId + '">' + this.bTitle + '</a></td>';
		                    htmls += '<td>'+ this.bDate + '</td>'; 
		                    htmls += '<td>'+ this.bHit + '</td>';	
		                    htmls += '</tr>';			                    		                   
	                	});	//each end

	                	htmls+='<tr>';
	                	htmls+='<td colspan="5"> <a href="${pageContext.request.contextPath}/write_view">글작성</a> </td>';		                	
	                	htmls+='</tr>';
	                	
				}

				$("#list-table").append(htmls);
				
	        }

		});	// Ajax end
	
	}      
   
   </script>
   
   <script>
      $(document).ready(function(){
         getAjaxList();
      });
   

   </script>


</head>
<body>
   
   <table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1" align="center">
      
   </table>
   
</body>
</html> 