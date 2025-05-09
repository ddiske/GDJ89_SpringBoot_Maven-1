package com.root.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private AuthenticationConfiguration configuration;
	
//	@Bean
//	WebSecurityCustomizer customizer() {
//		return (web) -> {
//			web.ignoring()
//			   .requestMatchers(null);
//		};
//	}
	
	@Bean
	SecurityFilterChain chain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors(cors->cors.disable())
					.csrf(csrf->csrf.disable())
					.authorizeHttpRequests(authorizeRequest->{
						authorizeRequest.requestMatchers("/user/check")
										.authenticated()
										.requestMatchers("/manager/check")
										.hasAnyRole("ADMIN", "MANAGER")
										.requestMatchers("/admin/check")
										.hasRole("ADMIN")
										.anyRequest()
										.permitAll();
					})
					.formLogin(formLogin->{
						formLogin.loginPage("/user/login")
								 .defaultSuccessUrl("/")
								 .failureUrl("/user/login")
								 .permitAll();
					})
					.logout(logout->{
						logout.logoutUrl("/user/logout")
							  .logoutSuccessUrl("/")
							  .invalidateHttpSession(true)
							  .permitAll();
					});
					
		
		return httpSecurity.build();
	}

}
