package com.root.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public String login() throws Exception {
		return "user/login";
	}
	
	@GetMapping("join")
	public String join(@ModelAttribute UserDTO userDTO) throws Exception {
		return "user/join";
	}
	
	@PostMapping("join")
	public String join(@Validated UserDTO userDTO, BindingResult bindingResult, MultipartFile multipartFile) throws Exception {
		
		if(userService.validCheck(userDTO, bindingResult)) {
			return "user/join";
		}
		userService.join(userDTO, multipartFile);
		return "user/login";
	}
	
	@GetMapping("mypage")
	public String mypage() throws Exception {
		return "user/mypage";
	}
	
}
