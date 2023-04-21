package com.team.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import com.team.domain.MusicUserAuth;
import com.team.domain.MusicUsers;
import com.team.mapper.MusicUserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MusicUserServiceImpl implements MusicUserService {

	@Autowired
	private MusicUserMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public int join(MusicUsers user) throws Exception {
		
		String plainPw = user.getUserPw();
		String encodedPw = passwordEncoder.encode(plainPw);
		user.setUserPw(encodedPw);

		int result = mapper.join(user);

		String userId = user.getUserId();
		
		if( result > 0 ) {
			MusicUserAuth userAuth = new MusicUserAuth();
			userAuth.setUserId(userId);
			userAuth.setAuth("ROLE_USER");
			mapper.insertAuth(userAuth);
		}

		return result;
	}
	
	@Override
	public HttpSession tokenAuthenticaion(MusicUsers user, HttpServletRequest request) throws Exception {
		String username = user.getUserId();
		String password = user.getUserPwChk();
		log.info("username : " + username);
		log.info("password : " + password);
		
		HttpSession session = request.getSession();
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken( username, password );
		
		// 토큰에 요청정보를 등록
		token.setDetails( new WebAuthenticationDetails(request) );
		
		// 토큰을 이용하여 인증 (로그인)
		Authentication authentication = authenticationManager.authenticate(token);
		
		User authUser = (User) authentication.getPrincipal();
		log.info("인증된 사용자 아이디: " + authUser.getUsername());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return session;
	}
	
}