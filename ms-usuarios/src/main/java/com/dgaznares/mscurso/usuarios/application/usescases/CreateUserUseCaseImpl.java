package com.dgaznares.mscurso.usuarios.application.usescases;

import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.usuarios.domain.model.UsuarioDto;
import com.dgaznares.mscurso.usuarios.domain.ports.in.CreateUserUseCase;
import com.dgaznares.mscurso.usuarios.domain.ports.out.UsuarioRepositoryPort;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase{
	
	private UsuarioRepositoryPort usuarioRepositoryPort;
	
	public CreateUserUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
		this.usuarioRepositoryPort=usuarioRepositoryPort;
	}

	@Override
	public UsuarioDto createUser(UsuarioDto usuarioDto) {
		return usuarioRepositoryPort.createUser(usuarioDto);
	}



}
