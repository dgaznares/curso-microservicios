package com.dgaznares.mscurso.cursos.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgaznares.mscurso.cursos.application.services.CursosService;
import com.dgaznares.mscurso.cursos.domine.model.CursoDto;


@RestController
@RequestMapping("/api/courses")
public class CursosController {
	
	private CursosService cursosService;
	
	@Autowired
	public CursosController(CursosService cursosService) {
		this.cursosService=cursosService;
		
	}
	@GetMapping()
	ResponseEntity <List<CursoDto>> findAllUsers(){
		return ResponseEntity.ok(cursosService.findAllUsers());	
	}
	
	@GetMapping("/{id}")
	ResponseEntity<CursoDto> findUser(@PathVariable Integer id){
		CursoDto user = cursosService.getUser(id);
		return ResponseEntity.ok(user);	
	}
	
	@PostMapping()
	ResponseEntity<CursoDto> createUser(@RequestBody CursoDto usuarioDto){
		CursoDto user = cursosService.createUser(usuarioDto);
		return ResponseEntity.ok(user);	
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Integer> deleteUser(@PathVariable Integer id){
		return ResponseEntity.ok(cursosService.deleteUser(id));	
	}
	

}
