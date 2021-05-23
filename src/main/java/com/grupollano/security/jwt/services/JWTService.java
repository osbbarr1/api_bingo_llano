package com.grupollano.security.jwt.services;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;

public interface JWTService {

	/**
	 * Se encarga de crear el Token y se obtiene el Username y Password
	 * 
	 * @param auth
	 * @return
	 * @throws IOException
	 */
	public String create(Authentication auth) throws IOException;

	/**
	 * validar el token
	 * 
	 * @param token
	 * @return
	 */
	public boolean validate(String token);

	/**
	 * Obtener los Claims
	 * 
	 * @param token
	 * @return
	 */
	public Claims getClaims(String token);

	/**
	 * Obtiene el username y passwor desde el token
	 * 
	 * @param token
	 * @return
	 */
	public String getUsername(String token);

	/**
	 * 
	 * @param token
	 * @return
	 * @throws IOException
	 */
	public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException;

	/**
	 * Encargado de entragar el token
	 * @param token
	 * @return
	 */
	public String resolve(String token);
}
