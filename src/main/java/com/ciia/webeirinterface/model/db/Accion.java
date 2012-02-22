package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class Accion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5879676693064241309L;

	private Integer idAccion;
	private String descripcion;				

	public Accion() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Accion(Integer idAccion, String descripcion) {
		super();
		this.idAccion = idAccion;
		this.descripcion = descripcion;
	}
	
	/**
	 * @param idAccion
	 */
	public Accion(Integer idAccion) {
		super();
		this.idAccion = idAccion;
	}
}
