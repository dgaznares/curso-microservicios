package com.dgaznares.mscurso.cursos.domine.ports.in;

import java.util.List;

import com.dgaznares.mscurso.cursos.domine.model.CursoDto;

public interface RetreaveCoursesUseCase {
	public List<CursoDto> findAllCourses();
	public CursoDto getCourse(Integer id);

}
