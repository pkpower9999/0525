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
	<h1>이름과 비밀번호를 입력해주세요</h1>
	<form action="view_pwd_pro" method="post">
		이름 <input id="registuser" name="registuser" type="text">
		비밀번호 <input id="password" name="password" type="password">
		
		<input type="hidden" id="seq" name="seq" value=${secretVO.seq}>
		<input type="submit" value="submit">
	</form>
</body>
</html>