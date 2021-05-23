package com.grupollano.service;

import java.util.List;

import com.grupollano.model.entityuser.Usuario;

public interface IUsuarioServices {

	public List<Usuario> findAll();
	
	public void save(Usuario usuario);

}
