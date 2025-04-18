package com.dgaznares.mscurso.cursos.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.cursos.domine.model.CursoDto;
import com.dgaznares.mscurso.cursos.domine.ports.in.RetreaveCoursesUseCase;
import com.dgaznares.mscurso.cursos.domine.ports.out.CursoRepositoryPort;

@Service
public class RetreaveCourseUseCaseImpl implements  RetreaveCoursesUseCase{

	private CursoRepositoryPort cursoRepositoryPort;
	
	@Autowired
	public RetreaveCourseUseCaseImpl(CursoRepositoryPort cursoRepositoryPort) {
		this.cursoRepositoryPort = cursoRepositoryPort;
	}

	@Override
	public List<CursoDto> findAllCourses() {		
		return cursoRepositoryPort.findAllCourses();
	}

	@Override
	public CursoDto getCourse(Integer id) {
		return cursoRepositoryPort.getCourse(id);
	}

}
