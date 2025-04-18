package com.dgaznares.mscurso.cursos.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.cursos.domine.model.CursoDto;
import com.dgaznares.mscurso.cursos.domine.ports.in.CreateCoursesUseCase;
import com.dgaznares.mscurso.cursos.domine.ports.in.DeleteCoursesUseCase;
import com.dgaznares.mscurso.cursos.domine.ports.in.RetreaveCoursesUseCase;

@Service
public class CursosService {
	
	
	private RetreaveCoursesUseCase retreaveCoursesUseCase;
	private CreateCoursesUseCase createCoursesUseCase;
	private DeleteCoursesUseCase deleteCoursesUseCase;
	
	@Autowired
	public CursosService(RetreaveCoursesUseCase retreaveCoursesUseCase,
			CreateCoursesUseCase createCoursesUseCase,
			DeleteCoursesUseCase deleteCoursesUseCase) {
		this.retreaveCoursesUseCase=retreaveCoursesUseCase;
		this.createCoursesUseCase=createCoursesUseCase;
		this.deleteCoursesUseCase=deleteCoursesUseCase;
		
	}
	
	public CursoDto getUser(Integer id){
		return retreaveCoursesUseCase.getCourse(id);
	}
	
	public List<CursoDto> findAllUsers(){
		return retreaveCoursesUseCase.findAllCourses();
	}
	
	
	public CursoDto createUser(CursoDto cursoDto){
		return createCoursesUseCase.createCourse(cursoDto);
	}
	
	public Integer deleteUser(Integer id){
		return deleteCoursesUseCase.deleteCourse(id);
	}

}
