<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시물 상세보기</h3>
	<a href="updateBoard?no=${b.no }">수정</a>
	<hr>
	번호: ${b.no }<br>
	제목: ${b.title }<br>
	작성자: ${b.writer }<br>
	등록일: ${b.regdate }<br>
	조회수: ${b.hit }<br>
	내용: <br>
	<textarea cols="80" rows="10" readonly="readonly">${b.content }</textarea><br>
	<img src="upload/${b.fname }" width="300" height="300">
</body>
</html>