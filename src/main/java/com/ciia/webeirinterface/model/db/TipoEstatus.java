package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class TipoEstatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2626898708267824057L;
	private Integer idTipoEstatus;
	private String descripcion; 
	
	public Integer getIdTipoEstatus() {
		return idTipoEstatus;
	}

	public void setIdTipoEstatus(Integer idTipoEstatus) {
		this.idTipoEstatus = idTipoEstatus;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoEstatus() {
		// TODO Auto-generated constructor stub
	}

	public TipoEstatus(Integer idTipoEstatus, String descripcion) {
		super();
		this.idTipoEstatus = idTipoEstatus;
		this.descripcion = descripcion;
	}
}
