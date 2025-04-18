package com.dgaznares.mscurso.cursos.domine.model;

public class CursoDto {
	 private Integer id;
	 private String nombre;
	
	 public CursoDto(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
}
