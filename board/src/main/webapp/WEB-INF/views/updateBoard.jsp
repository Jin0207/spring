<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시물 수정</h3>
	<hr>
	<form action="updateBoard" method="post" enctype="multipart/form-data">
		<input type="hidden" name="no" value="${b.no }">
		제목: <input type="text" name="title" value="${b.title }"><br>
		작성자: <input type="text" name="writer" value="${b.writer }" readonly="readonly"><br>
		게시물비밀번호: <input type="password" name="pwd"><br>
		내용: <br>
		<textarea cols="80" rows="10" name="content">${b.content }</textarea><br>
		파일업로드: <input type="file" name="uploadFile"><br>
		<input type="hidden" name="fname" value="${b.fname }">
		<img src="upload/${b.fname }" width="100" height="100">
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
</body>
</html>