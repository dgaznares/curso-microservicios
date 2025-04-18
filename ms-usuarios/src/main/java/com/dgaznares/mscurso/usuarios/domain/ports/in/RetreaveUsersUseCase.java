package com.dgaznares.mscurso.usuarios.domain.ports.in;

import java.util.List;

import com.dgaznares.mscurso.usuarios.domain.model.UsuarioDto;

public interface RetreaveUsersUseCase {
	
	public List<UsuarioDto> findAllUsers();
	public UsuarioDto getUser(Integer id);

}
