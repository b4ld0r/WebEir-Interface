package com.ciia.webeirinterface.model.login;

public class Permiso {
	private Integer id;
	private String nombre;
	
	public Permiso(Integer id, String nombre){
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
