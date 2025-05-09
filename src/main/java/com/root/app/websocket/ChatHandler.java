package com.root.app.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ChatHandler implements WebSocketHandler {
	
//	private Map<String, WebSocketSession> users = new HashMap<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		users.put(session.getPrincipal().getName(), session);
//		log.info("users : {}", users.size());
		
		WebSocketCollection.USERS.put(session.getPrincipal().getName(), session);
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		
//		ObjectMapper mapper = new ObjectMapper();
//		MessageDTO messageDTO = new MessageDTO();
//		messageDTO.setMessage("답글 달림");
//		
//		if(session == null) {
//			users.get(message.getPayload()).sendMessage(new TextMessage(mapper.writeValueAsString(messageDTO)));
//		}
//		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
//		users.remove(session.getPrincipal().getName());
		WebSocketCollection.USERS.remove(session.getPrincipal().getName());
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
