package com.dgaznares.mscurso.cursos.infrastructure.adapters;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dgaznares.mscurso.cursos.domine.model.CursoDto;
import com.dgaznares.mscurso.cursos.infrastructure.entities.Curso;

@Component
public class CursoDtoToCurso implements Converter<CursoDto, Curso>{

	@Override
	public Curso convert(CursoDto source) {	
		
		Curso curso = Optional.ofNullable(source)
				.map(s-> new Curso(
						s.getId(), 
						s.getNombre()))	
				.orElse(null);
		return curso;
	}

}
