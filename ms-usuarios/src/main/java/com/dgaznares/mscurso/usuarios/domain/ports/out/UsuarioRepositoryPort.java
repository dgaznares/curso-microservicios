package com.dgaznares.mscurso.usuarios.domain.ports.out;

import java.util.List;

import com.dgaznares.mscurso.usuarios.domain.model.UsuarioDto;

public interface UsuarioRepositoryPort {
	
	public List<UsuarioDto> findAllUsers();
	public UsuarioDto getUser(Integer id);
	public UsuarioDto createUser(UsuarioDto user);
	public Integer deleteUser(Integer id);

}
