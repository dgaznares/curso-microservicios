package com.dgaznares.mscurso.usuarios.application.usescases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.usuarios.domain.model.UsuarioDto;
import com.dgaznares.mscurso.usuarios.domain.ports.in.RetreaveUsersUseCase;
import com.dgaznares.mscurso.usuarios.domain.ports.out.UsuarioRepositoryPort;

@Service
public class RetreaveUsersUseCaseImpl implements RetreaveUsersUseCase{
	
	private UsuarioRepositoryPort usuarioRepositoryPort;
	
	public RetreaveUsersUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
		this.usuarioRepositoryPort=usuarioRepositoryPort;
	}

	@Override
	public List<UsuarioDto> findAllUsers() {
		return usuarioRepositoryPort.findAllUsers();
	}

	@Override
	public UsuarioDto getUser(Integer id) {
		return usuarioRepositoryPort.getUser(id);
	}
	
}
