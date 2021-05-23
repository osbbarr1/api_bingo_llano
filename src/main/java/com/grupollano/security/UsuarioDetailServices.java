package com.grupollano.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupollano.model.entityuser.Usuario;
import com.grupollano.repo.entityuser.IUsuarioDao;

@Service("UsuarioDetailServices")
public class UsuarioDetailServices implements UserDetailsService {
	

	@Autowired
	private IUsuarioDao usuarioDao;

	private Logger logger = LoggerFactory.getLogger(UsuarioDetailServices.class);

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = (Usuario) usuarioDao.findByUsername(username);
		System.out.println("Leggo al detailServices====> ");
		if (user == null) {
			logger.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
			throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
		}

		List<GrantedAuthority> rol = new ArrayList<GrantedAuthority>();

//		for(BingoRol role: user.getRol_id()) {
//			rol.add(new SimpleGrantedAuthority());
//		}

		rol.add(new SimpleGrantedAuthority("Admin"));
		rol.add(new SimpleGrantedAuthority("Superadmin"));
		rol.add(new SimpleGrantedAuthority("Jefe"));
		rol.add(new SimpleGrantedAuthority("caja"));
		// UserDetails userDetails = new User(user.getUsername(), user.getPassword(),
		// rol);
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, rol);
	}

}
