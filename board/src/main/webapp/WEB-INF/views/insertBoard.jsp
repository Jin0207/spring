<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시물 등록</h3>
	<hr>
	<form action="insertBoard" method="post" enctype="multipart/form-data">
		제목: <input type="text" name="title"><br>
		작성자: <input type="text" name="writer"><br>
		내용: <br>
		<textarea cols="80" rows="10" name="content"></textarea><br>
		파일업로드: <input type="file" name="uploadFile"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>