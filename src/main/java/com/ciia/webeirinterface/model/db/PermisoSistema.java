package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class PermisoSistema implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7756621902795988119L;
	private Integer idPermisoSistema;
	private String descripcion;	
	private Boolean activo;			

	public Integer getIdPermisoSistema() {
		return idPermisoSistema;
	}

	public void setIdPermisoSistema(Integer idPermisoSistema) {
		this.idPermisoSistema = idPermisoSistema;
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

	public PermisoSistema() {
		// TODO Auto-generated constructor stub
	}

	public PermisoSistema(Integer idPermisoSistema, String descripcion) {
		super();
		this.idPermisoSistema = idPermisoSistema;
		this.descripcion = descripcion;
	}
} 
