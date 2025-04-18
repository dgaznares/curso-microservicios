package com.dgaznares.mscurso.usuarios.application.usescases;

import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.usuarios.domain.ports.in.DeleteUserUseCase;
import com.dgaznares.mscurso.usuarios.domain.ports.out.UsuarioRepositoryPort;

@Service
public class DeleteUserUseCaseImpl implements DeleteUserUseCase{

	private UsuarioRepositoryPort usuarioRepositoryPort;
	
	public DeleteUserUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
		this.usuarioRepositoryPort=usuarioRepositoryPort;
	}

	@Override
	public Integer deleteUser(Integer id) {	
		return usuarioRepositoryPort.deleteUser(id);
	}


	


}
