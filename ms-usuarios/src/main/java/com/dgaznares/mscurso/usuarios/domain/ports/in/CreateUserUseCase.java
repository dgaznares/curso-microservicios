package com.dgaznares.mscurso.usuarios.domain.ports.in;

import com.dgaznares.mscurso.usuarios.domain.model.UsuarioDto;

public interface CreateUserUseCase {
	
	public UsuarioDto createUser(UsuarioDto usuarioDto);

}
