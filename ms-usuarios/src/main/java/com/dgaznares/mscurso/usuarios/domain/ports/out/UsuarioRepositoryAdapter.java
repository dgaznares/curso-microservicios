package com.dgaznares.mscurso.usuarios.domain.ports.out;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.usuarios.domain.model.UsuarioDto;
import com.dgaznares.mscurso.usuarios.infrastructure.adapters.UsuarioDtoToUsuario;
import com.dgaznares.mscurso.usuarios.infrastructure.adapters.UsuarioToUsuarioDto;
import com.dgaznares.mscurso.usuarios.infrastructure.entities.Usuario;
import com.dgaznares.mscurso.usuarios.infrastructure.repositories.UsuariosRepository;

@Service
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort{
	
	private UsuariosRepository usuariosRepository;
	private UsuarioToUsuarioDto usuarioToUsuarioDto;
	private UsuarioDtoToUsuario usuarioDtoToUsuario;
	
	@Autowired
	public UsuarioRepositoryAdapter(UsuariosRepository usuariosRepository, 
			UsuarioToUsuarioDto usuarioToUsuarioDto,
			UsuarioDtoToUsuario usuarioDtoToUsuario) {
		this.usuariosRepository=usuariosRepository;
		this.usuarioToUsuarioDto=usuarioToUsuarioDto;
		this.usuarioDtoToUsuario=usuarioDtoToUsuario;
	}

	@Override
	public List<UsuarioDto> findAllUsers() {
		return usuariosRepository.findAll().stream()
				.map(u-> usuarioToUsuarioDto.convert(u))
				.collect(Collectors.toList());	 
	}

	@Override
	public UsuarioDto getUser(Integer id) {
		Optional<Usuario> usuario = usuariosRepository.findById(id);
		if (usuario.isPresent())
			return usuarioToUsuarioDto.convert(usuariosRepository.findById(id).get());	
		else
			return null;
	}

	@Override
	public UsuarioDto createUser(UsuarioDto user) {
		Usuario usuario = usuarioDtoToUsuario.convert(user);
		return usuarioToUsuarioDto.convert(usuariosRepository.save(usuario));
	}

	@Override
	public Integer deleteUser(Integer id) {
		usuariosRepository.deleteById(id);
		return id;
		
	}



}
