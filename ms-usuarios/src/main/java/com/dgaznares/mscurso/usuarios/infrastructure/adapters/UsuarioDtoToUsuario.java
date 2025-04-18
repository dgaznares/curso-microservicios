package com.dgaznares.mscurso.usuarios.infrastructure.adapters;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dgaznares.mscurso.usuarios.domain.model.UsuarioDto;
import com.dgaznares.mscurso.usuarios.infrastructure.entities.Usuario;

@Component
public class UsuarioDtoToUsuario implements Converter<UsuarioDto, Usuario>{

	@Override
	public Usuario convert(UsuarioDto source) {	
		
		Usuario usuario = Optional.ofNullable(source)
				.map(s-> new Usuario(
						s.getId(), 
						s.getNombre(), 
						s.getEmail(), 
						s.getPassword()))
				.orElse(null);
		return usuario;
	}

}
