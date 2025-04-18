package com.dgaznares.mscurso.cursos.domine.ports.out;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.cursos.domine.model.CursoDto;
import com.dgaznares.mscurso.cursos.infrastructure.adapters.CursoDtoToCurso;
import com.dgaznares.mscurso.cursos.infrastructure.adapters.CursoToCursoDto;
import com.dgaznares.mscurso.cursos.infrastructure.entities.Curso;
import com.dgaznares.mscurso.cursos.infrastructure.repositories.CursosRepository;


@Service
public class CursoRepositoryAdapter implements CursoRepositoryPort{

	private CursosRepository cursosRepository;
	private CursoDtoToCurso cursoDtoToCurso;
	private CursoToCursoDto cursoToCursoDto;
	
	@Autowired
	public CursoRepositoryAdapter(CursosRepository cursosRepository, CursoDtoToCurso cursoDtoToCurso,
			CursoToCursoDto cursoToCursoDto) {
		super();
		this.cursosRepository = cursosRepository;
		this.cursoDtoToCurso = cursoDtoToCurso;
		this.cursoToCursoDto = cursoToCursoDto;
	}


	@Override
	public List<CursoDto> findAllCourses() {
		return cursosRepository.findAll().stream()
				.map(u-> cursoToCursoDto.convert(u))
				.collect(Collectors.toList());	
	}

	@Override
	public CursoDto getCourse(Integer id) {
		Optional<Curso> curso = cursosRepository.findById(id);
		if (curso.isPresent())
			return cursoToCursoDto.convert(cursosRepository.findById(id).get());	
		else
			return null;
	}

	@Override
	public CursoDto createCourse(CursoDto cursoDto) {
		Curso curso = cursoDtoToCurso.convert(cursoDto);
		return cursoToCursoDto.convert(cursosRepository.save(curso));
	}

	@Override
	public Integer deleteCourse(Integer id) {
		cursosRepository.deleteById(id);
		return id;
	}
	
	


}
