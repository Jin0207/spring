<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상품등록</h3>
	<hr>
	<form action="insertGoods" method="post" enctype="multipart/form-data">
		상품 번호: <input type="text" name="no"><br>
		상품 이름: <input type="text" name="name"><br>
		상품 가격: <input type="text" name="price"><br>
		상품 수량: <input type="text" name="qty"><br>
		상품 이미지: <input type="file" name="uploadFile"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>