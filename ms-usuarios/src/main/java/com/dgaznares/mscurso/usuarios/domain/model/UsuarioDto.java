package com.dgaznares.mscurso.usuarios.domain.model;


public class UsuarioDto {

	private Integer id;
    private String nombre; 
    private String email;
    private String password;
	public UsuarioDto() {
		super();
	}
	public UsuarioDto(Integer id, String nombre, String email, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + "]";
	}
    
    
	
}
