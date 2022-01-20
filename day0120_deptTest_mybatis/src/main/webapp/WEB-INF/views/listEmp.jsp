<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>직원 정보</h3>
	<hr>
	<table border="1" width="80%">
		<tr>
			<th>사원번호</th>
			<th>이름</th>
		</tr>
		<c:forEach var="e" items="${list }">
			<tr>
				<td>${e.eno }</td>
				<td>${e.ename }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>