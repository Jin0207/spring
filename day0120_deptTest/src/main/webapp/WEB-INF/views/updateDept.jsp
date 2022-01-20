<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>부서 수정</h3>
	<form action="updateDept.do" method="post">
		부서번호: <input type="text" name="dno" value="${list.dno }" readonly="readonly"><br>
		부서명: <input type="text" name="dname" value="${list.dname }"><br>
		부서위치: <input type="text" name="dloc" value="${list.dloc }"><br>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>