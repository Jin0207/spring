<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>고객 상세정보</h3>
	<hr>
	고객번호: ${c.custid }<br>
	고객명: ${c.name }<br>
	고객주소 ${c.address }<br>
	고객전화: ${c.phone }
	<hr>
	<a href="updateCustomer.do?custid=${c.custid }">수정</a>
	<a href="deleteCustomer.do?custid=${c.custid }">삭제</a>
</body>
</html>