<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 컨트롤러에서 상태유지한 데이터 출력 -->
	${msg }<br>
	<c:forEach items="${list }" var="data">
		${data }<br>
	</c:forEach>
</body>
</html>