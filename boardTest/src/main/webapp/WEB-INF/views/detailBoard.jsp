<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${b.title }</h3>
	작성자: ${b.writer}<br>
	등록일: ${b.regdate }<br>
	<a href="updateBoard.do?no=${b.no }">수정</a>
	<a href="deleteBoard.do?no=${b.no }">삭제</a>
	<hr>
	<img src="upload/${b.fname }" with="100" height="100">
	<textarea rows="8" cols="10" readonly="readonly">${b.content }</textarea>
</body>
</html>