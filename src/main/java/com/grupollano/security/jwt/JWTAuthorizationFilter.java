package com.grupollano.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.grupollano.security.jwt.services.JWTService;
import com.grupollano.security.jwt.services.JWTServiceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	
	private JWTService jwtServices;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTService  jwtServices) {
		super(authenticationManager);
		this.jwtServices = jwtServices;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader(JWTServiceImpl.HEADER_STRING);
			if (!requiresAuthentication(header)) {
			chain.doFilter(request, response);
			return;
		}
			
			UsernamePasswordAuthenticationToken authentication = null;
			
			 
			if(jwtServices.validate(header)) {
				authentication = new UsernamePasswordAuthenticationToken(jwtServices.getUsername(header),null,jwtServices.getRoles(header));
			}
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(request, response);
			
	}
	
	protected  boolean requiresAuthentication(String header) {
		if(header == null || !header.startsWith(JWTServiceImpl.TOKEN_PREFIX)) {
			return false;
		}
		return true;
	}
	
	
	

}
