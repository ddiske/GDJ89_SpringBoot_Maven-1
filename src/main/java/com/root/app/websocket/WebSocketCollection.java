package com.root.app.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

public class WebSocketCollection {
	
	public static final Map<String, WebSocketSession> USERS;
	
	static {
		USERS = new HashMap<>();
	}

}
