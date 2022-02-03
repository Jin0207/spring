<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상품 상세정보 수정</h3>
	<hr>
	<img src="images/${g.fname }" width="50" height="50"><br>
	<form action="updateGoods" method="post" enctype="multipart/form-data">
		<input type="hidden" name="no" value="${g.no }"><br>
		상품명: <input type="text" name="name" value="${g.name }"><br>
		상품가격: <input type="text" name="price" value="${g.price }"><br>
		상품수량: <input type="text" name="qty" value="${g.qty }"><br>
		상품이미지: <input type="file" name="uploadFile"><br>
		<input type="hidden" name="fname" value="${g.fname }">
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
</body>
</html>