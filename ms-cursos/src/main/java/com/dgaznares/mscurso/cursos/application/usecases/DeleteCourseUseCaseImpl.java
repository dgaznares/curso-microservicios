package com.dgaznares.mscurso.cursos.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.cursos.domine.ports.in.DeleteCoursesUseCase;
import com.dgaznares.mscurso.cursos.domine.ports.out.CursoRepositoryPort;

@Service
public class DeleteCourseUseCaseImpl implements DeleteCoursesUseCase{

	private CursoRepositoryPort cursoRepositoryPort;
	
	@Autowired
	public DeleteCourseUseCaseImpl(CursoRepositoryPort cursoRepositoryPort) {	
		this.cursoRepositoryPort = cursoRepositoryPort;
	}
	@Override
	public Integer deleteCourse(Integer id) {		
		return cursoRepositoryPort.deleteCourse(id);
	}

}
