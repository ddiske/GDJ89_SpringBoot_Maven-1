package com.root.app.home;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.root.app.user.UserDTO;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(@AuthenticationPrincipal UserDTO userDTO, HttpSession httpSession) throws Exception{
		
		httpSession.setAttribute("user", userDTO);
		
		return "home";
	}
	
}
