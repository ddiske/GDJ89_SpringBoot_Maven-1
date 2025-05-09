package com.root.app.websocket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
	
	private String sender;
	private String receiver;
	private String message;

}
