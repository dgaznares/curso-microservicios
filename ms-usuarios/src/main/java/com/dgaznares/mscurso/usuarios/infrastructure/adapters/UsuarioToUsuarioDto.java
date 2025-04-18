package com.dgaznares.mscurso.usuarios.infrastructure.adapters;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dgaznares.mscurso.usuarios.domain.model.UsuarioDto;
import com.dgaznares.mscurso.usuarios.infrastructure.entities.Usuario;

@Component
public class UsuarioToUsuarioDto implements Converter<Usuario, UsuarioDto>{

	@Override
	public UsuarioDto convert(Usuario source) {	
		return Optional.ofNullable(source)
				.map(s-> new UsuarioDto(
						s.getId(), s.getNombre(), s.getEmail(), s.getPassword()))
				.orElse(null);
	}

}
