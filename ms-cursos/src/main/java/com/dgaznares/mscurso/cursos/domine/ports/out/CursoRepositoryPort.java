package com.dgaznares.mscurso.cursos.domine.ports.out;

import java.util.List;

import com.dgaznares.mscurso.cursos.domine.model.CursoDto;

public interface CursoRepositoryPort {
	
	public List<CursoDto> findAllCourses();
	public CursoDto getCourse(Integer id);
	public CursoDto createCourse(CursoDto user);
	public Integer deleteCourse(Integer id);

}
