package com.dgaznares.mscurso.cursos.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.cursos.domine.model.CursoDto;
import com.dgaznares.mscurso.cursos.domine.ports.in.CreateCoursesUseCase;
import com.dgaznares.mscurso.cursos.domine.ports.out.CursoRepositoryPort;

@Service
public class CreateCourseUseCaseImpl implements CreateCoursesUseCase {
	
	private CursoRepositoryPort cursoRepositoryPort;
	
	@Autowired
	public CreateCourseUseCaseImpl(CursoRepositoryPort cursoRepositoryPort) {
		this.cursoRepositoryPort = cursoRepositoryPort;
	}

	@Override
	public CursoDto createCourse(CursoDto cursoDto) {
		return cursoRepositoryPort.createCourse(cursoDto);
	}

}
