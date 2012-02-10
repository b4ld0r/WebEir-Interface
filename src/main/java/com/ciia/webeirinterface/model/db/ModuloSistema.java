package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class ModuloSistema implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3979754518464212103L;
	private Integer idModuloSistema;
	private String descripcion;
	private Boolean activo;			

	public ModuloSistema() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdModuloSistema() {
		return idModuloSistema;
	}

	public void setIdModuloSistema(Integer idModuloSistema) {
		this.idModuloSistema = idModuloSistema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public ModuloSistema(Integer idModuloSistema, String descripcion) {
		super();
		this.idModuloSistema = idModuloSistema;
		this.descripcion = descripcion;
	}
}
