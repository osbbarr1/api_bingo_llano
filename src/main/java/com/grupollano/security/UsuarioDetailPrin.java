package com.grupollano.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.grupollano.model.entityuser.Usuario;

public class UsuarioDetailPrin implements UserDetails{
	
	private Usuario usuario;
	
	

	public UsuarioDetailPrin(Usuario usuario) {
		this.usuario = usuario;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> authorities = new ArrayList<>();



//	        // Extract list of permissions (name)
//	        this.user.getPermissionList().forEach(p -> {
//	            GrantedAuthority authority = new SimpleGrantedAuthority(p);
//	            authorities.add(authority);
//	        });
//
//	        // Extract list of roles (ROLE_name)
//	        this.user.getRoleList().forEach(r -> {
//	            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
//	            authorities.add(authority);
//	        });

	        return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

	private static final long serialVersionUID = 1L;

}
