<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상품 목록</h3>
	<a href="insertGoods">등록</a>
	<form action="listGoods" method="post">
		상품이름 : <input type="search" name="keyword">
		<input type="submit" value="검색"> 
	</form>
	<hr>
	<table border="1" width="80%">
		<tr>
			<th>상품 번호</th>
			<th>상품 이름</th>
		</tr>
		<c:forEach var="g" items="${list }">
			<tr>
				<td>${g.no }</td>
				<td>
					<a href="detailGoods?no=${g.no }">${g.name }</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<c:forEach var="i" begin="1" end="${totalPage }">
		<a href="listGoods?pageNUM=${i }">${i }</a>&nbsp;&nbsp;
	</c:forEach>
</body>
</html>