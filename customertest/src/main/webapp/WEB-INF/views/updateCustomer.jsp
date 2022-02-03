<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${c.custid } 번 고객정보 수정</h3>
	<hr>
	<form action="updateCustomer.do" method="post">
		<input type="hidden" name="custid" value="${c.custid }"><br>
		고객이름: <input type="text" name="name" value="${c.name }"><br>
		고객주소: <input type="text" name="address" value="${c.address }"><br>
		전화번호: <input type="text" name="phone" value="${c.phone }"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>