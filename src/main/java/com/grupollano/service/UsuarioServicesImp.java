package com.grupollano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupollano.model.entityuser.Usuario;
import com.grupollano.repo.entityuser.IUsuarioDao;



@Service
public class UsuarioServicesImp implements IUsuarioServices{
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}

}
