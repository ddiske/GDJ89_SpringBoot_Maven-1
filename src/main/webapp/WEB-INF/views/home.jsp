<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello ${user.username }!</h1>
	<c:if test="${empty user }">
		<a href="/user/login">로그인</a>
		<a href="/user/join">회원가입</a>
	</c:if>
	<c:if test="${not empty user }">
		<a href="/user/logout">로그아웃</a>
		<a href="/user/mypage">내 정보</a>
	</c:if>
	
	<div>
		<a href="/qna/list">QNA</a>
	</div>
	
	<c:import url="/WEB-INF/views/templates/websocket.jsp"></c:import>
</body>
</html>