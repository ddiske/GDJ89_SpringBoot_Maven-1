<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/user/login" method="post">
		ID : <input type="text" name="username">
		PW : <input type="password" name="password">
		<button type="submit">로그인</button>
	</form>
</body>
</html>