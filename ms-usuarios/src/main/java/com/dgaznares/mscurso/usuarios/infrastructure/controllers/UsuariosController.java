package com.dgaznares.mscurso.usuarios.infrastructure.controllers;

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

import com.dgaznares.mscurso.usuarios.application.services.UsuariosService;
import com.dgaznares.mscurso.usuarios.domain.model.UsuarioDto;

@RestController
@RequestMapping("/api/users")
public class UsuariosController {
	
	private UsuariosService usuariosService;
	
	@Autowired
	public UsuariosController(UsuariosService usuariosService) {
		this.usuariosService=usuariosService;
		
	}
	@GetMapping()
	ResponseEntity <List<UsuarioDto>> findAllUsers(){
		return ResponseEntity.ok(usuariosService.findAllUsers());	
	}
	
	@GetMapping("/{id}")
	ResponseEntity<UsuarioDto> findUser(@PathVariable Integer id){
		UsuarioDto user = usuariosService.getUser(id);
		return ResponseEntity.ok(user);	
	}
	
	@PostMapping()
	ResponseEntity<UsuarioDto> createUser(@RequestBody UsuarioDto usuarioDto){
		UsuarioDto user = usuariosService.createUser(usuarioDto);
		return ResponseEntity.ok(user);	
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Integer> deleteUser(@PathVariable Integer id){
		return ResponseEntity.ok(usuariosService.deleteUser(id));	
	}
	

}
