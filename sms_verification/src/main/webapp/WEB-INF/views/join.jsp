<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#form{
		visibility: hidden;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		let num = "";
		let phone = "";
		
		$("#btnSend").click(function() {
			phone = $("#phone").val();
			let data = {phone:phone};
			$.ajax({
				url: "sendNumber",
				data: data,
				success: function(data) {
					num = data;
					alert("인증번호를 전송하였습니다.");
				}
			})//end ajax
		});//end btnSend
		
		$("#btnOK").click(function() {
			let user = $("#user").val();
			if(user == num){
				$("#form").css("visibility","visible");
				$("#phone2").val(phone);
			}else{
				alert("불일치");
			}
		});
		
	});
</script>
</head>
<body>
	<h3>회원가입</h3>
	전화번호 : <input type="text" id="phone">
	<button id="btnSend">인증하기</button><br>
	인증번호 입력: <input type="text" id="user">
	<button id="btnOK">확인</button>
	<hr>
	<form action="join" method="post" id="form">
		아이디: <input type="text" name="id"><br>
		비밀번호: <input type="text" name="pwd"><br>
		이름: <input type="text" name="name"><br>
		전화번호: <input type="text" name="phone" id="phone2"><br>
		이메일: <input type="text" name="email"><br>
		<input type="submit" value="가입">
	</form>
</body>
</html>