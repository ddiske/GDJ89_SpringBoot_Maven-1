<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 작성</h1>
	<form action="" method="post" enctype="multipart/form-data">
	<input type="hidden" name="boardNum" value="${boardDTO.boardNum }">
	<input type="hidden" name="boardNum" value="${boardDTO.username }">
		<div>
			<input type="text" name="boardTitle" placeholder="글 제목">
		</div>
		<div>
			<textarea rows="10" cols="22" name="boardContents" placeholder="글 내용"></textarea>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
	<c:import url="/WEB-INF/views/templates/websocket.jsp"></c:import>
</body>
</html>