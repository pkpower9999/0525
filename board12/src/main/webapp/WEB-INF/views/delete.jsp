<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
		<script>
			$(function(){
				
			})
			
		
		</script>
		
		
		
	</head>
<body>
	<form action="delete_pro" method="post">
	
		비밀번호 <input id="password" name="password" type="password">
		
		<input type="hidden" id="seq" name="seq" value=${deleteBoard.seq}>
		<input type="submit" value="submit">
	</form>
</body>
</html>