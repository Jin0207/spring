<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>부서 정보 수정하기</h3>
	<hr>
	<form action="updateDept.do" method="post">
		부서번호: ${d.dno }
		<input type="hidden" name="dno" value="${d.dno }"><br>
		부서명: <input type="text" name="dname" value="${d.dname }"><br>
		부서위치: <input type="text" name="dloc" value="${d.dloc }"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>