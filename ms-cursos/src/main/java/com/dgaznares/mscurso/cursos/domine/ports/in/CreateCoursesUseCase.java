package com.dgaznares.mscurso.cursos.domine.ports.in;

import com.dgaznares.mscurso.cursos.domine.model.CursoDto;

public interface CreateCoursesUseCase {
	
	public CursoDto createCourse(CursoDto cursoDto);

}
