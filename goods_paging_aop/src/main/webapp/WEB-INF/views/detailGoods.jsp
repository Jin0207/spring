<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${g.no}번 상품, ${g.name }</h3>
	<a href="updateGoods?no=${g.no }">수정</a>
	<a href="deleteGoods?no=${g.no }">삭제</a>
	<hr>
	상품가격: ${g.price } 원<br>
	상품수량: ${g.qty } 개<br>
	<img src="images/${g.fname }" width="100" height="100">
</body>
</html>