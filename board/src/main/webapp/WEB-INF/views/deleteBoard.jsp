<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시물 삭제</h3>
	<hr>
	<form action="deleteBoard" method="post">
		<input type="hidden" name="no" value="${no }">
		게시물 비밀번호: <input type="password" name="pwd">
		<input type="submit" value="삭제">
	</form>
</body>
</html>