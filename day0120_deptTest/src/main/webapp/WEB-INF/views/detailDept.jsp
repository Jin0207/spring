<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서상세</h2>
	<a href="updateDept.do?dno=${list.dno }">수정하기</a>
	<a href="deleteDept.do?dno=${list.dno }">삭제하기</a>
	<hr>
	부서번호: ${list.dno }<br>
	부서이름: ${list.dname }<br> 
	부서위치: ${list.dloc }<br>
</body>
</html>