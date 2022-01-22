<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 파일업로드를위한 인코딩타입설정 -->
	<form action="insertGoods.do" method="post" enctype="multipart/form-data">
		상품번호: <input type="text" name="no"> <br>
		상품이름: <input type="text" name="name"> <br>
		상품가격: <input type="text" name="price"> <br>
		상품수량: <input type="text" name="qty"> <br>
		<!--type="file"의 name은 VO에서 설정한 변수명을 name으로 -->
		<!-- 업로드할 파일의 입력상자의 이름은 vo의 multipartFile의 이름과 동일하게 설정 -->
		상품이미지: <input type="file" name="uploadFile"> <br>
		<input type="submit" value="등록">
	</form>
</body>
</html>