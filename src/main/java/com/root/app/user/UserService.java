package com.root.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDAO userDAO;
	
	public boolean validCheck(UserDTO userDTO, BindingResult bindingResult) throws Exception {
		boolean check = false;
		check = bindingResult.hasErrors();
		
		// password가 일치하는 지 검증
		if(!userDTO.getPassword().equals(userDTO.getPasswordCheck())) {
			check = true;
			bindingResult.rejectValue("passwordCheck", "userDTO.password.notEqual");
		}else {
			check = false;
		}
		
		// ID 중복 검사
		UserDTO checkVO = userDAO.getDetail(userDTO);
		if(checkVO != null) {
			check = true;
			bindingResult.rejectValue("username", "userDTO.username.equal");
		}else {
			check = false;
		}
		
		return check;
	}
	
	public void join(UserDTO userDTO, MultipartFile multipartFile) throws Exception {
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		userDAO.join(userDTO);
	}

}
