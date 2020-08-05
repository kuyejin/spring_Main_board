 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>   
	    
	    function areaAjax2(){
	    	
	    	  $('form').submit(function(event) { 
	    		  
	    		   event.preventDefault();
	    		  
	    	        var formData= {
	    	            'width'  : $('input[name=width]').val(),
	    	            'height' : $('input[name=height]').val()
	    	        };
	    	 
	    	        $.ajax({
	    	            type        : 'POST',
	    	            url         : $('form').attr('action'),
	    	            data        : formData,
	    	            dataType    : 'json',
	    	            success : function(data) {
	    	                var jsonObj = JSON.parse(data);
	    	                $('body').html("");
	    	                $('body').append(jsonObj);   	                
	    	                
	    	            }, // success    
	    	            error : function(xhr, status) {
	    	                alert(xhr + " : " + status);
	    	            }
	    	        });
	    	 
	    	      
	    	    
	        }); // $.ajax 
	    }
	</script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		areaAjax2();
	});
	</script>
	
	<body>
	
		<h1>넓이구하기Ajax</h1>
		
		<form action="${pageContext.request.contextPath}/restful/recAjax.json">
		  <label for="fname">가로</label>
		  <input type="text" id="width" name="width"><br><br>
		  <label for="lname">세로</label>
		  <input type="text" id="height" name="height"><br><br>
		  <input type="submit" value="전송">
		</form>
	
	</body>
</html>
