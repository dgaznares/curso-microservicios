package com.dgaznares.mscurso.cursos.infrastructure.adapters;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dgaznares.mscurso.cursos.domine.model.CursoDto;
import com.dgaznares.mscurso.cursos.infrastructure.entities.Curso;

@Component
public class CursoToCursoDto implements Converter<Curso, CursoDto>{

	@Override
	public CursoDto convert(Curso source) {	
		return Optional.ofNullable(source)
				.map(s-> new CursoDto(
						s.getId(), s.getNombre()))
				.orElse(null);
	}

}
