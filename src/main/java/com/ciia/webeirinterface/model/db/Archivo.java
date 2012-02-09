package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class Archivo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3731338782281008011L;
	private Integer idArchivo;
	private String ruta;			
	private String nombre;
	private Boolean activo;			

	public Integer getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Archivo() {
		// TODO Auto-generated constructor stub
	}

	public Archivo(Integer idArchivo, String ruta, String nombre, Boolean activo) {
		super();
		this.idArchivo = idArchivo;
		this.ruta = ruta;
		this.nombre = nombre;
		this.activo = activo;
	}
}
