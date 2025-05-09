<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${dto.boardNum }</div>
	<div>${dto.boardTitle }</div>
	<div>${dto.boardContents }</div>
	<div>${dto.boardDate }</div>
	<div>${dto.boardHit }</div>
	<div>${dto.username }</div>
	<div>
		<a href="./reply?boardNum=${dto.boardNum }&username=${dto.username}" id="reply">답글 작성</a>
	</div>
	<c:import url="/WEB-INF/views/templates/websocket.jsp"></c:import>
</body>
</html>