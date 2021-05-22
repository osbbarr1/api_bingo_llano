package com.grupollano.repo.entityuser;

import org.springframework.data.repository.CrudRepository;

import com.grupollano.model.entityuser.Usuario;

public interface IUsuarioDao  extends CrudRepository<Usuario, Long>{

}
