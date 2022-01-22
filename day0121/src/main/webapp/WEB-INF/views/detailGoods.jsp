<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상품 상세보기</h3>
	<hr>
	상품번호: ${g.no }<br>
	상품명: ${g.name }<br>
	상품가격: ${g.price }<br>
	상품수량: ${g.qty }<br>
	<img alt="상품사진" src="images/${g.fname }" width="100" height="100">
	<hr>
	<a href="updateGoods.do?no=${g.no }">수정</a>
	<a href="deleteGoods.do?no=${g.no }">삭제</a>
</body>
</html>