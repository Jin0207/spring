<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�μ����</h2>
	<hr>
	<a href="insertDept.do">���</a>
	<table border="1" width="80%">
		<tr>
			<td>�μ���ȣ</td>
			<td>�μ���</td>
			<td>�μ���ġ</td>
		</tr>
		<c:forEach var="d" items="${list }">
			<tr>
				<td>${d.dno }</td>
				<td>${d.dname }</td>
				<td>${d.dloc }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>