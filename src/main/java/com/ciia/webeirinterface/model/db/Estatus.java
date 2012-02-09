package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class Estatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -559397461543332141L;
	private Integer idEstatus;
	private String descripcion;
	private TipoEstatus tipoEstatus;
	
	public Integer getIdEstatus() {
		return idEstatus;
	}

	public TipoEstatus getTipoEstatus() {
		return tipoEstatus;
	}

	public void setTipoEstatus(TipoEstatus tipoEstatus) {
		this.tipoEstatus = tipoEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estatus(Integer idEstatus, String descripcion,
			TipoEstatus tipoEstatus) {
		super();
		this.idEstatus = idEstatus;
		this.descripcion = descripcion;
		this.tipoEstatus = tipoEstatus;
	}

	public Estatus() {
		// TODO Auto-generated constructor stub
	}
}
