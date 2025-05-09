<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form:form modelAttribute="userDTO" action="./join" method="post" enctype="multipart/form-data">
	<div>
		ID : <form:input path="username"/>
		<form:errors path="username"></form:errors>
	</div>
	<div>
		PW : <form:password path="password"/>
		<form:errors path="password"></form:errors>
	</div>
	<div>
		PWCheck : <form:password path="passwordCheck"/>
		<form:errors path="passwordCheck"></form:errors>
	</div>
	<div>
		Name : <form:input path="name"/>
		<form:errors path="name"></form:errors>
	</div>
	<div>
		Phone : <form:input path="phone"/>
		<form:errors path="phone"></form:errors>
	</div>
	<div>
		Email : <form:input path="email"/>
		<form:errors path="email"></form:errors>
	</div>
	<div>
		Birth : <input type="date" name="birth">
		<form:errors path="birth"></form:errors>
	</div>
	<div>
		<input type="file" name="multipartFile">
	</div>
	<div>
		<button type="submit">가입</button>
	</div>
	</form:form>
</body>
</html>