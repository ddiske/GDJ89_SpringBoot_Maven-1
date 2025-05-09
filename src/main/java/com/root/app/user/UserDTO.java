package com.root.app.user;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO implements UserDetails {
	
	@NotBlank
	private String username;
	@Size(min = 6, max = 18)
	private String password;
	private String passwordCheck;
	@NotBlank
	private String name;
	@NotBlank
	private String phone;
	@NotBlank
	@Email
	private String email;
	@Past
	private Date birth;
	private String fileName;
	private String oriName;
	private List<RoleDTO> list;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> ar = new ArrayList<>();
		
		for(RoleDTO dto : this.list) {
			GrantedAuthority authority = new SimpleGrantedAuthority(dto.getRoleName());
			ar.add(authority);
		}
		return ar;
	}

}
