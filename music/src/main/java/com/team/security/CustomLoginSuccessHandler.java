package com.team.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request
									  , HttpServletResponse response
									  , Authentication authentication) throws ServletException, IOException {
		
		log.info("인증 처리 성공...");

		String rememberId = request.getParameter("remember-id"); 	
		String username = request.getParameter("username");			
		log.info("rememberId : " + rememberId);
		log.info("username : " + username);
		
		if( rememberId != null && rememberId.equals("on") ) {
			Cookie cookie = new Cookie("remember-id", username);
			cookie.setMaxAge(60*60*24*10);		
			cookie.setPath("/");
			response.addCookie(cookie);
		} 
		else {
			Cookie cookie = new Cookie("remember-id", null);
			cookie.setMaxAge(0);		
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		
		
		User user = (User) authentication.getPrincipal();
		
		log.info("아이디 : " + user.getUsername());
		log.info("패스워드 : " + user.getPassword());			
		log.info("권한 : " + user.getAuthorities());
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
