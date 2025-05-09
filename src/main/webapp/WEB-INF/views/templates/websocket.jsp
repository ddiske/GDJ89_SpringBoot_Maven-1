<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	
	/* WebSocket 연결 */
	const websocket = new WebSocket("/ws/chat")

	try {
		websocket.onopen=()=>{
			let m = "Connected";
		// 	console.log(m)
		// 	m = "내 게시글의 답글이 달렸습니다"
		// websocket.send(m)
		console.log(m)
		}
	
		websocket.onmessage=(m)=>{
			let mes = JSON.parse(m.data)
			console.log(mes)
			alert(mes.message)
		}
	
		websocket.onclose=()=>{
			websocket.send("Disconnected")
		}
	} catch (error) {
		
	}
	
</script>