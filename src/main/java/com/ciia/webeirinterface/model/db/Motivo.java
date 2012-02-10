package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class Motivo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -197851966975935743L;
	private Integer idMotivo;
	private String descripcion;	
	//private Escenario escenario;
	private Boolean activo;			

	public Integer getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(Integer idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/*
	public Escenario getEscenario() {
		return escenario;
	}

	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}
	*/
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Motivo() {
		// TODO Auto-generated constructor stub
	}

	public Motivo(Integer idMotivo, String descripcion) {
		super();
		this.idMotivo = idMotivo;
		this.descripcion = descripcion;
	}
}
