<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="user"/>
	</sec:authorize>
	<div>
		Name : ${user.name }
	</div>
	<div>
		Phone : ${user.phone }
	</div>
	<div>
		Email : ${user.email }
	</div>
	<div>
		Birth : ${user.birth }
	</div>
</body>
</html>