<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판 목록</h3>
	<hr>
	<table border="1" width="80%">
		<a href="insertBoard.do">게시글 작성</a>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.no }</td>
				<td><a href="detailBoard.do?no=${b.no }">${b.title }</a></td>
				<td>${b.writer }</td>
				<td>${b.hit }</td>
				<td>${b.regdate }</td>
			</tr>
		</c:forEach>
	</table>
		
</body>
</html>