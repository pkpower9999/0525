<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form>
		제목 : <input type="text" name="searchTitle"
			value=${(param.searchTitle) != null ? param.searchTitle : ""}>

		<input type="submit" value="검색">
	</form>

	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>등록유저</td>
			<td>등록날짜</td>
			<td>수정한 유저</td>
			<td>수정된 날짜</td>
			<td>상태</td>
		</tr>
		<c:forEach items="${list }" var="post">
			<tr>
				<td>${post.seq }</td>
				<c:choose>
					<c:when test="${post.status == '1'}">
						<td><a href="/view?seq=${post.seq }">${post.title }</a></td>
					</c:when>
					<c:otherwise>
						<td><a href="/view_pwd?seq=${post.seq }">비밀글 입니다</a></td>
					</c:otherwise>
				</c:choose>
				<td>${post.content }</td>
				<td>${post.registuser }</td>
				<td><fmt:formatDate value="${post.registdate }"
						pattern="yyyy-MM-dd HH:mm" /></td>
				<td>${post.updateuser }</td>
				<td><fmt:formatDate value="${post.updatedate }"
						pattern="yyyy-MM-dd HH:mm" /></td>
				<td>${post.status }</td>
			</tr>
		</c:forEach>

	</table>
	<a href="write">글쓰기</a>

	<div>
			<c:if test="${pageMaker.prev}">
				<a href="list${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<a href="list${pageMaker.makeQuery(idx)}">${idx}</a>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<a href="list${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a>
			</c:if>
	</div>

</body>
</html>