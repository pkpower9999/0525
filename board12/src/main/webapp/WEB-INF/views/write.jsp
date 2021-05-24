<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
		<script>
			$(function(){
				$("#back").click(function(){
					location.href="list";
				});
			
				$("#registBtn").click(function(){
				if($("#title").val() == "") {
					alert("제목을 입력해주세요");
					return;
				} else if ($("#title").val().length < 2 || $("#title").val().length > 20 ){
					alert("제목은 2~20자 사이로 입력하세요");
					return;
				} else if ($("#content").val() == ""){
					alert("내용을 입력해주세요");
					return;
				} else if ($("#content").val().length > 500 ){
					alert("내용은 500자 이내로 입력해주세요");
					return;
				} else if ($("input[name=registuser]").val() == "") {
					alert("이름을 입력해주세요");
					return;
				} else if ($("input[name=registuser]").val().length < 2 || $("input[name=registuser]").val().length > 20 ) {
					alert("이름은 2~20글자 사이로 입력해주세요");
					return;
				} else if ($("#password").val().length < 2 || $("#password").val().length > 20 ) {
					alert("비밀번호는 2~20글자 사이로 입력해주세요");
					return;
				} else if ($(':radio[name="status"]:checked').length <1) {
					alert("공개, 비공개 여부를 선택해주세요");
					return;
				} else if(confirm("등록하시겠습니까?")) {
					$("#form_target").submit();	
				}
			})
		}); 
		</script>
	</head>
<body>
	<form:form action="write_pro" id="form_target" method="post" modelAttribute="boardVO">
		<input type="hidden" name="mode" value="regist">
		<form:input path="seq" type="hidden" id="seq"/>
			<table>
					<tr>
						<td><h1>글작성</h1></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><form:input path="title" id="title"/></td>
					</tr>	
					<tr>
						<td>내용</td>
						<td><form:textarea path="content" id="content"/></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><form:input path="registuser" id="name"/></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><form:input path="password" type="password" id="password"/></td>
					</tr>
					<tr>
						<td>공개<form:radiobutton path="status"  id="status" value="1"/></td>
						<td>비공개<form:radiobutton path="status"  id="status" value="0"/></td>
					</tr>
			</table>
		
	
		<input type="button" value="등록" id="registBtn">  <!-- 버튼으로 -->
		<input type="button" id="back" value="목록">
	</form:form>
</body>
</html>