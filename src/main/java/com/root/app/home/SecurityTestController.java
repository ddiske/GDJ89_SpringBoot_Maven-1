package com.root.app.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SecurityTestController {
	
	@GetMapping("/admin/check")
	public void admin() throws Exception{
		log.info("Admin");
	}
	
	@GetMapping("/manager/check")
	public void manager() throws Exception{
		log.info("Manager");
	}
	
	@GetMapping("/user/check")
	public void user() throws Exception{
		log.info("User");
	}

}
