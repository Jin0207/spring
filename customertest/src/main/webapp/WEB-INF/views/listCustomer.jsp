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
	<h3>고객 목록</h3>
	<a href="insertCustomer.do">신규고객등록</a>
	<hr>
	<table border="1" width="80%">
		<tr>
			<td>고객번호</td>
			<td>고객이름</td>
		</tr>
		<c:forEach var="c" items="${list }">
			<tr>
				<td>${c.custid }</td>
				<td>
					<a href="detailCustomer.do?custid=${c.custid }">${c.name }</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>