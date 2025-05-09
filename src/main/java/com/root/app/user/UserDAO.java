package com.root.app.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface UserDAO {
	
	public UserDTO getDetail(UserDTO userDTO) throws UsernameNotFoundException;
	public int join(UserDTO userDTO) throws Exception;

}
