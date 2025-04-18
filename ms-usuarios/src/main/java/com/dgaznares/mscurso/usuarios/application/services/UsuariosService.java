package com.dgaznares.mscurso.usuarios.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.usuarios.domain.model.UsuarioDto;
import com.dgaznares.mscurso.usuarios.domain.ports.in.CreateUserUseCase;
import com.dgaznares.mscurso.usuarios.domain.ports.in.DeleteUserUseCase;
import com.dgaznares.mscurso.usuarios.domain.ports.in.RetreaveUsersUseCase;

@Service
public class UsuariosService {
	
	private RetreaveUsersUseCase retreaveUsersUseCase;
	private CreateUserUseCase createUsersUseCase;
	private DeleteUserUseCase deleteUserUseCase;
	
	@Autowired
	public UsuariosService(RetreaveUsersUseCase retreaveUsersUseCase,
			CreateUserUseCase createUsersUseCase,
			DeleteUserUseCase deleteUserUseCase) {
		this.retreaveUsersUseCase=retreaveUsersUseCase;
		this.createUsersUseCase=createUsersUseCase;
		this.deleteUserUseCase=deleteUserUseCase;
		
	}
	
	public UsuarioDto getUser(Integer id){
		return retreaveUsersUseCase.getUser(id);
	}
	
	public List<UsuarioDto> findAllUsers(){
		return retreaveUsersUseCase.findAllUsers();
	}
	
	
	public UsuarioDto createUser(UsuarioDto usuarioDto){
		return createUsersUseCase.createUser(usuarioDto);	
	}
	
	public Integer deleteUser(Integer id){
		return deleteUserUseCase.deleteUser(id);
	}

}
