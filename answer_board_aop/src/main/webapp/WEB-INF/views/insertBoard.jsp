<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${head }</h3>
	<hr>
	<form action="insertBoard" method="post" enctype="multipart/form-data">
		<!-- 새글: 0, 답글: 부모글의 번호 전달 -->
		<input type="hidden" name="no" value="${no }">
		제목: <input type="text" name="title" value="${title }"><br>
		작성자: <input type="text" name="writer"><br>
		비밀번호: <input type="password" name="pwd"><br>
		내용:<br>
		<textarea name="content" rows="10" cols="80"  ></textarea><br>
		파일업로드: <input type="file" name="uploadFile"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>