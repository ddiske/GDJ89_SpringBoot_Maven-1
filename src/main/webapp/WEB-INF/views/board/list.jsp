<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>BoardNum</th>
				<th>BoartTitle</th>
				<th>BoardDate</th>
				<th>BoardHit</th>
				<th>Username</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.boardNum }</td>
					<td><a href="./detail?boardNum=${dto.boardNum }">${dto.boardTitle }</a></td>
					<td>${dto.boardDate }</td>
					<td>${dto.boardHit }</td>
					<td>${dto.username }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="./add">글 추가</a>
	</div>
	<c:import url="/WEB-INF/views/templates/websocket.jsp"></c:import>
</body>
</html>