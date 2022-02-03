<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${c.custid } 번 고객정보</h3>
	<a href="updateCustomer.do?custid=${c.custid }">수정</a>
	<a href="deleteCustomer.do?custid=${c.custid }">삭제</a>
	<hr>
	고객번호 : ${c.custid }<br>
	고객이름 : ${c.name }<br>
	주소 : ${c.address }<br>
	전화번호 : ${c.phone}<br>
</body>
</html>