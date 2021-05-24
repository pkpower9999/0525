<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
		<script>
			$(function(){
				$("#modi").click(function(){
					if(confirm("수정하시겠습니까?")) {
						$("#target").submit();	
					}
				})
						
				$("#back").click(function(){
					location.href="list";
				});	
						
		})
		
		</script>
	</head>
<body>
	<h1>글 수정페이지</h1>

	<form id="target" action="modify_pro" method="post">
			<input type="hidden" id="md" name="mode" value="modify">
			<input type="hidden" id="seq" name="seq" value=${modifyBoard.seq }>
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value=${modifyBoard.title }></td>
				</tr>	
				<tr>
					<td>내용</td>
					<td><textarea type="text" name="content">${modifyBoard.content }</textarea></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="registuser" value=${modifyBoard.registuser }></td>
				</tr>
				
				<c:if test="${modifyBoard.status == 1}">
				<tr>
					<td>공개<input type="radio" name="status" id="public" value="1" checked ></td> 
					<td>비공개<input type="radio" name="status" id="secret" value="0"></td>
				</tr>
				</c:if>
				<c:if test="${modifyBoard.status == 2}">
				<tr>
					<td>공개<input type="radio" name="status" id="public" value="1"></td> 
					<td>비공개<input type="radio" name="status" id="secret" value="0" checked ></td>
				</tr>
				</c:if>
			</table>
			<br>
				<input type="button" value="수정" id="modi">  <!-- 버튼으로 -->
				<input type="button" id="back" value="목록">
				<input type="button" value="삭제" id="delete_btn">
				
	</form>	
	
</body>
</html>